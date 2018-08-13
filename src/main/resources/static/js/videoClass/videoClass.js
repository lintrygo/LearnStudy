//fileInput初始化

var vaildatorVideoClassRule={
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
            message: '版块名称验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '版块名称名不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 20,
                    message: '版块名称长度必须在1到20位之间'
                }
            }
        },
        weight: {
            //提示消息
            message: '版块权重验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '版块权重不能为空'
                },
                digits: {
                    message: '版块权重只能包含数字。'
                }
            }
        },
    }
};
var videoClass_tab;
$(function(){
    //初始化表格
    var No=0;
    videoClass_tab = $('#videoClass_tab').DataTable({
        "dom":'itflp',
        "processing":true,
        "searching":false,
        "serverSide":true, //启用服务器端分页
        "bInfo":false,
        "language":{"url":"/adminlte/plugins/datatables/language.json"},
        "ajax":{"url":"/back/videoClass/dataList","type":"post"},
        "columns":[
            {"data":null},
            {"data":"name"},
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
                    var btn ='<a  class="btn btn-xs btn-primary" onclick="addVideo(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">新增视频</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showVideoClassView(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">查看</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showVideoClassEdit(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">修改</a> &nbsp;'
                        +'<a  class="btn btn-xs btn-primary" onclick="showVideoClassDelete(' + JSON.stringify(data).replace(/"/g, '&quot;') + ')">删除</a> &nbsp;';
                    return btn;
                }
            } ]
    }).on('preXhr.dt', function ( e, settings, data ) {
        console.log(data,settings)
        No=0;
    } );
    $("#addVideoClassForm").bootstrapValidator(vaildatorVideoClassRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#addVideoClassForm").data('bootstrapValidator');

    $("#addVideoClass").click(function () {
        $("#addVideoClassModal").modal('show');
    })

    $("#addVideoClassSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/videoClass/addClass',
                type: 'post',
                dataType: 'json',
                data: $("#addVideoClassForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            videoClass_tab.ajax.reload();
            $("#addVideoClassModal").modal('hide');
        }else{
            return;
        }
    })

    $("#addVideoClassClose").click(function (){
        $('#addVideoClassModal').modal('hide');
    })

    $('#addVideoClassModal').on('hidden.bs.modal', function () {
        $("#addVideoClassName").val("");
        $("#addVideoClassWeight").val("");
        //重置bootstrapValidator
        $("#addVideoClassForm").data('bootstrapValidator').destroy();
        $("#addVideoClassForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#addVideoClassForm").bootstrapValidator(vaildatorVideoClassRule);
        $("#addVideoClassForm").data('bootstrapValidator').validate();
    })
});

