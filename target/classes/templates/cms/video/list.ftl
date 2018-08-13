
<#include "/cms/video/view.ftl"/>
<#include "/cms/video/edit.ftl"/>
<#include "/cms/video/delete.ftl"/>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title">视频管理管理</h3>
			</div>
			<div class="col-sm-2">
				<label>视频课程类别选择:</label>
				<select id="videoClassSelect" class="form-control">
					<option value="-1">全部</option>
					<#list videoClassList as videoClass>
					<option value=${videoClass.videoClassId!}>${videoClass.name!}</option>
					</#list>
				</select>
			</div>
			<div class="box-body">
				<table id="video_tab" class="table table-bordered table-striped">
					<thead>
						<tr>
							<tr>
								<th>序号</th>
								<th>名称</th>
								<th>权重/排序</th>
								<th>所属视频课程</th>
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
<script type="text/javascript" src="/js/video/video.js"></script>
<script type="text/javascript" src="/js/video/view.js"></script>
<script type="text/javascript" src="/js/video/add.js"></script>
<script type="text/javascript" src="/js/video/edit.js"></script>
<script type="text/javascript" src="/js/video/delete.js"></script>

