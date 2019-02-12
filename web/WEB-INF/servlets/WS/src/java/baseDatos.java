/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author soporte
 */
@WebServlet(urlPatterns = {"/baseDatos"})
public class baseDatos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet requ cnmb cvc v est
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("nombre");
            String autor = request.getParameter("autor");
            String editorial = request.getParameter("editorial");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet baseDatos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Base de datos libreria</h1>");
            out.println("<ul>");
              try{  
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:8889/libreria","tumatador","123");  
                //here sonoo is database name, root is username and password  
                Statement stmt=con.createStatement();  
                 stmt.executeUpdate("INSERT INTO libros (nombre, autor, editorial) VALUES ('"+nombre+"','"+autor+"','"+editorial+"')");
                ResultSet rs=stmt.executeQuery("select * from libros");                  
                
             while(rs.next()){  
                 out.println("<li>"+rs.getString(1)+" "+ rs.getString(2)+" " +rs.getString(3)+" " + "</li>");
                        }
             out.println("</ul>");
            con.close(); 
             
                
                }
                catch(Exception e)
                { 
                    out.println("<h1>error en la base de datos</h1>");
                    System.out.println(e);
                } 
            
            out.println("<a href='baseDatos.html'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
