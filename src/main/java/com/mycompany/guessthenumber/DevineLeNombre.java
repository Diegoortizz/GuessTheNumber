/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthenumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Utilisateur
 */
public class DevineLeNombre extends HttpServlet {

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

        ServletContext app = this.getServletContext();
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if (action != null) {
            System.out.println("--------------" + action + "--------------");
            switch (action) {
                case "connexion":
                    String pseudo = request.getParameter("playerName");
                    if (null != pseudo && !pseudo.equals(" ")) {
                        session.setAttribute("savedusername", pseudo);
                        session.setAttribute("nbtentatives", 1);
                        System.out.println(action + " " + pseudo);
                        request.getSession(true).setAttribute("answer", new Random().nextInt(101));
                        request.getRequestDispatcher("jeu.jsp").forward(request, response);
                    }
                    break;
                case "deviner":
                    String guess = request.getParameter("guess");
                    int toguess = (int) session.getAttribute("answer");
                    int nbuser = Integer.parseInt(guess);
                    int nbtentatives = (int) session.getAttribute("nbtentatives");
                    String message = "";
                    if (toguess > nbuser) {
                        message += "plus haut";
                        session.setAttribute("message", message);
                        session.setAttribute("nbtentatives", nbtentatives + 1);
                        request.getRequestDispatcher("jeu.jsp").forward(request, response);
                    } else if (toguess < nbuser) {
                        message += "plus bas";
                        session.setAttribute("message", message);
                        session.setAttribute("nbtentatives", nbtentatives + 1);
                        request.getRequestDispatcher("jeu.jsp").forward(request, response);
                    } else {
                        message += "Bravo tu as gagné ! ";
                        session.setAttribute("message", message);
                        request.getRequestDispatcher("winpage.jsp").forward(request, response);
                    }
                    break;
                case "deconnexion":
                    session.invalidate();
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                    break;
                case "rejouer":
                    // que faire ?
                    break;
                default:
                    break;
            }
        } else {
            request.getRequestDispatcher("menu.jsp").forward(request, response);

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
