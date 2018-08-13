$(function() {

    $("#moduleEditForm").bootstrapValidator(vaildatorModuleRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#moduleEditForm").data('bootstrapValidator');

    $("#editModuleSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            if($("#initPreview").val()!=""){
                $('#editModuleUploadfile').fileinput('refresh', {uploadUrl: "/back/module/updateModule"});
                $("#editModuleUploadfile").fileinput("upload");
            }else{
                if($("#editModuleUploadfile").val()==""){
                    toastr.error("上传图片不能为空!");
                }else{
                    $('#editModuleUploadfile').fileinput('refresh', {uploadUrl: "/back/module/updateModuleWithFile"});
                    $("#editModuleUploadfile").fileinput("upload");
                }
            }
        }else{
            return;
        }
    })

    $("#editModuleClose").off("click").click(function (){
        $('#editModuleModal').modal('hide');
    })

    $('#editModuleModal').on('hidden.bs.modal', function () {
        $("#editUploadfile").fileinput("clear");
        $("#editUploadfile").fileinput("destroy");

        //重置bootstrapValidator
        $("#moduleEditForm").data('bootstrapValidator').destroy();
        $("#moduleEditForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#moduleEditForm").bootstrapValidator(vaildatorModuleRule);
        $("#moduleEditForm").data('bootstrapValidator').validate();
    })

    //上传成功处理事件
    $("#editModuleUploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        toastr.success("修改模块成功!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editModuleModal').modal('hide');
        }, 1000);
        module_tab .ajax.reload();
        // // $('#addModal').modal('hide');
    });

    //上传失败处理事件
    $('#editModuleUploadfile').on('filebatchuploaderror', function(event, data, msg) {
        // $("#initPreview").val("")
    });

    //选中文件触发事件
    $('#editModuleUploadfile').on('change', function(event) {
        $("#initPreview").val("");
    });

    //关闭预览款事件
    $('#editModuleUploadfile').on('fileclear', function(event) {
        $("#initPreview").val("");
    });

    //点击initPreview删除按钮触发事件
    $('#editModuleUploadfile').on('filebeforedelete', function(event, key, data) {
        $("#initPreview").val("");
    });

    $("#editModuleClose").click(function (){
        $('#editModuleModal').modal('hide');
    })

    $('#editModuleModal').on('hidden.bs.modal', function () {
        $("#editModuleUploadfile").fileinput("clear");
        $("#editModuleUploadfile").fileinput("destroy");
    })

})

function showModuleEdit(data) {
    $("#editModuleStageId").val(data.stageId);
    $("#editModuleModuleId").val(data.moduleId),
    $("#editModuleCourseName").val(data.courseName);
    $("#editModuleStageName").val(data.stageName);
    $("#editModuleName").val(data.moduleName);
    $("#editModuleDescription").val(data.moduleDescription);
    $("#editModuleWeight").val(data.moduleWeight);
    $("#initPreview").val(data.logo);
    $("#editLogo").val(data.logo);
    editModuleInit(data.logo);
    $("#editModuleModal").modal('show');
}

function editModuleInit(url){
    $("#editModuleUploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/edit", //上传的地址
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
        uploadExtraData:function (previewId, index) {
            var obj = {};
            obj={
                stageId:$("#editModuleStageId").val(),
                moduleId:$("#editModuleModuleId").val(),
                name:$("#editModuleName").val(),
                description:$("#editModuleDescription").val(),
                logo:$("#editLogo").val(),
                weight:$("#editModuleWeight").val()
            };
            return obj;
        },
        initialPreviewShowDelete:true,
        initialPreviewConfig: [ //配置预览中的一些参数
            {size: 329892, width: "120px", url: "deletePic", key: 1},
        ],
        initialPreview: ['<img src='+url+' class="file-preview-image" alt="图片不存在!">',],
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });
}
