/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.app;

import fr.utbm.projetlo54.entity.Client;
import fr.utbm.projetlo54.entity.CourseSession;
import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.repository.JdbcformationDAO;
import fr.utbm.projetlo54.entity.Producer;
import fr.utbm.projetlo54.repository.HibernateClientDAO;
import fr.utbm.projetlo54.repository.HibernateCourseDAO;
import fr.utbm.projetlo54.repository.HibernateCourseSessionDAO;
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
        /*LocationService ls = new LocationService();
        List<Location> list = ls.getAllLocations();
        for(Location l : list)
        {
            System.out.println(l.getCity());
        }*/
        /*HibernateClientDAO hibernate = new HibernateClientDAO();
        List<Client> listcli = hibernate.findClientdWithIdCourseSession(2);
        for(Client c : listcli)
        {
            System.out.println(c.getId());
        }*/
       /* HibernateCourseSessionDAO hibernate = new HibernateCourseSessionDAO();
        List<CourseSession> listcli = hibernate.findCourseSessionByCourseAndLocation("GL51", 1);
        for(CourseSession c : listcli)
        {
            System.out.println(c.getId());
        }*/
        
    }
}
