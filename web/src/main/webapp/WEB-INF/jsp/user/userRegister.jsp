<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../common/taglibs.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>慕课互动在线注册</title>
    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="${ctx}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/css/form-elements.css">
    <link rel="stylesheet" href="${ctx}/assets/module/user/css/userregister.css">

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

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Bootstrap Multi Step Registration Form Template</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
							<%--<span class="li-text">--%>
								<%--Put some text or--%>
							<%--</span>--%>
                    <%--<a href="#"><strong>links</strong></a>--%>
							<%--<span class="li-text">--%>
								<%--here, or some icons:--%>
							<%--</span>--%>
							<%--<span class="li-social">--%>
								<%--<a href="#"><i class="fa fa-facebook"></i></a>--%>
								<%--<a href="#"><i class="fa fa-twitter"></i></a>--%>
								<%--<a href="#"><i class="fa fa-envelope"></i></a>--%>
								<%--<a href="#"><i class="fa fa-skype"></i></a>--%>
							<%--</span>--%>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>慕课互动在线</strong>会员注册</h1>
                    <div class="description">
                        <p>
                            <%--This is a free responsive multi-step registration form made with Bootstrap.--%>
                            <%--Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!--%>
                            注册后，您将可以浏览和使用此网站的全部功能，此为限时注册，30日以后注册用户将不再提供全部服务
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">

                    <form role="form" method="post" action="userRegister.do" class="registration-form">

                        <%--<fieldset>--%>
                            <%--<div class="form-top">--%>
                                <%--<div class="form-top-left">--%>
                                    <%--<h3>第 1 / 3 步</h3>--%>
                                    <%--<p>让我们知道你是谁:</p>--%>
                                <%--</div>--%>
                                <%--<div class="form-top-right">--%>
                                    <%--<i class="fa fa-user"></i>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="form-bottom">--%>
                                <%--<div class="form-group">--%>
                                    <%--<label class="sr-only" for="form-first-name">长辈给起的名字</label>--%>
                                    <%--<input type="text" name="userName" placeholder="First name..." class="form-first-name form-control" id="form-first-name">--%>
                                <%--</div>--%>
                                <%--<div class="form-group">--%>
                                    <%--<label class="sr-only" for="form-last-name">自己起的酷酷的名字</label>--%>
                                    <%--<input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">--%>
                                <%--</div>--%>
                                <%--<div class="form-group">--%>
                                    <%--<label class="sr-only" for="form-about-yourself">一句话描述下你</label>--%>
                                    <%--<textarea name="form-about-yourself" placeholder="About yourself..."--%>
                                              <%--class="form-about-yourself form-control" id="form-about-yourself"></textarea>--%>
                                <%--</div>--%>
                                <%--<button type="button" class="btn btn-next">下一步</button>--%>
                            <%--</div>--%>
                        <%--</fieldset>--%>

                        <fieldset>
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>第 1 / 2 步</h3>
                                    <p>设置你的账户:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-key"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <div class="form-group">
                                    <label class="sr-only" for="form-email">邮箱</label>
                                    <input type="text" name="email" placeholder="Email..." class="form-email form-control" id="form-email">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">密码</label>
                                    <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-repeat-password">重复下密码</label>
                                    <input type="password" name="repeatPassword" placeholder="Repeat password..."
                                           class="form-repeat-password form-control" id="form-repeat-password">
                                </div>
                                <%--<button type="button" class="btn btn-previous">上一步</button>--%>
                                <button type="button" class="btn btn-next">下一步</button>
                            </div>
                        </fieldset>

                        <fieldset>
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>第 2 / 2 步</h3>
                                    <p>社交资料:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-twitter"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <div class="form-group">
                                    <label class="sr-only" for="form-facebook">手机</label>
                                    <input type="text" name="mobile" placeholder="mobile..." class="form-facebook form-control" id="form-facebook">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-twitter">姓名</label>
                                    <input type="text" name="userName" placeholder="Name..." class="form-twitter form-control" id="form-twitter">
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-google-plus">qq</label>
                                    <input type="text" name="qq" placeholder="qq..." class="form-google-plus form-control" id="form-google-plus">
                                </div>
                                <button type="button" class="btn btn-previous">上一步</button>
                                <button type="submit" class="btn">注册!</button>
                            </div>
                        </fieldset>

                    </form>

                </div>
            </div>
        </div>
    </div>

</div>

<!-- Javascript -->
<!-- Javascript -->
<script src="${ctx}/assets/jquery/jquery-1.11.3.min.js"></script>
<script src="${ctx}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/assets/module/user/js/jquery.backstretch.min.js"></script>
<script src="${ctx}/assets/module/user/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="${ctx}/assets/module/user/js/placeholder.js"></script>
<![endif]-->

<script type="text/javascript">
    jQuery(document).ready(function() {
        /*
         Fullscreen background
         */
        $.backstretch("${ctx}/assets/module/user/img/backgrounds/2.jpg");

        $('#top-navbar-1').on('shown.bs.collapse', function(){
            $.backstretch("resize");
        });
        $('#top-navbar-1').on('hidden.bs.collapse', function(){
            $.backstretch("resize");
        });

        /*
         Form
         */
        $('.registration-form fieldset:first-child').fadeIn('slow');

        $('.registration-form input[type="text"], .registration-form input[type="password"], .registration-form textarea').on('focus', function() {
            $(this).removeClass('input-error');
        });

        // next step
        $('.registration-form .btn-next').on('click', function() {
            var parent_fieldset = $(this).parents('fieldset');
            var next_step = true;

            parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
                if( $(this).val() == "" ) {
                    $(this).addClass('input-error');
                    next_step = false;
                }
                else {
                    $(this).removeClass('input-error');
                }
            });

            if( next_step ) {
                parent_fieldset.fadeOut(400, function() {
                    $(this).next().fadeIn();
                });
            }

        });

        // previous step
        $('.registration-form .btn-previous').on('click', function() {
            $(this).parents('fieldset').fadeOut(400, function() {
                $(this).prev().fadeIn();
            });
        });

        // submit
        $('.registration-form').on('submit', function(e) {

            $(this).find('input[type="text"], input[type="password"], textarea').each(function() {
                if( $(this).val() == "" ) {
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