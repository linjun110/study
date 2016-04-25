<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
    <my-taglib:header />
    <body>
        <div class="container body-container">
            <div class="col-sm-2">
            </div>
            <div class="col-sm-8">
                <div class="well">
                    <span class="label label-primary">Ref</span>
                    <a target="_blank" href="https://d3js.org/">Website</a>
                    <a target="_blank" href="https://github.com/mbostock/d3">Github</a>
                </div>
                <div class="well">
                    <style>
                        .target span{
                            display: block;
                            height: 10px;
                            margin-top: 2px;
                            background-color: #cdcdcd;
                        }
                    </style>
                    <div class="target">
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/libs/d3.js'></script>
    <script type='text/javascript' src='js/d3.js'></script>
</html>

