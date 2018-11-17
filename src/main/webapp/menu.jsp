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
        <link rel="stylesheet" type="text/css" href="stlye_menu.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine un nombre</title>
    </head>
    <body>

        <div>
            <h1 id="header">BIENVENUE DANS NOTRE JEU !</h1>
        </div>
        <form method="POST">
            <label>Ton prénom : <input name="playerName"></label>
            <input name="action" value="connexion" type="SUBMIT">
        </form>
        <p> ${numberConnected} joueurs connectés</p>
    </body>
</html>

