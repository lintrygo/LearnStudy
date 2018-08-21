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
    <script type="text/javascript" src="/front/syntaxhighlighter_3.0.83/scripts/shCore.js"></script>
    <script type="text/javascript" src="/front/syntaxhighlighter_3.0.83/scripts/shBrushJava.js"></script>
    <link type="text/css" rel="stylesheet" href="/front/syntaxhighlighter_3.0.83/styles/shCoreDefault.css"/>
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
    <div class="main-content">
        <div class="row">
            <div class="col-md-2">
                <nav>
                    <a class="disabled list-group-item">${(moduleModel.name)!}</a>
                    <#if catalogList??>
                        <#list catalogList as catalog>
                           <a href="" class="list-group-item">${catalog.title}</a>
                         </#list>
                    </#if>
                </nav>
             </div>
            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading" style="margin-bottom: 10px">
                        <span class="glyphicon glyphicon-list"></span>
                        <a href="/learn/course/stage/${stageModel.stageId}">${stageModel.name}/</a><a href="">${moduleModel.name}/</a>${(catalog.name)!}
                    </div>
                    <div class="panel-body">
                        <div class="pull-right">
                            <table style="width:300px" class="table">
                                <caption style="text-align:center;font-weight:bold">相关下载</caption>
                                <thead>
                                    <tr>
                                        <th>文件名</th>
                                        <th>文件大小</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><a href=""><span class="glyphicon glyphicon-download-alt">JDK安装包</span></a></td>
                                    <td>100M</td>
                                </tr>
                                <tr>
                                    <td><a href=""><span class="glyphicon glyphicon-download-alt">代码包</span></a></td>
                                    <td>500K</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style="margin-top: 40px">
                            ${(catalog.description)!}
                        </div>
                        <div class="row">
                            <div class="col-md-8 col-sm-offset-2 text-center">
                                <video width="320" height="240" controls>
                                    <source src="/front/images/11.mp4" type="video/mp4">
                                    <source src="/front/images/222.wmv" type="video/ogg">
                                    <source src="/front/images/222.wmv" type="video/webm">
                                    您的浏览器不支持 video 标签。
                                </video>
                            </div>
                        </div>
                        <!--<div style="clear:both;margin-left: auto;margin-right: auto;  ">是的发送到发送到发送到发送到发斯蒂芬</div>-->
                        <!--<div>是的发送到发送到发送到发送到发斯蒂芬</div>-->
                        <#if stepList??>
                        <#list stepList as step>
                            <div class="panel panel-info" style="margin-top: 30px">
                                <div class="panel-heading" style="border-bottom: 0px solid;background-color: #d9edf7 !important">
                                    <span class="glyphicon glyphicon-tag basicColor"></span>
                                    <span>步骤${step_index+1}：${step.title}</span>
                                </div>
                                <div class="panel-body" style="width: 90%; margin: 0px auto; display: block;" >
                                    ${step.content!}
                                    <#if step.code!="">
                                    <button  style="margin-top:0px;margin-right:10px" class="pull-right copyButton btn btn-info btn-xs"  type="button">
                                        复制代码
                                    </button>
                                    <button onclick="codeCompare()" style="margin-top:0px;margin-right: 20px" class="pull-right differButton btn btn-warning btn-xs" type="button">
                                        代码比较
                                    </button>
                                    <pre class="brush: java;">
                                      ${step.code!}
                                    </pre>
                                    </#if>
                                </div>
                            </div>
                        </#list>
                        </#if>
                        <!--<div class="panel panel-info" style="margin-top: 30px">-->
                            <!--<div class="panel-heading" style="border-bottom: 0px solid;background-color: #d9edf7 !important">-->
                                <!--<span class="glyphicon glyphicon-tag basicColor"></span>-->
                                <!--步骤1：-->
                                <!--<span>先看下效果</span>-->
                            <!--</div>-->
                            <!--<div class="panel-body" style="width: 90%; margin: 0px auto; display: block;" >-->
                                <!--ssss-->
                            <!--</div>-->
                        <!--</div>-->

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<div id="compareModal" class="modal fade">
    <div class="modal-dialog" style="width:800px;height:500px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="text-align: center;">代码对比</h4>
            </div>
            <div class="modal-body">
                <p>将代码内容填放在左侧，与右侧本文代码对比!</p>
                <div id="mergely"></div>

            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    SyntaxHighlighter.all();
    $(document).ready(function () {

    });
    function codeCompare(){
        $('#mergely').mergely({
            width: 750,
            height:400,
        });
        $('#mergely').mergely('lhs', "");

        // get async rhsResponse, then set rhs value
        $('#mergely').mergely('rhs', "public class HelloWorld {\n" +
            "    public static void main(String[] args) {\n" +
            "        //声明一个引用\n" +
            "        int[] a;\n" +
            "        //创建一个长度是5的数组，并且使用引用a指向该数组\n" +
            "        a = new int[5];\n" +
            "          \n" +
            "        int[] b = new int[5]; //声明的同时，指向一个数组\n" +
            "          \n" +
            "    }\n" +
            "}");
        $("#compareModal").modal('show');

    }
</script>
<#include "/front/common/footer.ftl"/>
<style>
    .panel {
        border: 0;
        box-shadow: none;
    }

    .table > thead > tr > th, .table > thead > tr > td {
        border: 0;
    }
    /*.panel-heading{*/
        /*border-bottom: 0px solid;*/
    /*}*/

</style>
</body>
</html>