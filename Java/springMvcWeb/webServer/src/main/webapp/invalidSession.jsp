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
            <div class="row">
                <div id="main" class="col-sm-4">
                </div>
                <div id="main" class="col-sm-4">
                    <div class="well">
                    Invalid session!!
                    </div>
                </div>
                <div id="main" class="col-sm-4">
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
</html>

