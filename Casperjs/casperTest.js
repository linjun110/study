// Casper APIs: http://docs.casperjs.org/en/latest/modules/index.html
// Phantom APIs: http://phantomjs.org/api/

// import TRAP: keep the order.
var Linky = require('./lib/linky').Linky;

var x = require('casper').selectXPath;
var utils = require('utils');

var fs = require('fs');
var _ = require("./lib/underscore");

var USER_AGENT = 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.9999.69 Safari/537.36';
var VIEWPORT_WIDTH = 1280;
var VIEWPORT_HEIGHT = 800;

var INJECT_JS_DIR = "injectJS";
var OUT_DIR = "./out";
var CAPTURED_FILE_NAME = OUT_DIR + "/captured";
var EXTRACTED_FILE_NAME = OUT_DIR + "/extracted";
var DUMP_FILE_NAME = OUT_DIR + "/dumped";

var linkyOptions = {
    clientScripts:  [
        INJECT_JS_DIR +'/jquery-2.2.3.min.js',      // These scripts will be injected
        INJECT_JS_DIR + '/underscore-1.8.3.min.js'   // in remote DOM on every request
    ],
    pageSettings: {
        javascriptEnabled : true,
        loadImages : false,
        loadPlugins : true,
        userAgent : USER_AGENT
    },
    logLevel: "info",
    verbose: true
};


var URL = "http://www.baidu.com";
var PAGE_LOAD_TIME = 5000;

var linky = new Linky(linkyOptions).start();
linky.doOpen(URL)
    .doWait(PAGE_LOAD_TIME)
    .doDump(DUMP_FILE_NAME)
    .doExtract('img', 'src', EXTRACTED_FILE_NAME)
    .doDownloadLink(EXTRACTED_FILE_NAME);

linky.run();
