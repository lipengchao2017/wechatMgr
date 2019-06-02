<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>用户维护</title>
    <script type="text/javascript" src="/jars/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        body{margin: 10px;}
    </style>
</head>
<body>
<table class="layui-hide" id="user" lay-filter="user"></table>

<script type="text/html" id="userBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/layui/layui.js"></script>
<script>
    layui.use(['laydate', 'laypage', 'layer', 'table','element'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element;

        //执行一个 table 实例
        table.render({
            elem: '#user'
            /*,height: 'full-200'*/
            ,url: './show' //数据接口
            ,title: '用户表'
            ,page: true //开启分页
            ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,cellMinWidth: 80
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'userid', title: 'ID', sort: true, fixed: 'left'}
                ,{field: 'usercode', title: '用户编号', }
                ,{field: 'username', title: '用户名称', sort: true}
                ,{field: 'creator', title: '创建人'}
                ,{field: 'createtime', title: '创建时间'}
                ,{field: 'updator', title: '修改者'}
                ,{field: 'updatetime', title: '修改时间'}
                ,{fixed: 'right', align:'center', width: 165 , toolbar: '#userBar'}
            ]]
        });

        //监听头工具栏事件
        table.on('toolbar(user)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    data = [];
                    addOrUpdate(data);
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        addOrUpdate(data);
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请至少选择一行进行删除操作');
                    } else {
                        layer.confirm('真的删除所选中行么', function(index) {
                            delUserData(data);
                        });
                    }
                    break;
            };
        });

        function addOrUpdate(data){
            var codes = [];
            if(Array.isArray(data)){
                for (var i =0;i<data.length;i++){
                    codes.push(data[i]);
                }
            }else{
                codes.push(data);
            }

            layer.open({
                type: 2 //此处以iframe举例
                ,title: '用户维护'
                ,id : "add"
                ,area: ['390px', '260px']
                ,shade: 0
                ,maxmin: true
                ,offset: 'auto'
                ,content: './showInput'
                ,resize: false
                ,btn: ['提交', '重置','关闭']
                ,yes: function(index){
                    var body = layer.getChildFrame('body', index);
                    body.find('#userSubmit').click();
                }
                ,btn2: function(index){
                    var body = layer.getChildFrame('body', index);
                    body.find('#userReset').click();
                    return false;
                }
                ,btn3: function(){
                    layer.closeAll();
                }
                ,success: function(layero, index){
                    if(codes.length > 0){
                        var body = layer.getChildFrame('body', index);
                        var userData = codes[0];
                        body.find('#usercode').val(userData.usercode);
                        body.find('#username').val(userData.username);
                        body.find('#userid').val(userData.userid);
                    }else{
                        var body = layer.getChildFrame('body', index);
                        body.find('#usercode').val('');
                        body.find('#username').val('');

                        body.find('#userid').val('');
                    }
                }
            });
        }

        function delUserData(data){
            var codes = [];
            if(Array.isArray(data)){
                for (var i =0;i<data.length;i++){
                    codes.push(data[i].usercode);
                }
            }else{
                codes.push(data.usercode);
            }

            $.ajax({
                url:'./del',
                type:"POST",
                data:{"ids":JSON.stringify(codes)},
                success:function (data) {
                    layer.msg('成功删除了'+data+'条数据');
                    tabReload();
                }
            })
        }

        function tabReload(){
            table.reload('group', {
                url: './show'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        }

        //监听行工具事件
        table.on('tool(user)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    delUserData(data);
                    layer.close(index);
                });
            } else if(layEvent === 'edit'){
                addOrUpdate(data);
            }
        });
    });
</script>
</body>
</html>