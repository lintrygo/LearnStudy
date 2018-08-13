//fileInput初始化
var catalog_tab;
$(function(){

    //初始化表格
    var No=0;
    catalog_tab = $('#catalog_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/catalog/dataList","type":"post",
            "data": function(d) {
                d.courseId =$("#courseSelect option:selected").val();
                d.stageId =$("#stageSelect option:selected").val();
                d.moduleId =$("#moduleSelect option:selected").val();
            }
        },
        "columns":[
            {"data":null},
            {"data":"catalogTitle"},
            {"data":"catalogWeight"},
            {"data":"courseName"},
            {"data":"stageName"},
            {"data":"moduleName"},
            {"data":"catalogCreateTime"},
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
                    var btn ='<a  class="btn btn-xs btn-primary" onclick="addStep(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">新增步骤</a> &nbsp;'
                        + '<a  class="btn btn-xs btn-primary" onclick="showCatalogView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showCatalogEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showCatalogDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
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
        catalog_tab.draw();
    })

    $("#stageSelect").change(function(){
        catalog_tab.draw();
    })

    $("#moduleSelect").change(function(){
        catalog_tab.draw();
    })

});


