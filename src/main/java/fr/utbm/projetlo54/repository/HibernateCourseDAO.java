/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.Course;
import fr.utbm.projetlo54.util.HibernateUtil;
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

    // TODO: List<Object[]> findAllCoursesWithNextCourseSessions()
        // use an HQL join between Course and CourseSession
        // return only the course sessions starting after actual date
    
    // TODO: List<Object[]> findCoursesByKeywordWithNextCourseSessions(String keyword)
        // use an HQL join between Course and CourseSession
        // return only the courses containing the keyword in their title
        // return only the course sessions starting after actual date
        
    // TODO: List<Object[]> findCoursesByDateWithNextCourseSessions(Date d)
        // use an HQL join between Course and CourseSession
        // return only the course sessions with start date <= d <= end date
        // return only the course sessions starting after actual date (d will be >= actual date)
    
    // TODO: List<Object[]> findCoursesByLocationWithNextCourseSessions(Location l)
        // use an HQL join between Course and CourseSession
        // return only the course sessions with location == l
        // return only the course sessions starting after actual date
    
    // TODO: List<Object[]> findCoursesByCritariaWithNextCourseSessions(String titleKeyword, Date d, Location l)
        // combine the 3 previous methods
        // 2 options: 
            // calling the previous methods and merging the results to keep only values appearing in all of them
            // using only one HQL request with all the criteria in it (faster and better)
        // a null parameter means criteria not used (ex : l == null means any location)
            
}
