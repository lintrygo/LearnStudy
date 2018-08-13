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
<div class="container">
    <div class="main-content">
        <div class="row">
            <div class="col-md-2">
                <nav>
                    <a class="disabled list-group-item">阶段</a>
                    <#if stageList??>
                        <#list stageList as stage>
                             <a href="/learn/course/stage/${stage.stageId}" class="list-group-item">${stage.name}</a>
                        </#list>
                    </#if>
                </nav>
            </div>
            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading" style="margin-bottom: 10px">
                        <span class="glyphicon glyphicon-list"></span>
                        ${(stageName)!}
                    </div>
                    <div class="panel-body">
                        <#if moduleList??>
                            <#list moduleList as module>
                                <a href="/learn/course/content/${module.moduleId}" class="module" style="margin-top:5px">
                                    <img src="${module.logo}">
                                    <span class="moduleName pull-right">${module.name}</span>
                                    <br>
                                    <br>
                                    <span>${module.description}</span>
                                    <span class="badge moduleNumber pull-right">${module_index+1}</span>
                                </a>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
<#include "/front/common/footer.ftl"/>
<style>

    a.module{
        display: block;
        width:280px;
        height:150px;
        margin: 10px;
        padding:15px;
        background-color: #d9edf7;
        float:left;
        border-radius: 18px;
        position: relative;

    }

    a.module span.moduleNumber{
        position: absolute;
        top: 120px;
        left: 250px;
        color:#BC8F8F;
        background-color: #F5F5DC;
        border:1px green silver;
    }

    a.module span.progressBar{
        display:inline-block;
        position: absolute;
        left: 0px;
        top: 170px;
        width:100%;
    }

    a.module:hover{
        background-color: #dff0d8;
    }


</style>
</body>
</html>