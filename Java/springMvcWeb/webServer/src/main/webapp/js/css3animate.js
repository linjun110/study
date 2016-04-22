$(document).ready(function(){
    $('#animateElem').addClass('animated bounceOutLeft');

    // Define the effect to use.
    $('#holder img').addClass('slideDownClose');
    $('#imageWrapper').addClass('minClose');
    $('#textWrapper').addClass('minClose');

    // show welcome
    $('#welcome').show();

    var animationCache = {};
    $('#step1').click(function(){
        _navigateToElem('book', animationCache);
    });

    $('#step2').click(function(){
        _navigateToElem('video', animationCache);

        $('#imageWrapper').removeClass('minClose').addClass('minOpen').addClass('animated');
    });

    $('#step3').click(function(){
        _navigateToElem('disc', animationCache);
    });

});

function _navigateToElem(name, cache){
    if(cache.prev){
        cache.prev.addClass('slideDownClose');
    }
    cache.prev = $('#'+name);

    // any action should hide the welcome.
    $('#welcome').hide();

    $('#holder').show();
    $('#holder img').removeClass('slideDownOpen');
    $('#'+name).removeClass('slideDownClose').addClass('slideDownOpen').addClass('animated');
}
