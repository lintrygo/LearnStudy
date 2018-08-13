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
    <link rel="stylesheet"  href="/mergely/mergely.css" />
    <link rel="stylesheet"  href="/mergely/codemirror.css" />
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
    <script src="/mergely/codemirror.min.js"></script>
    <script src="/mergely/searchcursor.js"></script>
    <script src="/mergely/mergely.js" type="text/javascript"></script>
</head>
<body class="gray-bg">
<#include "/front/common/header.ftl"/>
<div class="container">
    <div class="main-content projects">
        <div class="row white-bg group-list">
            <div class="panel-heading" style="margin-bottom: 30px">
                所有精讲课程
            </div>
            <div class="panel-body">
                <div class="items">
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
            </div>
        </div>
        </div>
    </div>
</div>
<div id="test" class="modal fade">
    <div class="modal-dialog" style="width:800px;height:800px">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" style="text-align: center;">修改目录</h4>
        </div>
            <div class="modal-body">
                <div id="compare3"></div>

            </div>
        </div>
    </div>
</div>

        <div id="mergely"></div>

<#include "/front/common/footer.ftl"/>

</body>
<script>
    $(document).ready(function () {
       // $('#mergely').mergely();
       //  $('#mergely').mergely({
       //      lhs: function(setValue) {
       //          setValue('the quick red fox\njumped over the hairy dog');
       //      },
       //      rhs: function(setValue) {
       //          setValue('the quick brown fox\njumped over the lazy dog');
       //      }
       //  });
        // $('#mergely').mergely('cm', 'lhs').options.readOnly = true;
        $('#compare3').mergely({
            width: 750,
            height: 800,
        });
        // get async lhsResponse, then set lhs value
        $('#compare3').mergely('lhs', "121212");

        // get async rhsResponse, then set rhs value
        $('#compare3').mergely('rhs', "ewrwerwe");
        $("#my").click(function () {
            $("#test").modal('show');
        })



    });
</script>
</html>