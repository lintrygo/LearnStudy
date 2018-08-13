
$(function() {
    $("#editPostClassForm").bootstrapValidator(vaildatorPostClassRule); //vaildatorRule 验证规则
    //得到获取validator对象或实例
    var bootstrapValidator = $("#editPostClassForm").data('bootstrapValidator');

    $("#editPostClassSave").click(function () {
        // 执行表单验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            $.ajax({
                url: '/back/post/updateClass',
                type: 'post',
                dataType: 'json',
                data: $("#editPostClassForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }
                    postClass_tab.ajax.reload();
                },
                error:function (data) {
                    toastr.error("操作异常!");
                }
            });
            $("#editPostClassModal").modal('hide');
        }
    })

    $("#editPostClassClose").click(function (){
        $('#editPostClassModal').modal('hide');
    })

})

function showPostClassEdit(data) {
    $("#editPostClassId").val(data.postClassId);
    $("#editPostClassName").val(data.name);
    $("#editPostClassWeight").val(data.weight);
    $("#editPostClassModal").modal('show');
}
