$(function(){
    $('#editsummernote').summernote({
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
                        $('#editsummernote').summernote('insertImage',data.obj,'img');
                    }
                });
            }
        }
    });


    $("#stepEditForm").bootstrapValidator(vaildatorStepRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#stepEditForm").data('bootstrapValidator');


    $("#editStepSave").off("click").click(function () {
        // 执行表单验证
        var content=$("#editsummernote").summernote('code');
        $("#editStepContent").val(content);
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/step/updateStep',
                type: 'post',
                dataType: 'json',
                data: $("#stepEditForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                    step_tab .ajax.reload();
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            $("#editStepModal").modal('hide');
        }
    })

    $('#editStepModal').on('hidden.bs.modal', function () {
        //重置bootstrapValidator
        $("#stepEditForm").data('bootstrapValidator').destroy();
        $("#stepEditForm").data('bootstrapValidator', null);
        //初始化bootstrapValidator
        $("#stepEditForm").bootstrapValidator(vaildatorStepRule);
        $("#stepEditForm").data('bootstrapValidator').validate();
    })

})

function showStepEdit(data) {
    $("#editStepStepId").val(data.stepId);
    $("#editStepCourseName").val(data.courseName);
    $("#editStepCatalogId").val(data.catalogId);
    $("#editStepStageName").val(data.stageName);
    $("#editStepModuleName").val(data.moduleName);
    $("#editStepTitle").val(data.stepTitle);
    $("#editStepCatalogTitle").val(data.catalogTitle);
    $("#editsummernote").summernote('code',data.stepContent)
    $("#editStepWeight").val(data.stepWeight);
    $("#editStepCode").val(data.stepCode);
    $("#editStepModal").modal('show');
    $('#editStepModal').css({'overflow-y':'scroll'});
}

