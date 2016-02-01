<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>慕课互动在线</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${ctx}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/css/form-elements.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${ctx}/assets/module/user/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/assets/module/user/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/assets/module/user/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/assets/module/user/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${ctx}/assets/module/user/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>慕课互动在线</strong> 交流平台</h1>

                    <div class="description">
                        <p>
                            我们的使命：让学习与交流变得简单快乐
                            你可以直接发送建议 <a href="mailto:zhangxuegang@gmail.com?subject=建议函&body=我建议%0d%0ayyy">点击发送邮件<strong></strong></a>, 让我们一起变得更好!
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>登录我们的网站</h3>

                            <p>请输入用户名和密码:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="userindex.do" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">用户名</label>
                                <input type="text" name="userId" placeholder="Username..."
                                       class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <input type="password" name="password" placeholder="Password..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">登录</button>

                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>用以下方式登录:<a href="toUserRegister.do">注册</a></h3>

                    <div class="social-login-buttons">
                        <a class="btn btn-link-1 btn-link-1-facebook" href="#">
                            <i class="fa fa-facebook"></i> Facebook
                        </a>
                        <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                            <i class="fa fa-twitter"></i> Twitter
                        </a>
                        <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                            <i class="fa fa-google-plus"></i> Google Plus
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="${ctx}/assets/jquery/jquery-1.11.3.min.js"></script>
<script src="${ctx}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/module/user/js/jquery.backstretch.min.js"></script>
<script src="${ctx}/assets/module/user/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="${ctx}/assets/module/user/js/placeholder.js"></script>
<![endif]-->

<script type="text/javascript">
    jQuery(document).ready(function () {
        /*
         Fullscreen background
         */
        $.backstretch("${ctx}/assets/module/user/img/backgrounds/1.jpg");

        /*
         Form validation
         */
        $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function () {
            $(this).removeClass('input-error');
        });

        $('.login-form').on('submit', function (e) {

            $(this).find('input[type="text"], input[type="password"], textarea').each(function () {
                if ($(this).val() == "") {
                    e.preventDefault();
                    $(this).addClass('input-error');
                }
                else {
                    $(this).removeClass('input-error');
                }
            });

        });


    });

</script>
</body>
</html>