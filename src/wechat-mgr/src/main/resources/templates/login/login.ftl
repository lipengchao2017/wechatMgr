<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
    <title>登录页</title>
</head>
<body>
    <h2>首页</h2>
    <font>
        <#list userList as item>
            ${item!}<br>
        </#list>
    </font>

    <button class="a">click me</button>
</body>
</html>