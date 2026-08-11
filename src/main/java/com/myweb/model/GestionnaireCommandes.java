package com.myweb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionnaireCommandes {

    private static final List<Commande> commandes = new ArrayList<>();

    public static void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    public static List<Commande> listerCommandes() {
        return Collections.unmodifiableList(commandes);
    }

    public static Commande trouverParId(String id) {
        for (Commande commande : commandes) {
            if (commande.getId().equals(id)) {
                return commande;
            }
        }
        return null;
    }
}
