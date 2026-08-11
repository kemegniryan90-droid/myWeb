<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administration des commandes - myWeb</title>
</head>
<body>
    <h1>Gestion des commandes</h1>
    <a href="catalogue">Retour au catalogue</a>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Articles</th>
            <th>Total (€)</th>
            <th>Statut</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="commande" items="${commandes}">
            <tr>
                <td>${commande.id}</td>
                <td>${commande.dateCommande}</td>
                <td>
                    <c:forEach var="ligne" items="${commande.lignes}">
                        ${ligne.produit.nom} x${ligne.quantite}<br>
                    </c:forEach>
                </td>
                <td>${commande.total}</td>
                <td>${commande.statut}</td>
                <td>
                    <form action="admin/commandes" method="post">
                        <input type="hidden" name="id" value="${commande.id}">
                        <select name="statut">
                            <option value="EN_ATTENTE">EN_ATTENTE</option>
                            <option value="VALIDEE">VALIDEE</option>
                            <option value="ANNULEE">ANNULEE</option>
                        </select>
                        <button type="submit">Changer le statut</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
