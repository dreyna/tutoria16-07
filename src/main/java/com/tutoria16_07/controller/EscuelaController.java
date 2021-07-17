/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutoria16_07.controller;

import com.google.gson.Gson;
import com.tutoria16_07.daoImpl.EscuelaDaoImpl;
import com.tutoria16_07.entity.Escuela;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dreyna
 */
public class EscuelaController extends HttpServlet {
private final EscuelaDaoImpl esc = new EscuelaDaoImpl();
private final Gson gson = new Gson();
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
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         int id = 0;
        int op = Integer.parseInt(request.getParameter("opc"));
        switch(op){
            case 1:  out.println(gson.toJson(esc.readAll2()));
                            break;
            case 2:  out.println(gson.toJson(esc.create(new Escuela(request.getParameter("escuela"),Integer.parseInt(request.getParameter("idfacu"))))));
                            break;
            case 3:   Escuela s = new Escuela();
                            s.setIdescuela(Integer.parseInt(request.getParameter("idesc")));
                            s.setNombre(request.getParameter("escuela"));
                            s.setIdfacultad(Integer.parseInt(request.getParameter("idfacu")));
                            out.println(gson.toJson(esc.update(s )));
                            break;
            case 4: out.println(gson.toJson(esc.delete(Integer.parseInt(request.getParameter("idesc")))));
                        break;
            case 5: out.println(gson.toJson(esc.read(Integer.parseInt(request.getParameter("idesc")))));
                        break;
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
