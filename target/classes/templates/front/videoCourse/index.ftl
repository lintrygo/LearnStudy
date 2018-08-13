<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link href="/common/css/zui.min.css" rel="stylesheet">
    <link href="/front/css/app.css" rel="stylesheet">
    <link rel="stylesheet" href="/adminlte/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/front/css/site.min.css">
    <!--[if lt IE 9]>
    <script src="/common/js/html5shiv.min.js"></script>
    <script src="/common/js/respond.min.js"></script>
    <![endif]-->
    <script src="/common/js/jquery-2.1.1.min.js"></script>
    <script src="/common/js/zui.min.js"></script>
    <script src="/plugins/layer/layer.js"></script>
    <script src="/common/js/jquery.form.js"></script>
    <script src="/common/js/jeesns.js"></script>
    <script src="/common/js/extendPagination.js"></script>
</head>

<body class="gray-bg">
<#include "/front/common/header.ftl"/>
<div class="wrapper wrapper-content">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">
            <div class="ibox-content">
                <div class="tabs-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="tabs.html#tab-1">Spring Boot</a></li>
                        <li class=""><a data-toggle="tab" href="tabs.html#tab-2">Spring Cloud</a></li>
                        <li class=""><a data-toggle="tab" href="tabs.html#tab-3">Dubbo</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane active">
                            <div class="panel-body">
                                <a href="" target="_blank" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">JavaBean内省机制以及在Spring中的应用</p>
                                    </div>
                                </a>
                                <a href="" target="_blank" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">Java9新特性之核心类库</p>
                                    </div>
                                </a>
                                <a href="" data-toggle="modal" data-target="#example" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">高并发 Reactor 编程</p>
                                    </div>
                                </a>



                            </div>
                        </div>
                        <div id="tab-2" class="tab-pane">
                            <div class="panel-body">
                                <a href="" target="_blank" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">JavaBean内省机制以及在Spring中的应用</p>
                                    </div>
                                </a>
                                <a href="" target="_blank" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">Java9新特性之核心类库</p>
                                    </div>
                                </a>
                                <a href="" data-toggle="modal" data-target="#example" class="card col-sm-3 px-0 my-2" >
                                    <img class="card-img-top" src="http://upload-images.jianshu.io/upload_images/3424642-2f6de103c7d7dd08.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240" alt="Card image cap">
                                    <div class="card-body">
                                        <p class="card-text">高并发 Reactor 编程</p>
                                    </div>
                                </a>
                             </div>
                    </div
                    >
                </div>
            </div>
        </div>
    </div>

    <div id="example" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog" style="width:800px;height:400px" role="document">
            <div class="modal-content">
                <div class="row">
                    <div class="col-md-8 col-sm-offset-2 text-center">
                        <video style="height:400px"  controls>
                            <source src="/front/images/11.mp4" type="video/mp4">
                            <source src="/front/images/33.mp4" type="video/ogg">
                            <source src="/front/images/33.mp4" type="video/webm">
                            您的浏览器不支持 video 标签。
                        </video>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    .card {
        position: relative;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -ms-flex-direction: column;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid rgba(0,0,0,.125);
        border-radius: .25rem;
    }

    .card-img-top {
        width: 100%;
        border-top-left-radius: calc(.25rem - 1px);
        border-top-right-radius: calc(.25rem - 1px);
    }
    img {
        vertical-align: middle;
        border-style: none;
    }

    .card-body {
        -webkit-box-flex: 1;
        -ms-flex: 1 1 auto;
        flex: 1 1 auto;
        padding: 1.25rem;
    }
</style>



</body>
</html>