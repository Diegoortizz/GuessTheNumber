<%-- 
    Document   : winpage.jsp
    Created on : 14 nov. 2018, 22:18:25
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine un nombre</title>
    </head>
    <body>
        <hr>
        <h2> joueurs connectés</h2>
        <hr>

        <h3>Bravo, tu as gagné !</h3>
        <form method="POST">
            <input type="SUBMIT" name="action" value="deconnexion"/>
            <input type="SUBMIT" name="action" value="rejouer"/>
        </form>
    </body>
</html>
