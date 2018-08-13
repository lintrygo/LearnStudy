
<#include "/cms/step/view.ftl"/>
<#include "/cms/step/edit.ftl"/>
<#include "/cms/step/delete.ftl"/>

<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">步骤管理</h3>
			</div>
			<div class="col-sm-2">
				<label>课程选择:</label>
				<select id="courseSelect" class="form-control">
					<option value="-1">全部</option>
					<#list courseList as course>
					<option value=${course.courseId!}>${course.name!}</option>
					</#list>
				</select>
			</div>
			<div class="col-sm-2">
				<label>阶段选择:</label>
				<select id="stageSelect" class="form-control">
					<option value="-1">全部</option>
					<#list stageList as stage>
					<option value=${stage.stageId!}>${stage.name!}</option>
					</#list>
				</select>
			</div>
			<div class="col-sm-2">
				<label>模块选择:</label>
				<select id="moduleSelect" class="form-control">
					<option value="-1">全部</option>
					<#list moduleList as module>
					<option value=${module.moduleId!}>${module.name!}</option>
					</#list>
				</select>
			</div>
			<div class="col-sm-2">
				<label>模块选择:</label>
				<select id="catalogSelect" class="form-control">
					<option value="-1">全部</option>
					<#list catalogList as catalog>
					<option value=${catalog.catalogId!}>${catalog.title!}</option>
				</#list>
				</select>
			</div>
			<div class="box-body">
				<table id="step_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>权重/排序</th>
								<th>所属课程</th>
								<th>所属阶段</th>
								<th>所属模块</th>
								<th>所属目录</th>
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
<script type="text/javascript" src="/js/step/step.js"></script>
<script type="text/javascript" src="/js/step/view.js"></script>
<script type="text/javascript" src="/js/step/add.js"></script>
<script type="text/javascript" src="/js/step/edit.js"></script>
<script type="text/javascript" src="/js/step/delete.js"></script>
