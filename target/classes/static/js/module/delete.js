$(function () {
    $("#deleteModuleSave").click(function () {
        $.ajax({
            url: '/back/module/deleteModule',
            type: 'post',
            dataType: 'json',
            data: {moduleId:$("#deleteModuleId").val(),url:$("#url").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                module_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteModuleModal").modal('hide');
    })

})

function  showModuleDelete(data) {
    $("#deleteModuleId").val(data.moduleId);
    $("#url").val(data.logo);
    $("#deleteModuleModal").modal('show');
}