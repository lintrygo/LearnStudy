$(function () {
    $("#deleteStepSave").click(function () {
        $.ajax({
            url: '/back/step/deleteStep',
            type: 'post',
            dataType: 'json',
            data: {stepId:$("#deleteStepId").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                step_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteStepModal").modal('hide');
    })

})

function  showStepDelete(data) {
    $("#deleteStepId").val(data.stepId);
    $("#deleteStepModal").modal('show');
}