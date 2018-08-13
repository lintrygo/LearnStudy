$(function(){

    $("#catalogEditForm").bootstrapValidator(vaildatorCatalogRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#catalogEditForm").data('bootstrapValidator');


    $("#editCatalogSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            if($("#initPreview").val()!=""){
                $('#editCatalogUploadfile').fileinput('refresh', {uploadUrl: "/back/catalog/updateCatalog"});
                $("#editCatalogUploadfile").fileinput("upload");
            }else{
                if($("#editCatalogUploadfile").val() != ""){
                    $('#editCatalogUploadfile').fileinput('refresh', {uploadUrl: "/back/catalog/updateCatalogWithFile"});
                    $("#editCatalogUploadfile").fileinput("upload");
                }else{
                    $("#delete").val(0);
                    $('#editCatalogUploadfile').fileinput('refresh', {uploadUrl: "/back/catalog/updateCatalog"});
                    $("#editCatalogUploadfile").fileinput("upload");
                }
            }
        }
    })

    //上传成功处理事件
    $("#editCatalogUploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        toastr.success("修改目录成功!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editCatalogModal').modal('hide');
        }, 1000);
        catalog_tab .ajax.reload();
        // // $('#addModal').modal('hide');
    });

    //上传失败处理事件
    $('#editCatalogUploadfile').on('filebatchuploaderror', function(event, data, msg) {
        // $("#initPreview").val("")
        toastr.success("修改目录失败!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editCatalogModal').modal('hide');
        }, 1000);
    });

    //选中文件触发事件
    $('#editCatalogUploadfile').on('change', function(event) {
        $("#initPreview").val("");
    });

    //关闭预览款事件
    $('#editCatalogUploadfile').on('fileclear', function(event) {
        $("#initPreview").val("");
    });

    //点击initPreview删除按钮触发事件
    $('#editCatalogUploadfile').on('filebeforedelete', function(event, key, data) {
        $("#initPreview").val("");
    });

    $("#editCatalogClose").click(function (){
        $('#editCatalogModal').modal('hide');
    })

    $('#editCatalogModal').on('hidden.bs.modal', function () {
        $("#editCatalogUploadfile").fileinput("clear");
        $("#editCatalogUploadfile").fileinput("destroy");
    })


    $("#editCatalogClose").click(function (){
        $('#editCatalogModal').modal('hide');
    })

    $('#editCatalogModal').on('hidden.bs.modal', function () {
        $("#editCatalogNameTitle").val("");
        $("#editCatalogDescription").val("");
        $("#editCatalogWeight").val("");
        $("#editCataloguploadfile").fileinput("clear");
        $("#editCataloguploadfile").fileinput("destroy");
        //重置bootstrapValidator
        $("#catalogEditForm").data('bootstrapValidator').destroy();
        $("#catalogEditForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#catalogEditForm").bootstrapValidator(vaildatorCatalogRule);
        $("#catalogEditForm").data('bootstrapValidator').validate();
    })

})

function showCatalogEdit(data) {
    var test="<div class='file-preview-other'>" +
        "<h2><i class='glyphicon glyphicon-file'></i></h2>" +
        "video" + "</div>";
    if(data.catalogVideo==""||data.catalogVideo==null){
        editCatalogInit("");
    }else{
        editCatalogInit(test);
    }
    $("#editCatalogCatalogId").val(data.catalogId);
    $("#editCatalogCourseName").val(data.courseName);
    $("#editCatalogModuleId").val(data.moduleId);
    $("#editCatalogStageName").val(data.stageName);
    $("#editCatalogModuleName").val(data.moduleName);
    $("#editCatalogTitle").val(data.catalogTitle);
    $("#editCatalogDescription").val(data.catalogDescription);
    $("#editCatalogWeight").val(data.catalogWeight);
    $("#initPreview").val(data.catalogVideo);
    $("#editVideo").val(data.catalogVideo);
    $("#delete").val(1);
    $("#editCatalogModal").modal('show');
}

function editCatalogInit(url) {
    $("#editCatalogUploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/back/catalog/updateCatalog", //上传的地址
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
                catalogId:$("#editCatalogCatalogId").val(),
                moduleId:$("#editCatalogModuleId").val(),
                title: $("#editCatalogTitle").val(),
                description: $("#editCatalogDescription").val(),
                weight: $("#editCatalogWeight").val(),
                video:$("#editVideo").val(),
                delete:$("#delete").val()
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