$(function () {
    $("#deleteCatalogSave").click(function () {
        $.ajax({
            url: '/back/catalog/deleteCatalog',
            type: 'post',
            dataType: 'json',
            data: {catalogId:$("#deleteCatalogId").val(),url:$("#url").val()},
            success: function (data) {
                if(data.code==100){
                    toastr.success(data.message);
                }else if(data.code==200){
                    toastr.info(data.message);
                }
                catalog_tab .ajax.reload();

            },
            error:function (data) {
                toastr.error("操作异常!");
            }
        });
        $("#deleteCatalogModal").modal('hide');
    })

})

function  showCatalogDelete(data) {
    $("#deleteCatalogId").val(data.catalogId);
    $("#url").val(data.logo);
    $("#deleteCatalogModal").modal('show');
}