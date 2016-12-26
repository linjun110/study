define(['marionette','controllers/fooController'],function(marionette,Controller){
	var router = Backbone.Marionette.AppRouter.extend({
		initialize: function(options){
			this.controller = new Controller(options);
		},
		controller: null,
		appRoutes: {
			"": "main",
			"route_path_1": "route_path_1_cb"
		},
		routes : {
			"route_path_2" : "route_path_2_cb"
		},
		route_path_2_cb : function(){
			console.log("route_path_2_cb");
		}
	});
	return router;
});
