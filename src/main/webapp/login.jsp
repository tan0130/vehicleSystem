<%--
  Created by IntelliJ IDEA.
  User: tan.jinming
  Date: 2018/7/9
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>新能源车辆服务系统</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/base.css">

    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="login-hd">
    <div class="left-bg"></div>
    <div class="right-bg"></div>
    <div class="hd-inner">
        <span class="logo"></span>
        <span class="split"></span>
        <span class="sys-name">新能源车辆服务系统</span>
    </div>
</div>
<div class="login-bd">
    <div class="bd-inner">
        <div class="inner-wrap">
            <div class="lg-zone">
                <div class="lg-box">
                    <div class="lg-label"><h4>用户登录</h4></div>
                    <div class="alert alert-error">
                        <i class="iconfont icon-error"></i>
                        <span><font color="red" class="message"></font></span><%--${formBean.errors.error }--%>
                    </div>
                    <form id="loginForm" method="post"><%--/servlet/LoginServlet--%>
                        <div class="input-item">
                            <i class="iconfont icon-user"></i>
                            <input class="easyui-validatebox" type="text" name="id" id="id" placeholder="请输入用户名" value="${formBean.id }" >
                        </div>
                        <div class="input-item">
                            <i class="iconfont icon-password"></i>
                            <input class="easyui-validatebox" type="password" name="password" id="password" placeholder="请输入密码" value="${formBean.password }">
                        </div>

                        <!-- <div class="input-item1">
                            <input type="radio" name="type" value="管理员" id="admin" style="margin-left:35px" checked="checked">
                            <label for="admin">管理员</label>
                            <input type="radio" name="type" value="员工" id="employee" style="margin-left:35px">
                            <label for="employee">员工</label>
                        </div> -->

                        <div class="lg-check clearfix">
                            <div class="input-item">
                                <i class="iconfont icon-ecurityCode"></i>
                                <input type="text" name="code" placeholder="验证码">
                            </div>
                            <span class="check-code" id="checkCode"><img src="/servlet/ImgServlet"  id="checkImg" onclick="refresh()"></span>

                        </div>
                        <!-- <div class="tips clearfix">
                            <label><input type="checkbox" checked="checked">记住用户名</label>
                            <!--  <a href="javascript:;" class="register">立即注册</a>
                            <a href="javascript:;" class="forget-pwd">忘记密码？</a>-->
                        <div class="enter">
                            <!--  <a href="javascript:;" class="user" onClick="javascript:window.location=''">登录</a>-->
                            <input class= "login" type="button"  onclick="LoginCheck()" value="登录" />
                        </div>
                    </form>
                </div>
            </div>
            <div class="lg-poster"></div>
        </div>
    </div>
    <div class="login-ft">
        <div class="ft-inner">
            <div class="about-us">
                <a href="javascript:;">关于我们</a>
                <a href="javascript:;">法律声明</a>
                <a href="javascript:;">服务条款</a>
                <a href="javascript:;">联系方式</a>
            </div>
            <div class="address">地址：深圳市坪山新区比亚迪路3009号 &nbsp;&nbsp;Copyright&nbsp;©&nbsp;2017&nbsp;-&nbsp;2020&nbsp;研发六科版权所有</div>
            <div class="other-info">建议使用IE8及以上版本浏览器、Firefox或Chrome&nbsp;</div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    function refresh() {
        document.getElementById("checkImg").src = "${pageContext.request.contextPath }/servlet/ImgServlet?" + Math.random();
    }

    function LoginCheck() {
        var id = $('#id').val();
        var password = $('#password').val();
        var checkCode = $('#checkCode').val();
        $('#loginForm').form('submit',{
            url: '/login/check',
            onSubmit: function() {
                if ("" == id) {
                    $('.message')[0].innerHTML = "用户名不能为空";
                } else if ("" == password) {
                    $(".message")[0].innerHTML = "密码不能为空"
                } else if ("" == checkCode) {
                    $('.message')[0].innerHTML = "验证码不能为空;"
                }
            },
            success: function(data) {
                if ("idNotExist" == data) {
                    $('.message')[0].innerHTML = "用户不存在;"
                } else if ("errorPassword" == data) {
                    $('.message')[0].innerHTML = "密码错误;"
                } else {
                    window.location.href = "/vehicle/toMainPage";
                }
            }
        })
    }
</script>
</html>

