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
import fr.utbm.projetlo54.repository.HibernateLocationDAO;
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
    
    public static void main(String[] arg)throws JMSException, NamingException, ParseException{
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
        String keyword = "Processus";*/
        /*List<Object[]> courses = hiber.findCoursesByCritariaWithNextCourseSessions(keyword, date, l);
        for(Object[] ob : courses){
            Course course = (Course) ob[0];
            CourseSession courseSession = (CourseSession) ob[1];
            System.out.println(course.getTitle() + " : " + courseSession.getCourse() + " : " + courseSession.getStartDate());
        }*/
        
        
        //Test add new Location : OK
        Location l = new Location();
        l.setCity("Paris");
        l.setId(20);
        //new HibernateLocationDAO().addLocation(l);
        
        //Test add new Course : OK
        Course cours = new Course();
        cours.setCode("re51");
        cours.setTitle("reseau");
        //new HibernateCourseDAO().addCourse(cours);
                
        //Test add new Client : OK
        Client cl = new Client();
        cl.setFirstName("quentin");
        cl.setLastName("barthelemy");
        cl.setSessionID(1);
        cl.setEmail("quentin.barthelemy@utbm.fr");
        cl.setPhone("0606060606");
        cl.setAddress("3 rue gaston defferre 90000 Belfort");
        cl.setId(10);
        //new HibernateClientDAO().addClient(cl);
        
        //Test add new courseSession
        CourseSession cs = new CourseSession();
        cs.setCourse(cours.getCode());
        cs.setLocation(l.getId());
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2001");
        cs.setStartDate(d);
        d= new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2005");
        cs.setEndDate(d);
        cs.setId(102);
        new HibernateCourseSessionDAO().addCourseSession(cs);
    }
}
