<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administration des utilisateurs - myWeb</title>
</head>
<body>
    <h1>Gestion des utilisateurs</h1>
    <a href="catalogue">Retour au catalogue</a>

    <h2>Utilisateurs existants</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>Nom</th>
            <th>Email</th>
            <th>Rôle</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="utilisateur" items="${utilisateurs}">
            <tr>
                <td>${utilisateur.nom}</td>
                <td>${utilisateur.email}</td>
                <td>${utilisateur.role}</td>
                <td>
                    <form action="admin/utilisateurs" method="post">
                        <input type="hidden" name="action" value="supprimer">
                        <input type="hidden" name="id" value="${utilisateur.id}">
                        <button type="submit">Supprimer</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Ajouter un utilisateur</h2>
    <form action="admin/utilisateurs" method="post">
        <input type="hidden" name="action" value="ajouter">
        <label>Nom : <input type="text" name="nom" required></label><br>
        <label>Email : <input type="email" name="email" required></label><br>
        <label>Rôle :
            <select name="role">
                <option value="CLIENT">CLIENT</option>
                <option value="ADMIN">ADMIN</option>
            </select>
        </label><br>
        <button type="submit">Ajouter</button>
    </form>
</body>
</html>
