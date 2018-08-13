<div class="modal fade" id="editStepModal"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改步骤</h4>
            </div>
            <div class="modal-body">
                <form id="stepEditForm" class="form-horizontal">
                    <input type="hidden" id="editStepCatalogId" name="catalogId">
                    <input type="hidden" id="editStepStepId" name="stepId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editStepCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editStepStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属模块</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editStepModuleName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属目录</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editStepCatalogTitle" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">步骤标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editStepTitle" name="title" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">步骤权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="editStepWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">具体内容</label>
                        <div class="col-sm-10">
                            <div class="summernote" id="editsummernote"></div>
                        </div>
                    </div>
                    <input type="hidden" id="editStepContent" name="content" value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">代码</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" style="height:200px;" id="editStepCode" name="code" value=""></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editStepClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editStepSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>