<%--
  Created by IntelliJ IDEA.
  User: szper
  Date: 2018/2/8
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="JS/jquery-3.3.1.min.js"></script>
    <title>Login</title>
    <script type="text/javascript">
        function getLogin() {
            var data={};
            data['username'] = $('#uname').val();
            data["password"] = $('#upwd').val();
            console.log(data['username'] + "    " + date['password']);
            $.ajax({
                url: "/userLogin.form",
                data: data,
                Type: "GET",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    console.log("AJAX FAIL");
                }
            })
        }
    </script>
</head>
<body>

    <form action="/userLogin.form" method="post">
    用户名：<input type="text" name="username" id="uname" />
    密码： <input type="password" name="password" id="upwd" />
        <input type="submit" value="提交" id="submit"/>
    </form>
</body>
</html>
