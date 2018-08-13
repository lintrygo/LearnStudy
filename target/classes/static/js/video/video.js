//fileInput初始化
var video_tab;
$(function(){

    //初始化表格
    var No=0;
    video_tab = $('#video_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/video/dataList","type":"post",
            "data": function(d) {
                d.videoClassId =$("#videoClassSelect option:selected").val();
            }
        },
        "columns":[
            {"data":null},
            {"data":"videoName"},
            {"data":"videoWeight"},
            {"data":"videoClassName"},
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
                    var btn =
                       '<a  class="btn btn-xs btn-primary" onclick="showVideoView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showVideoEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showVideoDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
                    return btn;
                }
            } ]
    }).on('preXhr.dt', function ( e, settings, data ) {
        console.log(data,settings)
        No=0;
    } );

    $("#videoClassSelect").change(function(){
        video_tab.draw();
    })


});


