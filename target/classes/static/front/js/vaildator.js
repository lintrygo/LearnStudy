var vaildatorLogin={
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        //表单name
        name: {
            //提示消息
            message: '用户名验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '用户名不能为空!'
                }
            }
        },
        password: {
            //提示消息
            message: '密码验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '密码不能为空'
                }
            }
        },

    }
};

var vaildatorRegister={
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        //表单name
        name: {
            //提示消息
            message: '用户名验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '用户名不能为空!'
                }
            }
        },
        password: {
            //提示消息
            message: '密码验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {//相同
                    field: 'password', //需要进行比较的input name值
                    message: '两次密码不一致'
                },
            }
        },
        repassword: {
            //提示消息
            message: '重复密码验证失败',
            //需要做的验证
            validators: {
                //验证项
                notEmpty: {
                    message: '密码不能为空',
                },
                identical: {//相同
                    field: 'password', //需要进行比较的input name值
                    message: '两次密码不一致'
                },
            }
        },

    }
};