$(function () {
    $("#delete").off("click").click(function () {
        $.ajax({
            url: '/back/course/deleteCourse',
            type: 'post',
            dataType: 'json',
            data: {courseId:$("#tempId").val(),url:$("#url").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                course_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteModal").modal('hide');
    })

})

function  showDelete(data) {
    $("#tempId").val(data.courseId);
    $("#url").val(data.logo);
    $("#deleteModal").modal('show');
}