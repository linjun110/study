function logout() {
    document.getElementById("logoutForm").submit();
}

$(document).ready(function(){
    $("#register").click(function(){
        window.location.href = "register"
    });
    $("#logout").click(logout);
});