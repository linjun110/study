define(['backbone',
    'marionette',
    'views/RootView',
    'views/ProcessTestView',
    'views/RabbitMqTestView',
    'views/RedisTestView',
    'models/FooModel'
    ],function(
        Backbone,
        Marionette,
        RootView,
        ProcessTestView,
        RabbitMqTestView,
        RedisTestView,
        FooModel
    ){
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

		actionSendCmd: function () {
			var dmJson = {
                name: "linjun"
			};

			var dm = new FooModel(dmJson);

			var _view = new ProcessTestView({model: dm});
			_view.render();
		},

		actionSendMsg: function () {
			var dmJson = {
                name: "linjun"
			};

			var dm = new FooModel(dmJson);

			var _view = new RabbitMqTestView({model: dm});
			_view.render();
		},

		actionRedis: function () {
			var dmJson = {
                name: "linjun"
			};

			var dm = new FooModel(dmJson);

			var _view = new RedisTestView({model: dm});
			_view.render();
		},
	});
	return _controller;
});