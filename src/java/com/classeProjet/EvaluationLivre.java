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
public class EvaluationLivre {
    private Integer id;
   
    private String idProf;
    
    private String idLivre;
    
    private double note;
   
    private String commentaire;
    private double moyenne;
    private String prof;
    private String liv;
    private String comm;
    private  int nbre;
    

    public EvaluationLivre() {
       
    }
     public EvaluationLivre(double note,String commentaire ,String idLivre, int nbre) {
     this.note=note;
     this.commentaire = commentaire;
     this.idLivre=idLivre;
     this.nbre= nbre;
     
     }
     

    public EvaluationLivre(Integer id, String idProf, String idLivre, double note, String commentaire) {
      
        this.idProf = idProf;
        this.idLivre = idLivre;
        this.note = note;
        this.commentaire = commentaire;
    }
    public EvaluationLivre(String prof,String liv,String comm,int nbre,double moyenne){
         this.prof =prof;
           this.liv= liv ;
            this.comm=comm;
           this.nbre=nbre;
        this.moyenne = moyenne;
     }
    
    public EvaluationLivre(String idProf,String idLivre, double note ,String commentaire){
         this.idProf =idProf;
           this.idLivre= idLivre ;
           this.note=note;
            this.commentaire=commentaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
     public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
    public String getLiv() {
        return liv;
    }

    public void setLiv(String liv) {
        this.liv = liv;
    }
    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }
public int getNbre() {
        return nbre;
    }

    public void setProf(int nbre) {
        this.nbre = nbre;
    }
    

   
}
