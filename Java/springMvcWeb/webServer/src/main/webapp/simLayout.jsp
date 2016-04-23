<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="my-taglib" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
    <my-taglib:header />
    <link rel="stylesheet" href="css/simLayout.css">
    <link rel="stylesheet" href="css/linjun-ui-button.css">
    <link rel="stylesheet" href="css/linjun-ui-icon.css">
    <link rel="stylesheet" href="css/linjun-ui-block.css">
    <link rel="stylesheet" href="css/linjun-ui-tag.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <body>
        <div class="container" id="pageContent"></div>

        <div id="view-content-left">
            <div class = "inner-container">
                <div class = "top-row">
                    <div class = "top-row-left">
                        <div class = "foo-actions linjun-btn-group">
                            <button class="linjun-btn btn-green">
                                <i class="icon-download"></i>
                            </button>
                            <button class="linjun-btn btn-green">
                                <i class="icon-down-arrow"></i>
                            </button>
                            <ul class="linjun-dropdown-menu">
                                <li>
                                    <a>Export</a>
                                </li>
                                <li>
                                    <a>Download</a>
                                </li>
                            </ul>
                        </div>
                        <button class="linjun-btn btn-green">
                            <i class="icon-down-arrow"></i>
                        </button>
                    </div>
                    <div class = "top-row-right">
                        <div class = "foo-actions linjun-btn-group">
                            <button class="linjun-btn btn-green">
                                <i class="icon-grid"></i>
                            </button>
                            <button class="linjun-btn btn-green">
                                <i class="icon-down-arrow"></i>
                            </button>
                        </div>
                    </div>
                </div>
                <div id= "search-filter">
                    <label> Search filter
                    <a><i class="icon-question-sign"></i></a>
                    </label>

                    <div class= "block-style-1">
                        <div class= "block-header">
                            Some text
                            <span class="block-action">clear</span>
                        </div>
                        <hr>
                        <div class= "filter-wrapper linjun-btn-group">
                            <button class="linjun-btn btn-green left-btn" title="left">filter condition 1</button>
                            <button class="linjun-btn btn-green right-btn">
                                <i class="icon-close"></i>
                            </button>
                        </div>
                        <div class= "filter-wrapper linjun-btn-group">
                            <button class="linjun-btn btn-green left-btn" title="left">filter condition 2</button>
                            <button class="linjun-btn btn-green right-btn">
                                <i class="icon-close"></i>
                            </button>
                        </div>
                        <div class="search-filter">
                            <button class="linjun-btn btn-blue" title="">search</button>
                        </div>
                    </div> <!-- end of div class=block-style-1-->

                    <div class= "block-style-1">
                        <div class= "block-header">
                            Some text
                            <span class="block-action">Select All</span>
                        </div>
                        <hr>
                        <div class= "block-body">
                            <ul>
                                <li>
                                    <a>Unlabled</a>
                                </li>
                                <li>
                                    <a>
                                        <i class="icon-filled-square" style="background-color: red;">
                                        </i>
                                        In Scoping
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div> <!-- end of div class=block-style-1 -->
                </div>
            </div>
        </div> <!-- end of div view-content-left -->

        <div id="view-content-center">
            <div class="left-placeholder">
            </div>
            <div class="inner-container">
                <div class="result-header"></div>
                <div class="result-body">
                    <ul>
                        <li>
                            <div class="result-checkbox">
                                <input type="checkbox" />
                            </div>
                            <div class="result-content">
                                <div class="item-title">
                                    <a><b>Issue whitelisted SBR NA</b></a>
                                </div>
                                <div class="item-time">
                                    <span>43m ago</span>
                                </div>
                                <div class="clearfix">
                                </div>
                                <div class="item-context">
                                    <span>Please note: Seller with WBA features set has not been script to blablabla</span>
                                </div>
                            </div>
                            <div class="result-content-footer">
                                <div class="path">
                                    <span> Ship By Region/SBR Whitelisting </span>
                                </div>
                                <span class="tag-wrapper">
                                    <span class="linjun-tag linjun-tag-issue">
                                        <a>SBR-Whitelisting-184</a>
                                    </span>
                                </span>
                                <span class="tag-wrapper">
                                    <span class="linjun-tag linjun-tag-status-resolved">
                                        <i class="icon-flag"></i>
                                    </span>
                                </span>
                            </div>
                        </li>
                        <li>
                            <div class="result-checkbox">
                                <input type="checkbox" />
                            </div>
                            <div class="result-content">
                                <div class="item-title">
                                    <a><b>Issue whitelisted SBR NA</b></a>
                                </div>
                                <div class="item-time">
                                    <span>43m ago</span>
                                </div>
                                <div class="clearfix">
                                </div>
                                <div class="item-context">
                                    <span>Please note: Seller with WBA features set has not been script to blablabla</span>
                                </div>
                            </div>
                            <div class="result-content-footer">
                                <div class="path">
                                    <span> Ship By Region/SBR Whitelisting </span>
                                </div>
                                <span class="tag-wrapper">
                                    <span class="linjun-tag linjun-tag-issue">
                                        <a>SBR-Whitelisting-184</a>
                                    </span>
                                </span>
                                <span class="tag-wrapper">
                                    <span class="linjun-tag linjun-tag-status-resolved">
                                        <i class="icon-flag"></i>
                                    </span>
                                </span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="result-footer"></div>
            </div>
        </div> <!-- end of div view-content-center -->
        <div id="view-content-right">
            <div class="inner-container">
                <div class="content">
                    <div class="header">
                        <div class="title">
                            <div class="spec">
                                <h2>Issue whitelisting SBR NA week 04/18/2016</h2>
                            </div>
                            <ul class="path">
                                <li>
                                    <span class="icon-dir"></span>
                                </li>
                                <li>
                                    <span class="path-dir">
                                        Ship By Region
                                    </span>
                                    <ul style="display:none;">
                                        <li>
                                            view issue in folder
                                        </li>
                                        <li>
                                            configure folder
                                        </li>
                                        <li>
                                            create issue in folder
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <span class="path-file tag-wrapper">
                                        <span class="linjun-tag linjun-tag-issue">
                                            <a>SBR-Whitelisting-184</a>
                                        </span>
                                    </span>
                                </li>
                            </ul>
                        </div>
                        <div class="control">
                            <div class = "foo-actions linjun-btn-group" style="float:right;">
                                <button class="linjun-btn btn-green">
                                    <i class="icon-email"></i>
                                </button>
                                <button class="linjun-btn btn-green">
                                    <i class="icon-down-arrow"></i>
                                </button>
                            </div>
                            <button class="linjun-btn btn-green" style="float:right;">
                                <i class="icon-plus">1</i>
                            </button>
                        </div>
                        <div class="clearfix">
                        </div>
                    </div> <!-- end of header -->
                    <div class="tab-view-wrapper">
                        <div class="tab-container">
                            <ul>
                                <li>
                                    <a class="selected">Overview</a>
                                </li>
                                <li>
                                    <a>Information</a>
                                </li>
                                <li>
                                    <a>Planing</a>
                                </li>
                            </ul>
                        </div>
                    </div> <!-- end of tab view wrapper -->
                    <div class="document-content">
                        <div class="document-detail">
                            <div class="document-profile">
                            </div>
                            <div class="document-overview-data">
                                <div class="document-options">
                                    <button class="linjun-btn btn-green">
                                        <i class="icon-down-arrow"></i>
                                    </button>
                                </div>
                                <div class="document-text">
                                    Pls Note:
                                    Seller with WBA feature set has not been supported ever since, we have corrected supported feature set in the wiki. Sorry for the mismatch, but WBA sellers will not be able to see new SBR UI even whitelisted already. So please DO NOT make request for sellers with WBA features.
                                </div>
                                <div class="document-options">
                                    <button class="linjun-btn btn-green">
                                        <i class="icon-down-arrow"></i>
                                    </button>
                                    <br>
                                    <button class="linjun-btn btn-green">
                                        <i class="icon-down-arrow"></i>
                                    </button>
                                </div>

                                <div class="tab-view-wrapper">
                                    <div class="tab-container">
                                        <ul>
                                            <li>
                                                <a class="selected">All</a>
                                            </li>
                                            <li>
                                                <a>Updated</a>
                                            </li>
                                            <li>
                                                <a>Worklog</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div> <!-- end of tab view wrapper -->
                                <div class="document-threads">
                                    <div class="document-thread">
                                        <div class="replier">
                                            <img src="images/meow.jpg" />
                                        </div>
                                        <div class="reply-content-wrapper">
                                            <div class="reply-content-title">
                                                <span class="name">linjun</span>
                                                commented on this issue 9d ago | Updated
                                            </div>
                                            <div class="reply-content-body">
                                                Meets all criteria

                                                A2TAF2TSFLZTR7
                                            </div>
                                            <div class="reply-content-toolbar">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="document-thread">
                                        <div class="replier">
                                            <img src="images/meow.jpg" />
                                        </div>
                                        <div class="reply-content-wrapper">
                                            <div class="reply-content-title">
                                                <span class="name">linjun</span>
                                                commented on this issue 9d ago | Updated
                                            </div>
                                            <div class="reply-content-body">
                                                Meets all criteria

                                                A2TAF2TSFLZTR7
                                            </div>
                                            <div class="reply-content-toolbar">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="document-thread">
                                        <div class="replier">
                                            <img src="images/meow.jpg" />
                                        </div>
                                        <div class="reply-content-wrapper">
                                            <div class="reply-content-title">
                                                <span class="name">linjun</span>
                                                commented on this issue 9d ago | Updated
                                            </div>
                                            <div class="reply-content-body">
                                                Meets all criteria

                                                A2TAF2TSFLZTR7
                                            </div>
                                            <div class="reply-content-toolbar">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="document-thread">
                                        <div class="replier">
                                            <img src="images/meow.jpg" />
                                        </div>
                                        <div class="reply-content-wrapper">
                                            <div class="reply-content-title">
                                                <span class="name">linjun</span>
                                                commented on this issue 9d ago | Updated
                                            </div>
                                            <div class="reply-content-body">
                                                Meets all criteria

                                                A2TAF2TSFLZTR7
                                            </div>
                                            <div class="reply-content-toolbar">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div> <!-- end of document content -->
                </div>
            </div>
        </div> <!-- end of div view-content-right -->

    </body>
    <my-taglib:footer />
    <script type='text/javascript' src='js/simLayout.js'></script>
    <script type='text/javascript' src='js/libs/jquery-ui.js'></script>
</html>
