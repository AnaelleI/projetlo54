/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import fr.utbm.projetlo54.repository.JdbcformationDAO;

/**
 *
 * @author java
 */
public class App {
    
    public static void main(String[] arg){
        JdbcformationDAO jdbc = new JdbcformationDAO();
        jdbc.connect();
    }
}
