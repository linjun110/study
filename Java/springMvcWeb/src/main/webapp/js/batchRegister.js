$(document).ready(function(){
    // create the editor
    var container = document.getElementById("jsoneditor");
    var options = {
        mode: 'code',
        //modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
        modes: ['code'], // allowed modes
        onError: function (err) {
          alert(err.toString());
        },
        onModeChange: function (newMode, oldMode) {
          console.log('Mode switched from', oldMode, 'to', newMode);
        }
      };
    var editor = new JSONEditor(container, options);

    // create the editor2
    var container2 = document.getElementById("jsoneditor2");
    var options2 = {
        mode: 'tree',
        modes: ['form', 'text', 'tree', 'view'], // allowed modes
        onError: function (err) {
          alert(err.toString());
        },
        onModeChange: function (newMode, oldMode) {
          console.log('Mode switched from', oldMode, 'to', newMode);
        }
    };
    var editor2 = new JSONEditor(container2, options2);

    // set json
    var json = [{
            "name": "",
            "password": "",
            "gender": 0,
            "idCard": ""
        }];
    editor.set(json);
    editor2.set(json);

    // get json
    var json = editor.get();

    $("#toTree .convert-right").click(function(){
        editor2.set(editor.get());
    });
    $("#toCode .convert-left").click(function(){
        editor.set(editor2.get());
    });

    $("#batchRegister").click(function(){
        var data = editor.get();

        $.ajax({
            type: "POST",
            url: "rest/adminRestBatchRegister",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function(){
                alert("success");
            },
            error: function(){
                alert("error");
            }
        });
    });
});