package com.mycompany.guessthenumber;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DevineLeNombre extends HttpServlet {

    /*
    
    TODO : 
    - Utiliser des listners pour le nombre de personne connectés
    
    - Comment on pourrait résoudre le problème du raffraichissement de la page 
    qui met à jour le compteurs de nb de tentatives et aussi qu'il mémorise la 
    dernière action qui à été effectué.
    
    */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action != null) {
            Object nbjoueurs = request.getServletContext().getAttribute("numberConnected");
            if (nbjoueurs == null) {
                request.getServletContext().setAttribute("numberConnected", 0);
                System.out.println((int) request.getServletContext().getAttribute("numberConnected"));
            }

            switch (action) {
                case "connexion":
                    String pseudo = request.getParameter("playerName");
                    if (null != pseudo && !pseudo.equals("")) {
                        HttpSession session = request.getSession();
                        session.setAttribute("playerName", pseudo);
                        session.setAttribute("nbtentatives", 1);
                        request.getSession(true).setAttribute("answer", new Random().nextInt(101));
                        int nc = 1 + (int) request.getServletContext().getAttribute("numberConnected");
                        request.getServletContext().setAttribute("numberConnected", nc);
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
                            Object highscore = request.getServletContext().getAttribute("highscore");
                            message += "Bravo tu as gagné ! ";
                            request.setAttribute("message", message);

                            if (highscore == null || ((int) highscore < nbtentatives)) {
                                request.setAttribute("NewRecord", true);
                                request.getServletContext().setAttribute("highscore", nbtentatives);
                                request.getServletContext().setAttribute("recordman", (String) request.getSession().getAttribute("playerName"));

                            } else {
                                request.setAttribute("newRecord", false);
                            }

                            request.getRequestDispatcher("winpage.jsp").forward(request, response);
                        }
                    }
//                    request.getSession(true).setAttribute("guess", ""); // comment faire en sorte de remetre guess à 0 ? remettre déconnexion à "" ?
//                    request.setAttribute("guess", "");
//                    request.getSession().removeAttribute("guess");
//                    String guess2 = request.getParameter("guess");
//                    System.out.println("after " + guess2);

                    break;
                case "deconnexion":

                    int nc = -1 + (int) getServletContext().getAttribute("numberConnected");
                    getServletContext().setAttribute("numberConnected", nc);

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
