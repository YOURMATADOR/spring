<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>       
         <form action="/sprin/saludo" method="POST">
            <input type="text" name="nombre" value="" placeholder="ingresa tu nombre para saludarte" />
            <input type="submit"/>           
        </form>
            <h1>Hola ${nombre}</h1>
            <h1>Hola ${ejemplo}</h1>
    </body>
</html>
