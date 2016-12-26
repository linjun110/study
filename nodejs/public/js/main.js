requirejs.config({
	baseUrl: '/js',
	paths: {
		jquery: 'libs/jquery',
		underscore: 'libs/underscore',
		backbone: 'libs/backbone',
		marionette: 'libs/backbone.marionette',
		text: 'libs/text'
    },
    shim: {
    	'underscore': {
    		deps: ['jquery']
        },
        'backbone': {
            deps: ['underscore']
        },
        'marionette': {
            deps: ['backbone', 'text']
        }
    }
});

require(['fooApp'], function(App){
 App.start();
});