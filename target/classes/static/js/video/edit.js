$(function(){

        $("#videoEditForm").bootstrapValidator(vaildatorVideoRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#videoEditForm").data('bootstrapValidator');


    $("#editVideoSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            if($("#initPreviewVideo").val()!=""){
                $('#editVideoUploadfile').fileinput('refresh', {uploadUrl: "/back/video/updateVideo"});
                $("#editVideoUploadfile").fileinput("upload");
            }else{
                if($("#editVideoUploadfile").val() != ""){
                    $('#editVideoUploadfile').fileinput('refresh', {uploadUrl: "/back/video/updateVideoWithFile"});
                    $("#editVideoUploadfile").fileinput("upload");
                }else{
                    $("#deleteVideo").val(0);
                    $('#editVideoUploadfile').fileinput('refresh', {uploadUrl: "/back/video/updateVideo"});
                    $("#editVideoUploadfile").fileinput("upload");
                }
            }
        }
    })

    //上传成功处理事件
    $("#editVideoUploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        toastr.success("修改视频成功!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editVideoModal').modal('hide');
        }, 1000);
        video_tab .ajax.reload();
        // // $('#addModal').modal('hide');
    });

    //上传失败处理事件
    $('#editVideoUploadfile').on('filebatchuploaderror', function(event, data, msg) {
        // $("#initPreviewVideo").val("")
        toastr.success("修改视频失败!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editVideoModal').modal('hide');
        }, 1000);
    });

    //选中文件触发事件
    $('#editVideoUploadfile').on('change', function(event) {
        $("#initPreviewVideo").val("");
    });

    //关闭预览款事件
    $('#editVideoUploadfile').on('fileclear', function(event) {
        $("#initPreviewVideo").val("");
    });

    //点击initPreviewVideo删除按钮触发事件
    $('#editVideoUploadfile').on('filebeforedelete', function(event, key, data) {
        $("#initPreviewVideo").val("");
    });

    $("#editVideoClose").click(function (){
        $('#editVideoModal').modal('hide');
    })

    $('#editVideoModal').on('hidden.bs.modal', function () {
        $("#editVideoUploadfile").fileinput("clear");
        $("#editVideoUploadfile").fileinput("destroy");
    })


    $("#editVideoClose").click(function (){
        $('#editVideoModal').modal('hide');
    })

    $('#editVideoModal').on('hidden.bs.modal', function () {
        $("#editVideouploadfile").fileinput("clear");
        $("#editVideouploadfile").fileinput("destroy");
        //重置bootstrapValidator
        $("#videoEditForm").data('bootstrapValidator').destroy();
        $("#videoEditForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#videoEditForm").bootstrapValidator(vaildatorVideoRule);
        $("#videoEditForm").data('bootstrapValidator').validate();
    })

})

function showVideoEdit(data) {
    var test="<div class='file-preview-other'>" +
        "<h2><i class='glyphicon glyphicon-file'></i></h2>" +
        "video" + "</div>";
    if(data.videoUrl==""||data.videoUrl==null){
        editVideoInit("");
    }else{
        editVideoInit(test);
    }
    $("#editVideoId").val(data.videoId);
    $("#editVideoClassName").val(data.videoClassName);
    $("#editVideoName").val(data.videoName);
    $("#editVideoDescription").val(data.videoDescription);
    $("#editVideoWeight").val(data.videoWeight);
    $("#initPreviewVideo").val(data.videoUrl);
    $("#editVideoUrl").val(data.videoUrl);
    $("#deleteVideo").val(1);
    $("#editVideoModal").modal('show');
}

function editVideoInit(url) {
    $("#editVideoUploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/back/video/updateVideo", //上传的地址
        //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
        //allowedFileExtensions: ['jpg', 'png', 'gif','zip'],//接收的文件后缀
        uploadAsync: false, //默认异步上传
        removeFromPreviewOnError: true,                 //当文件不符合规则，就不显示预览
        showUpload: false, //是否显示上传按钮
        showClose: true,
        showRemove: false, //显示移除按钮
        showPreview: true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: false,//是否显示拖拽区域
        layoutTemplates: {
            // actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload: '',//去除上传预览缩略图中的上传图片；
            // actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        previewSettings: {
            image: {width: "200px", height: "100px"},
        },
        uploadExtraData: function (previewId, index) {
            var obj = {};
            obj = {
                videoId:$("#editVideoId").val(),
                name: $("#editVideoName").val(),
                description: $("#editVideoDescription").val(),
                weight: $("#editVideoWeight").val(),
                url:$("#editVideoUrl").val(),
                delete:$("#deleteVideo").val()
            };
            return obj;
        },
        initialPreviewShowDelete: true,
        initialPreview: [url],
        initialPreviewConfig: [ //配置预览中的一些参数
            {caption: "transport-1.jpg", size: 329892, width: "120px", url: "deletePic", key: 1},
        ],
        maxFileSize: 200 * 1000 * 1000,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true
    });
}