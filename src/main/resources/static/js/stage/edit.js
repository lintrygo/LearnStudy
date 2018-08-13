
$(function() {
    $("#editStageForm").bootstrapValidator(vaildatorStageRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#editStageForm").data('bootstrapValidator');

    $("#editStageSave").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/stage/updateStage',
                type: 'post',
                dataType: 'json',
                data: $("#editStageForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                    stage_tab.ajax.reload();
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            $("#editStageModal").modal('hide');
        }
    })

    $("#editStageClose").click(function (){
        $('#editStageModal').modal('hide');
    })

})

function showStageEdit(data) {
    $("#editStageId").val(data.stageId);
    $("#editStageCourseName").val(data.courseName);
    $("#editStageName").val(data.stageName);
    $("#editStageDescription").val(data.stageDescription);
    $("#editStageWeight").val(data.stageWeight);
    $("#editStageModal").modal('show');
}
