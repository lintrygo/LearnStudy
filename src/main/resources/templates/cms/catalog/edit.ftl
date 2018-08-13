<div class="modal fade" id="editCatalogModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改目录</h4>
            </div>
            <div class="modal-body">
                <form id="catalogEditForm" class="form-horizontal">
                    <input type="hidden" id="editCatalogModuleId" name="moduleId">
                    <input type="hidden" id="editCatalogCatalogId" name="catalogId">
                    <input type="hidden" id="delete" >
                    <input type="hidden"  id="editVideo" name="video" value="">
                    <input type="hidden"  id="initPreview"  value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editCatalogCourseName" value="" disabled="disabled">
                        </div>
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editCatalogStageName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属模块</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editCatalogModuleName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">目录标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editCatalogTitle" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">目录描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editCatalogDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">目录权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="editCatalogWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频文件</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="editCatalogUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editCatalogClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editCatalogSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>