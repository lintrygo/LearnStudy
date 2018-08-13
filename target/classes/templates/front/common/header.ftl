<link rel="stylesheet" href="/css/toastr.css" />
<script src="/js/bootstrap/bootstrapValidator.js"></script>
<script src="/js/toastr.js"></script>
<script src="/js/initToastr.js"></script>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header m-navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">JEESNS</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand jeesns-logo" href=""><img src="" height="50px"/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/learn">首页</a></li>
                <li><a href="/learn/course">精讲课程</a></li>
                <li><a href="/learn/videoCourse">视频课程</a></li>
                <!--<li><a href="">文章</a></li>-->
                <li><a href="">讨论区</a></li>
            </ul>
            <ul class="nav navbar-top-links navbar-right">
                <div class="nav navbar-nav navbar-nav-right">
                    <#if loginUser ??>
                    <div class="btn-group nav-username m-t-10">
                        <img src="" class="img-circle" width="25px" height="25px" style="margin-top: 1px;margin-right:5px;"/>
                        <a class="header-action-link" href="javascript:void(0)">
                            ${loginUser.name}
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/learn/user/index">个人中心</a></li>
                            <li><a href="">系统信息 </a></li>
                            <li><a href="">私信</a></li>
                            <li><a href="">设置</a></li>

                        <li class="divider"></li>
                        <li><a href="/learn/logout">退出</a></li>
            </ul>
            <script>
                $(function () {
                    $(".nav-username").hover(function(){
                        $(this).addClass("open");
                    },function(){
                        $(this).removeClass("open");
                    });
                })
            </script>
        </div>

        <#else>
        <!--<li><a data-toggle="modal" data-target="#login" href="">登录</a></li>-->
        <!--<li><a data-toggle="modal" data-target="#register" href="">注册</a></li>-->
        <ul class="nav navbar-nav navbar-right">
                     <li><a data-toggle="modal" data-target="#register" href=""><span class="glyphicon glyphicon-user"></span> 注册</a></li>
                     <li><a data-toggle="modal" data-target="#login" href=""><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                 </ul>
    </#if>
    </div>
    </ul>
    </div>
    </div>
</nav>

<!-- 注册窗口 -->
     <div id="register" class="modal fade" tabindex="-1">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-body">
                        <button class="close" data-dismiss="modal">
                             <span>&times;</span>
                        </button>
                     </div>
                     <div class="modal-title">
                         <h1 class="text-center">注册</h1>
                     </div>
                     <div class="modal-body">
                         <form id="registerForm" class="form-horizontal" action="">
                                 <div class="form-group">
                                    <label for="">用户名</label>
                                    <input id="registerName" name="name" class="form-control" type="text" placeholder="6-15位字母或数字">
                                 </div>
                                 <div class="form-group">
                                     <label for="">密码</label>
                                     <input id="registerPassword" name="password" class="form-control" type="password" placeholder="至少6位字母或数字">
                                 </div>
                                <div class="form-group">
                                     <label for="">再次输入密码</label>
                                     <input id="registerRePassword" name="repassword" class="form-control" type="password" placeholder="至少6位字母或数字">
                                 </div>
                             <div class="form-group">
                                 <label for="">邮箱</label>
                                 <input id="registerEmail" class="form-control" name="email" type="email" placeholder="例如:123@123.com">
                             </div>
                             <div class="text-right">
                                 <button id="registerSubmit" class="btn btn-primary" type="submit">提交</button>
                                 <button class="btn btn-danger" data-dismiss="modal">取消</button>
                             </div>
                             <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                     </form>
                     </div>
               </div>
             </div>
         </div>
     <!-- 登录窗口 -->
     <div id="login" class="modal fade">
         <div class="modal-dialog">
             <div class="modal-content">
                 <div class="modal-body">
                     <button class="close" data-dismiss="modal">
                         <span>&times;</span>
                     </button>
                 </div>
                 <div class="modal-title">
                     <h1 class="text-center">登录</h1>
                 </div>
                 <div class="modal-body">
                     <form id="loginForm" class="form-horizontal" action="">
                             <div class="form-group">
                                 <label class="control-label">用户名</label>
                                 <input id="loginName" name="name" class="form-control" type="text" placeholder="">
                             </div>
                             <div class="form-group">
                                 <label class="control-label">密码</label>
                                 <input id="loginPassword" name="password" class="form-control" type="password" placeholder="">
                             </div>
                             <div class="text-right">
                                 <button id="loginSubmit" class="btn btn-primary" type="submit">登录</button>
                                 <button class="btn btn-danger" data-dismiss="modal">取消</button>
                             </div>
                             <a href="" data-toggle="modal" data-dismiss="modal" data-target="#register">还没有账号？点我注册</a>
                     </form>
                 </div>
             </div>
         </div>
        </div>
<script src="/front/js/vaildator.js"></script>
<script>
    $(function() {
        $("#loginForm").bootstrapValidator(vaildatorLogin);
        var loginValidator = $("#loginForm").data('bootstrapValidator');
        $("#registerForm").bootstrapValidator(vaildatorRegister);
        var registerValidator = $("#registerForm").data('bootstrapValidator');
        $("#loginSubmit").click(function () {
            loginValidator.validate();
            if(loginValidator.isValid()){
                $.ajax({
                    url: '/learn/login',
                    type: 'post',
                    dataType: 'json',
                    data: $("#loginForm").serialize(),
                    success: function (data) {
                        if(data.code==100){
                            toastr.success(data.message);
                            setTimeout(function () {
                                window.location.reload();
                            }, 1000);
                        }else if(data.code==200){
                            toastr.error(data.message);
                        }

                    }
                });
            }
        })
        $('#login').on('hidden.bs.modal', function () {
            $("#loginName").val("");
            $("#loginPassword").val("");
            //重置bootstrapValidator
            $("#loginForm").data('bootstrapValidator').destroy();
            $("#loginForm").data('bootstrapValidator', null);
            //初始化bootstrapValidator
            $("#loginForm").bootstrapValidator(vaildatorLogin);
            $("#loginForm").data('bootstrapValidator').validate();
        })



        $("#registerSubmit").click(function () {
            registerValidator.validate();
            if(registerValidator.isValid()){
                $.ajax({
                    url: '/learn/register',
                    type: 'post',
                    dataType: 'json',
                    data: $("#registerForm").serialize(),
                    success: function (data) {
                        if(data.code==100){
                            toastr.success(data.message);
                            setTimeout(function () {
                                window.location.reload();
                            }, 1000);
                        }else if(data.code==200){
                            toastr.error(data.message);
                        }

                    }
                });
            }
        })

        $('#register').on('hidden.bs.modal', function () {
            $("#registerName").val("");
            $("#registerPassword").val("");
            $("#registerRePassword").val("");
            $("#registerEmail").val("");
            //重置bootstrapValidator
            $("#registerForm").data('bootstrapValidator').destroy();
            $("#registerForm").data('bootstrapValidator', null);
            //初始化bootstrapValidator
            $("#registerForm").bootstrapValidator(vaildatorRegister);
            $("#registerForm").data('bootstrapValidator').validate();
        })


    })
</script>
