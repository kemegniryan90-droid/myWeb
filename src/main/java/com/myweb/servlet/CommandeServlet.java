package com.myweb.servlet;

import com.myweb.model.Commande;
import com.myweb.model.GestionnaireCommandes;
import com.myweb.model.Panier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");

        if (panier == null || panier.getLignes().isEmpty()) {
            response.sendRedirect("panier.jsp");
            return;
        }

        Commande commande = new Commande(panier.getLignes());
        GestionnaireCommandes.ajouterCommande(commande);

        // On vide le panier après validation
        session.setAttribute("panier", new Panier());

        request.setAttribute("commande", commande);
        request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Commande commande = GestionnaireCommandes.trouverParId(id);
            request.setAttribute("commande", commande);
            request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
        } else {
            request.setAttribute("commandes", GestionnaireCommandes.listerCommandes());
            request.getRequestDispatcher("/historique.jsp").forward(request, response);
        }
    }
}
