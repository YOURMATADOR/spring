<%-- 
    Document   : agregar_libro
    Created on : 12-feb-2019, 8:52:33
    Author     : soporte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .libro-item{
                display: flex;
                width: 90%;
                flex-direction: column;
            }
            .libro{
                display: flex;
                flex-direction: column;
                width: 20%;
                margin: auto;
                justify-content: center;
                align-items: center;
                border: 1px solid;
                border-radius: 1rem;
            }
        </style>
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <p>Agregar un nuevo libro.</p>
        <br>       
        <form action="${url}" method="POST" class="libro" >
            <input type="hidden" name="id" value="${id}" class="libro-item--input" placeholder="ingresa nombre de libro" />
            <label class="libro-item" >Nombre 
                <input type="text" name="nombre" value= "${nombre}" class="libro-item--input" placeholder="ingresa nombre de libro" />
            </label>
            <label class="libro-item" >Autor
                <input type="text" name="autor" value="${autor}" class="libro-item--input" placeholder="ingresa autor de libro" />
            </label>
            <label class="libro-item" >Editorial
                <input type="text" name="editorial" value="${editorial}" class="libro-item--input" placeholder="ingresa editorial de libro" />
            </label>
            <input type="submit" value ="Guardar"/>           
        </form>
        <a href="/sprin/libros">Volver</a>
        <a href="/sprin">indice</a>
    </body>
</html>
