$(function() {

    $("#viewVideoClose").click(function (){
        $('#viewVideoModal').modal('hide');
    })

    $('#viewVideoModal').on('hidden.bs.modal', function () {
        $("#viewVideoUploadfile").fileinput("clear");
        $("#viewVideoUploadfile").fileinput("destroy");
    })

})

function showVideoView(data) {
    $("#viewVideoClassName").val(data.videoClassName);
    $("#viewVideoName").val(data.videoName);
    $("#viewVideoDescription").val(data.videoDescription);
    $("#viewVideoWeight").val(data.videoWeight);
    var test="<div class='file-preview-other'>" +
        "<h2><i class='glyphicon glyphicon-file'></i></h2>" +
        "video" + "</div>";
    if(data.videoUrl==""||data.videoUrl==null){
        viewVideoInit("");
    }else{
        viewVideoInit(test);
    }
    $("#viewVideoModal").modal('show');
}

function viewVideoInit(url){
    $("#viewVideoUploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/view", //上传的地址
        allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
        uploadAsync: false, //默认异步上传
        removeFromPreviewOnError:true,                 //当文件不符合规则，就不显示预览
        showUpload: false, //是否显示上传按钮
        showClose:true,
        dropZoneEnabled: false,//是否显示拖拽区域
        showRemove : false, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        initialPreviewShowDelete:true,
        initialPreview: [url],
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });
}
