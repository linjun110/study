define(['text!templates/fooView1Template.html'],function(Template){
	view = Backbone.Marionette.ItemView.extend({
		template: _.template(Template),
		//自定义事件监听
		events: {
			"click #view1_button":"button_clicked_handler"
		},
		//内置事件监听
		modelEvents: {
    		"change": "modelChanged"
		},
		button_clicked_handler: function(){
			console.log("button_clicked_handler");
			this.trigger("app_event",{op:"op"});
		},
		initialize: function(){
			if( typeof(this.model) !== "undefined"){
				//this.listenTo(this.model, "change:foo", this.modelChanged);
				console.log("app_view1, this.model=",this.model);
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
	  		console.log("app_view1 modelChanged",model.get("name"));
	  		this.render();
		},
		modelAdded: function(model){
			console.log("app_view1 modelAdded");
		}
	});
	return view;
});
