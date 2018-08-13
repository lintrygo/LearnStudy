<div class="modal fade" id="viewModuleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">查看模块</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                <form id="moduleViewForm" class="form-horizontal">
                    <input type="hidden" id="viewModuleCourseId" name="courseId">
                    <input type="hidden" id="viewModuleStageId" name="stageId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewModuleCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewModuleStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">模块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="viewModuleName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="viewModuleDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="viewModuleWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">模块logo</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="viewModuleUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
               </fieldset>
            </div>
            <div class="modal-footer">
                <button id="viewModuleClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>