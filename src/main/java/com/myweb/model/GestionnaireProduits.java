package com.myweb.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GestionnaireProduits {

    private static final GestionnaireProduits INSTANCE = new GestionnaireProduits();

    private final List<Produit> produits = new CopyOnWriteArrayList<>();
    private final AtomicInteger prochainId = new AtomicInteger(1);

    private GestionnaireProduits() {
        ajouter("Perceuse électrique", "Perceuse 500W avec mallette", 49.99, 10);
        ajouter("Casque de chantier", "Casque de protection homologué", 12.50, 25);
        ajouter("Échelle télescopique", "Échelle en aluminium 3.8m", 89.90, 5);
    }

    public static GestionnaireProduits getInstance() {
        return INSTANCE;
    }

    public List<Produit> getTousLesProduits() {
        return produits;
    }

    public Produit getParId(int id) {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Produit ajouter(String nom, String description, double prix, int stock) {
        Produit produit = new Produit(prochainId.getAndIncrement(), nom, description, prix, stock);
        produits.add(produit);
        return produit;
    }

    public boolean modifier(int id, String nom, String description, double prix, int stock) {
        Produit produit = getParId(id);
        if (produit == null) {
            return false;
        }
        produit.setNom(nom);
        produit.setDescription(description);
        produit.setPrix(prix);
        produit.setStock(stock);
        return true;
    }

    public boolean supprimer(int id) {
        return produits.removeIf(p -> p.getId() == id);
    }
}
