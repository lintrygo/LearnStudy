<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <meta name="keywords" content="keywords"/>
    <meta name="description" content="description"/>
    <meta name="author" content=""/>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/common/css/zui.min.css" rel="stylesheet">
    <link href="/front/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/toastr.css" />
    <link rel="stylesheet" href="/adminlte/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/front/css/site.min.css">
    <!--<link rel="stylesheet" href="/front/css/index.css">-->
    <!--[if lt IE 9]>
    <script src="/common/js/html5shiv.min.js"></script>
    <script src="/common/js/respond.min.js"></script>
    <![endif]-->
    <!--<script src="/common/js/jquery-2.1.1.min.js"></script>-->
    <script src="/adminlte/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="/adminlte/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/common/js/zui.min.js"></script>
    <script src="/plugins/layer/layer.js"></script>
    <script src="/common/js/jquery.form.js"></script>
    <script src="/common/js/jeesns.js"></script>
    <script src="/common/js/extendPagination.js"></script>
    <script src="/js/bootstrap/bootstrapValidator.js"></script>
</head>
<body class="gray-bg">
<#include "/front/common/header.ftl"/>
<div class="container">
    <div id="banner" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#banner" data-slide-to="0" class="active"></li>
            <li data-target="#banner" data-slide-to="1"></li>
            <li data-target="#banner" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img alt="First slide" src="/front/images/ban1.png">
                <div class="carousel-caption">
                    <h3></h3>
                    <p></p>
                </div>
            </div>
            <div class="item">
                <img alt="Second slide" src="/front/images/ban2.png">
                <div class="carousel-caption">
                    <h3></h3>
                    <p></p>
                </div>
            </div>
            <div class="item">
                <img alt="Third slide" src="/front/images/ban3.png">
                <div class="carousel-caption">
                    <h3></h3>
                    <p></p>
                </div>
            </div>
        </div>
    </div>

    <div class="main-content m-t-10 projects">
        <div class="row">
            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        推荐精讲课程
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="/learn/course">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body">
                        <div class="items">
                            <#if courseList??>
                                <#list courseList as course>
                                    <div class="col-sm-6 col-md-4 col-lg-3 ">
                                        <div class="thumbnail" style="height: 300px;">
                                            <a href="/learn/course/${course.courseId}"> <img src="${(course.logo)!}"  ></a>
                                            <div class="caption">
                                                <h3>
                                                    <a href="/learn/course/${course.courseId}">${course.name}<br></a>
                                                </h3>
                                                <p>
                                                   ${course.description}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </#list>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        最新帖子
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body">
                        <div class="items">
                            <div class="col-md-4">
                                <div class="article-hot-list">
                                    <ul>

                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="items">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        推荐视频课程
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body">
                        <div class="items">
                            <div class="col-md-12 group-list">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        友情链接
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body friend-link">
                        <ul>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/front/common/footer.ftl"/>
<script type="text/javascript">
    $(function () {
        $(".pagination").jeesns_page("jeesnsPageForm");
    });
</script>

</body>
</html>