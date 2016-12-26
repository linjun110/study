define(['text!templates/booksCompositeViewTemplate.html', 'views/bookView', 'models/bookModel'],function(Template, ItemView, ItemModel){
	// It seems the app_collection_template is no use.
	view = Backbone.Marionette.CompositeView.extend({
		template: _.template(Template),
		itemView: ItemView,
		itemViewContainer: "#_container",
		//tagName: "tr",

		operatingModel: null,	// record which model is operating

		events:{
			"click #add":"addHandler",
			"click #update":"updateHandler"
		},
		collectionEvents: {
			"add": "modelAdded"
		},
		initialize: function(){
			/*
			if( typeof(this.collection) !== "undefined"){
				this.listenTo(this.collection, "add", this.modelAdded);
			}
			*/
		},
		modelAdded: function(model){
			//console.log("modelAdded, model: ",model);
		},
		appendHtml: function(collectionView, itemView){ //内置方法, called for each item
			var _this = this;
			itemView.on("bookEvent", _this.bookEventHandler, _this);
			collectionView.$("#_container").append(itemView.el);
			//console.log("collectionView.el:",collectionView.el);
		},
		onShow: function () {
			this.$el.find("#update").hide();
			this.update();
		},
		update: function (){
			this.collection.fetch();
		},
		bookEventHandler: function (e) {
			var _this = this;
			/*  TIP: you can trigger event to upper layer
			 *  _this.trigger("booksCompositeEvent",e);
			 */

			/*
			 * DIY:
			 */
			 if(e.event === "clicked"){
			 	var _model = e.model;
			 	_this.operatingModel = _model;
			 	this.$el.find("#number").val(_model.get("number"));
			 	this.$el.find("#title").val(_model.get("title"));
			 	this.$el.find("#author").val(_model.get("author"));
			 	this.$el.find("#update").show();
			 }else if(e.event === "deleteSuccess"){
			 	_this.update();
			 }
		},
		addHandler: function () {
			var _this = this;
			var _model = new ItemModel();
			_model.set("number", _this.$el.find("#number").val());
			_model.set("title", _this.$el.find("#title").val());
			_model.set("author", _this.$el.find("#author").val());
			_model.save({},{
				success: function (model, response) {
					console.log("success:", arguments);
					_this.update();
					_this.cleanInput();
				},
				error: function (model, response) {
					console.log("error:", arguments);
				}
			});

		},
		updateHandler: function () {
			var _this = this;
			var _model = _this.operatingModel;
			if(_model === null)return;
			_model.set("number", _this.$el.find("#number").val());
			_model.set("title", _this.$el.find("#title").val());
			_model.set("author", _this.$el.find("#author").val());
			_model.save({},{
				success: function (model, response) {
					console.log("success:", arguments);
					_this.update();
					_this.cleanInput();
				},
				error: function (model, response) {
					console.log("error:", arguments);
				}
			});
		},
		cleanInput: function () {
			this.operatingModel = null;
		 	this.$el.find("#number").val("");
		 	this.$el.find("#title").val("");
		 	this.$el.find("#author").val("");
		 	this.$el.find("#update").hide();
		}
	});
	return view;
});
