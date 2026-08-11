package com.myweb.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Commande {

    public enum Statut {
        EN_ATTENTE,
        VALIDEE,
        ANNULEE
    }

    private String id;
    private List<LignePanier> lignes;
    private LocalDateTime dateCommande;
    private Statut statut;
    private double total;

    public Commande(List<LignePanier> lignes) {
        this.id = UUID.randomUUID().toString();
        this.lignes = lignes;
        this.dateCommande = LocalDateTime.now();
        this.statut = Statut.EN_ATTENTE;
        this.total = calculerTotal();
    }

    private double calculerTotal() {
        double somme = 0;
        for (LignePanier ligne : lignes) {
            somme += ligne.getProduit().getPrix() * ligne.getQuantite();
        }
        return somme;
    }

    public String getId() { return id; }
    public List<LignePanier> getLignes() { return lignes; }
    public LocalDateTime getDateCommande() { return dateCommande; }
    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }
    public double getTotal() { return total; }
}
