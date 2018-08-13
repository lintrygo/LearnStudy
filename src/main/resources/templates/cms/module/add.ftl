<div class="modal fade" id="addModuleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增模块</h4>
            </div>
            <div class="modal-body">
                <form id="moduleAddForm" class="form-horizontal">
                    <input type="hidden" id="addModuleCourseId" name="courseId">
                    <input type="hidden" id="addModuleStageId" name="stageId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addModuleCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addModuleStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">模块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addModuleName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="addModuleDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="addModuleWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块logo</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="addModuleuploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addModuleClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="addModuleSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>