package com.myweb.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GestionnaireUtilisateurs {

    private static final List<Utilisateur> utilisateurs = new ArrayList<>();
    private static final AtomicInteger prochainId = new AtomicInteger(1);

    public static Utilisateur ajouter(String nom, String email, Utilisateur.Role role) {
        Utilisateur utilisateur = new Utilisateur(prochainId.getAndIncrement(), nom, email, role);
        utilisateurs.add(utilisateur);
        return utilisateur;
    }

    public static List<Utilisateur> listerUtilisateurs() {
        return Collections.unmodifiableList(utilisateurs);
    }

    public static boolean supprimer(int id) {
        return utilisateurs.removeIf(u -> u.getId() == id);
    }
}
