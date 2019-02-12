<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Lista de libros en la base de datos.</p>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>autor</th>
                    <th>editorial</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty libros}">
                    <c:forEach items="${libros}" var="libro">
                        <tr>
                            <td>${libro.id}</td>
                            <td>${libro.nombre}</td>
                            <td>${libro.autor}</td>
                            <td>${libro.editorial}</td>
                        </tr>                                                                     
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
        <a href="/sprin">Volver</a>
    </body>
</html>
