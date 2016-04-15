define(['backbone', 'marionette', 'views/RootView', 'models/FooModel'],function(Backbone, Marionette, RootView, FooModel){
	var _controller = Backbone.Marionette.Controller.extend({
		app: null,
		initialize: function(options){
			this.app = options.app;

			this.app.pageContent.on("show", function(view){
				console.log("content_region show:",view);
			});

			this.app.pageContent.on("close", function(view){
				console.log("content_region close:",view);
			});
		},
		action: function () {
			var dmJson = {
                name: "linjun"
			};

			var dm = new FooModel(dmJson);

			var _view = new RootView({model: dm});
			_view.render();

		}
	});
	return _controller;
});