<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8" />
    <title>Meow</title>
    <link rel="icon" type="image/x-icon" href="favicon.ico" />
    <link rel="stylesheet" href='css/bootstrap.css' />
    <link rel="stylesheet" href='css/index.css' />
    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="index">
                    LINJUN WEBSITE
                </a>
            </div>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <span class="navbar-brand" href="index" style="float:right;">
                    Welcome : ${pageContext.request.userPrincipal.name}
                    <a href="javascript:logout()"> Logout</a>
                </span>
            </c:if>

            <div class="navbar-collapse collapse">
            </div>
        </div>
    </div>
    <style>
        .error {
            padding: 15px;
            margin-top: 5px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
