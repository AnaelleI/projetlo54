/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.Course;
import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author
 */
public class HibernateCourseDAO 
{
    /**
     * Adds a course to the database and returns its code.
     * 
     * @param c the new course to add to the database
     */
    public void addCourse(Course c)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (session.getTransaction() != null)
            {
                try
                {
                    session.getTransaction().rollback();
                }
                catch (HibernateException e2)
                {
                    e2.printStackTrace();
                }
            }
        }       
        finally
        {
            if (session != null)
            {
                try
                {
                    session.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
    
    /**
     * Returns a list of all the courses in the database.
     * 
     * @return the list of courses
     */
    public List<Course> findAllCourses()
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Course");
        List<Course> courses = query.list();
        return courses;
    }
    
    /**
     * Returns the course with the code ccode.
     * 
     * @param ccode the code of the course to find in the database
     * @return the course if found, null otherwise
     */
    public Course findCourseByCode(int ccode)
    {
        Course c = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            c = (Course) session.get(Course.class, ccode);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (session.getTransaction() != null)
            {
                try
                {
                    session.getTransaction().rollback();
                }
                catch (HibernateException e2)
                {
                    e2.printStackTrace();
                }
            }
        }    
        finally
        {
            if (session != null)
            {
                try
                {
                    session.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        return c;
    }
    
    /**
     * Updates a course.
     * 
     * @param c the course to update in the database
     */
    public void updateCourse(Course c)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (session.getTransaction() != null)
            {
                try
                {
                    session.getTransaction().rollback();
                }
                catch (HibernateException e2)
                {
                    e2.printStackTrace();
                }
            }
        }       
        finally
        {
            if (session != null)
            {
                try
                {
                    session.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
    
    /**
     * Removes a course.
     * 
     * @param c the course to remove from the database
     */
    public void deleteCourse(Course c)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.delete(c);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (session.getTransaction() != null)
            {
                try
                {
                    session.getTransaction().rollback();
                }
                catch (HibernateException e2)
                {
                    e2.printStackTrace();
                }
            }
        }       
        finally
        {
            if (session != null)
            {
                try
                {
                    session.close();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }

    
    /**
     * trouve tous les sessions des cours qui commencent après aujourd'hui
     * @return les courses sessions
     */
    public List<Object[]> findAllCoursesWithNextCourseSessions(){
        Session session;
        List<Object[]> listCourse = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate > SYSDATE()");
            listCourse = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch(HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }
        finally{
            if(session != null){
                try{
                    session.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return listCourse;
    }
            
    
    /**
     * retourne les cours avec ses sessions associés qui contiennent le mot clé et qui commence après la date du jour
     * @param keyword le mot clé que doit contenir le titre des cours retournés
     * @return les cours
     */
    public List<Object[]> findCoursesByKeyWordWithNewtCourseSessions(String keyword){
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate > SYSDATE() and cour.title like :titre");
            query.setParameter("titre", "%" + keyword + "%");
            listCourses = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch(HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }
        finally{
            if(session != null){
                try{
                    session.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return listCourses;
    }
        
    // TODO: List<Object[]> findCoursesByDateWithNextCourseSessions(Date d)
        // use an HQL join between Course and CourseSession
        // return only the course sessions with start date <= d <= end date
        // return only the course sessions starting after actual date (d will be >= actual date)
    public List<Object[]> findCoursesByDateWithNextCourseSessions(Date d){
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate >= SYSDATE() and cs.startDate <= :date and cs.endDate >= :date");
            query.setParameter("date", d);
            listCourses = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch(HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }
        finally{
            if(session != null){
                try{
                    session.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return listCourses;
    }
    
    /**
     * retourne les cours avec ses sessions associées commencant après la date du jour et sur le site demandé
     * @param l la location demandée
     * @return les cours avec les sessions associées
     */
    public List<Object[]> findCoursesByLocationWithNextCourseSessions(Location l){
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs join cs.location loc where cs.startDate >= SYSDATE() and loc.Id = ?");
            query.setParameter(0, l.getId());
            listCourses = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch(HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }
        finally{
            if(session != null){
                try{
                    session.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return listCourses;
    }
    
    /**
     * etourne les cours avec ses sessions associées commencant après la date du jour, sur le site demandé et entre la date demandée
     * @param titleKeyword le mot clé
     * @param d la date 
     * @param l la location du cours
     * @return une liste d'un tableau d'objet
     */
    public List<Object[]> findCoursesByCritariaWithNextCourseSessions(String titleKeyword, Date d, Location l){
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs join cs.location loc where cs.startDate >= SYSDATE() and cs.startDate <= ? and cs.endDate >= ? and loc.Id = ? and cour.title like ?");
            query.setParameter(0, d);
            query.setParameter(1, d);
            query.setParameter(2, l.getId());
            query.setParameter(3, titleKeyword);
            listCourses = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch(HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }
        finally{
            if(session != null){
                try{
                    session.close();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return listCourses;
    }       
}
