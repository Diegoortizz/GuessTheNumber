<%-- 
    Document   : winpage.jsp
    Created on : 14 nov. 2018, 22:18:25
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="stlye_menu.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devine un nombre</title>
    </head>
    <body>


        <h1>Bravo ${playerName}, tu as gagné en ${nbtentatives} tentatives !</h1>

    <c:if test="${NewRecord}">
        <h1 class="classwin"> C'est un nouveau record! Félicitations! </h1>
    </c:if>
    <form method="POST">
        <input type="SUBMIT" name="action" value="deconnexion"/>
        <input type="SUBMIT" name="action" value="rejouer"/>
    </form>

    <p> ${numberConnected} joueurs connectés</p>

</body>
</html>
