<%-- 
    Document   : respuesta
    Created on : 22-ene-2019, 20:42:23
    Author     : soporte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tu informacion!</h1>
        <jsp:useBean id="mybean" scope="session" class="org.server.respuesta.handler.server" />
          <jsp:setProperty name="mybean" property="name" />
          <h1><jsp:getProperty name="mybean" property="name" /></h1>

    </body>
</html>
