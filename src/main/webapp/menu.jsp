<%-- 
    Document   : affichage
    Created on : 14 nov. 2018, 21:06:18
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine un nombre</title>
    </head>
    <body>
        <h1>Bienvenue dans notre jeu !</h1>
        <hr>
        <h2>${cpt_joueurs_co} joueurs connectés</h2>
        <hr>

        <form method="POST">
            <label>Ton prénom : <input name="playerName"></label>
            <input name="action" value="connexion" type="SUBMIT">
        </form>
    </body>
</html>

