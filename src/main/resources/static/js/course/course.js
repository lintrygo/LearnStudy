//fileInput初始化

var vaildatorRule={
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        //表单name
        name: {
            //提示消息
            message: '课程名称验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '课程名称名不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 10,
                    message: '课程名称长度必须在1到10位之间'
                }
            }
        },
        description: {
            //提示消息
            message: '课程描述验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '课程描述不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 50,
                    message: '课程描述长度必须在1到50位之间'
                }
            }
        },
        weight: {
            //提示消息
            message: '课程权重验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '课程权重不能为空'
                },
                digits: {
                    message: '课程权重只能包含数字。'
                }
            }
        },
    }
};
var course_tab;
$(function(){
//上传成功处理事件
    $("#uploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        if(data.response.code=="100"){
            toastr.success("新增课程成功!");
        }else{
            toastr.error(data.response.message+" 新增课程失败!");
        }
        setTimeout(function () {
            $('#addModal').modal('hide');
        }, 1000);
        course_tab .ajax.reload();
        // $('#addModal').modal('hide');
    });

//上传失败处理事件
    $('#uploadfile').on('filebatchuploaderror', function(event, data, msg) {
        toastr.response.error(data.response.message+" 新增课程失败!");
        setTimeout(function () {
            $('#addModal').modal('hide');
        }, 1000);
    });



    //初始化表格
    var No=0;
    course_tab = $('#course_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/course/dataList","type":"post"},
        "columns":[
            {"data":null},
            {"data":"name"},
            {"data":"description"},
            {"data":"weight"},
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
                    var btn = '<a  class="btn btn-xs btn-primary" onclick="addStage(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">新增阶段</a> &nbsp;'
                                +'<a  class="btn btn-xs btn-primary" onclick="showView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                                +'<a  class="btn btn-xs btn-primary" onclick="showEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                                +'<a  class="btn btn-xs btn-primary" onclick="showDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
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
    $("#courseForm").bootstrapValidator(vaildatorRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#courseForm").data('bootstrapValidator');

    $("#add").click(function () {
        init();
        $("#addModal").modal('show');
    })

    $("#save").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            if ($("#uploadfile").val() == "") {
                toastr.error("上传图片不能为空!");
            }else{
                $("#uploadfile").fileinput("upload");
            }
        }else{
            return;
        }
    })

    $("#close").click(function (){
        $('#addModal').modal('hide');
    })

    $('#addModal').on('hidden.bs.modal', function () {
        $("#name").val("");
        $("#description").val("");
        $("#weight").val("");
        $("#uploadfile").fileinput("clear");
        $("#uploadfile").fileinput("destroy");

        //重置bootstrapValidator
        $("#courseForm").data('bootstrapValidator').destroy();
        $("#courseForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#courseForm").bootstrapValidator(vaildatorRule);
        $("#courseForm").data('bootstrapValidator').validate();
    })
});
function init(){
    $("#uploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/back/course/addCourse", //上传的地址
        //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
        //allowedFileExtensions: ['jpg', 'png', 'gif','zip'],//接收的文件后缀
        uploadAsync: false, //默认异步上传
        removeFromPreviewOnError:true,                 //当文件不符合规则，就不显示预览
        showUpload: false, //是否显示上传按钮
        showClose:true,
        showRemove : false, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: false,//是否显示拖拽区域
        layoutTemplates :{
            // actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'',//去除上传预览缩略图中的上传图片；
            // actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        previewSettings: {
            image: {width: "200px", height: "100px"},
        },
        uploadExtraData:function (previewId, index) {
            var obj = {};
            obj={
                name:$("#name").val(),
                description:$("#description").val(),
                weight:$("#weight").val()
            };
            return obj;
        },
        initialPreviewShowDelete:true,
        //initialPreview: ['<img src='+url+' class="file-preview-image" alt="Your Avatar">',],
        initialPreviewConfig: [ //配置预览中的一些参数
            {caption: "transport-1.jpg", size: 329892, width: "120px", url: "deletePic", key: 1},
        ],
        maxFileSize:200*1000*1000,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });
}
