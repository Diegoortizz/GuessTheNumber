<%-- 
    Document   : vue
    Created on : 14 nov. 2018, 21:11:36
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="document.guessForm.guess.focus()">
        <hr>
        <h2>${nbPlayers} joueurs connectés</h2>
        <hr>

        <h3>Hello ${playerName}, Devine mon nombre</h3>
        <h4> réponse -> ${answer}</h4>
        <h4> ${message}</h4>
        <h3> Tentative n° ${nbtentatives} </h3>
        <h2>Je pense à un nombre compris entre 0 et 100</h2>
        <form name="guessForm" method="POST" accept-charset="UTF-8" >
            <label>Ta proposition : <input type="number" min="0" max="100" required name="guess"></label> 
            <input type="SUBMIT" name="action" value="deviner"><br/>
        </form>
        <form method="POST">
            <input type="SUBMIT" name="action" value="deconnexion">
        </form>

        <hr>



    </body>
</html>