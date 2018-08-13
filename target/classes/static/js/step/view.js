$(function() {
    $('#viewsummernote').summernote({
        height: 250,
        lang: 'zh-CN',
    });

    $("#viewStepClose").click(function (){
        $('#viewStepModal').modal('hide');
    })

    $('#viewStepModal').on('hidden.bs.modal', function () {
    })

})

function showStepView(data) {
    $("#viewStepCourseName").val(data.courseName);
    $("#viewStepStageName").val(data.stageName);
    $("#viewStepModuleName").val(data.moduleName);
    $("#viewStepTitle").val(data.stepTitle);
    $("#viewStepCatalogTitle").val(data.catalogTitle);
    $("#viewsummernote").summernote('code',data.stepContent)
    $("#viewStepWeight").val(data.stepWeight);
    $("#viewStepCode").val(data.stepCode);
    $('#viewsummernote').summernote('disable')
    $("#viewStepModal").modal('show');
}
