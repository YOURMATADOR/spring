<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>WLista de libros</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
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
                            <td><form method="POST" action="/sprin/editar_libro"><input type="hidden" name="id" value="${libro.id}"/><button type="submit"><i class="fa fa-pen"></i></button></form></td>
                            <td><form method="POST" action="/sprin/eliminar_libro"><input type="hidden" name="id" value="${libro.id}"/><button type="submit"><i class="fas fa-trash"></i></button></form></td>
                            
                        </tr>                                                                     
                    </c:forEach>
                </c:if>          
            </tbody>
        </table>
        
        <a href="/sprin/agregar_libro">agregar libro</a>
        <a href="/sprin">Volver</a>
    </body>
</html>
