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
public class Livre {
    
  private  String ISBN,Titre, Edition, MotsCles,Description,
          etat,NomAuteur;
     private      int Annee, NbPages ,note,nbEvaluation;
       public Livre() {
    }
       public Livre(String NomAuteur , String Titre){
       this.NomAuteur=NomAuteur;
       this.Titre=Titre;
       
       }
       
 public Livre ( String ISBN, String Titre,String Edition, int Annee, String MotsCles,
            String NomAuteur, String etat ,String Description,  
            int NbPages, int note,int nbEvaluation ) {
                
                this.ISBN = ISBN;
                this.Titre = Titre;
                this.Edition = Edition;
                this.MotsCles = MotsCles;
                this.NomAuteur= NomAuteur;
                this.etat= etat;
                this.Description = Description;
                this.Annee = Annee;
                this.NbPages = NbPages;
                this.note = note;
                this.nbEvaluation =nbEvaluation;
                
            }
             public String getISBN() {
        return ISBN;
    }

    public void setPassword(String ISBN) {
        this.ISBN= ISBN;
    }
     public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }
     public String getEdition() {
        return Edition;
    }

    public void setEdition(String Edition) {
        this.Edition = Edition;
    }
     public String getMotsCles() {
        return MotsCles;
    }

    public void setMotsCles(String MotsCles) {
        this.MotsCles = MotsCles;
    }
    public String getNomAuteur() {
        return NomAuteur;
    }

    public void setNomAuteur(String NomAuteur) {
        this.NomAuteur = NomAuteur;
    }
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
     public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.NomAuteur = Description;
    }
     public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int  Annee) {
        this.Annee = Annee;
    }
     public int getNbPages() {
        return NbPages;
    }

    public void setNbPages(int NbPages) {
        this.NbPages = NbPages;
    }
     public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
     public int getNbEvaluation() {
        return nbEvaluation;
    }

    public void setNbEvaluation(int nbEvaluation) {
        this.nbEvaluation = nbEvaluation;
    }
    
}
