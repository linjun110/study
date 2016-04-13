<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.linjunbackgroundHolder.navbar{
    height:50px;
}
.linjunbackground.navbar{
    width: 100%;
    position: fixed;
    top: 0px;
    background-color: #f8f8f8;

    box-shadow: 2px 2px 2px #cdcdcd;
}
</style>
<head>
    <meta charset="UTF-8" />
    <title>Meow</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <link rel="stylesheet" href='css/bootstrap.css' />
    <link rel="stylesheet" href='css/bootstrap-datepicker.css' />
    <link rel="stylesheet" href='css/linjun.css' />
    <div class="linjunbackgroundHolder navbar navbar-default navbar-static-top" role="navigation">
    </div>
    <div class="linjunbackground navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <img src="images/nakoruru.gif" title="ya" style="height:50px;width:33px;"/>
                <a class="navbar-brand" href="index">
                林俊的个人小站
                </a>
            </div>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <span class="navbar-brand" href="index" style="float:right;">
                    欢迎: ${pageContext.request.userPrincipal.name}
                    <a href="javascript:logout()"> 登出 </a>
                </span>
            </c:if>

            <div class="navbar-collapse collapse">
            </div>
        </div>
    </div>
</head>
