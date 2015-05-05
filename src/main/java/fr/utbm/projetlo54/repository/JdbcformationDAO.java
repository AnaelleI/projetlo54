/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Anaëlle Isola
 */
public class JdbcformationDAO {
    
    public void connect(){
        Connection con  = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FORMATION", "java", "java");
            System.out.println("CONNEXION OK");
        }
        catch(Throwable e){
            System.out.println("CONNEXION KO");
            e.printStackTrace();
        }
        finally{
            try{
                if(con != null)
                    con.close();
            }
            catch(SQLException ex){
            }
        }
    }
}
