define(['backbone'],function(backbone){
	var model = Backbone.Model.extend({
		idAttribute: "_id",
		urlRoot : '/books',
		defaults: {
			"number":  "",
			"title":  "",
			"author": ""
		}
	});
	return model;
});
