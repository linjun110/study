define(['marionette', 'text!templates/fooLayoutTemplate.html', 'views/booksCompositeView', 'models/booksCollection', 'views/foodsCompositeView', 'models/foodsCollection'],function(marionette, Template, BooksCompositeView, BooksCollection, FoodsCompositeView, FoodsCollection){
//define(['marionette', 'text!templates/fooLayoutTemplate.html', 'views/booksCompositeView', 'models/booksCollection', 'views/userView', 'models/userModel'],function(marionette, Template, BooksCompositeView, BooksCollection, UserView, UserModel){
	var layout = Backbone.Marionette.Layout.extend({
		template: Template,
		initialize: function(){
			this.region_1.on("show", function(view){
				//console.log("fooLayout.foo_layout_region_1 show:",view);
			});
			this.region_1.on("close", function(view){
				//console.log("fooLayout.foo_layout_region_1 close:",view);
			});
			this.region_2.on("show", function(view){
				//console.log("fooLayout.foo_layout_region_2 show:",view);
			});
			this.region_2.on("close", function(view){
				//console.log("fooLayout.foo_layout_region_2 close:",view);
			});
		},
		regions: {
			region_1: "#foo_layout_region_1",
			region_2: "#foo_layout_region_2"
		},
		onShow: function () {
			var _booksCompositeView = new BooksCompositeView({collection: new BooksCollection()});
			_booksCompositeView.on("booksCompositeEvent", function(e){
				console.log("Detect booksCompositeEvent occurs in view, e:", e);
			});
			this.region_1.show(_booksCompositeView);
			this.region_2.show(new FoodsCompositeView({collection: new FoodsCollection()}));

			//this.region_2.show(new UserView({model: new UserModel({_id: 0})}));
		}
	});
	return layout;
});
