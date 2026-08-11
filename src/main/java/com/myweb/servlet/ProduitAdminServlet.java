package com.myweb.servlet;
import com.myweb.model.GestionnaireProduits;
import com.myweb.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/admin/produits")
public class ProduitAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("produits", GestionnaireProduits.getInstance().getTousLesProduits());
        request.getRequestDispatcher("/admin-produits.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            GestionnaireProduits.getInstance().ajouter(nom, description, prix, stock);

        } else if ("modifier".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            GestionnaireProduits.getInstance().modifier(id, nom, description, prix, stock);

        } else if ("supprimer".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            GestionnaireProduits.getInstance().supprimer(id);
        }

        response.sendRedirect(request.getContextPath() + "/admin/produits");
    }
}
