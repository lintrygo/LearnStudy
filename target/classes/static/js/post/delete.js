$(function () {
    $("#deletePostClass").off("click").click(function () {
        $.ajax({
            url: '/back/post/deleteClass',
            type: 'post',
            dataType: 'json',
            data: {id:$("#deletePostClassId").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                postClass_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deletePostClassModal").modal('hide');
    })

})

function  showPostClassDelete(data) {
    $("#deletePostClassId").val(data.postClassId);
    $("#deletePostClassModal").modal('show');
}