/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoProjet;

import com.classeProjet.EvaluationLivre;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sypeke
 */
public class EvaluationLivreDao extends Dao<EvaluationLivre> {
     
    public EvaluationLivreDao(Connection cnx) {
        super(cnx);
    }
       //@Override
    public boolean create(EvaluationLivre x) {
        // TODO Auto-generated method stub "','" 

        String req = "INSERT INTO evaluation (`idProf`,`idLivre`,"
                + "`note`,`commentaire` ) "
                + "VALUES ('" +x.getIdProf()+"','"+ x.getIdLivre() + 
                "'," +x.getNote()+",'"+ x.getCommentaire() +"')";

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
    public boolean delete(EvaluationLivre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM evaluation WHERE id='" + x.getId());
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
    public EvaluationLivre read(String idLivre) { //devrait poseproblemet
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM evaluation WHERE idLivre = '" + idLivre + "'");
            if (r.next()) {
               EvaluationLivre l = new EvaluationLivre (r.getInt("id"),r.getString("idProf"), r.getString("idLivre"),
                r.getDouble("note"),r.getString("commentaire"));
                r.close();
                stm.close();
                return l;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(EvaluationLivre x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE evaluation SET id= '" + x.getId() + "'"
                    + " WHERE idProf =  '"+x.getIdProf()+ "', idLivre = '" + x.getIdLivre() + 
                    "', note = '" + x.getNote() +  "', commantaire = '" + x.getCommentaire() + "'";
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
    public  List<EvaluationLivre> findAll() {
        // TODO Auto-generated method stub
        List<EvaluationLivre> liste = new LinkedList<EvaluationLivre>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM evaluation ");
            while (r.next()) {
               EvaluationLivre l = new EvaluationLivre (r.getInt("id"),r.getString("idProf"), r.getString("IdLivre"),
                r.getDouble("note"),r.getString("commentaire"));
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
   
     public List<EvaluationLivre> noteEvaluation(String idLivre) { // à changer pour faire les 
     
         List<EvaluationLivre> liste = new LinkedList<EvaluationLivre>();
         //double dd =0;
        try {
            Statement stm = cnx.createStatement();
           ResultSet r = stm.executeQuery("SELECT AVG( DISTINCT note),  COUNT( idLivre),commentaire,idLivre FROM evaluation group by IdLivre HAVING  Count(idLivre) >  0");
      
            while (r.next()) {
              EvaluationLivre l = new EvaluationLivre (r.getDouble("AVG( DISTINCT note)"),r.getString("commentaire")
              ,r.getString("idLivre"),r.getInt("COUNT( idLivre)"));

             liste.add(l);
            }
            
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
     public void evaluer (EvaluationLivre x) {
       
  
            try {
                
           
            PreparedStatement entrez = cnx.prepareStatement(" INSERT INTO evaluation(`idProf`,`idLivre`,"
                + "`note`,`commentaire` "
                    + "VALUES (?,?,?,?)");
                     entrez.setString(1,x.getIdProf() );
                     entrez.setString(2,x.getIdLivre());
                     entrez.setDouble(3,x.getNote());
                     entrez.setString(4,x.getCommentaire());
                   entrez.executeUpdate();
                  

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
}
