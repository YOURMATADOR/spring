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
    @RequestMapping(value = "/agregar_libro", method = RequestMethod.GET)
    public String agregar_libro_view_get(Model model)
    {   
                model.addAttribute("nombre","");
                model.addAttribute("id",0);
                model.addAttribute("editorial","");
                model.addAttribute("autor","");
                model.addAttribute("url","/sprin/agregar_libro");
        return "agregar_libro";
    }
     @RequestMapping(value = "/agregar_libro", method = RequestMethod.POST)
    public String agregar_libro_post(Model model,@RequestParam("nombre") String nombre,@RequestParam("editorial") String editorial,@RequestParam("autor") String autor) throws SQLException
    {        
        
        Connection con = db.getDB();
        Statement stmt= con.createStatement();  
        stmt.executeUpdate("INSERT INTO libros (nombre, autor, editorial) VALUES ('"+nombre+"','"+autor+"','"+editorial+"')");
         return "redirect:/libros";

    }
     @RequestMapping(value = "/editar_libro", method = RequestMethod.POST)
    public String editar_libro_post(Model model,@RequestParam("id") String id) throws SQLException
    {        
         Connection con = db.getDB();
        Statement stmt= con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from libros WHERE id='"+id+"' "); // * obtener libro de DB   
         while (rs.next()) {                          
                model.addAttribute("nombre",rs.getString("nombre"));
                model.addAttribute("id",rs.getString("id"));
                model.addAttribute("editorial",rs.getString("editorial"));
                model.addAttribute("autor",rs.getString("autor"));
                model.addAttribute("url","/sprin/editar_libro_post");
         }
     
         return "agregar_libro";

    }
     @RequestMapping(value = "/editar_libro_post", method = RequestMethod.POST)
    public String editar_libro_post_post(Model model,@RequestParam("id") String id,@RequestParam("nombre") String nombre,@RequestParam("autor") String autor,@RequestParam("editorial") String editorial) throws SQLException
    {        String sSQL = "UPDATE libros SET nombre='"+nombre+"',editorial='"+editorial+"',autor='"+autor+"' WHERE id='"+id+"' ";
         Connection con = db.getDB();
        Statement stmt= con.createStatement();  
        PreparedStatement pstm = con.prepareStatement(sSQL);
         pstm.executeUpdate();

         return "redirect:/libros";

    }
     @RequestMapping(value = "/eliminar_libro", method = RequestMethod.POST)
    public String eliminar_libro_post(Model model,@RequestParam("id") String id) throws SQLException
    {        
        Connection con = db.getDB();
        Statement stmt= con.createStatement();  
        stmt.executeUpdate("DELETE FROM libros WHERE id ='"+id+"'");
         return "redirect:/libros";

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