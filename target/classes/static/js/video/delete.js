$(function () {
    $("#deleteVideoSave").click(function () {
        $.ajax({
            url: '/back/video/deleteVideo',
            type: 'post',
            dataType: 'json',
            data: {videoId:$("#deleteVideoId").val(),url:$("#deleteVideoUrl").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                video_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteVideoModal").modal('hide');
    })

})

function  showVideoDelete(data) {
    $("#deleteVideoId").val(data.videoId);
    $("#deleteVideoUrl").val(data.videoUrl);
    $("#deleteVideoModal").modal('show');
}