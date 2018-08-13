<div class="modal fade" id="addVideoClassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增类别</h4>
            </div>
            <div class="modal-body">
                <form id="addVideoClassForm" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">类别名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addVideoClassName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">类别权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="addVideoClassWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addVideoClassClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="addVideoClassSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>