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
        <link rel="stylesheet" type="text/css" href="stlye_jeu.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine un nombre</title>
    </head>

    <body onload="document.guessForm.guess.focus()">


        <h1>Salut ${playerName}, tu dois deviner mon nombre !</h1>
        <br>
        <h1>Je pense à un nombre compris entre 0 et 100 ...</h1>

        <div id="div1">
            <form name="guessForm" method="POST" accept-charset="UTF-8" >
                <label>Votre proposition <input type="number" min="0" max="100" required name="guess"></label> 
                <input type="SUBMIT" name="action" value="deviner"><br/>
            </form>
        </div>
        <div id="div2">
            <form method="POST">
                <input type="SUBMIT" name="action" value="deconnexion">
            </form>
        </div>

        
        <div id="p1">
            <p> Tentative n° ${nbtentatives} <br> ${message} </p>
        </div>


        <div id="p2">
            <p> réponse -> ${answer}</p>
        </div>


        <div id="p3">
            <p> ${numberConnected} joueurs connectés</p>
        </div>



    </body>
</html>