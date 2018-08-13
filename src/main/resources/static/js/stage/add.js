var vaildatorStageRule={
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
            message: '阶段名称验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '阶段名称名不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 10,
                    message: '阶段名称长度必须在1到10位之间'
                }
            }
        },
        description: {
            //提示消息
            message: '阶段描述验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '阶段描述不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 20,
                    message: '阶段描述长度必须在1到20位之间'
                }
            }
        },
        weight: {
            //提示消息
            message: '阶段权重验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '阶段权重不能为空'
                },
                digits: {
                    message: '阶段权重只能包含数字。'
                }
            }
        },
    }
};

$(function(){

    $("#stageAddForm").bootstrapValidator(vaildatorStageRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#stageAddForm").data('bootstrapValidator');


    $("#addStageSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/stage/addStage',
                type: 'post',
                dataType: 'json',
                data: $("#stageAddForm").serialize(),
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
            $("#addStageModal").modal('hide');
        }
    })

    $("#addStageClose").click(function (){
        $('#addStageModal').modal('hide');
    })

    $('#addStageModal').on('hidden.bs.modal', function () {
        $("#addStageName").val("");
        $("#addStageDescription").val("");
        $("#addStageWeight").val("");
        //重置bootstrapValidator
        $("#stageAddForm").data('bootstrapValidator').destroy();
        $("#stageAddForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#stageAddForm").bootstrapValidator(vaildatorRule);
        $("#stageAddForm").data('bootstrapValidator').validate();
    })

})

function addStage(data) {
    $("#addStageCourseName").val(data.name);
    $("#addStageCourseId").val(data.courseId);
    $("#addStageModal").modal('show');
}