$(document).ready(function(){
    $('#animateElem').addClass('animated bounceOutLeft');


    window.cs = null;
    $('#step1').click(function(){
        if(window.cs){
            cs.addClass('off');
        }
        window.cs = $('#book');
        $('#myTarget img').removeClass('open');
        $('#book').removeClass('off');
        $('#book').addClass('open');
    });
    $('#step2').click(function(){
        if(window.cs){
            cs.addClass('off');
        }
        window.cs = $('#video');
        $('#myTarget img').removeClass('open');
        $('#video').removeClass('off');
        $('#video').addClass('open');
    });
    $('#step3').click(function(){
        if(window.cs){
            cs.addClass('off');
        }
        window.cs = $('#disc');
        $('#myTarget img').removeClass('open');
        $('#disc').removeClass('off');
        $('#disc').addClass('open');
    });
});