<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人中心</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content="JEESNS"/>
    <link href="/common/css/bootstrap.min.css" rel="stylesheet">
    <link href="/common/css/font-awesome.min.css" rel="stylesheet">
    <link href="/common/css/jeesns.css" rel="stylesheet">
    <link href="/common/css/jeesns-skin.css" rel="stylesheet">
    <link href="/plugins/emoji/css/emoji.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="/common/js/html5shiv.min.js"></script>
    <script src="/common/js/respond.min.js"></script>
    <![endif]-->
    <script src="/common/js/jquery-2.1.1.min.js"></script>
    <script src="/common/js/bootstrap.min.js"></script>
    <script src="/plugins/layer/layer.js"></script>
    <script src="/common/js/jquery.form.js"></script>
    <script src="/common/js/jeesns.js"></script>
    <script src="/plugins/emoji/js/underscore-min.js"></script>
    <script src="/plugins/emoji/js/editor.js"></script>
    <script src="/plugins/emoji/js/emojis.js"></script>
    <script src="/common/js/extendPagination.js"></script>
</head>

<body class="gray-bg">
<#include "/front/user/common/header.ftl"/>
<div class="wrapper wrapper-content">
    <div class="member-banner" style="background-image: url(/front/images/ban1.png);">
        <div class="attempts"></div>
        <div class="container">
            <div class="container content">
                <div class="left">
                    <div class="avatar">
                        <img src="/front/images/ban1.png" class="img-circle" width="80px" height="80px"/>
                    </div>
                    <div class="info">
                        <div class="name">
                            ${loginUser.name}
                          </div>
                        <p class="operator">
                            <a class="btn btn-info btn-outline member-follows" href="">
                                <i class="fa fa-edit"></i> 编辑个人资料
                            </a>
                        </p>
                    </div>
                </div>
                <div class="right">
                    <div class="login-info">
                   </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="ibox">
                <div class="ibox-content float-left">
                    <div class="col-sm-2">
                        <div class="float-e-margins">
                            <div class="feed-activity-list">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-10">

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $(".pagination").jeesns_page("jeesnsPageForm");
    });
</script>
</body>
</html>