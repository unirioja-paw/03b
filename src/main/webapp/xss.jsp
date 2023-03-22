<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
    </head>
    <body>
        <h1>Cross-Site Scripting (XSS) reflejado</h1>
        <p>This is a JSP page</p>
        Parameter in query string:
        <c:out value="${param.name}" />
        <!-- 
        Prueba con esta url:
        http://localhost:8080/Spike03b/xss.jsp?name=%3Cscript%3Ealert(%27oh%20oh%27);%3C/script%3E
        -->
    </body>
</html>
