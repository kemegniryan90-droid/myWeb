<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mon panier - myWeb</title>
</head>
<body>
    <h1>Mon panier</h1>

    <a href="catalogue">Retour au catalogue</a>

    <c:choose>
        <c:when test="${empty panier.lignes}">
            <p>Votre panier est vide.</p>
        </c:when>
        <c:otherwise>
            <table border="1" cellpadding="8">
                <tr>
                    <th>Produit</th>
                    <th>Prix unitaire (€)</th>
                    <th>Quantité</th>
                    <th>Sous-total (€)</th>
                    <th></th>
                </tr>
                <c:forEach var="ligne" items="${panier.lignes}">
                    <tr>
                        <td>${ligne.produit.nom}</td>
                        <td>${ligne.produit.prix}</td>
                        <td>${ligne.quantite}</td>
                        <td>${ligne.sousTotal}</td>
                        <td>
                            <a href="panier?action=retirer&id=${ligne.produit.id}">Retirer</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <h3>Total : ${panier.total} €</h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
