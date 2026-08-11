<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administration des produits - myWeb</title>
</head>
<body>
    <h1>Gestion des produits</h1>
    <a href="catalogue">Retour au catalogue</a>

    <h2>Produits existants</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix (€)</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <form action="admin/produits" method="post">
                    <input type="hidden" name="action" value="modifier">
                    <input type="hidden" name="id" value="${produit.id}">
                    <td><input type="text" name="nom" value="${produit.nom}"></td>
                    <td><input type="text" name="description" value="${produit.description}"></td>
                    <td><input type="number" step="0.01" name="prix" value="${produit.prix}"></td>
                    <td><input type="number" name="stock" value="${produit.stock}"></td>
                    <td>
                        <button type="submit">Modifier</button>
                </form>
                <form action="admin/produits" method="post" style="display:inline">
                    <input type="hidden" name="action" value="supprimer">
                    <input type="hidden" name="id" value="${produit.id}">
                    <button type="submit">Supprimer</button>
                </form>
                    </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Ajouter un produit</h2>
    <form action="admin/produits" method="post">
        <input type="hidden" name="action" value="ajouter">
        <label>Nom : <input type="text" name="nom" required></label><br>
        <label>Description : <input type="text" name="description" required></label><br>
        <label>Prix (€) : <input type="number" step="0.01" name="prix" required></label><br>
        <label>Stock : <input type="number" name="stock" required></label><br>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
