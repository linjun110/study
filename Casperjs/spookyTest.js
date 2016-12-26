// APIs: http://docs.casperjs.org/en/latest/modules/index.html
var utils = require('utils');
var x = require('casper').selectXPath;
var Linky = require('./lib/linky').Linky;
var fs = require('fs');

var linky = new Linky().start();

var PAGE_LOAD_TIME = 5000;

linky.doOpen("https://www.baidu.com")
    .doInput(x('//*[@id="kw"]'), "linjun")
    .doClick(x("//input[@type='submit']"))
    .doDump("captured", PAGE_LOAD_TIME);

linky.run();
