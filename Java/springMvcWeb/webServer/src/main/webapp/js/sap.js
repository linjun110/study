requirejs.config({
	baseUrl: '/springMvcWeb/js',
	paths: {
		jquery: 'libs/jquery-2.2.3.min',
		underscore: 'libs/underscore-1.8.3.min',
		backbone: 'libs/backbone-1.3.3.min',
		marionette: 'libs/backbone.marionette',
		text: 'libs/text',
		bootstrap: 'libs/bootstrap',
		bootstrapTreeView: 'libs/bootstrap-treeview.min',
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
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'bootstrapTreeView': {
            deps: ['bootstrap']
        },
    }
});

require(['app'], function(App){
    App.start();
});