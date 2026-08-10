package com.myweb.servlet;

import com.myweb.model.Panier;
import com.myweb.model.Produit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Panier panier = (Panier) session.getAttribute("panier");
        if (panier == null) {
            panier = new Panier();
            session.setAttribute("panier", panier);
        }

        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));

            Produit produit = new Produit(id, nom, "", prix, 0);
            panier.ajouterProduit(produit, 1);
        } else if ("retirer".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            panier.retirerProduit(id);
        }

        request.setAttribute("panier", panier);
        request.getRequestDispatcher("/panier.jsp").forward(request, response);
    }
}
