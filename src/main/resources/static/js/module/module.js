//fileInput初始化
var module_tab;
$(function(){

    //初始化表格
    var No=0;
    module_tab = $('#module_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/module/dataList","type":"post",
            "data": function(d) {
                d.courseId =$("#courseSelect option:selected").val();
                d.stageId =$("#stageSelect option:selected").val();
            }
        },
        "columns":[
            {"data":null},
            {"data":"moduleName"},
            {"data":"moduleDescription"},
            {"data":"moduleWeight"},
            {"data":"courseName"},
            {"data":"stageName"},
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
                    var btn ='<a  class="btn btn-xs btn-primary" onclick="addCatalog(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">新增目录</a> &nbsp;'
                        + '<a  class="btn btn-xs btn-primary" onclick="showModuleView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showModuleEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showModuleDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
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

    $("#courseSelect").change(function(){
        module_tab.draw();
    })

    $("#stageSelect").change(function(){
        module_tab.draw();
    })

});


