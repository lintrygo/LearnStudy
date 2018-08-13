<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="container">
                    <div class="navbar-header jeesns-logo">
                        <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse"
                                class="navbar-toggle collapsed" type="button">
                            <i class="fa fa-reorder"></i>
                        </button>
                        <a href="" class="navbar-brand"><img src="" height="50px"/></a>
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
        </div>
