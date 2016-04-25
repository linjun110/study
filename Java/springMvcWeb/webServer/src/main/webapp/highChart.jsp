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
                    <a target="_blank" href="http://www.hcharts.cn/">WebSite</a>
                    <a target="_blank" href="http://www.hcharts.cn/demo/index.php?p=99">Sample Code and Demo</a>
                </div>
                <div class="well">
                    <style>
                    </style>
                    <div class="target">
                    </div>
                    <div class="target2">
                    </div>
                </div>
            </div>
            <div class="col-sm-2">
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/libs/highcharts.js'></script>
    <script type='text/javascript' src='js/libs/highcharts-more.js'></script>
    <script type='text/javascript' src='js/libs/highcharts-3d.js'></script>
    <script type='text/javascript' src='js/highChart.js'></script>
</html>

