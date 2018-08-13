<div class="modal fade" id="editVideoClassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">修改类别</h4>
            </div>
            <div class="modal-body">
                <form id="editVideoClassForm" class="form-horizontal">
                    <input type="hidden"  id="editVideoClassId" name="videoClassId" value="">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">版块类别</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="editVideoClassName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">类别权重</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="editVideoClassWeight" name="weight" value=""></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="editVideoClassClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="editVideoClassSave" type="button" class="btn btn-primary">更新</button>
            </div>
        </div>
    </div>
</div>