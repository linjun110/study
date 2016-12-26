var _ = require('underscore')  
  , path = require('path')  
  , fs = require('fs');  

// relative path to project root.
var WORK_PATH = "nakoruru/";
var SRC_FILE_NAMES = ['main.js', 'utils.js', 'api.js', 'object.js', 'model.js',
 'collection.js', 'region.js', 'view.js'];

var SCRIPT_FILES = _.map(SRC_FILE_NAMES, function(file){
  return WORK_PATH + 'src/' + file;
});

module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    meta: {
      version: '<%= pkg.version %>',
      core_banner:
        '// Nakoruru (Backbone.Nakoruru)\n' +
        '// ----------------------------------\n' +
        '// v<%= pkg.version %>\n' +
        '//\n' +
        '// Copyright (c)<%= grunt.template.today("yyyy") %> Linjun.\n' +
        '// Distributed under MIT license\n' +
        '//\n' +
        '// http://mocklinjun.com\n' +
        '\n',
      banner:
        '<%= meta.core_banner %>\n' +
        '/*!\n' +
        ' */\n\n\n'
    },
    jshint: {
      all: [
        WORK_PATH + 'src/*.js'
      ],
      options: {
        browser: true,            // browser environment
        devel: true                // 
      }
    },
    // Configure a mochaTest task 
    // Ref: https://www.npmjs.com/package/grunt-mocha-test
    mochaTest: {
      test: {
        options: {
          reporter: 'spec',
          captureFile: WORK_PATH + 'results.txt', // Optionally capture the reporter output to a file
          quiet: false, // Optionally suppress output to standard out (defaults to false) 
          clearRequireCache: false // Optionally clear the require cache before running tests (defaults to false) 
        },
        src: [WORK_PATH + 'test/**/*.js']
      },
      coverage: { // coverage is folder name
        options: {
          reporter: 'html-cov',
          // use the quiet flag to suppress the mocha console output
          quiet: true,
          // specify a destination file to capture the mocha
          // output (the quiet option does not suppress this)
          captureFile: WORK_PATH + 'coverage.html'
        },
        src: [WORK_PATH + 'coverage/**/*.js']
      }
    },
    concat: {
      // 这里是concat任务的配置信息。
      options: {
        banner: '<%= meta.core_banner %>'
      },
      core: { //把所有SCRIPT_FILES合并为一个文件
        src: SCRIPT_FILES,
        dest: WORK_PATH + 'dist/<%= pkg.name %>.js',
      },
    },
    uglify: {
      options: {
        // 定义min.js文件头部
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      build: {
        src: WORK_PATH + 'dist/<%= pkg.name %>.js',
        dest: WORK_PATH + 'build/<%= pkg.name %>.min.js'
      }
    },
    shell: {
        options: {
            stderr: false
        },
        cp2libs: {
            command: 'cp -f ' + WORK_PATH + 'dist/<%= pkg.name %>.js public/js/libs/'
        }
    },
    // HELP: to start watch, run "grunt watch"
    // Ref: https://www.npmjs.com/package/grunt-contrib-watch
    watch: {  
      scripts: {  //files文件有改动,则触发以下tasks
          files: SCRIPT_FILES,
          tasks: ['jshint', 'mochaTest', 'concat', 'uglify', 'shell'],  
          options: {  
              debounceDelay: 250  
          }  
      }
    }, 
  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-mocha-test');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-shell');

  // Default task(s).
  grunt.registerTask('default', ['jshint', 'mochaTest', 'concat', 'uglify', 'shell']);

};
