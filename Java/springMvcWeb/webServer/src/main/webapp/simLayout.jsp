<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <my-taglib:header />
    <link rel="stylesheet" href="css/simLayout.css">
    <body>
        <div class="container" id="pageContent">
            <div id="view-content-left">
                <div class = "inner-container">
                    <div class = "top-row">
                        <div class = "top-row-left">
                        </div>
                        <div class = "top-row-right">
                        </div>
                    </div>
                    <div id= "search-filter">
                        <label> Search filter
                        <a><i class="icon-question-sign"></i></a>
                        </label>
                        <div class= "current-filters">
                            <div class= "filter-header">
                                Some text
                                <span>clear</span>
                            </div>
                            <hr>
                            <div class= "some-btn-wrapper">
                                <button class="left-btn" title="left">left</button>
                                <button class="right-btn">X</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/simLayout.js'></script>
</html>
