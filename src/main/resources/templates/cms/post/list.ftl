<#include "/cms/post/add.ftl"/>
<#include "/cms/post/edit.ftl"/>
<#include "/cms/post/delete.ftl"/>
<#include "/cms/stage/add.ftl"/>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">讨论区版块管理</h3>
                <div class="box-tools pull-right">
                    <a class="btn btn-sm btn-primary" id="addPostClass">添加</a>
                </div>
            </div>
            <div class="box-body">
                <table id="postClass_tab" class="table table-bordered table-striped">
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
<script type="text/javascript" src="/js/post/post.js"></script>
<script type="text/javascript" src="/js/post/edit.js"></script>
<script type="text/javascript" src="/js/post/delete.js"></script>
