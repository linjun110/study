define(['marionette', 'text!templates/foodViewTemplate.html'],function(marionette, Template){
	view = Backbone.Marionette.ItemView.extend({
		tagName: "tr",
		template: _.template(Template),
		//自定义事件监听
		events: {
			"click td":"clickedHandler",
			"click button":"deleteHandler",
		},
		clickedHandler: function () {
			var _this = this;
			this.trigger("foodEvent",{ event: "clicked", model: _this.model });
		},
		deleteHandler: function () {
			var _this = this;
			if(_this.model === null)return;
			_this.model.destroy({
				success: function (model, response) {
					console.log("success:", arguments);
					this.trigger("foodEvent",{ event: "deleteSuccess" });
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
	  		console.log("foodView modelChanged",model);
	  		this.render();
		},
		modelAdded: function(model){
			console.log("foodView modelAdded");
		}
	});
	_.extend(view.prototype, Backbone.Events);
	return view;
});
