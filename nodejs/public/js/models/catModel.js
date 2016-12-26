define(['backbone'],function(backbone){
	var model = Backbone.Model.extend({
		idAttribute: "_id",
		urlRoot : '/cats',
		defaults: {
			"name":  "",
			"desc":  ""
		}
	});
	return model;
});
