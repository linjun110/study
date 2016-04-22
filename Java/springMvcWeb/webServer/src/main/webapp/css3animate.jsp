<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <my-taglib:header />
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/css3animate.css">
    <body>
        <div class="container" id="pageContent">
            <div class="col-sm-3">
            </div>
            <div class="col-sm-6">
                <div class="well">
                    <span class="label label-primary">Ref</span>
                    <a target="_blank" href="https://github.com/daneden/animate.css">github</a>
                    <a target="_blank" href="http://www.dowebok.com/demo/2014/98/">效果</a>
                    <a target="_blank" href="http://www.dowebok.com/98.html">1</a>
                </div>
                <div class="well">
                    <div id="animateElem" style="font-size: 20px;color:#ff0000;">GOGOGO</div>
                </div>
            </div>
            <div class="col-sm-3">
            </div>
        </div>
        <div class="container" id="pageContent">
            <div class="col-sm-3">
                <button id="step1" class="btn btn-success">
                    show book
                </button>
                <br>
                <button id="step2" class="btn btn-success">
                    show video
                </button>
                <br>
                <button id="step3" class="btn btn-success">
                    show disc
                </button>
                <br>
            </div>
            <div class="col-sm-9">
                <div id="welcome">
                </div>
                <div id="holder">
                    <div id="imageWrapper">
                        <div id="anchor">
                            <img id="book" class="" src="images/book.png" />
                            <img id="video" class="" src="images/video.png" />
                            <img id="disc" class="" src="images/disc.png" />
                        </div>
                    </div>
                    <div id="textWrapper">
                    </div>
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/css3animate.js'></script>
</html>
