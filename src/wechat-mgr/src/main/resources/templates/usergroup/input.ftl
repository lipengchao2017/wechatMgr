<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>构建用户用户组关系</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        body{margin: 10px;}
    </style>
</head>
<body>
<form class="layui-form" id="saveForm" action="##" onsubmit="return false" method="post">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名称</label>
        <div class="layui-input-block">
            <input type="text" id="groupcode" name="groupcode" hidden="hidden">
            <input type="text" id="username" name="username" lay-verify="required" placeholder="请输入并选择对应的用户" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" hidden>
        <div class="layui-input-block">
            <button id="usergroupSubmit" lay-filter="usergroup" class="layui-btn" lay-submit lay-filter="*">立即提交</button>
            <button id="usergroupReset" type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="/layui/layui.js"></script>
<script type="text/javascript">

    $(function(){



    });

    layui.use(['layer','form'], function(){
        var layer = layui.layer
            ,form = layui.form;

        form.on('submit(usergroup)', function(data){
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "./save" ,//url
                data: $('#saveForm').serialize(),
                success: function (data) {

                }
            });
        });

    })
</script>
</body>
</html>