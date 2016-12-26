//define(['layouts/fooLayout', 'views/app_collection_view', 'views/app_composite_view','views/app_view1', 'views/app_view2', 'models/fooModel', 'models/fooCollection'],function(Layout, CollectionView, CompositeView, View1, View2, Model, Collection){
define(['marionette', 'layouts/fooLayout', 'layouts/fooLayout2'],function(marionette, Layout, Layout2){
	var controller = Backbone.Marionette.Controller.extend({
		app: null,
		initialize: function(options){
			this.app = options.app;

			this.app.content_region.on("show", function(view){
				//console.log("content_region show:",view);
			});
			this.app.content_region.on("close", function(view){
				//console.log("content_region close:",view);
			});
		},
		main: function () {
			var _this = this;
			var _app = this.app;
			var _layout = new Layout();
			_app.content_region.show(_layout);
			_layout.on("fooEvent", function(e){
				console.log("detect fooEvent occurs in layout, e:",e);
			});
		},
		route_path_1_cb : function(){
			var _this = this;
			var _app = this.app;
			var _layout = new Layout2();
			_app.content_region.show(_layout);
			_layout.on("fooEvent", function(e){
				console.log("detect fooEvent occurs in layout2, e:",e);
			});
		},
	});
	return controller;	
});
