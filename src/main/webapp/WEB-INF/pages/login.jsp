<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
        <style>
            body {
                font-family: verdana;
                font-size: 18px;
            }
            .box {
                margin: 50px;
                padding: 20px;
                border: solid 1px #CCC;
            }
            .box-error {
                border: solid 1px red;
                background-color: #ffcccc;
                font-weight: bold;
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
        <h1>Login</h1>

        <div class="box">
            <form method="post">
                <div class="form-control">
                    <label for="username">Usuario:</label>
                    <input type="text" name="username" id="username">
                </div>
                <div class="form-control">
                    <label for="userpasswd">Clave:</label>
                    <input type="text" name="userpasswd" id="userpasswd">
                </div>
                <div class="form-control">
                    <button type="submit">Entrar</button>
                </div>
            </form>
        </div>
        <div>
            authSucces: <%= request.getAttribute("loginSuccess")%>,
            authSucces: ${param.loginSuccess == true},
            username: <%=request.getAttribute("username")%>
        </div>
        <c:if test="${param.username != null and not param.loginSuccess}" >
            <div class="box box-error">
                Usuario <%=request.getAttribute("username")%>: no permitido
            </div>
        </c:if>
    </body>
</html>
