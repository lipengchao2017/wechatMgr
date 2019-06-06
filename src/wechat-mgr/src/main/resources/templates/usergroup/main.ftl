<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>构建用户组与用户关系</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <style>
        body{margin: 10px;}
    </style>
</head>
<body>
<div class="layui-col-md3">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>角色列表</legend>
    </fieldset>
    <div style="height: 200px">
        <div id="roletree"></div>
    </div>
</div>
<div class="layui-col-md9">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>角色与人员</legend>
    </fieldset>
    <table class="layui-hide" id="userrole" lay-filter="userrole"></table>
</div>

<script src="/layui/layui.js"></script>
<script>

    $(function () {
        $.ajax({
            //几个参数需要注意一下
            type: "GET",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "./getTree" ,//url
            success: function (data) {
                dataArr = data;
            }
        });
    })

    layui.use(['laydate', 'laypage', 'layer', 'table','element'], function(){

    });
</script>
</body>
</html>