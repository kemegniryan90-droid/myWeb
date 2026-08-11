package com.myweb.servlet;
import com.myweb.model.Commande;
import com.myweb.model.GestionnaireCommandes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/commandes")
public class CommandeAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("commandes", GestionnaireCommandes.listerCommandes());
        request.getRequestDispatcher("/admin-commandes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String nouveauStatut = request.getParameter("statut");

        Commande commande = GestionnaireCommandes.trouverParId(id);
        if (commande != null) {
            commande.setStatut(Commande.Statut.valueOf(nouveauStatut));
        }

        response.sendRedirect(request.getContextPath() + "/admin/commandes");
    }
}
