/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoProjet;

import com.classeProjet.EvaluationCours;
import com.classeProjet.EvaluationLivre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import static java.lang.System.out;

/**
 *
 * @author sypeke
 */
public class EvaluationCoursDao extends Dao<EvaluationCours> {
    
    public EvaluationCoursDao(Connection cnx) {
        super(cnx);
    }
       //@Override
    public boolean create(EvaluationCours x) {
        // TODO Auto-generated method stub "','" 

        String req = "INSERT INTO evaluationcours (`idLivre`,`idProf`,`idCours`,"
                + "`note`,`commentaire`) "
                + "VALUES ('" + x.getIdLivre()+"','"+ x.getIdProf()+ 
                "'," +x.getIdCours()+",'"+x.getNote()+",'"+ x.getCommentaire() +"')";

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
    public boolean delete(EvaluationCours x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM evaluationcours WHERE id='" + x.getId());
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
    public EvaluationCours read(String idCours) { //devrait poseproblemet
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM evaluationcours WHERE idCours = '" + idCours + "'");
            if (r.next()) {
               EvaluationCours l = new EvaluationCours (r.getString("idLivre"), r.getString("idProf"),r.getString("idCours"),
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
    public boolean update(EvaluationCours x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE evaluationcours SET id= '" + x.getId() + "'"
                    + " WHERE idProf =  '"+x.getIdProf()+ "', idLivre = '" + x.getIdLivre() + 
                    "', note = '" + x.getNote() +"', idCours = '" + x.getIdCours() + "', commentaire = '" + x.getCommentaire() + "'";
            
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
    public  List<EvaluationCours> findAll() {
        // TODO Auto-generated method stub
        List<EvaluationCours> liste = new LinkedList<EvaluationCours>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM evaluationcours ");
            while (r.next()) {
               EvaluationCours l = new EvaluationCours (r.getString("idLivre"), r.getString("IdProf"),
                r.getString("idCours"),r.getDouble("note"),r.getString("commentaire"));
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
   
     public List<EvaluationCours> noteEvaluation(String idCours) { // à changer pour faire les 
       
         List<EvaluationCours> liste = new LinkedList<EvaluationCours>();
        
        try {
            Statement stm = cnx.createStatement();
           ResultSet r = stm.executeQuery("SELECT AVG(DISTINCT note), COUNT(idCours), commentaire , idCours , idLivre FROM evaluationcours group by IdCours HAVING Count(idCours) > 0");
           

            while (r.next()) {
              EvaluationCours l = new EvaluationCours (r.getDouble("AVG( DISTINCT note)"),r.getString("commentaire")
              ,r.getString("idCours"),r.getString("idLivre"),r.getInt("COUNT(idCours)"));
               liste.add(l);
            }
            
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
     public void evaluer (EvaluationCours x) {
       
  
            try {
                
            //Statement stm = cnx.createStatement();
            PreparedStatement entrez = cnx.prepareStatement(" INSERT INTO evaluationcours(`idLivre`,`idProf`,`idCours`,"
                + "`note`,`commentaire` "
                    + "VALUES (?,?,?,?)");
                     entrez.setString(2,x.getIdLivre());
                      entrez.setString(1,x.getIdProf() );
                     entrez.setString(1,x.getIdCours() );
                    entrez.setDouble(3,x.getNote());
                     entrez.setString(4,x.getCommentaire());
                   entrez.executeUpdate();
                  

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
     
}

    

