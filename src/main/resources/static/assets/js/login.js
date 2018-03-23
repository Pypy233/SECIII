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
                        window.location.href="draw/index.html";
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
