define(['backbone', 'models/catModel'],function(backbone, Model){
	var collection = Backbone.Collection.extend({
  		model: Model,
  		url: "/cats"
	});
	return collection;
});
