<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>构建角色与用户关系</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <style>
        body{margin: 10px;}
    </style>
</head>
<body>
<div class="layui-container">
    <div class="layui-col-md3">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>角色列表</legend>
        </fieldset>
        <div id="roletree"></div>
    </div>
    <div class="layui-col-md9">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>角色与人员</legend>
        </fieldset>
        <table class="layui-hide" id="userrole" lay-filter="userrole"></table>
    </div>

<script src="/layui/layui.js"></script>
<script>

    var dataArr;
    var tabledatas = [];
    var rolecode = '';

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

    //待写点击跳转加载事件

    layui.use(['laydate', 'laypage', 'layer', 'table','element','tree'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,tree = layui.tree;

            //渲染
            tree.render({
                elem: '#roletree'  //绑定元素
                ,data: dataArr
                ,click: function(obj){
                    //置换table表里面的数据 并且刷新
                    rolecode = obj.data.id;
                    var id = obj.data.id;
                    $.ajax({
                        //几个参数需要注意一下
                        type: "GET",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "./selectUserByRole" ,//url
                        data: {"rolecode":id},
                        success: function (data) {
                            tabledatas = data;
                            refreshReload();
                        }
                    });
                }
            });

        table.render({
            elem: '#userrole'
            /*,height: 'full-200'*/
            ,data : tabledatas
            ,title: '用户角色关系表'
            ,page: true //开启分页
            ,id : 'userRole'
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,cellMinWidth: 80
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'usercode', title: '用户编号', }
                ,{field: 'username', title: '用户名称', sort: true}
            ]]
        });

        table.on('toolbar(userrole)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    if(rolecode == ''){
                        layer.msg("请在左侧选择需要构建关系的角色");
                    }else{
                        addRel(rolecode);
                    }
                    break;
                case 'update':

                    break;
                case 'delete':



                    break;
            };
        });

        function refreshReload(){
            table.reload('userRole', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }

        function addRel(rolecode){
            layer.open({
                type: 2 //此处以iframe举例
                ,title: '角色用户关系'
                ,id : "addRel"
                ,area: ['390px', '260px']
                ,shade: 0
                ,offset: 'auto'
                ,content: './toShowInput'
                ,resize: false
                ,btn: ['提交', '重置','关闭']
                ,yes: function(index){
                    var body = layer.getChildFrame('body', index);
                    body.find('#userroleSubmit').click();
                }
                ,btn2: function(index){
                    var body = layer.getChildFrame('body', index);
                    body.find('#userroleReset').click();
                    return false;
                }
                ,btn3: function(){
                    layer.closeAll();
                }
                ,success: function(layero, index){
                    var body = layer.getChildFrame('body', index);
                    body.find('#rolecode').val(rolecode);
                    body.find('#username').val('');
                }
            });
        }

    });
</script>
</body>
</html>