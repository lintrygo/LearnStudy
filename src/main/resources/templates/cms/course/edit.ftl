<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改课程</h4>
            </div>
            <div class="modal-body">
                <form id="editForm" class="form-horizontal">
                    <input type="hidden"  id="editId" name="courseId" value="">
                    <input type="hidden"  id="editLogo" name="logo" value="">
                    <input type="hidden"  id="initPreview" name="logo" value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">课程名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">课程描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">课程权重</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editWeight" name="weight" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">课程logo</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="editUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editSave" type="button" class="btn btn-primary">更新</button>
            </div>
        </div>
    </div>
</div>