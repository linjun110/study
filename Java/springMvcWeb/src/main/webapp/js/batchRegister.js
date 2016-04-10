$(document).ready(function(){
    // create the editor
    var container = document.getElementById("jsoneditor");
    var options = {
        mode: 'code',
        modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
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
        modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
        onError: function (err) {
          alert(err.toString());
        },
        onModeChange: function (newMode, oldMode) {
          console.log('Mode switched from', oldMode, 'to', newMode);
        }
      };
    var editor2 = new JSONEditor(container2, options2);

    // set json
    var json = {
        "Array": [1, 2, 3],
        "Boolean": true,
        "Null": null,
        "Number": 123,
        "Object": {"a": "b", "c": "d"},
        "String": "Hello World"
    };
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
});