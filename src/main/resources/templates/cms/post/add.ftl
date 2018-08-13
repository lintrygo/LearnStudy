<div class="modal fade" id="addPostClassModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">新增版块</h4>
            </div>
            <div class="modal-body">
                <form id="addPostClassForm" class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" style="">版块名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addPostClassName" name="name" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">版块权重</label>
                        <div class="col-sm-10">
                            <input class="form-control" id="addPostClassWeight" name="weight" value="" placeholder="权重越大排序越靠前"></input>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addPostClassClose" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="addPostClassSave" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>