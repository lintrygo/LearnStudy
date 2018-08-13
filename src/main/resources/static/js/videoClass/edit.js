
$(function() {
    $("#editVideoClassForm").bootstrapValidator(vaildatorVideoClassRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#editVideoClassForm").data('bootstrapValidator');

    $("#editVideoClassSave").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/videoClass/updateClass',
                type: 'post',
                dataType: 'json',
                data: $("#editVideoClassForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                    videoClass_tab.ajax.reload();
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            $("#editVideoClassModal").modal('hide');
        }
    })

    $("#editVideoClassClose").click(function (){
        $('#editVideoClassModal').modal('hide');
    })

})

function showVideoClassEdit(data) {
    $("#editVideoClassId").val(data.videoClassId);
    $("#editVideoClassName").val(data.name);
    $("#editVideoClassWeight").val(data.weight);
    $("#editVideoClassModal").modal('show');
}
