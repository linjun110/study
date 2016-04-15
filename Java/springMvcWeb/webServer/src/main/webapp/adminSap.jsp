<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href='css/bootstrap-treeview.min.css' />
    <my-taglib:header />
    <body>
        <div class="container" id="pageContent">
        </div>
    </body>
    <my-taglib:footer />
    <script type="text/javascript" data-main="js/sap" src="js/libs/require.js"></script>
</html>
