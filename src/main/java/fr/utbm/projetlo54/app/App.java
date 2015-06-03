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
import fr.utbm.projetlo54.entity.Course;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        /*HibernateCourseDAO hiber = new HibernateCourseDAO();
        SimpleDateFormat dateformat3 = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
	try {
	            date = dateformat3.parse("19/06/2015");
        } 
        catch(ParseException e){
            System.out.println(e);
        }
        String keyword = "Processus";
        Location l = new Location();
        l.setCity("Belfort");
        l.setId(1);        
        List<Object[]> courses = hiber.findCoursesByCritariaWithNextCourseSessions(keyword, date, l);
        for(Object[] ob : courses){
            Course course = (Course) ob[0];
            CourseSession courseSession = (CourseSession) ob[1];
            System.out.println(course.getTitle() + " : " + courseSession.getCourse() + " : " + courseSession.getStartDate());
        }*/
        
    }
}
