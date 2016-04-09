<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome!</title>
        <link rel="icon" type="image/x-icon" href="favicon.ico" />
        <!--<link rel="stylesheet" href='css/app.css' />-->
        <link rel="stylesheet" href='css/bootstrap.css' />
        <link rel="stylesheet" href='css/bootstrap-datepicker3.min.css' />

        <div class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index">
                        LINJUN WEBSITE
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                </div>
            </div>
        </div>
    </head>
    <body>
        <div class="container body-container">
            <div class="row">
                <div id="main" class="col-sm-4">
                </div>
                <div id="main" class="col-sm-4">
                    <div class="well">
                        <form action="addUser" method="post">
                            <fieldset>
                                <legend><i class="fa fa-lock"></i>Register</legend>
                                <div class="form-group">
                                    <label>姓名</label>
                                    <input type="text" id="username" name="_username" value="" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input type="password" id="password" name="_password" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label>身份证</label>
                                    <input type="text" id="idCard" name="_idCard" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label>性别</label>
                                    <select class="form-control">
                                        <option value="0">男</option>
                                        <option value="1">女</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>出生日期</label>
                                    <div class="input-append date form_datetime">
                                        <input size="16" type="text" class="datetimeInput" value="" readonly>
                                        <span class="add-on"><i class="icon-th"></i></span>
                                    </div>
                                </div>
                                <input type="hidden" name="_csrf_token" value="csrf_token"/>
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
        <!--<script type='text/javascript' src='js/app.js'></script>-->
        <script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
        <script type='text/javascript' src='js/bootstrap.js'></script>
        <script type='text/javascript' src='js/bootstrap-datepicker.min.js'></script>
        <script type='text/javascript' src='js/register.js'></script>
    </body>
    <footer>
        <div class="container">
            <div class="row">
                <div id="footer-copyright" class="col-md-6">
                    <p>LinJun Project</p>
                    <p></p>
                </div>
                <div id="footer-resources" class="col-md-6">
                    <p> </p>
                </div>
            </div>
        </div>
    </footer>
</html>

