define(['backbone', 'models/bookModel'],function(backbone, Model){
	var collection = Backbone.Collection.extend({
  		model: Model,
  		url: "/foods"
	});
	return collection;
});
