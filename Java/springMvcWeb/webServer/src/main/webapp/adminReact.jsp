<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <my-taglib:header />
    <script src="js/libs/react/react.js"></script>
    <script src="js/libs/react/react-dom.js"></script>
    <script src="js/libs/react/browser.min.js"></script>
    <script src="js/reactPage.js"></script>
    <body>
        <div class="container" id="pageContent">
            hi react
            <div class="container" id="root">
            </div>
            <div id="example"></div>
            <script type="text/babel">
              ReactDOM.render(
                <h1>Hello, world!</h1>,
                document.getElementById('example')
              );
            </script>
        </div>
    </body>
    <my-taglib:footer />
</html>
