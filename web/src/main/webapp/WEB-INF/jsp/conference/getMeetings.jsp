<%--
  Created by IntelliJ IDEA.
  User: zhangxuegang
  Date: 2016/2/2
  Time: 14:55
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
  <%@include file="../common/header.jsp" %>
</header>

<section id="feature" >
  <div class="container">
    <div class="center wow fadeInDown">
      <h2>标签快速搜索区域预留</h2>
      <%--<p class="lead">在线互动的核心功能<br>快速便捷的使用通道，我们竭诚为您服务 </p>--%>
    </div>

    <%--bootstrap弹出层--%>

    <div class="theme-popover">
      <div class="theme-poptit">
        <a href="javascript:void(0);" title="关闭" class="close">×</a>
        <h3>快速加入会议</h3>
      </div>
      <div class="theme-popbod dform">
        <div class="theme-signin">
          <ol>
            <li><h4>加入此会议！</h4></li>
            <li><strong>会议名称：</strong><input class="ipt" type="text" name="meetingName" id="meetingName" value="" size="20" /></li>
            <%--隐藏会议id字段,然后进入该会议--%>
            <input type="hidden" name = "meetingID" value="">
              <li><strong>你的名字：</strong><input class="ipt" type="fullName" name="fullName" id="fullName" value="" size="20" /></li>
            <li><strong>会议密码：</strong><input class="ipt" type="password" name="password" id="password" value="" size="20" /></li>
            <li id="inviteHrefLi" style="display: none"><strong id="inConference">进入会议：</strong></li>
            <li id="inviteURLLi" style="display: none"><strong>邀请地址：</strong><input class="ipt" type="inviteURL" name="inviteURL" id="inviteURL" value="" size="20" /></li>
            <li><input class="btn btn-primary" id="joinConference" type="submit" name="submit" value=" 加入会议 " /></li>
          </ol>
        </div>
      </div>
    </div>
    <div class="theme-popover-mask"></div>

    <div class="row">
      <div class="features">
        <c:forEach var="meeting"  items="${meetings}" >
          <%--<input type = "text" value = "${meetings}">--%>
          <div class="col-md-4 col-sm-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms">
            <div class="feature-wrap">
              <i class="fa fa-bullhorn"></i>
              <div>会议名称：<td>${meeting.meetingName }</td></div>
              <div>已参加人数：<td>${meeting.participantCount }</td></div>
              <div>人数限制：<td>${meeting.maxUsers }</td></div>
                <td>
                  <a class="btn btn-primary btn-large theme-login" href="javascript:void(0);" onclick='joinMeeting("${meeting.meetingID}","${meeting.meetingName}")'> 加入会议</a>
                </td>
              </tr>
                <%--<h3>加入会议</h3>--%>
            </div>
          </div><!--/.col-md-4-->
        </c:forEach>
      </div><!--/.services-->
    </div><!--/.row-->
  </div><!--/.container-->
</section><!--/#feature-->

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

  // 加入会议
  function joinMeeting(meetingID, meetingName) {
    $("#meetingName").val(meetingName);
    $('.theme-popover-mask').fadeIn(100);
    $('.theme-popover').slideDown(200);
    $("#joinConference").click(function () {
      $("#meetingID").val(meetingID);
      var password = $("#password").val();
      var fullName = $("#fullName").val();
      jQuery.post("${ctx}/conference/joinConference.do", {
        meetingID: meetingID,
        password: password,
        fullName: fullName
      }, function (data) {
        window.location.href = data;
      }, "json");
    })
  }

  jQuery(document).ready(function () {
    // 关闭弹出层
    $('.theme-poptit .close').click(function () {
      $('.theme-popover-mask').fadeOut(100);
      $('.theme-popover').slideUp(200);
    })
  })

</script>
</body>
</html>