define(['marionette', 'text!templates/userViewTemplate.html'],function(marionette, Template){
	view = Backbone.Marionette.ItemView.extend({
		template: _.template(Template),
		//自定义事件监听
		events: {
			"click button":"updateHandler"
		},
		//内置事件监听
		modelEvents: {
    		"change": "modelChanged"
		},
		updateHandler: function(){
			var _this = this;
			var _model = this.model;
			_model.set("name", this.$el.find("#name").val());
			_model.save({},{
				success: function (model, response) {
					console.log("success:", arguments);
					_this.update();
				},
				error: function (model, response) {
					console.log("error:", arguments);
				}
			});
		},
		initialize: function(){
			if( typeof(this.model) !== "undefined"){
				//this.listenTo(this.model, "change:foo", this.modelChanged);
				//this.listenTo(this.model, "change", this.modelChanged2);
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
	  		this.render();
		},
		modelAdded: function(model){
		},
		onShow: function(){
			this.update();
		},
		update: function () {
			this.model.fetch();
		},
		cleanInput: function () {
		 	this.$el.find("#name").val("");
		}
	});
	return view;
});
