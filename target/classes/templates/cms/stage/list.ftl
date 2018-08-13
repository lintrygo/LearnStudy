
<#include "/cms/stage/view.ftl"/>
<#include "/cms/stage/edit.ftl"/>
<#include "/cms/stage/delete.ftl"/>
<#include "/cms/module/add.ftl"/>
<div class="row">
    <div class="col-xs-12">
        <div class="box">
            <div class="box-header">
                <h3 class="box-title">阶段管理</h3>
            </div>
            <div class="col-sm-2">
                <label>课程选择:</label>
                <select id="select" class="form-control">
                    <option value="-1">全部</option>
                    <#list courseList as list>
                        <option value=${list.courseId!}>${list.name!}</option>
                    </#list>
                </select>
            </div>
            <div class="box-body">
                <table id="stage_tab" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                    <tr>
                        <th>序号</th>
                        <th>名称</th>
                        <th>描述</th>
                        <th>权重/排序</th>
                        <th>所属课程</th>
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
<script type="text/javascript" src="/js/stage/stage.js"></script>
<script type="text/javascript" src="/js/stage/view.js"></script>
<script type="text/javascript" src="/js/stage/add.js"></script>
<script type="text/javascript" src="/js/stage/edit.js"></script>
<script type="text/javascript" src="/js/stage/delete.js"></script>
<script type="text/javascript" src="/js/module/add.js"></script>