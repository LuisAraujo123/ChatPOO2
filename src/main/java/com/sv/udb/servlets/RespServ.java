/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.controladores.RespCtrl;
import com.sv.udb.controladores.UsuariosCtrl;
import com.sv.udb.modelos.Conversaciones;
import com.sv.udb.modelos.Respuestas;
import com.sv.udb.modelos.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bernardo
 */
@WebServlet(name = "RespServ", urlPatterns = {"/RespServ"})
public class RespServ extends HttpServlet {

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
            String CRUD = request.getParameter("RespBton");
            if(CRUD.equals("Enviar"))
            {
                Respuestas obje = new Respuestas();
                HttpSession session = request.getSession(true);
                Usuarios objeUsua = (Usuarios) session.getAttribute("usuaActu");
                Conversaciones objeConv = (Conversaciones) session.getAttribute("convActu");
                obje.setCodiConv(objeConv);
                obje.setCodiUsuaResp(objeUsua);
                obje.setMensResp(request.getParameter("resp"));
                obje.setFechHoraResp(new java.util.Date());
                if(new RespCtrl().guar(obje))
                {
                    System.out.println("mensaje enviado!");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
                else
                {
                    System.err.println("Eror al enviar :c");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
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
