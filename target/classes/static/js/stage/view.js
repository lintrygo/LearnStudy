$(function() {


    $("#viewStageClose").click(function (){
        $('#viewStageModal').modal('hide');
    })

    $('#viewStageModal').on('hidden.bs.modal', function () {
    })

})

function showStageView(data) {
    $("#viewStageCourseName").val(data.courseName);
    $("#viewStageName").val(data.stageName);
    $("#viewStageDescription").val(data.stageDescription);
    $("#viewStageWeight").val(data.stageWeight);
    $("#viewStageModal").modal('show');
}
