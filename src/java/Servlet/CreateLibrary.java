/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Common.Utils;
import Controllers.LibraryController;
import Models.Lenguage;
import Models.Library;
import Models.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Cruz
 */
public class CreateLibrary extends HttpServlet {

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
        try {
           if(Utils.isValidSession(request))
           {
                Library Lib = new Library();
                Lib.setName(request.getParameter("name"));

                Lenguage Len = new Lenguage();
                Len.setId(Integer.parseInt(request.getParameter("idLen")));

                Lib.setLenguage(Len);

                Result Res = LibraryController.Create(Lib);

                if(Res.getResult() == Result.Results.Error)
                {
                    HttpSession objSession = request.getSession();
                    objSession.setAttribute("error", Res.getMessage());
                    
                    response.sendRedirect("./Vistas/create-library.jsp");
                }
                else
                {
                    response.sendRedirect("./Vistas/librerias.jsp");
                }
           }
           else
           {
               response.sendRedirect("index.jsp");
           }   
        }
        catch(Exception e){
            HttpSession objSession = request.getSession();
            objSession.setAttribute("error", "Ocurrio un error, por favor, comuniquese con el administrador.");
            
            response.sendRedirect("./Vistas/librerias.jsp");
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
