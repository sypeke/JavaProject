/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoProjet;


import com.classeProjet.Livre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.daoProjet.Dao;

public class LivreDao  extends Dao<Livre> {

    public LivreDao(Connection cnx) {
        super(cnx);
    }
       //@Override
    public boolean create(Livre x) {
        // TODO Auto-generated method stub "','" 

        String req = "INSERT INTO  livre (`ISBN` ,`Titre`  ,`Edition`,"
                + "`Annee`  ,`MotsCles`,`NomAuteur`  ,`etat`,`Description`  ,`NbPages`"
                + ",`note`  ,`nbEvaluation ) "
                + "VALUES ('" + x.getISBN() + "','" +x.getTitre()+"','"+ x.getEdition() + 
                "','" +x.getAnnee()+"','"+ x.getMotsCles()+ "','" +x.getNomAuteur()+"','"
                + x.getEtat() + "','" +x.getDescription()+"','"+ x.getNbPages()+
                "','" +x.getNote()+"','"+ x.getNbEvaluation() +"')";

        //System.out.println("REQUETE "+req);

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public boolean delete(Livre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM livre WHERE ISBN='" + x.getISBN());
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public Livre read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM livre WHERE ISBN = '" + id + "'");
            if (r.next()) {
                Livre l = new Livre(r.getString("ISBN"),r.getString("Titre"), r.getString("Edition"),
                r.getInt("Annee"),r.getString("MotsCles"), r.getString("NomAuteur"),
                r.getString("etat"),r.getString("Description"),r.getInt("NbPages"),
                r.getInt("note"),r.getInt("nbEvaluations"));
                r.close();
                stm.close();
                return l;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(Livre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE livre SET ISBN= '" + x.getISBN() + "'"
                    + " WHERE Titre =  '"+x.getTitre()+ "', Edition = '" + x.getEdition() + 
                    "', Annee= '" + x.getAnnee() +  "', MotsCles = '" + x.getMotsCles() + 
                    "', NomAuteur = '" + x.getNomAuteur() + "', etat = '" + x.getEtat() + 
                    "', Description = '" + x.getDescription() + "', NbPages = '" + x.getNbPages() + 
                    "', note = '" + x.getNote() + "', nbEvaluations = '" + x.getNbEvaluation() + "'";
            //System.out.println("REQUETE "+req);
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public  List<Livre> findAll() {
        // TODO Auto-generated method stub
        List<Livre> liste = new LinkedList<Livre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT*FROM livre ");
            while (r.next()) {
               Livre l = new Livre(r.getString("ISBN"),r.getString("Titre"), r.getString("Edition"),
                r.getInt("Annee"),r.getString("MotsCles"), r.getString("NomAuteur"),
                r.getString("etat"),r.getString("Description"),r.getInt("NbPages"),
                r.getInt("note"),r.getInt("nbEvaluations"));
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
     public  List<Livre> findByIsbn() {
        // TODO Auto-generated method stub
        List<Livre> liste = new LinkedList<Livre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM livre");
            while (r.next()) {
               Livre l = new Livre(r.getString("ISBN"),r.getString("Titre"), r.getString("Edition"),
                r.getInt("Annee"),r.getString("MotsCles"), r.getString("NomAuteur"),
                r.getString("etat"),r.getString("Description"),r.getInt("NbPages"),
                r.getInt("note"),r.getInt("nbEvaluations"));
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
     public  List<Livre> findTitreAut() {
      
        List<Livre> liste = new LinkedList<Livre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT Titre, NomAuteur FROM livre ");
            while (r.next()) {
               Livre l = new Livre(r.getString("Titre"), r.getString("NomAuteur"));
               
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
}
