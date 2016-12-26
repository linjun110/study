define(['backbone'],function(backbone){
	var model = Backbone.Model.extend({
		idAttribute: "_id",
		urlRoot : '/foods',
		defaults: {
			"name":  "",
			"desc":  ""
		}
	});
	return model;
});
