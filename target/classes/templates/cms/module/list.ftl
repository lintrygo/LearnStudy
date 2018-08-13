
<#include "/cms/module/view.ftl"/>
<#include "/cms/module/edit.ftl"/>
<#include "/cms/module/delete.ftl"/>
<#include "/cms/catalog/add.ftl"/>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">模块类别管理</h3>
			</div>
			<div class="col-sm-2">
				<label>课程选择:</label>
				<select id="courseSelect" class="form-control">
					<option value="-1">全部</option>
					<#list courseList as courseList>
					<option value=${courseList.courseId!}>${courseList.name!}</option>
					</#list>
				</select>
			</div>
			<div class="col-sm-2">
				<label>阶段选择:</label>
				<select id="stageSelect" class="form-control">
					<option value="-1">全部</option>
					<#list stageList as stageList>
					<option value=${stageList.stageId!}>${stageList.name!}</option>
					</#list>
				</select>
			</div>
			<div class="box-body">
				<table id="module_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>描述</th>
								<th>权重/排序</th>
								<th>所属课程</th>
								<th>所属阶段</th>
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
<script type="text/javascript" src="/js/module/module.js"></script>
<script type="text/javascript" src="/js/module/view.js"></script>
<script type="text/javascript" src="/js/module/add.js"></script>
<script type="text/javascript" src="/js/module/edit.js"></script>
<script type="text/javascript" src="/js/module/delete.js"></script>
<script type="text/javascript" src="/js/catalog/add.js"></script>
