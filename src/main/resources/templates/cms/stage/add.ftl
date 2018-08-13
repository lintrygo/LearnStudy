<div class="modal fade" id="addStageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增阶段</h4>
            </div>
            <div class="modal-body">
                <form id="stageAddForm" class="form-horizontal">
                    <input type="hidden" id="addStageCourseId" name="courseId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addStageCourseName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">阶段名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addStageName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">阶段描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="addStageDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">阶段权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="addStageWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addStageClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="addStageSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>