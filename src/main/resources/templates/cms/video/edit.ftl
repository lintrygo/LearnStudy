<div class="modal fade" id="editVideoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改视频</h4>
            </div>
            <div class="modal-body">
                <form id="videoEditForm" class="form-horizontal">
                    <input type="hidden" id="editVideoId" name="videoId">
                    <input type="hidden" id="deleteVideo" >
                    <input type="hidden"  id="editVideoUrl" name="video" value="">
                    <input type="hidden"  id="initPreviewVideo"  value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">所属课程</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="editVideoClassName" value="" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">视频名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editVideoName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频描述</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editVideoDescription" name="description" value=""></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="editVideoWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">视频文件</label>
                        <div class="col-sm-10">
                            <input type="file" name="uploadfile" id="editVideoUploadfile" multiple="multiple" class="file-loading" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editVideoClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editVideoSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>