<div class="modal fade" id="viewCatalogModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">查看目录</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                <form id="catalogViewForm" class="form-horizontal">
                    <input type="hidden" id="viewCatalogModuleId" name="moduleId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewCatalogCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewCatalogStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属模块</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewCatalogModuleName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">目录标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="viewCatalogTitle" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">目录描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="viewCatalogDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">目录权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="viewCatalogWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频文件</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="viewCatalogUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
                </fieldset>
            </div>
            <div class="modal-footer">
                <button id="viewCatalogClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="viewCatalogSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>