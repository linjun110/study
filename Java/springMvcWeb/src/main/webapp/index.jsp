<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Welcome!</title>
        <link rel="icon" type="image/x-icon" href="favicon.ico" />
        <link rel="stylesheet" href='css/app.css' />

        <div class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">
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
                        <form action="/login" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <label for="username">姓名</label>
                                    <input type="text" id="username" name="_username" value="" class="form-control"/>
                                </div>
                                <div class="form-group">
                                    <label for="password">密码</label>
                                    <input type="password" id="password" name="_password" class="form-control" />
                                </div>
                                <input type="hidden" name="_csrf_token" value="csrf_token"/>
                                <button type="submit" class="btn btn-primary">
                                    <i class="fa fa-sign-in"></i>登录
                                </button>
                            </fieldset>
                        </form>
                    </div>
                </div>
                <div id="main" class="col-sm-6">
                    <h3>
                        <i class="fa fa-long-arrow-left"></i>
                        Position 1
                    </h3>
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>linjun</td>
                                <td>linjun</td>
                                <td><code>ROLE_USER</code></td>
                            </tr>
                            <tr>
                                <td>lichun</td>
                                <td>lichun</td>
                                <td><code>ROLE_ADMIN</code></td>
                            </tr>
                        </tbody>
                    </table>
                    <div id="login-users-help" class="panel panel-default">
                        <div class="panel-body">
                            <p>
                                <span class="label label-success">note</span>
                                reload_fixtures<br/>
                                <code class="console">$ php app/console doctrine:fixtures:load</code>
                            </p>
                            <p>
                                <span class="label label-success">tip</span>
                                add_user<br/>
                                <code class="console">$ php app/console app:add-user</code>
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
                            Click on this button to show the source code of the <strong>Controller</strong> and <strong>template</strong> used to render this page.
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
        <script type='text/javascript' src='js/app.js'></script>
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
