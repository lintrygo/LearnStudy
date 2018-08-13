<div class="modal fade" id="viewVideoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增视频</h4>
            </div>
            <div class="modal-body">
                <fieldset disabled="disabled">
                <form id="videoViewForm" class="form-horizontal">
                    <input type="hidden" id="viewVideoModuleId" name="moduleId">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="viewVideoClassName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">视频名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="viewVideoName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="viewVideoDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="viewVideoWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频文件</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="viewVideoUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
                </fieldset>
            </div>
            <div class="modal-footer">
                <button id="viewVideoClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="viewVideoSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>