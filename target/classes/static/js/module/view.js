$(function() {

    $("#viewModuleClose").click(function (){
        $('#viewModuleModal').modal('hide');
    })

    $('#viewModuleModal').on('hidden.bs.modal', function () {
        $("#viewModuleUploadfile").fileinput("clear");
        $("#viewModuleUploadfile").fileinput("destroy");
    })

})

function showModuleView(data) {
    $("#viewModuleCourseName").val(data.courseName);
    $("#viewModuleStageName").val(data.stageName);
    $("#viewModuleName").val(data.moduleName);
    $("#viewModuleDescription").val(data.moduleDescription);
    $("#viewModuleWeight").val(data.moduleWeight);
    viewModuleInit(data.logo);
    $("#viewModuleModal").modal('show');
}

function viewModuleInit(url){
    $("#viewModuleUploadfile").fileinput({
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
