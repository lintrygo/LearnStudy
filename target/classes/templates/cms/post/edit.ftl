<div class="modal fade" id="editPostClassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改版块</h4>
            </div>
            <div class="modal-body">
                <form id="editPostClassForm" class="form-horizontal">
                    <input type="hidden"  id="editPostClassId" name="postClassId" value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">版块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editPostClassName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">版块权重</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editPostClassWeight" name="weight" value=""></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editPostClassClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editPostClassSave" type="button" class="btn btn-primary">更新</button>
            </div>
        </div>
    </div>
</div>