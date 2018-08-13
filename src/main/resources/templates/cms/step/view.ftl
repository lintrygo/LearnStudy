<div class="modal fade" id="viewStepModal"  tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">查看步骤</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                <form id="stepViewForm" class="form-horizontal">
                    <input type="hidden" id="viewStepCatalogId" name="catalogId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewStepCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewStepStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属模块</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewStepModuleName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属目录</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewStepCatalogTitle" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">步骤标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="viewStepTitle" name="title" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">步骤权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="viewStepWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">具体内容</label>
                        <div class="col-sm-10">
                            <div class="summernote" id="viewsummernote"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">代码</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" style="height:200px;" id="viewStepCode" name="code" value=""></textarea>
                        </div>
                    </div>
                </form>
                </fieldset>
            </div>
            <div class="modal-footer">
                <button id="viewStepClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>