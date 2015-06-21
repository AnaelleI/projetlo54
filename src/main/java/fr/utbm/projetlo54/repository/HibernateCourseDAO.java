/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.Course;
import fr.utbm.projetlo54.entity.CourseSession;
import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
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
    public Course findCourseByCode(String ccode)
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
     * Finds all the courses with course sessions starting after the current date.
     * Returns a list of object arrays with each array containing a course and a corresponding course session.
     * 
     * @return the list of the courses and course sessions found
     */
    public List<Object[]> findAllCoursesWithNextCourseSessions()
    {
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate > SYSDATE() order by cour.code");
            listCourses = query.list();
            // Loads the city of each course session location
            for (Object[] o : listCourses)
            {
                if (o[1] != null)
                {
                    CourseSession cs = (CourseSession) o[1];
                    Hibernate.initialize(cs.getLocation().getCity());
                }
            }
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
     * Finds all the courses containing a keyword in their title with course sessions starting after the current date.
     * Returns a list of object arrays with each array containing a course and a corresponding course session.
     * 
     * @param keyword the keyword to find in the course titles
     * @return the list of the courses and course sessions found
     */
    public List<Object[]> findCoursesByKeyWordWithNewtCourseSessions(String keyword)
    {
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate > SYSDATE() and cour.title like :title");
            query.setParameter("title", "%" + keyword + "%");
            listCourses = query.list();
            // Loads the city of each course session location
            for (Object[] o : listCourses)
            {
                if (o[1] != null)
                {
                    CourseSession cs = (CourseSession) o[1];
                    Hibernate.initialize(cs.getLocation().getCity());
                }
            }
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
     * Finds all the courses with course sessions starting before and ending after a specified date, and starting after the current date.
     * Returns a list of object arrays with each array containing a course and a corresponding course session.
     * 
     * @param d the date that must be between the start date and end date of the course session
     * @return the list of the courses and course sessions found
     */
    public List<Object[]> findCoursesByDateWithNextCourseSessions(Date d)
    {
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs where cs.startDate >= SYSDATE() and cs.startDate <= :date and cs.endDate >= :date");
            query.setParameter("date", d);
            listCourses = query.list();
            // Loads the city of each course session location
            for (Object[] o : listCourses)
            {
                if (o[1] != null)
                {
                    CourseSession cs = (CourseSession) o[1];
                    Hibernate.initialize(cs.getLocation().getCity());
                }
            }
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
     * Finds all the courses with course sessions that take place in the specified location and starting after the current date.
     * Returns a list of object arrays with each array containing a course and a corresponding course session.
     * 
     * @param l the location in which the course sessions must take place
     * @return the list of the courses and course sessions found
     */
    public List<Object[]> findCoursesByLocationWithNextCourseSessions(Location l)
    {
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            
            session.beginTransaction();
            Query query = session.createQuery("from Course cour join cour.courseSessions cs join cs.location loc where cs.startDate >= SYSDATE() and loc.Id = ?");
            query.setParameter(0, l.getId());
            listCourses = query.list();
            // Loads the city of each course session location
            for (Object[] o : listCourses)
            {
                if (o[1] != null)
                {
                    CourseSession cs = (CourseSession) o[1];
                    Hibernate.initialize(cs.getLocation().getCity());
                }
            }
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
     * Finds all the courses with course sessions corresponding to the specified criteria and starting after the current date.
     * Returns a list of object arrays with each array containing a course and a corresponding course session.
     * A null parameter is ignored.
     * 
     * @param titleKeyword the keyword to find in the course titles
     * @param d the date that must be between the start date and end date of the course session
     * @param l the location in which the course sessions must take place
     * @return the list of the courses and course sessions found
     */
    public List<Object[]> findCoursesByCriteriaWithNextCourseSessions(String titleKeyword, Date d, Location l)
    {
        Session session;
        List<Object[]> listCourses = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            // Creates and executes the query
            String queryString = "from Course cour join cour.courseSessions cs join cs.location loc where cs.startDate >= SYSDATE()";
            if (titleKeyword != null)
            {
                queryString += " and cour.title like :keyword";
            }
            if (d != null)
            {
                queryString += " and cs.startDate <= :date and cs.endDate >= :date";
            }
            if (l != null)
            {
                queryString += " and loc.Id = :loc";
            }
            queryString += " order by cour.code";
            Query query = session.createQuery(queryString);
            if (titleKeyword != null)
            {
                query.setParameter("keyword", "%" + titleKeyword + "%");
            }
            if (d != null)
            {
                query.setParameter("date", d);
            }
            if (l != null)
            {
                query.setParameter("loc", l.getId());
            }
            listCourses = query.list();
            // Loads the city of each course session location
            for (Object[] o : listCourses)
            {
                if (o[1] != null)
                {
                    CourseSession cs = (CourseSession) o[1];
                    Hibernate.initialize(cs.getLocation().getCity());
                }
            }
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
