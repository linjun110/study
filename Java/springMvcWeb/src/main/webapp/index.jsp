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
    <link rel="stylesheet" href='css/index.css' />
    <link rel="stylesheet" href='css/mop.css' />
    <body>
        <div class="container body-container">
            <div class="row" style="background-image: url('images/title_bg.jpg');">
                <div class="col-sm-3">
                </div>
                <div id="main" class="col-sm-6">
                    <div id="search">
                        <input type="text" name="q" class="" id="search-box" placeholder="请输入要搜索的游戏" autocomplete="off" />
                        <input type="submit" class="" id="search-box-submit" value/>
                    </div>
                </div>
                <div class="col-sm-3">
                </div>
            </div>
            <div id="bigMenu" class="row">
                <div class="col-sm-2">
                    <div class="game_rec_l">
                        <ul>
                            <li class="p1">
                                <h3><a>p1</a></h3>
                            </li>
                            <li class="p2">
                                <h3><a>p2</a></h3>
                            </li>
                            <li class="p3">
                                <h3><a>p3</a></h3>
                            </li>
                            <li class="p4">
                                <h3><a>p4</a></h3>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="main" class="col-sm-10">
                    <div class="game_rec_r">
                        <ul>
                            <li>
                                <b class="hot">热门游戏</b>
                                <a>梦幻传奇</a>
                                <a>我的世界</a>
                            </li>
                            <li>
                                <b class="zt">游戏专题</b>
                                <a>奇迹暖暖</a>
                                <a>刀塔来了</a>
                            </li>
                            <li>
                                <b class="hj">游戏合辑</b>
                                <a>日式RPG</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div id="myCarousel" class="carousel slide">
                       <!-- 轮播（Carousel）指标 -->
                       <ol class="carousel-indicators">
                          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                          <li data-target="#myCarousel" data-slide-to="1"></li>
                          <li data-target="#myCarousel" data-slide-to="2"></li>
                       </ol>
                       <!-- 轮播（Carousel）项目 -->
                       <div class="carousel-inner">
                          <div class="item active">
                             <img src="images/meow.jpg" alt="First slide">
                             <div class="carousel-caption">标题 1</div>
                          </div>
                          <div class="item">
                             <img src="images/nakoruru.gif" alt="Second slide">
                             <div class="carousel-caption">标题 2</div>
                          </div>
                          <div class="item">
                             <img src="images/meow.jpg" alt="Third slide">
                             <div class="carousel-caption">标题 3</div>
                          </div>
                       </div>
                       <!-- 轮播（Carousel）导航 -->
                       <a class="carousel-control left" href="#myCarousel"
                          data-slide="prev">&lsaquo;</a>
                       <a class="carousel-control right" href="#myCarousel"
                          data-slide="next">&rsaquo;</a>
                    </div>
                </div>
                <div class="col-sm-4">
                    <!-- extract to mop view -->
                    <div class="mop">
                        <div class="head">
                            <a class="link">More</a>
                            <strong class="spec">Spec</strong>
                        </div>
                        <ul class="contents">
                            <li class="content">
                                <a class="image">
                                    <img src='images/meow.jpg'/>
                                </a>
                                <p class="title">
                                    <a>
                                        This is title
                                    </a>
                                </p>
                                <a class="brief">
                                    <p>
                                        This is brief
                                    </p>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-4">
                </div>
            </div>
        </div>
    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/index.js'></script>
</html>
