$(document).ready(function(){
    if(window.parent!=window){//window.parent:如果不存在父窗口，那么该值默认为当前窗口对象
        toastr.error("登录超时!");
        window.parent.location.reload(true);

    }
    toastr.options = {
        "closeButton": false,//是否配置关闭按钮
        "debug": false,//是否开启debug模式
        "newestOnTop": false,//新消息是否排在最上层
        "progressBar": false,//是否显示进度条
        "positionClass": "toast-center-center",//消息框的显示位置
        "preventDuplicates": true,//是否阻止弹出多个消息框
        "onclick": null,//点击回调函数
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": "1500",//1.5s后关闭消息框
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    }
    $("#login").click(function(){
        if ($("#name").val()==""){
            toastr.error("用户名不能为空！");
        } else if($("#password").val()==""){
            toastr.error("密码不能为空!");
        }else{
            $.ajax({
                url: '/admin/toLogin',
                type: 'post',
                dataType: 'json',
                data: $("#loginForm").serialize(),
                success: function (data) {
                    if(data.code==100){
                        toastr.success(data.message);
                        setTimeout(function () {
                            window.location.href="/back/index";
                        }, 1000);
                    }else if(data.code==200){
                        toastr.info(data.message);
                    }

                }
            });
        }
    });
});