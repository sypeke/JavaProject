package com.daoProjet;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.daoProjet.Dao;
import com.classeProjet.User;

public class UserDao extends Dao<User> {

    public UserDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(User x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO user (`username` , `nom_prenom`, `password`) "
                + "VALUES ('" + x.getUsername() + "'," + x.getNom_prenom() + "','" + x.getPassword() + "')";

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
    public boolean delete(User x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM user WHERE username='" + x.getUsername() + "'");
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
    public User read(String id) {
        // TODO Auto-generated method stub
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM user WHERE username = '" + id + "'");
            if (r.next()) {
                User c = new User(r.getString("username"),r.getString("nom_prenom"), r.getString("password"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        }
        return null;
    }

    @Override
    public boolean update(User x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE user SET password= '" + x.getPassword() + "'"
                    + " WHERE password= '" + x.getNom_prenom() + "',username = '" + x.getUsername() + "'";
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
    public List<User> findAll() {
        // TODO Auto-generated method stub
        List<User> liste = new LinkedList<User>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM user");
            while (r.next()) {
                User c = new User(r.getString("username"),r.getString("nom_prenom"), r.getString("password"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
}
