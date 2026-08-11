<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.myweb.model.Commande" %>
<%@ page import="com.myweb.model.LignePanier" %>
<%
    Commande commande = (Commande) request.getAttribute("commande");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation de commande</title>
</head>
<body>

<% if (commande == null) { %>
    <h1>Commande introuvable</h1>
    <a href="catalogue">Retour au catalogue</a>
<% } else { %>

    <h1>Commande confirmée</h1>
    <p><strong>Numéro de commande :</strong> <%= commande.getId() %></p>
    <p><strong>Date :</strong> <%= commande.getDateCommande() %></p>
    <p><strong>Statut :</strong> <%= commande.getStatut() %></p>

    <table border="1" cellpadding="5">
        <tr>
            <th>Produit</th>
            <th>Quantité</th>
            <th>Sous-total</th>
        </tr>
        <% for (LignePanier ligne : commande.getLignes()) { %>
        <tr>
            <td><%= ligne.getProduit().getNom() %></td>
            <td><%= ligne.getQuantite() %></td>
            <td><%= ligne.getSousTotal() %> €</td>
        </tr>
        <% } %>
    </table>

    <p><strong>Total : <%= commande.getTotal() %> €</strong></p>

    <a href="catalogue">Retour au catalogue</a>

<% } %>

</body>
</html>

