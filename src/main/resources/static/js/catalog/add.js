var vaildatorCatalogRule={
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        //表单name
        title: {
            //提示消息
            message: '目录标题验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '目录标题名不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 10,
                    message: '目录标题长度必须在1到10位之间'
                }
            }
        },
        description: {
            //提示消息
            message: '目录描述验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '目录描述不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 50,
                    message: '目录描述长度必须在1到50位之间'
                }
            }
        },
        weight: {
            //提示消息
            message: '目录权重验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '目录权重不能为空'
                },
                digits: {
                    message: '目录权重只能包含数字。'
                }
            }
        },
    }
};

$(function(){

    $("#catalogAddForm").bootstrapValidator(vaildatorCatalogRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#catalogAddForm").data('bootstrapValidator');


    $("#addCatalogSave").off("click").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            if($("#addCataloguploadfile").val() != ""){
                $('#addCataloguploadfile').fileinput('refresh', {uploadUrl: "/back/catalog/addCatalogWithFile"});
            }
            $("#addCataloguploadfile").fileinput("upload");
        }
    })

    //上传成功处理事件
    $("#addCataloguploadfile").on("filebatchuploadsuccess", function (event, data, previewId, index) {
        if(data.response.code=="100"){
            toastr.success("新增目录成功!");
        }else{
            toastr.error(data.response.message+" 新增目录失败!");
        }
        setTimeout(function () {
            $('#addCatalogModal').modal('hide');
        }, 1000);
        //catalog_tab .ajax.reload();
        // $('#addModal').modal('hide');
    });

//上传失败处理事件
    $('#addCataloguploadfile').on('filebatchuploaderror', function(event, data, msg) {
        toastr.response.error(data.response.message+" 新增目录失败!");
        setTimeout(function () {
            $('#addCatalogModal').modal('hide');
        }, 1000);
    });

    $("#addCatalogClose").click(function (){
        $('#addCatalogModal').modal('hide');
    })

    $('#addCatalogModal').on('hidden.bs.modal', function () {
        $("#addCatalogNameTitle").val("");
        $("#addCatalogDescription").val("");
        $("#addCatalogWeight").val("");
        $("#addCataloguploadfile").fileinput("clear");
        $("#addCataloguploadfile").fileinput("destroy");
        //重置bootstrapValidator
        $("#catalogAddForm").data('bootstrapValidator').destroy();
        $("#catalogAddForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#catalogAddForm").bootstrapValidator(vaildatorCatalogRule);
        $("#catalogAddForm").data('bootstrapValidator').validate();
    })

})

function addCatalog(data) {
    addCatalogInit();
    $("#addCatalogCourseName").val(data.courseName);
    $("#addCatalogModuleId").val(data.moduleId);
    $("#addCatalogStageName").val(data.stageName);
    $("#addCatalogModuleName").val(data.moduleName);
    $("#addCatalogModal").modal('show');
}

function addCatalogInit() {
    $("#addCataloguploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl: "/back/catalog/addCatalog", //上传的地址
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
                moduleId:$("#addCatalogModuleId").val(),
                title: $("#addCatalogTitle").val(),
                description: $("#addCatalogDescription").val(),
                weight: $("#addCatalogWeight").val()
            };
            return obj;
        },
        initialPreviewShowDelete: true,
        //initialPreview: ['<img src='+url+' class="file-preview-image" alt="Your Avatar">',],
        initialPreviewConfig: [ //配置预览中的一些参数
            {caption: "transport-1.jpg", size: 329892, width: "120px", url: "deletePic", key: 1},
        ],
        maxFileSize: 200 * 1000 * 1000,
        maxFileCount: 1, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true
    });
}