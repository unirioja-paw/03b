<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
        <style>
            .box {
                margin: 50px;
                padding: 20px;
                font-size: 18px;
                font-family: verdana;
                border: solid 1px #CCC;
            }
            .box .form-control {
                margin: 10px 0;
            }

            input {
                padding: 6px 4px;
            }
        </style>
    </head>
    <body>

        <div class="box">
            <h1>
                Bienvenid@ <%=request.getAttribute("username")%>
            </h1>
            <h1>
                Bienvenid@ ${param.username}
            </h1>
        </div>

    </body>
</html>
