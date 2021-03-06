<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>
<%@ page import="java.util.List"%>
<%@ page import="com.linjun.java.springMvcWeb.dal.bo.Employee"%>
<%@ page import="com.linjun.java.springMvcWeb.dal.helpers.EmployeeHelper"%>
<!DOCTYPE html>
<html>
    <my-taglib:header />
    <style>
    .password{
        width: 140px;
        word-wrap: break-word;
        word-break: break-all;
    }
    .cookie_value{
        word-wrap: break-word;
        word-break: break-all;
    }
    </style>
    <body>
        <div class="container body-container">
            <div class="row">
                <div id="main" class="col-sm-2">
                    <div class="well">

                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name == null}">
                                <form action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <label for="username">姓名</label>
                                            <input type="text" autofocus id="username" name="username" value="<c:out value="${name}"></c:out>" class="form-control"/>
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
                    </div>
                </div>
                <div id="main" class="col-sm-8">
                    <h3>
                        <i class="fa fa-long-arrow-left"></i>
                        Employees
                    </h3>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th class="password">password</th>
                                <th>idcard</th>
                            </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Employee> employees = EmployeeHelper.get();
                            for(Employee e: employees){
                        %>
                            <tr>
                                <td><strong>
                        <%=
                            e.getId()
                        %>
                                </strong></td>
                                <td>
                        <%=
                            e.getName()
                        %>
                                </td>
                                <td class="password">
                        <%=
                            e.getPassword()
                        %>
                                </td>
                                <td>
                        <%=
                            e.getIdCard()
                        %>
                                </td>
                            </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                    <h3>
                        <i class="fa fa-long-arrow-left"></i>
                        Cookies
                    </h3>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Key</th>
                                <th class="cookie_value">Value</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cookies" items="${cookie}">
                            <tr>
                                <td><strong><c:out value="${cookies.key}"/></strong></td>
                                <td class="cookie_value"><code><c:out value="${cookies.value.value}"/></code></td>
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
                <div id="sidebar" class="col-sm-2">
                    <div class="section about">
                        <div class="well well-lg">
                            <p>
                                some information
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
    <script type='text/javascript' src='js/login.js'></script>
</html>
