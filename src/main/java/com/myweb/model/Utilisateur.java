package com.myweb.model;

public class Utilisateur {

    public enum Role {
        CLIENT,
        ADMIN
    }

    private int id;
    private String nom;
    private String email;
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String email, Role role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
