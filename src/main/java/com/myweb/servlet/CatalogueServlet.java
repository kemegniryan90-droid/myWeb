package com.myweb.servlet;
import com.myweb.model.GestionnaireProduits;
import com.myweb.model.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> produits = GestionnaireProduits.getInstance().getTousLesProduits();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("/catalogue.jsp").forward(request, response);
    }
}
