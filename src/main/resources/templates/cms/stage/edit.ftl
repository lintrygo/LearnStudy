<div class="modal fade" id="editStageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改阶段</h4>
            </div>
            <div class="modal-body">
                <form id="editStageForm" class="form-horizontal">
                    <input type="hidden"  id="editStageId" name="stageId" value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editStageCourseName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">阶段名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editStageName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">阶段描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editStageDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">阶段权重</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editStageWeight" name="weight" value=""></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editStageClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editStageSave" type="button" class="btn btn-primary">更新</button>
            </div>
        </div>
    </div>
</div>