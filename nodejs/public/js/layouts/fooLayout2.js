define(['marionette', 'text!templates/fooLayoutTemplate2.html', 'views/userView', 'models/userModel', 'views/catsCollectionView', 'models/catsCollection' ],function(marionette, Template, UserView, UserModel, CatsCollectionView, CatsCollection){
//define(['marionette', 'text!templates/fooLayoutTemplate2.html', 'views/foodsCompositeView', 'models/foodsCollection', 'views/catsCollectionView', 'models/catsCollection' ],function(marionette, Template, FoodsCompositeView, FoodsCollection, CatsCollectionView, CatsCollection){
	var layout = Backbone.Marionette.Layout.extend({
		template: Template,
		initialize: function(){
			this.region_1.on("show", function(view){
				console.log("fooLayout2.foo_layout2_region_1 show:",view);
			});
			this.region_1.on("close", function(view){
				console.log("fooLayout2.foo_layout2_region_1 close:",view);
			});
			this.region_2.on("show", function(view){
				console.log("fooLayout2.foo_layout2_region_2 show:",view);
			});
			this.region_2.on("close", function(view){
				console.log("fooLayout2.foo_layout2_region_2 close:",view);
			});
		},
		regions: {
			region_1: "#foo_layout2_region_1",
			region_2: "#foo_layout2_region_2"
		},
		onShow: function () {
			this.region_1.show(new UserView({model: new UserModel({_id: 0})}));
			this.region_2.show(new CatsCollectionView({collection: new CatsCollection()}));

			//this.region_1.show(new FoodsCompositeView({collection: new FoodsCollection()}));
		}
	});
	return layout;
});
