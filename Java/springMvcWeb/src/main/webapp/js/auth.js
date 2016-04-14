function logout() {
    document.getElementById("logoutForm").submit();
}
function animateGo() {
    $("#guitailang").attr("src", "images/guitailang.gif");
    $("#guitailang").animate({
        marginRight:"800px"
    }, {
        duration: 6000,
        complete: function(){
            setTimeout(animateBack, 1000);
        }
    });
}

function animateBack() {
    $("#guitailang").attr("src", "images/haomaru.gif");
    $("#guitailang").animate({
        marginRight:"0px"
    }, {
        duration: 6000,
        complete: function(){
            setTimeout(animateGo, 1000);
        }
    });
}

$(document).ready(function(){
    $("#register").click(function(){
        window.location.href = "register"
    });
    $("#logout").click(logout);

    animateGo();
});