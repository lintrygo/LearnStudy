var vaildatorStepRule={
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
            message: '步骤标题验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '步骤标题名不能为空'
                },
                stringLength: {
                    min: 1,
                    max: 10,
                    message: '步骤标题长度必须在1到10位之间'
                }
            }
        },
        weight: {
            //提示消息
            message: '步骤权重验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '步骤权重不能为空'
                },
                digits: {
                    message: '步骤权重只能包含数字。'
                }
            }
        },
    }
};

$(function(){
    $('#summernote').summernote({
        height: 250,
        lang: 'zh-CN',
        dialogsInBody: true,
        callbacks: {
            onImageUpload: function(files) {
                var formData = new FormData();
                formData.append('file',files[0]);
                $.ajax({
                    url : '/back/uploadFile',//后台文件上传接口
                    type : 'POST',
                    data : formData,
                    processData : false,
                    contentType : false,
                    success : function(data) {
                        $('#summernote').summernote('insertImage',data.obj,'img');
                    }
                });
            }
        }
    });


    $("#stepAddForm").bootstrapValidator(vaildatorStepRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#stepAddForm").data('bootstrapValidator');


    $("#addStepSave").off("click").click(function () {
        // 执行表单验证
        var content=$("#summernote").summernote('code');
        $("#stepContent").val(content);
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/step/addStep',
                type: 'post',
                dataType: 'json',
                data: $("#stepAddForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            $("#addStepModal").modal('hide');
        }
    })

    $('#addStepModal').on('hidden.bs.modal', function () {
        $("#addStepTitle").val("");
        $("#addStepContent").val("");
        $("#addStepWeight").val("");
        $("#summernote").summernote('code','');
        $("#addStepCode").val("");
        //重置bootstrapValidator
        $("#stepAddForm").data('bootstrapValidator').destroy();
        $("#stepAddForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#stepAddForm").bootstrapValidator(vaildatorStepRule);
        $("#stepAddForm").data('bootstrapValidator').validate();
    })

})

function addStep(data) {
    $("#addStepCourseName").val(data.courseName);
    $("#addStepCatalogId").val(data.catalogId);
    $("#addStepStageName").val(data.stageName);
    $("#addStepModuleName").val(data.moduleName);
    $("#addStepCatalogTitle").val(data.catalogTitle);
    $("#addStepModal").modal('show');
    $('#addStepModal').css({'overflow-y':'scroll'});
}

