<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/css/toastr.css" />
<link rel="stylesheet" type="text/css" href="/css/toastr.min.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="/css/component.css" />
<script type="text/javascript" src="/js/jquery/jquery-3.0.0.min.js"></script>
<script src="/js/html5.js"></script>
<script src="/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/toastr.js"></script>
<script type="text/javascript" src="/js/login/login.js"></script>
</head>
<body>
		<div class="demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>后台管理登录</h3>
						<form action="#" id="loginForm" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input id="name" name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id="password" name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2">
                                <button id="login" type="button" class="btn btn-primary btn-lg btn-block">登录</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="/js/TweenLite.min.js"></script>
		<script src="/js/EasePack.min.js"></script>
		<script src="/js/rAF.js"></script>
		<script src="/js/demo-1.js"></script>
	</body>
</html>