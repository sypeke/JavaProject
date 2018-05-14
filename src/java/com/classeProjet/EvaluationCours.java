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
public class EvaluationCours {
     private Integer id;
   
    private String idProf;
    
    private String idCours;
    
    private double note;
   
    private String commentaire;
    private double moyenne;
    private String prof;
    private String idLivre;
    private String comm;
    private  int nbre;
    

    public EvaluationCours() {
       
    }
     public EvaluationCours(double note,String commentaire ,String idCours,String idLivre, int nbre) {
     this.note=note;
     this.commentaire = commentaire;
     this.idCours=idCours;
     this.nbre= nbre;
     this.idLivre=idLivre;
     
     }
     

    public EvaluationCours(Integer id, String idProf, String idCours, double note, String commentaire) {
      
        this.idProf = idProf;
        this.idCours = idCours;
        this.note = note;
        this.commentaire = commentaire;
    }
    public EvaluationCours(String prof,String idLivre,String comm,int nbre,double moyenne){
         this.prof =prof;
           this.idLivre= idLivre ;
            this.comm=comm;
           this.nbre=nbre;
        this.moyenne = moyenne;
     }
    
    public EvaluationCours(String idLivre,String idProf,String idCours, double note ,String commentaire){
         this.idLivre =idLivre;
        this.idProf =idProf;
           this.idCours= idCours ;
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
        return idCours;
    }

    public void setIdLivre(String idCours) {
        this.idCours = idCours;
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
    public String getIdCours() {
        return idCours;
    }

    public void setIdCours(String idCours) {
        this.idCours = idCours;
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
