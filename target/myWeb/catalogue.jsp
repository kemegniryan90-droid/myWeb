<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catalogue - myWeb</title>
</head>
<body>
    <h1>Catalogue des équipements</h1>

    <a href="panier">Voir mon panier</a>

    <table border="1" cellpadding="8">
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix (€)</th>
            <th>Stock</th>
            <th></th>
        </tr>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td>${produit.nom}</td>
                <td>${produit.description}</td>
                <td>${produit.prix}</td>
                <td>${produit.stock}</td>
                <td>
                    <a href="panier?action=ajouter&id=${produit.id}&nom=${produit.nom}&prix=${produit.prix}">
                        Ajouter au panier
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
