$(function () {
    $("#deleteVideoClass").off("click").click(function () {
        $.ajax({
            url: '/back/videoClass/deleteClass',
            type: 'post',
            dataType: 'json',
            data: {id:$("#deleteVideoClassId").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                videoClass_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteVideoClassModal").modal('hide');
    })

})

function  showVideoClassDelete(data) {
    $("#deleteVideoClassId").val(data.videoClassId);
    $("#deleteVideoClassModal").modal('show');
}