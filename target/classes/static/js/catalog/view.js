$(function() {

    $("#viewCatalogClose").click(function (){
        $('#viewCatalogModal').modal('hide');
    })

    $('#viewCatalogModal').on('hidden.bs.modal', function () {
        $("#viewCatalogUploadfile").fileinput("clear");
        $("#viewCatalogUploadfile").fileinput("destroy");
    })

})

function showCatalogView(data) {
    $("#viewCatalogCourseName").val(data.courseName);
    $("#viewCatalogStageName").val(data.stageName);
    $("#viewCatalogModuleName").val(data.moduleName);
    $("#viewCatalogTitle").val(data.catalogTitle);
    $("#viewCatalogDescription").val(data.catalogDescription);
    $("#viewCatalogWeight").val(data.catalogWeight);
    var test="<div class='file-preview-other'>" +
        "<h2><i class='glyphicon glyphicon-file'></i></h2>" +
        "video" + "</div>";
    if(data.catalogVideo==""||data.catalogVideo==null){
        viewCatalogInit("");
    }else{
        viewCatalogInit(test);
    }
    $("#viewCatalogModal").modal('show');
}

function viewCatalogInit(url){
    $("#viewCatalogUploadfile").fileinput({
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
