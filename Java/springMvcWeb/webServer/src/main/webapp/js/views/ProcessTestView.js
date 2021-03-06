define(["backbone", "text!templates/ProcessTestTemplate.html", "bootstrapTreeView"],function(Backbone, Template){
	var view = Backbone.View.extend({
        el: "#pageContent",
        template: _.template(Template),

        events:{
			"click .sendCmd": "_sendCmdHandler"
        },

        _sendCmdHandler: function(){
            var that = this;
            var data = {
                cmd: that.$(".cmd").val()
            };
            this._ajaxCall(
                "rest/adminSendCmd",
                data,
                function(data){
                    if(data.status === "OK"){
                        alert("成功, 输出: " + data.msg);
                    }else{
                        alert("错误");
                    }
                },
                function(){
                    alert("错误");
                }
            );
        },

		render: function () {
            var that = this;

            this.$el.undelegate();

			this.$el.html(this.template(this.model.toJSON()));

			this.$(".tree").treeview({
                data: that._getTree(),
                onhoverColor: "#cdcdcd",
                enableLinks: true
            });

            this.delegateEvents();
		},

        // example to demo bootstrap tree view
		_getTree: function(){
            return [
              {
                text: "各种玩",
                icon: "glyphicon glyphicon-stop",
                selectedIcon: "glyphicon glyphicon-stop",
                color: "#000000",
                backColor: "#FFFFFF",
                selectable: true,
                state: {
                   checked: false,
                   disabled: false,
                   expanded: true,
                   selected: false
                },
                tags: ['available'],
                nodes: [
                  {
                    text: "运行后端独立进程",
                    href: "#routeSendCmd",
                    state: {
                       checked: false,
                       disabled: false,
                       selected: false
                    }
                  },
                  {
                    text: "RabbitMq",
                    href: "#routeSendMsg"
                  },
                  {
                    text: "Redis",
                    href: "#routeRedis"
                  }
                ]
              }
              /*
              * add more level1 node here
              */
            ];
		},

        _ajaxCall: function(url, data, successCb, errorCb){
            $.ajax({
                type: "POST",
                url: url,
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(response){
                    if(successCb){
                        successCb(response);
                    }
                },
                error: function(){
                    if(errorCb){
                        errorCb();
                    }
                }
            });
        },
	});
	return view;
});