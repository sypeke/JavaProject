/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoProjet;
import com.classeProjet.Cours;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.classeProjet.Cours;

/**
 *
 * @author sypeke
 */
public class CoursDao extends Dao<Cours> {
   public CoursDao(Connection cnx) {
        super(cnx);
    }
       //@Override
    public boolean create(Cours x) {
        // TODO Auto-generated method stub "','" 

        String req = "INSERT INTO cours (`numero`,`nom`,`duree`) "
                + "VALUES ('" + x.getNumero() + "','" +x.getNom()+"','"+x.getDuree()+"')";

      

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
    
    public boolean delete( Cours x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM cours WHERE numero='" + x.getNumero());
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
    public Cours read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM cours WHERE numero = '" + id + "'");
            if (r.next()) {
                Cours l = new Cours(r.getString("numero"),r.getString("nom"), r.getInt("duree"));
              
                r.close();
                stm.close();
                return l;
            }
        } catch (SQLException exp) {
        }
        return null;
    }
     @Override
    public boolean update(Cours x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE livre SET numero= '" + x.getNumero() + "'"
                    + " WHERE nom ='"+x.getNom()+ "',duree ='" + x.getDuree() + 
                    "'";
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
    public  List<Cours> findAll() {
        // TODO Auto-generated method stub
        List<Cours> liste = new LinkedList<Cours>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT* FROM cours");
            while (r.next()) {
               Cours l = new Cours(r.getString("numero"),r.getString("nom"),r.getInt("duree"));
               
                liste.add(l);
            }
            r.close();
            stm.close();
            return liste;
        } catch (SQLException exp) {
        }
        return null;
    }
     public  List<Cours> findByNum() {
        // TODO Auto-generated method stub
        List<Cours> liste = new LinkedList<Cours>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT numero FROM cours");
            while (r.next()) {
               Cours l = new Cours(r.getString("numero"));
               
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
