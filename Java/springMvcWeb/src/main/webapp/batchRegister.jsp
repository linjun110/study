<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
    <my-taglib:header />
     <link href="css/jsoneditor.min.css" rel="stylesheet" type="text/css">
     <style>
     div.convert-right {
         background: url(css/img/jsoneditor-icons.svg) 0 -48px;
     }
     div.convert-left {
         background: url(css/img/jsoneditor-icons.svg) -24px -48px;
     }
     div.convert-left, div.convert-right {
         width: 24px;
         height: 24px;
         margin: 0;
     }
     button.convert {
         cursor: default;
         padding: 2px;
     }
     #splitter #toCode {
         margin: 20px 0 0;
     }
     #splitter #toTree {
         margin: 40px 0 0;
     }
     </style>
    <body>
        <div class="container body-container">
            <div class="row">
                <div id="main" class="col-sm-5">
                    <div class="well">
                        <div id="jsoneditor" style="width: 400px; height: 400px;"></div>
                    </div>
                </div>

                <div id="main" class="col-sm-2">
                    <div id="splitter" class="well" style="padding:40px;">
                      <img title="meow" src="images/meow.jpg" style="width: 85px; height: 60px;"/>
                      <div style="padding:25px;">
                        <div>
                          <button id="toTree" class="convert" title="Copy code to tree editor (Ctrl + >)">
                            <div class="convert-right"></div>
                          </button>
                        </div>
                        <div>
                          <button id="toCode" class="convert" title="Copy tree to code editor (Ctrl + <)">
                            <div class="convert-left"></div>
                          </button>
                        </div>
                      </div>
                      <div>
                          <button id="batchRegister" class="btn btn-primary">
                              <i class="fa fa-sign-in"></i>批量注册
                          </button>
                      </div>
                    </div>
                </div>

                <div id="main" class="col-sm-5">
                    <div class="well">
                        <div id="jsoneditor2" style="width: 400px; height: 400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script src="js/jsoneditor.min.js"></script>
    <script type='text/javascript' src='js/batchRegister.js'></script>
</html>

