/*
Backbone:
Repo: https://github.com/jashkenas/backbone
Tutorial: http://backbonejs.org/
Marionette:
API: https://github.com/marionettejs/backbone.marionette/tree/master/docs
*/

define(['marionette','routers/fooRouter'], function(marionette, Router){
	var _app = new Backbone.Marionette.Application();
	_app.addRegions({
		content_region: "#content"
	});
	_app.addInitializer(function(options){
	  _app.router = new Router({app: _app});
	  Backbone.history.start();
	});
	return _app;
});

