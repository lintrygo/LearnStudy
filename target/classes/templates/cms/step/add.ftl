<div class="modal fade" id="addStepModal"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增步骤</h4>
            </div>
            <div class="modal-body">
                <form id="stepAddForm" class="form-horizontal">
                    <input type="hidden" id="addStepCatalogId" name="catalogId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addStepCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addStepStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属模块</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addStepModuleName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属目录</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addStepCatalogTitle" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">步骤标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addStepTitle" name="title" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">步骤权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="addStepWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">具体内容</label>
                        <div class="col-sm-10">
                            <div class="summernote" id="summernote"></div>
                        </div>
                    </div>
                    <input type="hidden" id="stepContent" name="content" value="111">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">代码</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" style="height:200px;" id="addStepCode" name="code" value=""></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addStepClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="addStepSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>