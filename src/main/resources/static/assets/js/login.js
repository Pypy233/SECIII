   $(function () {
        $("#btn").click(function () {
            var user = $('#username').val();
            var password = $('#password').val();
            $.ajax({
                type:"GET",
                url:"/login",
                dataType:"json",
                data : {
                    user: user,
                    password: password
                },

                success : function (data) {
                    if(data.success){
                        // 暂定为这玩意儿，以后改
                        window.location.href="views/painter.html";
                    }else
                        alert("Error!");
                },
                error : function () {
                    alert("Network warning");
                }
            });
        });

    }
    );
