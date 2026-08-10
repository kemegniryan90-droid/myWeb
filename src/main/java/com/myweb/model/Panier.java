package com.myweb.model;

import java.util.ArrayList;
import java.util.List;

public class Panier {

    private List<LignePanier> lignes;

    public Panier() {
        this.lignes = new ArrayList<>();
    }

    public List<LignePanier> getLignes() {
        return lignes;
    }

    public void ajouterProduit(Produit produit, int quantite) {
        for (LignePanier ligne : lignes) {
            if (ligne.getProduit().getId() == produit.getId()) {
                ligne.setQuantite(ligne.getQuantite() + quantite);
                return;
            }
        }
        lignes.add(new LignePanier(produit, quantite));
    }

    public void retirerProduit(int produitId) {
        lignes.removeIf(ligne -> ligne.getProduit().getId() == produitId);
    }

    public double getTotal() {
        double total = 0;
        for (LignePanier ligne : lignes) {
            total += ligne.getSousTotal();
        }
        return total;
    }

    public int getNombreArticles() {
        return lignes.size();
    }
}
