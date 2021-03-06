<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>角色添加修改</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        body{margin: 10px;}
    </style>
</head>
<body>
    <form class="layui-form" id="saveForm" action="##" onsubmit="return false" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">角色编号</label>
            <div class="layui-input-block">
                <input type="text" hidden="hidden" id="id" name="id">
                <input type="text" id="rolecode" name="rolecode" lay-verify="required" placeholder="请输入角色编号[不可重复]" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">角色名称</label>
            <div class="layui-input-block">
                <input type="text" id="rolename" name="rolename" lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" hidden>
            <div class="layui-input-block">
                <button id="roleSubmit" lay-filter="role" class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                <button id="roleReset" type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <script src="/layui/layui.js"></script>
<script type="text/javascript">

    $(function(){
        $('#rolecode').blur(function(){
            //目前先传递数据库做简单验证
            verifyCode();
        })
    });

    function verifyCode(){
        //获取输入框中的值
        var rolecode = $("#rolecode").val();
        $.ajax({
            //几个参数需要注意一下
            type: "GET",//方法类型
            dataType: "text",//预期服务器返回的数据类型
            url: "./verrify" ,//url
            data: {"rolecode":rolecode},
            success: function (data) {
                if (data == "yes") {
                    layer.msg("系统中存在相同编号，请确认后修改");
                    $("#rolecode").val("");
                }
            }
        });
    }

    layui.use(['layer','form'], function(){
        var layer = layui.layer
            ,form = layui.form;

        form.on('submit(role)', function(data){
            verifyCode();
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "text",//预期服务器返回的数据类型
                url: "./save" ,//url
                data: $('#saveForm').serialize(),
                success: function (data) {
                    if(data=="asuccess"){
                        layer.msg('添加成功',{time: 500},function(){
                            refresh();
                        });
                    }else if(data=="usuccess") {
                        layer.msg('修改成功',{time: 500},function(){
                            refresh();
                        });
                    }else{
                            layer.msg('出现异常问题');
                        }
                    }
                });
            });

            function refresh(){
                var index=parent.layer.getFrameIndex(window.name);
                window.parent.location.reload();
                parent.layer.close(index);
            }

        })
</script>
</body>
</html>