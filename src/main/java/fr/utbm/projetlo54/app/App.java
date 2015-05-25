/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.repository.JdbcformationDAO;
import fr.utbm.projetlo54.entity.Producer;
import fr.utbm.projetlo54.service.LocationService;
import java.util.List;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author java
 */
public class App {
    
    public static void main(String[] arg)throws JMSException, NamingException{
        /*JdbcformationDAO jdbc = new JdbcformationDAO();
        jdbc.connect();
        //new Producer(topic);
        Producer prod = new Producer("TPLO54");
        prod.sendToTopic("hello");*/
        LocationService ls = new LocationService();
        List<Location> list = ls.getAllLocations();
        for(Location l : list)
        {
            System.out.println(l.getCity());
        }
    }
}
