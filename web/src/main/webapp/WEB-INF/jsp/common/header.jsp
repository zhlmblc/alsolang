<%--
  Created by IntelliJ IDEA.
  User: zhangxuegang
  Date: 2016/2/6
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="top-bar">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-xs-4">
                <ul class="social-share01">
                    <li><a href="${ctx}/user/userlogin.do">登录</a></li>
                    <li><a href="${ctx}/user/toUserRegister.do">注册</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

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
                <li class="active"><a href="${ctx}">首页</a></li>
                <li class="dropdown">
                    <a href="${ctx}/conference/getMeetings.do" class="dropdown-toggle" data-toggle="dropdown">会议模块</a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/conference/getMeetings.do">在线会议</a></li>
                        <li><a href="${ctx}/record/getRecordings.do">会议录像</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="${ctx}/conference/getMeetings.do" class="dropdown-toggle" data-toggle="dropdown">课堂模块</a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/conference/getMeetings.do">在线课堂</a></li>
                        <li><a href="${ctx}/record/getRecordings.do">课堂录像</a></li>
                        <li><a href="${ctx}/record/getRecordings.do">精品课堂</a></li>
                        <li><a href="${ctx}/record/getRecordings.do">开放课堂</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="${ctx}/conference/getMeetings.do" class="dropdown-toggle" data-toggle="dropdown">聊天室</a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/conference/getMeetings.do">在线聊天</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="${ctx}/conference/getMeetings.do" class="dropdown-toggle" data-toggle="dropdown">加入我们</a>
                    <ul class="dropdown-menu">
                        <li><a href="${ctx}/conference/getMeetings.do">一起开发</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

