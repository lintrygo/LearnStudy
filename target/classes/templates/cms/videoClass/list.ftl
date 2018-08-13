<#include "/cms/videoClass/add.ftl"/>
<#include "/cms/videoClass/edit.ftl"/>
<#include "/cms/videoClass/delete.ftl"/>
<#include "/cms/video/add.ftl"/>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">视频课程类别管理</h3>
                <div class="box-tools pull-right">
                    <a class="btn btn-sm btn-primary" id="addVideoClass">添加</a>
                </div>
            </div>
            <div class="box-body">
                <table id="videoClass_tab" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    <tr>
                        <th>序号</th>
                        <th>名称</th>
                        <th>权重/排序</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/videoClass/videoClass.js"></script>
<script type="text/javascript" src="/js/videoClass/edit.js"></script>
<script type="text/javascript" src="/js/videoClass/delete.js"></script>
<script type="text/javascript" src="/js/video/add.js"></script>

