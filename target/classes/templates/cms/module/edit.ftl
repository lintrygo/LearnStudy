<div class="modal fade" id="editModuleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改模块</h4>
            </div>
            <div class="modal-body">
                    <form id="moduleEditForm" class="form-horizontal">
                        <input type="hidden" id="editModuleCourseId" name="courseId">
                        <input type="hidden" id="editModuleStageId" name="stageId">
                        <input type="hidden" id="editModuleModuleId" name="moduleId">
                        <input type="hidden"  id="editLogo" name="logo" value="">
                        <input type="hidden"  id="initPreview" name="logo" value="">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="">所属课程</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="editModuleCourseName" value="" disabled="disabled">
                            </div>
                            <label class="col-sm-2 control-label" style="">所属课程</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="editModuleStageName" value="" disabled="disabled">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="">模块名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="editModuleName" name="name" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">模块描述</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="editModuleDescription" name="description" value=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">模块权重</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="editModuleWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">模块logo</label>
                            <div class="col-sm-10">
                                <input type="file" name="uploadfile" id="editModuleUploadfile" multiple="multiple" class="file-loading" />
                            </div>
                        </div>
                    </form>
            </div>
            <div class="modal-footer">
                <button id="editModuleClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editModuleSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>