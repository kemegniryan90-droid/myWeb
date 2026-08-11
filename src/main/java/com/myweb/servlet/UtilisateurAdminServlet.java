package com.myweb.servlet;
import com.myweb.model.GestionnaireUtilisateurs;
import com.myweb.model.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/utilisateurs")
public class UtilisateurAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("utilisateurs", GestionnaireUtilisateurs.listerUtilisateurs());
        request.getRequestDispatcher("/admin-utilisateurs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            Utilisateur.Role role = Utilisateur.Role.valueOf(request.getParameter("role"));
            GestionnaireUtilisateurs.ajouter(nom, email, role);

        } else if ("supprimer".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestionnaireUtilisateurs.supprimer(id);
        }

        response.sendRedirect(request.getContextPath() + "/admin/utilisateurs");
    }
}
