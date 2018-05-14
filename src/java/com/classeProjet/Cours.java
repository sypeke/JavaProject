/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classeProjet;

/**
 *
 * @author sypeke
 */
public class Cours {
   private String numero;
    private String nom;
    private int duree;
   public  Cours (){
   }
    public  Cours (String numero,String nom,int duree){
    this.numero=numero;
    this.nom =nom;
    this.duree =duree;
    }
    public  Cours(String numero){
    this.numero=numero;
    }
     public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero=numero;
    }
    public String getNom(){
        return nom;
    }
    public  void setNom(){
    this.nom=nom;
   }
    public int getDuree(){
    return duree;
    }
    public void setDuree(int duree){
     this.duree = duree;
    }
}
