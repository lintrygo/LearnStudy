<div class="modal fade" id="viewStageModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">查看阶段</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                    <form id="viewStageForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="">所属课程</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="viewStageCourseName" value="" disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="">阶段名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="viewStageName" name="name" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">阶段描述</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="viewStageDescription" name="description" value=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">阶段权重</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="viewStageWeight" name="weight" value=""></textarea>
                            </div>
                        </div>
                    </form>
                </fieldset>
            </div>
            <div class="modal-footer">
                <button id="viewStageClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>