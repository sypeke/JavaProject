/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classeProjet;

/**
 *
 * @author moumene
 */
public class User {
    private String username, nom_prenon,password;

    public User(String username, String nom_prenon, String password) {
        this.username = username;
        this.nom_prenon = nom_prenon;      
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getNom_prenom(){
    return nom_prenon;
    }
    public void setNom_prenom(String nom_prenon){
    this.nom_prenon = nom_prenon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
