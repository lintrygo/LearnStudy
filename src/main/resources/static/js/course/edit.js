$(function () {
    $("#editForm").bootstrapValidator(vaildatorRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#editForm").data('bootstrapValidator');

    $("#editSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        //$("#editUploadfile").val() == ""
        if(bootstrapValidator.isValid()){
            if($("#initPreview").val()!=""){
                $('#editUploadfile').fileinput('refresh', {uploadUrl: "/back/course/updateCourse"});
                $("#editUploadfile").fileinput("upload");
            }else{
                if($("#editUploadfile").val()==""){
                    toastr.error("上传图片不能为空!");
                }else{
                    $('#editUploadfile').fileinput('refresh', {uploadUrl: "/back/course/updateCourseWithFile"});
                    $("#editUploadfile").fileinput("upload");
                }
            }
        }else{
            return;
        }
    })

    $("#editClose").off("click").click(function (){
        $('#editModal').modal('hide');
    })

    $('#editModal').on('hidden.bs.modal', function () {
        $("#editId").val("");
        $("#editName").val("");
        $("#editDescription").val("");
        $("#editLogo").val("");
        $("#initPreview").val("");
        $("#editUploadfile").fileinput("clear");
        $("#editUploadfile").fileinput("destroy");

        //重置bootstrapValidator
        $("#editForm").data('bootstrapValidator').destroy();
        $("#editForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#editForm").bootstrapValidator(vaildatorRule);
        $("#editForm").data('bootstrapValidator').validate();
    })

    //上传成功处理事件
    $("#editUploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        toastr.success("修改课程成功!");
        //$('#input-id').fileinput('refresh', {showCaption: false}).fileinput('disable');
        setTimeout(function () {
            $('#editModal').modal('hide');
        }, 1000);
         course_tab .ajax.reload();
        // // $('#addModal').modal('hide');
    });

   //上传失败处理事件
    $('#editUploadfile').on('filebatchuploaderror', function(event, data, msg) {
       // $("#initPreview").val("")
    });

    //选中文件触发事件
    $('#editUploadfile').on('change', function(event) {
        $("#initPreview").val("");
    });

    //关闭预览款事件
    $('#editUploadfile').on('fileclear', function(event) {
        $("#initPreview").val("");
    });

    //点击initPreview删除按钮触发事件
    $('#editUploadfile').on('filebeforedelete', function(event, key, data) {
        $("#initPreview").val("");
    });

})

function showEdit(data) {
    $("#editId").val(data.courseId);
    $("#editName").val(data.name);
    $("#editDescription").val(data.description);
    $("#editLogo").val(data.logo);
    $("#editWeight").val(data.weight);
    $("#initPreview").val(data.logo);
    editInit(data.logo);
    $("#editModal").modal('show');
}

function editInit(url){
    $("#editUploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/back/course/updateCourseWithFile", //上传的地址
        //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
        allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
        uploadAsync: false, //默认异步上传
        removeFromPreviewOnError:true,                 //当文件不符合规则，就不显示预览
        showUpload: false, //是否显示上传按钮
        showClose:true,
        showRemove : false, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: false,//是否显示拖拽区域
        layoutTemplates :{
            // actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'',//去除上传预览缩略图中的上传图片；
            // actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        previewSettings: {
            image: {width: "200px", height: "100px"},
        },
        uploadExtraData:function (previewId, index) {
            var obj = {};
            obj={
                courseId:$("#editId").val(),
                name:$("#editName").val(),
                description:$("#editDescription").val(),
                logo:$("#editLogo").val(),
                weight:$("#editWeight").val()
            };
            return obj;
        },
        initialPreviewShowDelete:false,
       // initialPreviewAsData:true,
        initialPreview: ['<img src='+url+' class="file-preview-image" alt="图片不存在!请重新上传">',],
        initialPreviewConfig: [ //配置预览中的一些参数
            {size: 329892, width: "120px", url: "deletePic", key: 1},
        ],
        maxFileSize:20000,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true
    });
}
