/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Justine Ventalon
 */
public class HibernateLocationDAO 
{
    /**
     * Adds a location to the database and returns its id.
     * 
     * @param l the new location to add to the database
     * @return the generated id for the new course session or -1 if an error occurred
     */
    public int addLocation(Location l)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        int lid = -1;
        try
        {
            session.beginTransaction();
            Location newL = (Location) session.merge(l);
            session.getTransaction().commit();
            lid = newL.getId();
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
        return lid;
    }
    
    /**
     * Returns a list of all the locations in the database.
     * 
     * @return the list of locations
     */
    public List<Location> findAllLocations()
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Location");
        List<Location> locations = query.list();
        return locations;
    }
    
    /**
     * Returns the location with the id lid.
     * 
     * @param lid the id of the location to find in the database
     * @return the location if found, null otherwise
     */
    public Location findLocationById(int lid)
    {
        Location l = new Location();
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            l = (Location) session.get(Location.class, lid);
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
        return l;
    }
    
    /**
     * Updates a location.
     * 
     * @param l the location to update in the database
     */
    public void updateLocation(Location l)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.update(l);
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
     * Removes a location.
     * 
     * @param l the location to remove from the database
     */
    public void deleteLocation(Location l)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            session.delete(l);
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
}
