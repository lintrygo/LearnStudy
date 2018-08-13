$(function() {

    $("#viewClose").click(function (){
        $('#viewModal').modal('hide');
    })

    $('#viewModal').on('hidden.bs.modal', function () {
        $("#viewUploadfile").fileinput("clear");
        $("#viewUploadfile").fileinput("destroy");
    })

})

function showView(data) {
    $("#viewName").val(data.name);
    $("#viewDescription").val(data.description);
    $("#viewWeight").val(data.weight);
    viewInit(data.logo);
    $("#viewModal").modal('show');
}


function viewInit(url){
    $("#viewUploadfile").fileinput({
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
        initialPreview: ['<img src='+url+' class="file-preview-image" alt="图片不存在!">',],
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });
}