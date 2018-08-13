<#include "/cms/course/add.ftl"/>
<#include "/cms/course/view.ftl"/>
<#include "/cms/course/edit.ftl"/>
<#include "/cms/course/delete.ftl"/>
<#include "/cms/stage/add.ftl"/>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">课程类别管理</h3>
				<div class="box-tools pull-right">
					<a class="btn btn-sm btn-primary" id="add">添加</a>
				</div>
			</div>
			<div class="box-body">
				<table id="course_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>描述</th>
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
<script type="text/javascript" src="/js/course/course.js"></script>
<script type="text/javascript" src="/js/course/view.js"></script>
<script type="text/javascript" src="/js/course/edit.js"></script>
<script type="text/javascript" src="/js/course/delete.js"></script>
<script type="text/javascript" src="/js/stage/add.js"></script>