<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <my-taglib:header />
    <link rel="stylesheet" href="css/3dbutton.css">
    <body>
        <style>
            .container .btn2{
                margin-right: 100px;
            }

            a.tryBA {
                position: relative;
                display: inline-block;
                outline: none;
                text-decoration: none;
                color: #000;
                font-size: 32px;
                padding: 5px 10px;
            }

            a.tryBA:hover::before, a.tryBA:hover::after { position: absolute; }
            a.tryBA:hover::before { content: "\5B"; left: -10px; }
            a.tryBA:hover::after { content: "\5D"; right:  -10px; }
        </style>
        <div class="container" id="pageContent">
            <a href="" class="btn2 btn_demo1">1</a>
            <a href="" class="btn2 btn_demo2">2</a>
            <a href="" class="btn2 btn_demo3">3</a>
            <a href="" class="btn2 btn_demo4">4</a>
            <a href="" class="btn2 btn_demo5">5</a>

            <a href="" class="tryBA">try1</a>
            <a href="" class="tryBA">try2</a>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/3dbutton.js'></script>
</html>
