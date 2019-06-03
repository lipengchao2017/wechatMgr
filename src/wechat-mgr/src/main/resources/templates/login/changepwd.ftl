<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>修改密码</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        body{margin: 10px;}
    </style>
</head>
<body>

<form class="layui-form" action="" id="saveForm">
    <div class="layui-form-item">
        <label class="layui-form-label">旧密码</label>
        <div class="layui-input-inline">
            <input type="password" name="oldpassword" required lay-verify="required" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="newpassword" required lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">确认新密码</label>
        <div class="layui-input-inline">
            <input type="password" name="verifypassword" required lay-verify="required" placeholder="请确认新密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux"></div>
    </div>

    <div class="layui-form-item" hidden="hidden">
        <div class="layui-input-block">
            <button id="pwdSubmit" class="layui-btn" lay-submit lay-filter="formPWD">提交</button>
            <button id="pwdReset" type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
<script src="/layui/layui.js"></script>
<script>
    layui.use(['layer','form'], function(){
        var form = layui.form;

        form.on('submit(formPWD)', function(data){
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "text",//预期服务器返回的数据类型
                url: "./save" ,//url
                data: $('#saveForm').serialize(),
                success: function (data) {
                    if(data=="asuccess"){

                    }
                    else if(data=="usuccess") {

                    }
                    else{

                    }
                }
            });
        });
    });
</script>
</body>
</html>