define(['marionette','controllers/Controller'],function(marionette,Controller){
	var _router = Backbone.Marionette.AppRouter.extend({
		initialize: function(options){
			this.controller = new Controller(options);
		},
		controller: null,
		appRoutes: {
			"": "actionSendCmd",
			"routeSendCmd": "actionSendCmd",
			"routeSendMsg": "actionSendMsg",
			"routeRedis": "actionRedis",
		}
	});
	return _router;
});