<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>
<%@ page import="java.util.List"%>
<%@ page import="com.linjun.java.springMvcWeb.bo.Employee"%>
<%@ page import="com.linjun.java.springMvcWeb.helpers.EmployeeHelper"%>
<!DOCTYPE html>
<html>
    <my-taglib:header />
    <body>
        <div class="container body-container">
            <my-taglib:search />
            <div id="bigMenu" class="row" style="background-color: #fff;">
                <div class="col-sm-2">
                    <my-taglib:paopaonetmenu_left />
                </div>
                <div id="main" class="col-sm-10">
                    <my-taglib:paopaonetmenu_right />
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">

                    <my-taglib:head_style_1 style_bg_color="#ff0000" head="head" link="link" />
                    <div class="contentWrapper">
                        <ul class="contents">
                            <my-taglib:li_style_1 />
                            <my-taglib:li_style_3 image_src="images/meow.jpg" title="title" brief="brief" />
                        </ul>
                    </div>
                    <my-taglib:tail_style_1 />

                    <my-taglib:carousel />

                </div>
                <div class="col-sm-4">
                    <my-taglib:head_style_1 head="head" link="link" />
                    <div class="contentWrapper">
                        <ul class="contents">
                            <my-taglib:li_style_3 image_src="images/meow.jpg" title="title" brief="brief" />
                        </ul>
                    </div>
                    <my-taglib:tail_style_1 />

                    <my-taglib:head_style_1 style_bg_color="#adcded" head="head" link="link" />
                    <div class="contentWrapper">
                        <ul class="contents">
                            <my-taglib:li_style_3 image_src="images/meow.jpg" title="title" brief="brief" />
                        </ul>
                    </div>
                    <my-taglib:tail_style_1 />
                </div>
                <div class="col-sm-4">
                    <my-taglib:head_style_2 head="head" link="link" />
                    <div class="contentWrapper">
                        <ul class="contents">
                            <my-taglib:li_style_1 />
                            <my-taglib:li_style_2 spec="我又饿了" link="http://www.baidu.com"/>
                            <my-taglib:li_style_3 image_src="images/meow.jpg" title="title" brief="brief" />
                        </ul>
                    </div>
                    <my-taglib:tail_style_1 />

                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/index.js'></script>
</html>
