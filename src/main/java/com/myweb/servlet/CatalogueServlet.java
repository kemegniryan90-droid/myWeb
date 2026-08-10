package com.myweb.servlet;

import com.myweb.model.Produit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produit> produits = new ArrayList<>();
        produits.add(new Produit(1, "Perceuse électrique", "Perceuse 500W avec mallette", 49.99, 10));
        produits.add(new Produit(2, "Casque de chantier", "Casque de protection homologué", 12.50, 25));
        produits.add(new Produit(3, "Échelle télescopique", "Échelle en aluminium 3.8m", 89.90, 5));

        request.setAttribute("produits", produits);
        request.getRequestDispatcher("/catalogue.jsp").forward(request, response);
    }
}