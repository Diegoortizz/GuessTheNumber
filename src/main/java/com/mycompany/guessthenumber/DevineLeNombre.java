/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthenumber;

import java.io.IOException;
import java.util.Random;
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

//    SessionCounter sc = new SessionCounter();
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

        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "connexion":
                    String pseudo = request.getParameter("playerName");
                    if (null != pseudo && !pseudo.equals("")) {
                        HttpSession session = request.getSession();
                        session.setAttribute("playerName", pseudo);
                        session.setAttribute("nbtentatives", 1);
                        request.getSession(true).setAttribute("answer", new Random().nextInt(101));
                        request.getRequestDispatcher("jeu.jsp").forward(request, response);
                        System.out.println("connexion");
                    }
                    break;
                case "deviner":
                    String guess = request.getParameter("guess");
                    int nbuser = Integer.parseInt(guess);

                    int answer = (int) request.getSession().getAttribute("answer");
                    int nbtentatives = (int) request.getSession().getAttribute("nbtentatives");

                    String message = "";

                    System.out.println("before " + guess);

                    if (!guess.equals("")) {
                        if (answer > nbuser) {
                            message += "plus haut";
                            request.setAttribute("message", message);
                            request.getSession(true).setAttribute("nbtentatives", nbtentatives + 1);
                            request.getRequestDispatcher("jeu.jsp").forward(request, response);
                        } else if (answer < nbuser) {
                            message += "plus bas";
                            request.setAttribute("message", message);
                            request.getSession(true).setAttribute("nbtentatives", nbtentatives + 1);
                            request.getRequestDispatcher("jeu.jsp").forward(request, response);

                        } else {
                            message += "Bravo tu as gagné ! ";
                            request.setAttribute("message", message);
                            request.getRequestDispatcher("winpage.jsp").forward(request, response);
                        }
                    }
//                    request.getSession(true).setAttribute("guess", ""); // comment faire en sorte de remmetre guess à 0 ?
//                    request.setAttribute("guess", "");
//                    request.getSession().removeAttribute("guess");
//                    String guess2 = request.getParameter("guess");
//                    System.out.println("after " + guess2);

                    break;
                case "deconnexion":
                    request.getSession(true).invalidate();
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                    System.out.println("déconnexion");
                    break;
                case "rejouer":
                    request.getSession().setAttribute("nbtentatives", 1);
                    request.getSession().setAttribute("message", "");
                    request.getSession(true).setAttribute("answer", new Random().nextInt(101));
                    request.getRequestDispatcher("jeu.jsp").forward(request, response);
                    break;
            }
        } else {
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        }
        System.out.println("---------------------------------------------------------------");

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
