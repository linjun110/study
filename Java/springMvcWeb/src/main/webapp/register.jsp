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
                        <form action="addUser" method="post" commandName="employee" role="form">
                            <fieldset>
                                <legend><i class="fa fa-lock"></i>Register</legend>
                                <div class="form-group">
                                    <label>姓名</label>
                                    <input type="text" id="username" name="username" value="" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input type="password" id="password" name="password" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label>身份证</label>
                                    <input type="text" id="idCard" name="idCard" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label>性别</label>
                                    <select class="form-control" name="gender">
                                        <option value="0">男</option>
                                        <option value="1">女</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>出生日期</label>
                                    <div class="input-append date form_datetime">
                                        <input size="16" type="text" class="datetimeInput" name="birthday" value="" readonly>
                                        <span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-sign-in"></i>注册
                                </button>
                            </fieldset>
                        </form>
                    </div>
                </div>
                <div id="main" class="col-sm-4">
                </div>
            </div>
        </div>
    </body>
    <script type='text/javascript' src='js/register.js'></script>
    <my-taglib:footer />
</html>

