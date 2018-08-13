$(function () {
    $("#deleteStageSave").click(function () {
        $.ajax({
            url: '/back/stage/deleteStage',
            type: 'post',
            dataType: 'json',
            data: {stageId:$("#deleteStageId").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                stage_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteStageModal").modal('hide');
    })

})

function  showStageDelete(data) {
    $("#deleteStageId").val(data.stageId);
    $("#deleteStageModal").modal('show');
}