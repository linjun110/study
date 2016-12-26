define(['backbone'],function(backbone){
	var model = Backbone.Model.extend({
		idAttribute: "_id",
		urlRoot : '/users',
		defaults: {
			"name":  ""
		}
	});
	return model;
});
