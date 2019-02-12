/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matador;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
 
@Controller
public class default_controller
{
    @RequestMapping(value = "/libros", method = RequestMethod.GET)
    public String libros_view(Model model) throws SQLException, ClassNotFoundException
    {   
        ArrayList <lista_libros> lista_libro = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");

        Connection con = db.getDB();
        Statement stmt= con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from libros");   
         while (rs.next()) {
             lista_libros libro = new lista_libros();
             libro.setId(rs.getString("id"));
             libro.setNombre(rs.getString("nombre"));
             libro.setAutor(rs.getString("autor"));
             libro.setEditorial(rs.getString("editorial"));
             lista_libro.add(libro);
         }
         model.addAttribute("libros",lista_libro);
        return "libros";
    }
    @RequestMapping(value = "/saludo", method = RequestMethod.GET)
    public String hola_view_get(Model model)
    {   
        
        return "hola";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index_view(Model model)
    {   
        
        return "index";
    }
    
   
    @RequestMapping(value = "/saludo", method = RequestMethod.POST)
    public String hola_view(Model model,@RequestParam("nombre") String nombre)
    {        
        model.addAttribute("nombre",nombre);
        model.addAttribute("ejemplo","post");
        return "hola";
    }
}