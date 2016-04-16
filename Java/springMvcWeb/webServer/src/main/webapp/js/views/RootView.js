define(["backbone", "text!templates/FooTemplate.html", "bootstrapTreeView"],function(Backbone, Template){
	var view = Backbone.View.extend({
        el: "#pageContent",
        template: _.template(Template),

        events:{
			"click .sendCmd": "_sendCmdHandler",
			"click .sendMsg": "_sendMsgHandler"
        },
        _sendCmdHandler: function(){
            var that = this;
            var data = {
                cmd: that.$(".cmd").val()
            };
            $.ajax({
                type: "POST",
                url: "rest/adminSendCmd",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(data){
                    if(data.status === "OK"){
                        alert("独立进程命令输出: " + data.msg);
                    }else{
                        alert("错误");
                    }
                },
                error: function(){
                    alert("错误");
                }
            });
        },

        _sendMsgHandler: function(){
            var that = this;
            var data = {
                msg: that.$(".msgContent").val()
            };
            $.ajax({
                type: "POST",
                url: "rest/adminSendMsg",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(data){
                    if(data.status === "OK"){
                        alert("成功");
                    }else{
                        alert("错误");
                    }
                },
                error: function(){
                    alert("错误");
                }
            });
        },

		render: function () {
            var that = this;

			this.$el.html(this.template(this.model.toJSON()));

			this.$(".tree").treeview({data: that._getTree()});
		},

        // example to demo bootstrap tree view
		_getTree: function(){
            return [
              {
                text: "Parent 1",
                icon: "glyphicon glyphicon-stop",
                selectedIcon: "glyphicon glyphicon-stop",
                color: "#000000",
                backColor: "#FFFFFF",
                href: "#node-1",
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
                    text: "Child 1",
                    state: {
                       checked: false,
                       disabled: false,
                       expanded: true,
                       selected: false
                    },
                    nodes: [
                      {
                        text: "Grandchild 1",
                        state: {
                           checked: false,
                           disabled: false,
                           selected: true
                        }
                      },
                      {
                        text: "Grandchild 2"
                      }
                    ]
                  },
                  {
                    text: "Child 2"
                  }
                ]
              },
              {
                text: "Parent 2"
              }
            ];
		}
	});
	return view;
});