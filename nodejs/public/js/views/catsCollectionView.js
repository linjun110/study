define(['views/catView', 'models/catModel'],function(ItemView, ItemModel){
	view = Backbone.Marionette.CollectionView.extend({
		itemView: ItemView,

		operatingModel: null,	// record which model is operating

		events:{
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
			console.log("modelAdded, model: ",model);
		},
		appendHtml: function(collectionView, itemView){ //内置方法, called for each item
			var _this = this;
			itemView.on("catEvent", _this.catEventHandler, _this);
			collectionView.$el.append(itemView.el);
			console.log("collectionView.el:",collectionView.el);
		},
		catEventHandler: function () {
			
		},
		onShow: function () {
			this.update();
		},
		update: function (){
			this.collection.fetch();
		}
	});
	return view;
});
