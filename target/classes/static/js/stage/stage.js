//fileInput初始化
var stage_tab;
$(function(){

    //初始化表格
    var No=0;
    stage_tab = $('#stage_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/stage/dataList","type":"post",
            "data": function(d) {
                //自定义查询参数
                var id=$("#select option:selected").val();
                id=id==-1?null:id;
                d.courseId =$("#select option:selected").val();
            }
        },
        "columns":[
            {"data":null},
            {"data":"stageName"},
            {"data":"stageDescription"},
            {"data":"stageWeight"},
            {"data":"courseName"},
            {"data":"createTime"},
            {"data":null}
        ],
        "columnDefs" : [
            {
                targets: 0,
                data: null,
                render: function (data) {
                    No=No+1;
                    return No;
                }
            },
            {
                "targets" : -1,
                "data" : null,
                "render" : function(data) {
                    var btn ='<a  class="btn btn-xs btn-primary" onclick="addModule(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">新增模块</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showStageView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showStageEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showStageDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
                    // if(data.roleValue != 'super'){
                    //     btn = btn
                    //         +'<a class="btn btn-xs btn-info" onclick="roleToListAjax();" target="modal" modal="lg" href="/role/edit/'+ data.id+'">修改</a> &nbsp;'
                    //         +'<a class="btn btn-xs btn-default" callback="roleReload();" data-body="确认要删除吗？" target="ajaxTodo" href="/role/delete/'+ data.id + '">删除</a>  &nbsp;'
                    // }
                    return btn;
                }
            } ]
    }).on('preXhr.dt', function ( e, settings, data ) {
        console.log(data,settings)
        No=0;
    } );

    $("#select").change(function(){
        // text=$("#select option:selected").text();
        // stage_tab.columns(4).search(text).draw();
        stage_tab.draw();
    })

});




