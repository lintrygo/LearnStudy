<div class="modal fade" id="viewModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">查看课程</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                    <form id="viewForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label" style="">课程名称</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="viewName" name="name" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">课程描述</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="viewDescription" name="description" value=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">课程权重</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="viewWeight" name="weight" value=""></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">课程logo</label>
                            <div class="col-sm-10">
                                <input type="file" name="uploadfile" id="viewUploadfile" multiple="multiple" class="file-loading" />
                            </div>
                        </div>
                    </form>
                <fieldset disabled="disabled">
            </div>
            <div class="modal-footer">
                <button id="viewClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>