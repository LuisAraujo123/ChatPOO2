/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.servlets;

import com.sv.udb.controladores.ConvCtrl;
import com.sv.udb.controladores.UsuariosCtrl;
import com.sv.udb.modelos.Conversaciones;
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
@WebServlet(name = "ConvServ", urlPatterns = {"/ConvServ"})
public class ConvServ extends HttpServlet {

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
            String codiConv = request.getParameter("ConvBton");
            System.out.println(codiConv);
            if (codiConv == null)
            {
                Integer codiUsua = Integer.parseInt(request.getParameter("InicBton"));
                HttpSession session = request.getSession(true);
                Usuarios usuaActu = (Usuarios)session.getAttribute("usuaActu");
                Conversaciones objeConv = new Conversaciones();
                objeConv.setUsuaUno(usuaActu);
                objeConv.setUsuaDos(new UsuariosCtrl().cons(codiUsua));
                objeConv.setTempConv(new java.util.Date());
                if (new ConvCtrl().guar(objeConv))
                {
                    request.setAttribute("mensAler", " - Nueva conversación agregada");
                    request.getRequestDispatcher("/menu.jsp").forward(request, response);
                    
                }
            }
            else
            {
                Conversaciones objeConv = new ConvCtrl().cons(Integer.parseInt(codiConv));
                //request.setAttribute("mensAler", objeConv.getCodiConv());
                HttpSession session = request.getSession(true);
                session.setAttribute("convActu", objeConv);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/menu.jsp");
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
