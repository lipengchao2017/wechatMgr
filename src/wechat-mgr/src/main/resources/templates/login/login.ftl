<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/css/layui/layui.css">
    <script src="/js/layui/layui.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
    <link rel="stylesheet" href="/css/login.css">
    <title>微信SAAS平台登录页</title>
</head>
<body>
<h1>微信SAAS管理平台</h1>

<div class="w3ls-login box">
    <img src="/images/logo.png" alt="logo_img" />
    <form action="./main" method="post">
        <div class="agile-field-txt">
            <input type="text" name="usercode" placeholder="Your UserCode" required="" />
        </div>
        <div class="agile-field-txt">
            <input type="password" name="password" placeholder="Password" required="" id="myInput" />
            <div class="agile_label">
                <input id="check3" name="check3" type="checkbox" value="show password">
                <label class="check" for="check3">Remember me</label>
                <a class="forget" href="">Forget?</a>
            </div>
        </div>
        <div class="w3ls-bot">
            <input type="submit" value="LOGIN">
        </div>
    </form>
</div>

<div class="copy-wthree">
    <p>Copyright &copy; 2019.Company name All rights reserved.</p>
</div>
<script>
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer,
                form = layui.form;



    });
</script>
</body>
</html>