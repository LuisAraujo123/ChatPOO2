/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.controladores.UsuariosCtrl;
import com.sv.udb.modelos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DanielWilfredo
 */
@WebServlet(name = "UsuaServ", urlPatterns = {"/UsuaServ"})
public class UsuaServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("TipoBton");
            if(CRUD.equals("Registrar"))
            {
                Usuarios obje = new Usuarios();
                String nomb=request.getParameter("nomb");
                        String email=request.getParameter("email");
              String c1=request.getParameter("cont");
              String c2=request.getParameter("cont2");
                
               if(c1.equals(c2))
               {                  
                   obje.setNombUsua(nomb);
                obje.setMailUsua(email); 
                 obje.setContUsua(c1);                                               
                mens = new UsuariosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/registrar_usuario.jsp").forward(request, response);
               }
               else
               {
                mens= new UsuariosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados // Las contraseñas son incorrectas";
                request.getRequestDispatcher("/registrar_usuario.jsp").forward(request, response);
               }
                

            }
            else if(CRUD.equals("Consultar"))
            {
                //Para un objeto
                String codi = request.getParameter("codiradi");
                //Tipos objeTipo = new TiposCtrl().cons(Integer.parseInt(codi));
                //Para una lista [Tablas]
                //List<Tipos> listTipo = new TiposCtrl().cons();
                //request.setAttribute("codi", objeTipo.getCodiTipo());
                 //request.setAttribute("nomb", objeTipo.getNombTipo());
                 request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else if(CRUD.equals("Eliminar"))
            {
                String codi = request.getParameter("codiradi");
                //Tipos objeTipo = new TiposCtrl().cons(Integer.parseInt(codi));
                //mens = new TiposCtrl().dele(objeTipo) ? "Datos Eliminados exitosamente" : "Datos NO Eliminados";
                //request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
         else if(CRUD.equals("Modificar"))
            {
                //Para un objeto
                String codi = request.getParameter("codi");
              //  Tipos objeTipo = new TiposCtrl().cons(Integer.parseInt(codi));
              
                //Para una lista [Tablas]
                //objeTipo.setNombTipo(request.getParameter("nomb"));
                //mens = new TiposCtrl().edit(objeTipo) ? "Datos modificados exitosamente" : "Datos NO guardados";
                 request.getRequestDispatcher("/index.jsp").forward(request, response);
                
            }
               else
        {
               request.setAttribute("mensAler", mens); 
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
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

