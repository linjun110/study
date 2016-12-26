define(['marionette', 'text!templates/catViewTemplate.html'],function(marionette, Template){
	view = Backbone.Marionette.ItemView.extend({
		tagName: "div",
		className: "cat",
		template: _.template(Template),
		//自定义事件监听
		events: {
			"click td":"clickedHandler",
			"click button":"deleteHandler",
		},
		clickedHandler: function () {
			var _this = this;
			this.trigger("catEvent",{ event: "clicked", model: _this.model });
		},
		deleteHandler: function () {
			var _this = this;
			if(_this.model === null)return;
			_this.model.destroy({
				success: function (model, response) {
					console.log("success:", arguments);
					this.trigger("catEvent",{ event: "deleteSuccess" });
				},
				error: function (model, response) {
					console.log("error:", arguments);
				}
			});
		},
		//内置事件监听
		modelEvents: {
    		"change": "modelChanged"
		},
		initialize: function(){
			if( typeof(this.model) !== "undefined"){
				//this.listenTo(this.model, "change:foo", this.modelChanged);
				//this.listenTo(this.model, "change", this.modelChanged);
			}
	    	//this.listenTo(this.collection, "add", this.modelAdded);
		},
		/*内置方法
		onShow: function(){
			console.log("app_view1 onShow");
		},
		onBeforeClose: function(){
	  		console.log("app_view1 onBeforeClose");
	  	},
	  	onClose: function(){
	  		console.log("app_view1 onClose");
	  	},
	  	*/
		modelChanged: function(model, value){
	  		console.log("catView modelChanged",model);
	  		this.render();
		},
		modelAdded: function(model){
			console.log("catView modelAdded");
		}
	});
	_.extend(view.prototype, Backbone.Events);
	return view;
});
