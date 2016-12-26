/**
 * Linky is a enhancement for CasperJS in coded Web UI tests.
 */
var require = patchRequire(require);
var Casper = require('casper').Casper;
var utils = require('utils');
var sutils = require('./lib/selector_utils');
var fs = require('fs');
var selectXPath = require('casper').selectXPath;

//TODO: move globalization to another file.
//BEGIN: globalization
//make x to be global, and add 'append' to XPath Selector
x = function(path){
    var selector = selectXPath(path);
    selector.append = function(subX){
        return sutils.xChild(selector, subX);
    };
    return selector;
};

//globalize useful X helpers
wrapX = sutils.wrapX;
createXWrapperTree = sutils.createXWrapperTree;
createXElement = sutils.createXElement;

//make underscore to be global
_ = require("./lib/underscore");

// add collectMappings to underscore
if(!_.collectMappings) {
    /**
     * Generate mappings by collection and mappingGenerator
     *     collectMappings([1,2], function(num, index){
     *          var mappings = {};
     *          mappings["num"+index+"add1"] = num + 1;
     *          mappings["num"+index+"add2"] = num + 2;
     *          return mappings;
     *     });
     *     => {num0add1:2, num0add2:3, num1add1:3, num1add2:4}
     * @param collection
     * @param mappingGenerator, generate part of mappings, accept params as iteratee in _.map does
     * @returns mappings
     */
    _.collectMappings = function (collection, mappingGenerator) {
        return _.chain(collection)
            .map(mappingGenerator)
            .reduce(function (memo, mapping) {
                return _.extend(memo, mapping);
            }, {})
            .value();
    };
}

// add mapping to underscore
if(!_.mapping) {
    /**
     * Generate single mapping
     * @param key
     * @param value
     * @returns mapping = {key: value}
     */
    _.mapping = function (key, value) {
        return _.object([key], [value]);
    };
}

/**
 * Add JavaScript Enhancement
 */
require("./lib/function_curry").init();
require("./lib/string_format").init();

//END: globalization

//exit codes definition
var exitCodes = {
    UNCLASSIFIED : 100,
    WAITING_STATUS_CHANGED_TIMEOUT : 101,
    UNREMAINED_CAUGHT : 102
};

var SECOND = 1000;
var DEFAULT_EVENT_BINDING_DELAY = 1 * SECOND;

function Linky(casperOptions, linkyOptions) {
    Linky.super_.apply(this, arguments);
    
    //Linky options can be overridden by subclass
    var defaultLinkyOptions = {
        timeoutErrorTypes : null,
        generatePathToSaveFailureScene : null
    };
    this.linkyOptions = utils.mergeObjects(defaultLinkyOptions, linkyOptions);
}

utils.inherits(Linky, Casper);

Linky.prototype.say = function(toBeSaid){
    return this.then(function(){
        this.echo(toBeSaid);
    });
};

Linky.prototype.checked = function(selector){
    this.checkStarted();
    return this.visible(selector) && this.evaluate(function(selector) {
        var element = __utils__.findOne(selector);
        var checked;
        //checkbox or… radio button (weird, I know)
        if (element.hasAttribute('value')) {
            checked = element.checked ? element.getAttribute('value') : undefined;
        } else {
            checked = element.checked;
        }
        if(checked){
            return true;
        }
        return false;
    }, selector);
};

Linky.prototype.unchecked = function(selector) {
    return !this.checked(selector);
};
Linky.prototype.enabled = function(selector){
    return !this.disabled(selector);
};

Linky.prototype.disabled = function(selector){
    this.checkStarted();
    var result = this.visible(selector) && this.evaluate(function(selector){
        var element = __utils__.findOne(selector);
        return element["disabled"];
    }, selector);
    if(result){
        return true;
    }
    return false;
};
 
Linky.prototype.waitSelectorAndDo = function (selector, DELAY, then) {
    return this.waitForSelector(selector, function(){
        }).waitAndDo(
            utils.isUndefined(DELAY) ? DEFAULT_EVENT_BINDING_DELAY : DELAY,
            function(){
                if(then){
                    then.apply(this);
                }
            });
};

Linky.prototype.waitAndDo = function (DELAY, then) {
    return this.wait(
            utils.isUndefined(DELAY) ? DEFAULT_EVENT_BINDING_DELAY : DELAY,
            function(){
                if(then){
                    then.apply(this);
                }
            });
};

Linky.prototype.doWait = function (DELAY) {
    return this.wait(
            utils.isUndefined(DELAY) ? DEFAULT_EVENT_BINDING_DELAY : DELAY,
            function(){
            });
};
Linky.prototype.doClick = function (selector, DELAY) {
    return this.waitSelectorAndDo(selector, DELAY,
        function(){
            this.click(selector);
        });
};

Linky.prototype.doDump = function (filename, DELAY) {
    return this.waitAndDo(DELAY,
        function(){
            this.capture(filename + ".png");
            fs.write(filename + ".html", this.getHTML());
        });
};

Linky.prototype.doOpen = function(url){
    return this.thenOpen(url);
};

Linky.prototype.doHover = function(selector, DELAY) {
    return this.waitSelectorAndDo(selector, DELAY,
        function() {
            this.mouseEvent('mousemove', selector);
        });
};

Linky.prototype.doInput = function(selector, content, DELAY) {
    return this.waitSelectorAndDo(selector, DELAY,
        function() {
            this.sendKeys(selector, content)
        });
};

Linky.prototype.doSelect = function(dropdownSelector, option, DELAY) {
    return this.waitSelectorAndDo(dropdownSelector, DELAY,
            function() {
                this.evaluate(function(dropdownSelector, option) {
                    var selectedOption = document.querySelector(dropdownSelector + " option[selected='selected']").text;
                    // no need to switch
                    if (selectedOption === option) {
                        return true;
                    }

                    var options = document.querySelectorAll(dropdownSelector
                            + " option");
                    // find option index
                    for ( var i = 0; i < options.length; i++) {
                        if (option === options[i].text) {
                            break;
                        }
                    }
                    // set index
                    document.querySelector(dropdownSelector).selectedIndex = i;

                    // trigger 'change' event
                    var event = document.createEvent("HTMLEvents");
                    event.initEvent("change", true, true);
                    document.querySelector(dropdownSelector).dispatchEvent(event);
                    return true;
                }, {
                    dropdownSelector : dropdownSelector,
                    option : option
                });
            });
};

Linky.prototype.doExtract = function(selector, attr, path) {
    this.checkStarted();
    return this.then(function(){
        var rc = this.evaluate(function(selector, attr){
            var rt = [];
            var elements = __utils__.findAll(selector);
            for(var i =0; i< elements.length; i++ ){
                rt.push(elements[i].getAttribute(attr));
            }
            return rt;
        }, selector, attr);
        var toWrite = rc.join("\n");
        fs.write(path, toWrite);
        this.log("Extract to " + path, "info");
    });
};

// one url each line
Linky.prototype.doDownloadLink = function(path) {
    this.checkStarted();
    return this.then(function(){
        this.log("Reading from " + path, "info");
        var links = fs.read(path).split("\n");
        var total = links.length;
        _.each(links, function(link, index){
            this.log("Downloading ("+(index+1)+"/"+total+"):" + link);
            //this.download(a[i], OUR_DIR + '/images/img'+i+".jpg");
        }, this);
    });
};

Linky.prototype.urlChangedTo = function(url, timeout) {
    var linky = this, urlReg;
    if (url instanceof RegExp) {
        urlReg = url;
    } else {
        urlReg = new RegExp(url.replace(/[\/\.\?]/g, "\\$&"));
    }
    return this.waitForUrl(urlReg, function() {
        linky.log("[URL Change][ThisIsWhatWeWant] {0}".format(url), "debug");
    }, function() {
        linky.log("[URL Change][WeDoNotWantThis] {0}".format(linky.getCurrentUrl()), "error");
        linky.fail("URL is not changed to {0} as expected".format(url), exitCodes.WAITING_STATUS_CHANGED_TIMEOUT);
    }, timeout);
};
 
/**
 * Can be used to concatenate common or shared steps into a special case or steps
 *
 * @param stepsFunction, a function with 'this'=Linky scripting test steps
 * @param [parameters]
 */
Linky.prototype.concatSteps = function(stepsFunction){
    if(!utils.isFunction(stepsFunction)){
        throw new CasperError('Unsupported steps type');
    }
    var parameters = Array.prototype.slice.call(arguments, 1);
    stepsFunction.apply(this, parameters);
    return this;
};

exports.Linky = Linky;
