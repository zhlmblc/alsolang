<%--
  Created by IntelliJ IDEA.
  User: zhangxuegang
  Date: 2016/1/29
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../common/taglibs.jsp"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="慕课互动首页">
    <meta name="author" content="zhangxuegang">
    <title>慕课互动</title>
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
</head>

<body class="homepage">
<header id="header">
    <%@include file="../common/header.jsp" %>
</header>
<section id="feature" >
    <div class="container">
        <div class="center wow fadeInDown">
            <h2>快速通道</h2>
            <p class="lead">慕课互动在线核心功能的快捷入口</p>
        </div>
        <div class="theme-popover">
            <div class="theme-poptit">
                <a href="javascript:void(0);" title="关闭" class="close">×</a>
                <h3>急速创建会议</h3>
            </div>
            <div class="theme-popbod dform">
                <div class="theme-signin">
                    <ol>
                        <li><h4>急速创建会议！</h4></li>
                        <li><strong>会议名称：</strong><input class="ipt" type="text" name="meetingName" id="meetingName" value="" size="20" /></li>
                        <li><strong>用户名称：</strong><input class="ipt" type="text" name="userName" id="userName" value="" size="20" /></li>
                        <li><strong>会议密码：</strong><input class="ipt" type="password" name="password" id="password" value="" size="20" /></li>
                        <li id="inviteHrefLi" style="display: none"><strong id="inConference">进入会议：</strong></li>
                        <li id="inviteURLLi" style="display: none"><strong>邀请地址：</strong><input class="ipt" type="inviteURL" name="inviteURL" id="inviteURL" value="" size="20" /></li>
                        <li><input class="btn btn-primary" id="createConference" type="submit" name="submit" value=" 创建会议 " /></li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="theme-popover-mask"></div>
        <div class="row">
            <div class="features">
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-bullhorn"></i>
                            <a class="btn btn-primary btn-large theme-login" href="javascript:;">创建一个会议</a>
                        <h3>你可以快速创建一个会议，小伙伴可以查询该会议并参与其中，会议可以提供全程录像，</h3>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-comments"></i>
                        <h2>精品课堂</h2>
                        <h3>评选出的精品课堂，由行业专家，对课堂内容，互动气氛，进行专业的打分</h3>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-cloud-download"></i>
                        <h2>开放课堂</h2>
                        <h3>逛逛看看有没有自己感兴趣的课堂主题，感受开放课堂给您带来的喜悦</h3>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-leaf"></i>
                        <h2>创建课堂</h2>
                        <h3>你可以创建一个课堂，设定课堂的主题，可以设定课堂的金额</h3>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-cogs"></i>
                        <h2>鞭策我们</h2>
                        <h3>告诉我们哪里做的不好，你想要的功能，我们会根据您的建议，理性分析，实时更新</h3>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="feature-wrap">
                        <i class="fa fa-heart"></i>
                        <h2>一起开发</h2>
                        <h3>此平台的源代码托管于github，欢迎加入我们，一起创建快乐互动新时代</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="bottom">
    <%@include file="../common/bottom.jsp" %>
</section>

<footer id="footer" class="midnight-blue">
    <%@include file="../common/footer.jsp" %>
</footer>

<script src="${ctx}/assets/module/index/js/jquery.js"></script>
<script src="${ctx}/assets/module/index/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/module/index/js/jquery.prettyPhoto.js"></script>
<script src="${ctx}/assets/module/index/js/jquery.isotope.min.js"></script>
<script src="${ctx}/assets/module/index/js/main.js"></script>
<script src="${ctx}/assets/module/index/js/wow.min.js"></script>

<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $('.theme-login').click(function () {
            $('.theme-popover-mask').fadeIn(100);
            $('.theme-popover').slideDown(200);
        })
        $('.theme-poptit .close').click(function () {
            $('.theme-popover-mask').fadeOut(100);
            $('.theme-popover').slideUp(200);
        })

        // 异步请求创建会议
        $("#createConference").click(function () {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var meetingName = $("#meetingName").val();
            jQuery.post("${ctx}/conference/createConference.do", {
                userName: userName,
                password: password,
                meetingName: meetingName
            }, function (data) {
                $("#inviteURL").val(data);
                $("#inConference").after("<a href = \"" + data + "\"> 点击进入" + "<\/a>");
                window.location.href = data;
            }, "json");
        });
    })
</script>

</body>
</html>