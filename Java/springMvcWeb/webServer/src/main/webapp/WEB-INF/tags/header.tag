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

    .linjunbackground.navbar.navbar-default .navbar-brand:hover{
        color: red;
    }

    .btn-auth-wrapper {
        line-height: 50px;
        float: right;
    }

    .btn-auth a{
        text-decoration: none;
        cursor: pointer;
        color: #fff;
    }

    .btn-auth a:hover {
        text-decoration: none;
        cursor: pointer;
        color: #fff;
    }
</style>
<head>
    <meta charset="UTF-8" />
    <title>Meow</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <link rel="stylesheet" href='css/libs/bootstrap.css' />
    <link rel="stylesheet" href='css/libs/bootstrap-datepicker.css' />
    <link rel="stylesheet" href='css/linjun.css' />
    <div class="linjunbackgroundHolder navbar navbar-default navbar-static-top" role="navigation">
    </div>
    <div class="linjunbackground navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <img src="images/nakoruru.gif" title="Mamahaha~i~go~yo" style="height:50px;width:33px;"/>
                <a class="navbar-brand" href="index">
                    LinJun的花式作死小站
                </a>
            </div>

            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <div class="btn-auth-wrapper">
                        <button class="btn btn-danger btn-auth">
                            <a class="fa fa-sign-in" href="javascript:logout()">登出</a>
                        </button>
                    </div>
                    <span class="navbar-brand" href="index" style="float:right;">
                        欢迎: ${pageContext.request.userPrincipal.name}
                    </span>
                </c:when>
                <c:otherwise>
                    <div class="btn-auth-wrapper">
                        <button type="submit" class="btn btn-success btn-auth">
                            <a class="fa fa-sign-in" href="login">登录</a>
                        </button>
                    </div>
                </c:otherwise>
            </c:choose>
            <img id="guitailang" src="images/guitailang.gif" title="hm!" style="height:50px;width:50px;float:right;"/>

            <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                    value="${_csrf.token}" />
            </form>

        </div>
    </div>
</head>
