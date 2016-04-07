<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>Welcome message : <c:out value="${message}"></c:out></h1>
        <h2>Hey cat2!</h2>
        <c:if test="${myBoolean1 == true}">
            <div>myBoolean1</div>
        </c:if>
        <c:if test="${myInt <= 5}">
            <div>Less than 5</div>
        </c:if>
        <script type='text/javascript' src='js/app.js'></script>
    </body>
</html>
