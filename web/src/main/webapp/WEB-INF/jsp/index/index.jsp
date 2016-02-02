<%--
  Created by IntelliJ IDEA.
  User: zhangxuegang
  Date: 2016/1/29
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    request.setAttribute("ctx","http://alsolang.com");
%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>慕课互动</title>

    <!-- core CSS -->
    <link href="${ctx}/assets/module/index/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/prettyPhoto.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/main.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/responsive.css" rel="stylesheet">
    <link href="${ctx}/assets/module/index/css/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${ctx}/assets/module/index/js/html5shiv.js"></script>
    <script src="${ctx}/assets/module/index/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/assets/module/index/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/assets/module/index/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/assets/module/index/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/assets/module/index/images/ico/apple-touch-icon-57-precomposed.png">

</head><!--/head-->

<body class="homepage">
<header id="header">
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-xs-4">
                    <ul class="social-share01">
                        <li><a href="${ctx}/user/userlogin.do">登录</a></li>
                        <li><a href="${ctx}/user/toUserRegister.do">注册</a></li>
                    </ul>
                </div>
                <div class="col-sm-6 col-xs-8">
                    <div class="social">
                        <ul class="social-share">
                            <li><a href="#">会</a></li>
                            <li><a href="#">建</a></li>
                            <li><a href="#">参</a></li>
                            <li><a href="#">联</a></li>
                        </ul>
                        <%--<div class="search">--%>
                        <%--<form role="form">--%>
                        <%--<input type="text" class="search-form" autocomplete="off" placeholder="Search">--%>
                        <%--<i class="fa fa-search"></i>--%>
                        <%--</form>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div><!--/.container-->
    </div><!--/.top-bar-->

    <nav class="navbar navbar-inverse" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html"><img src="${ctx}/assets/module/index/images/logo.png" alt="logo"></a>
            </div>

            <div class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">首页</a></li>
                    <li><a href="about-us.html">互动精品</a></li>
                    <li><a href="${ctx}/conference/getMeetings.do">急速会议</a></li>
                    <li><a href="portfolio.html">创建互动</a></li>
                    <li class="dropdown">
                        <a href="${ctx}/conference/getMeetings.do" class="dropdown-toggle" data-toggle="dropdown">开放会议专区</a>
                        <ul class="dropdown-menu">
                            <li><a href="blog-item.html">艺术</a></li>
                            <li><a href="pricing.html">编程技术</a></li>
                            <li><a href="shortcodes.html">生活、兴趣</a></li>
                        </ul>
                    </li>
                    <li><a href="blog.html">使用说明</a></li>
                    <li><a href="contact-us.html">联系我们</a></li>
                </ul>
            </div>
        </div><!--/.container-->
    </nav><!--/nav-->

</header><!--/header-->

<section id="feature" >
    <div class="container">
        <div class="center wow fadeInDown">
            <h2>快速通道</h2>
            <p class="lead">在线互动的核心功能<br>快速便捷的使用通道，我们竭诚为您服务 </p>
        </div>

        <%--bootstrap弹出层--%>

        <div class="theme-popover">
            <div class="theme-poptit">
                <a href="javascript:void(0);" title="关闭" class="close">×</a>
                <h3>急速创建会议</h3>
            </div>
            <div class="theme-popbod dform">
                <%--<form class="theme-signin" name="loginform"  method="post">--%>
                <div class="theme-signin">
                    <ol>
                        <li><h4>急速创建会议！</h4></li>
                        <li><strong>会议名称：</strong><input class="ipt" type="text" name="userName" id="userName" value="" size="20" /></li>
                        <li><strong>会议密码：</strong><input class="ipt" type="password" name="password" id="password" value="" size="20" /></li>
                        <li id="inviteHrefLi" style="display: none"><strong id="inConference">进入会议：</strong></li>
                        <li id="inviteURLLi" style="display: none"><strong>邀请地址：</strong><input class="ipt" type="inviteURL" name="inviteURL" id="inviteURL" value="" size="20" /></li>
                        <li><input class="btn btn-primary" id="createConference" type="submit" name="submit" value=" 创建会议 " /></li>
                    </ol>
                </div>
                <%--</form>--%>
            </div>
        </div>
        <div class="theme-popover-mask"></div>

        <div class="row">
            <div class="features">
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-bullhorn"></i>
                        <%--<div class="theme-buy">--%>
                            <a class="btn btn-primary btn-large theme-login" href="javascript:;">创建急速会议</a>
                        <%--</div>--%>
                        <h3>你可以瞬间创建临时会议，会议不会记录您的任何信息，随时和小伙伴们组织一个会议</h3>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-comments"></i>
                        <h2>精品课堂</h2>
                        <h3>评选出的精品课堂，由行业专家，对课堂内容，互动气氛，进行专业的打分</h3>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-cloud-download"></i>
                        <h2>开放课堂</h2>
                        <h3>逛逛看看有没有自己感兴趣的课堂主题，感受开放课堂给您带来的喜悦</h3>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-leaf"></i>
                        <h2>创建课堂</h2>
                        <h3>你可以创建一个课堂，设定课堂的主题，可以设定课堂的金额</h3>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-cogs"></i>
                        <h2>鞭策我们</h2>
                        <h3>告诉我们哪里做的不好，你想要的功能，我们会根据您的建议，理性分析，实时更新</h3>
                    </div>
                </div><!--/.col-md-4-->

                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-heart"></i>
                        <h2>一起开发</h2>
                        <h3>此平台的源代码托管于github，欢迎加入我们，一起创建快乐互动新时代</h3>
                    </div>
                </div><!--/.col-md-4-->
            </div><!--/.services-->
        </div><!--/.row-->
    </div><!--/.container-->
</section><!--/#feature-->

<section id="bottom">
    <div class="container wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="widget">
                    <h3>Company</h3>
                    <ul>
                        <li><a href="#">About us</a></li>
                        <li><a href="#">We are hiring</a></li>
                        <li><a href="#">Meet the team</a></li>
                        <li><a href="#">Copyright</a></li>
                        <li><a href="#">Terms of use</a></li>
                        <li><a href="#">Privacy policy</a></li>
                        <li><a href="#">Contact us</a></li>
                    </ul>
                </div>
            </div><!--/.col-md-3-->

            <div class="col-md-3 col-sm-6">
                <div class="widget">
                    <h3>Support</h3>
                    <ul>
                        <li><a href="#">Faq</a></li>
                        <li><a href="#">Blog</a></li>
                        <li><a href="#">Forum</a></li>
                        <li><a href="#">Documentation</a></li>
                        <li><a href="#">Refund policy</a></li>
                        <li><a href="#">Ticket system</a></li>
                        <li><a href="#">Billing system</a></li>
                    </ul>
                </div>
            </div><!--/.col-md-3-->

            <div class="col-md-3 col-sm-6">
                <div class="widget">
                    <h3>Developers</h3>
                    <ul>
                        <li><a href="#">Web Development</a></li>
                        <li><a href="#">SEO Marketing</a></li>
                        <li><a href="#">Theme</a></li>
                        <li><a href="#">Development</a></li>
                        <li><a href="#">Email Marketing</a></li>
                        <li><a href="#">Plugin Development</a></li>
                        <li><a href="#">Article Writing</a></li>
                    </ul>
                </div>
            </div><!--/.col-md-3-->

            <div class="col-md-3 col-sm-6">
                <div class="widget">
                    <h3>Our Partners</h3>
                    <ul>
                        <li><a href="#">Adipisicing Elit</a></li>
                        <li><a href="#">Eiusmod</a></li>
                        <li><a href="#">Tempor</a></li>
                        <li><a href="#">Veniam</a></li>
                        <li><a href="#">Exercitation</a></li>
                        <li><a href="#">Ullamco</a></li>
                        <li><a href="#">Laboris</a></li>
                    </ul>
                </div>
            </div><!--/.col-md-3-->
        </div>
    </div>
</section><!--/#bottom-->

<footer id="footer" class="midnight-blue">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                &copy; 2013 <a target="_blank" href="http://shapebootstrap.net/" title="Free Twitter Bootstrap WordPress Themes and HTML templates">ShapeBootstrap</a>. All Rights Reserved.
            </div>
            <div class="col-sm-6">
                <ul class="pull-right">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Faq</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer><!--/#footer-->

<script src="${ctx}/assets/module/index/js/jquery.js"></script>
<script src="${ctx}/assets/module/index/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/module/index/js/jquery.prettyPhoto.js"></script>
<script src="${ctx}/assets/module/index/js/jquery.isotope.min.js"></script>
<script src="${ctx}/assets/module/index/js/main.js"></script>
<script src="${ctx}/assets/module/index/js/wow.min.js"></script>

<script type="text/javascript">
    jQuery(document).ready(function($) {
        $('.theme-login').click(function(){
            $('.theme-popover-mask').fadeIn(100);
            $('.theme-popover').slideDown(200);
        })
        $('.theme-poptit .close').click(function(){
            $('.theme-popover-mask').fadeOut(100);
            $('.theme-popover').slideUp(200);
        })


        // 异步请求创建会议
        $("#createConference").click(function () {
            var userName = $("#userName").val();
            var password = $("#password").val();
//            alert("userName==>>" + userName);
//            alert("password==>>" + password);
            jQuery.post("${ctx}/conference/createConference.do", {
                userName: userName,
                password: password
            }, function (data) {
                $("#inviteURL").val(data);
                $("#inConference").after("<a href = \""+data+"\"> 点击进入" +"<\/a>");
                $("#inviteHrefLi").show();
                $("#inviteURLLi").show();
            }, "json");
        });
    })

</script>
</body>
</html>