<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome!</title>
        <link rel="icon" type="image/x-icon" href="favicon.ico" />
        <!--<link rel="stylesheet" href='css/app.css' />-->
        <link rel="stylesheet" href='css/bootstrap.css' />
        <link rel="stylesheet" href='css/index.css' />

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
                <div id="main" class="col-sm-3">
                    <div class="well">
                        <form action="login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <label for="username">姓名</label>
                                    <input type="text" id="username" name="username" value="<c:out value="${name}"></c:out>" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="password" id="password" name="password" class="form-control" />
                                </div>
                                <input type="hidden" name="_csrf_token" value="csrf_token"/>
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-sign-in"></i>登录
                                </button>
                                <span class="btn btn-success" id="register">
                                    <i class="fa fa-sign-in"></i>注册
                                </span>
                            </fieldset>
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
        <!--<script type='text/javascript' src='js/app.js'></script>-->
        <script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
        <script type='text/javascript' src='js/bootstrap.js'></script>
        <script type='text/javascript' src='js/bootstrap-datepicker.min.js'></script>
        <script type='text/javascript' src='js/index.js'></script>
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
