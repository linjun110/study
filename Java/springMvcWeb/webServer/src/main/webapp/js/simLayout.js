function adjustViewRight(){
    var center_width = parseInt($("#view-content-center .inner-container").css("width"), 10);
    var left_width = parseInt($("#view-content-left").css("width"), 10);
    $("#view-content-right").css("margin-left", (center_width + left_width) + "px" );
    $("#view-content-right").css("width", "calc(100% - " +(center_width + left_width) + "px)" );
}

$(document).ready(function(){
    $( "#view-content-left" ).resizable({
        minWidth: 50,
        maxWidth: 300,
        resize: function(event, ui){
            $("#view-content-center .inner-container").css("left", ui.size.width);
            adjustViewRight();
        }
    });

    $( "#view-content-center .inner-container .result-body" ).resizable({
        minWidth: 50,
        maxWidth: 500,
        resize: function(event, ui){
            $("#view-content-center .inner-container").css("width", ui.size.width);
            $("#view-content-center .result-header").css("width", ui.size.width);
            $("#view-content-center .result-footer").css("width", ui.size.width);

            adjustViewRight();
        }
    });
});
