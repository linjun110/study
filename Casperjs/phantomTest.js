var fs = require('fs');

console.log('Args:');
console.log(phantom.args);

var OUT_DIR = "./out";
var content = fs.read(OUT_DIR+"/images.csv");
console.log('read data:', content)
var srcs = content.split("\n");
console.log('read srcs:', srcs);
console.log('len:', srcs.length);

phantom.exit();

