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
                <div id="main" class="col-sm-3">
                    <div class="well">

                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name == null}">
                                <form action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <label for="username">姓名</label>
                                            <input type="text" id="username" name="username" value="<c:out value="${name}"></c:out>" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="password">密码</label>
                                            <input type="password" id="password" name="password" class="form-control" />
                                        </div>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <button type="submit" class="btn btn-primary">
                                            <i class="fa fa-sign-in"></i>登录
                                        </button>
                                        <span class="btn btn-success" id="register">
                                            <i class="fa fa-sign-in"></i>注册
                                        </span>
                                    </fieldset>
                                </form>
                            </c:when>

                            <c:otherwise>
                                谢天谢地你来啦: ${pageContext.request.userPrincipal.name}
                            </c:otherwise>

                        </c:choose>
                        <c:if test="${not empty error}">
                            <div class="error">${error}</div>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </c:if>

                        <c:url value="/j_spring_security_logout" var="logoutUrl" />
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                value="${_csrf.token}" />
                        </form>
                    </div>
                </div>
                <div id="main" class="col-sm-6">
                    <h3>
                        <i class="fa fa-long-arrow-left"></i>
                        Cookies
                    </h3>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Key</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cookies" items="${cookie}">
                            <tr>
                                <td><strong><c:out value="${cookies.key}"/></strong></td>
                                <td><code><c:out value="${cookies.value.value}"/></code></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div id="login-users-help" class="panel panel-default">
                        <div class="panel-body">
                            <p>
                                <span class="label label-success">note</span>
                                Just for debug<br/>
                                <code class="console">$ ./desploy.sh</code>
                            </p>
                        </div>
                    </div>
                </div>
                <div id="sidebar" class="col-sm-3">
                    <div class="section about">
                        <div class="well well-lg">
                            <p>
                                app_description
                            </p>
                            <p>
                                more_information
                            </p>
                        </div>
                    </div>
                    <div class="section source-code">
                        <p>
                            Click on this button to show <strong>Model</strong>
                        </p>
                        <button type="button" class="btn btn-default btn-lg btn-block" data-toggle="modal" data-target="#sourceCodeModal">
                          <i class="fa fa-cogs"></i> Show Modal
                        </button>

                        <div class="modal fade" id="sourceCodeModal" tabindex="-1" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">×</span>
                                        </button>
                                        <h4 class="modal-title"><i class="fa fa-code"></i> Source code used to render this page</h4>
                                    </div>
                                    <div class="modal-body">
                                        <h3>Controller code<small class="pull-right"><a href="subl://open?url=file:///Users/linjun/symfony_demo/src/AppBundle/Controller/SecurityController.php&amp;line=29" title="Click to open this file" class="file_link"><abbr title="/Users/linjun/symfony_demo/src">src</abbr>/AppBundle/Controller/SecurityController.php at line 29</a></small></h3>
                                        <span class="hljs-comment"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/index.js'></script>
</html>
