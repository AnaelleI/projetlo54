/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.CourseSession;
import fr.utbm.projetlo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Justine Ventalon
 */
public class HibernateCourseSessionDAO 
{
    /**
     * Adds a course session to the database and returns its id.
     * 
     * @param cs the new course session to add to the database
     * @return the generated id for the new course session or -1 if an error occurred
     */
    public int addCourseSession(CourseSession cs)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        int csid = -1;
        try
        {
            if(cs==null)
            {
            session.flush(); 
            session.close();
            }
            else {
            session.beginTransaction();
            session.merge(cs);
            session.getTransaction().commit();
            csid = cs.getId();
            }
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
        return csid;
    }
    
    /**
     * Returns a list of all the course sessions in the database.
     * 
     * @return the list of course sessions
     */
    public List<CourseSession> findAllCourseSessions()
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from CourseSession");
        List<CourseSession> courseSessions = query.list();
        return courseSessions;
    }
    
    /**
     * Returns the course session with the id csid.
     * 
     * @param csid the id of the course session to find in the database
     * @return the course session if found, null otherwise
     */
    public CourseSession findCourseSessionById(int csid)
    {
        CourseSession cs = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            cs = (CourseSession) session.get(CourseSession.class, csid);
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
        return cs;
    }
    
    /**
     * Updates a course session.
     * 
     * @param cs the course session to update in the database
     */
    public void updateCourseSession(CourseSession cs)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.update(cs);
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
     * Removes a course session.
     * 
     * @param cs the course session to remove from the database
     */
    public void deleteCourseSession(CourseSession cs)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.delete(cs);
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
     * find the courseSession with the specified course and location in parameters
     * @param course the course's id requested
     * @param location the location's id requested
     * @return a list of CourseSession
     */
    public List<CourseSession> findCourseSessionByCourseAndLocation(String course, int location){
        Session session;
        List<CourseSession> courseSession = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from CourseSession where COURSE_CODE = ? and LOCATION_ID = ?");
            query.setParameter(0, course);
            query.setParameter(1, location);
            courseSession = query.list();
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
           e.printStackTrace();
            if(session.getTransaction() != null)
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
        finally{
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
        
        return courseSession;
    }
    
    /**
     * get the course session loaded with the location and the course
     * @param csid the id of course session
     * @return the course session
     */
    public CourseSession findCourseSessionByIdWithLocationAndCourse(int csid){
        CourseSession cs = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            cs = (CourseSession) session.get(CourseSession.class, csid);
            if(cs != null){
                Hibernate.initialize(cs.getLocation());
                Hibernate.initialize(cs.getCourse());
            }
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
            if (session.getTransaction() != null){
                try{
                    session.getTransaction().rollback();
                }
                catch (HibernateException e2){
                    e2.printStackTrace();
                }
            }
        }    
        finally{
            if (session != null){
                try{
                    session.close();
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        return cs;
    }
}
