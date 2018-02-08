<%--
  Created by IntelliJ IDEA.
  User: leehaoze
  Date: 2018/1/31
  Time: 下午3:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="JS/jquery-3.3.1.min.js"></script>
    <title>Test Page</title>
</head>
<script>
    $(function () {
        $.ajax({
            dataType: 'json',
            url: '/getAllClassesName.form',
            success: function (data) {
                for (var i = 0; i < data.length; ++i) {
                    $('#className').append(
                        '<option id="op-name" value="' + data[i] + '">' + data[i] + '</option>'
                    )
                }
            }
        })
    });


    function loadMethod() {
        console.log("loadMethod");
        $.ajax({
            dataType: 'json',
            url: '/getClassMethod/' + $('#className option:selected').text() + '.form',
            success: function (data) {
                $('#method').remove();
                $('#para').remove();
                $('#sub').remove();
                $('#lee').find('tbody').append(
                    '<tr id="method">' +
                    '<td>方法</td>' +
                    '<td><select id="methodName" name="methodName" onchange="loadParameter()"></select></td>' +
                    '</tr>'
                );

                for (var i = 0; i < data.length; ++i) {
                    $('#methodName').append(
                        '<option id="op-name" value="' + data[i] + '">' + data[i] + '</option>'
                    )
                }
            }
        })
    }

    var parameterType = "";

    function loadParameter() {
        $.ajax({
            dataType: 'json',
            url: '/getMethodParameter/' + $('#className option:selected').text() + '/' + $('#methodName option:selected').text() + '.form',
            success: function (data) {
                $('#para').remove();
                $('#sub').remove();
                if (data.length > 0) {
                    $('#lee').find('tbody').append(
                        '<tr id="para">' +
                        '<td>参数</td>' +
                        '<td id="parameter"></td>' +
                        '</tr>'
                    );

                    for (var i = 0; i < data.length; ++i) {
                        if(i!=0)
                            parameterType += ',';
                        parameterType += data[i];
                        $('#parameter').append(
                            data[i] + '<input class="parameter" type="text">'
                        )
                    }
                }
                $('#lee').find('tbody').append(
                    '<tr id="sub"><td><input id="submit" type="button" value="Test"></td></tr>'
                );
                $('#submit').click(function () {
                    submit();
                })
            }
        })
    }


    function submit() {
        var parameter = "";
        $('.parameter').each(function (index) {
            if(index != 0)
                parameter += ',';
            parameter += $(this).val();
        });


        //无参数
        if ($('#parameter').length == 0) {
            $.ajax({
                dataType: 'json',
                url: '/excuteTest.form?className=' + $('#className option:selected').text() + '&methodName=' + $('#methodName option:selected').text(),
                success: function (data) {
                    console.log("Success");
                    $('#result').children().remove();

                    for (var i = 0; i < data.length; ++i) {
                        console.log("<tr>" + JSON.stringify(data[i]) + "</tr>");
                        $('#result').append(
                            '<tr><td>'+ JSON.stringify(data[i]) +'</td></tr>'
                        )
                    }
                }
            })
        }
        else{
            $.ajax({
                dataType: 'json',
                url: '/excuteTest.form?className=' + $('#className option:selected').text() + '&methodName=' + $('#methodName option:selected').text() + '&parameter=' + parameter + '&type=' + parameterType ,
                success: function (data) {
                    $('#result').children().remove();

                    for (var i = 0; i < data.length; ++i) {
                        console.log("<tr>" + JSON.stringify(data[i]) + "</tr>");
                        $('#result').append(
                            '<tr><td>'+ JSON.stringify(data[i]) +'</td></tr>'
                        )
                    }
                }
            })
        }
    }

</script>

<body>
<form>
    <table id="lee">
        <tr>
            <td>测试类名</td>
            <td><select id="className" name="className" onchange="loadMethod()"></select></td>
        </tr>
    </table>
    <table id="result"></table>
</form>
</body>
</html>
