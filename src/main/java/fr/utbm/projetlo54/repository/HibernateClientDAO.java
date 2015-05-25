/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.repository;

import fr.utbm.projetlo54.entity.Client;
import fr.utbm.projetlo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Justine Ventalon
 */
public class HibernateClientDAO 
{    
    /**
     * Adds a client to the database and returns its id.
     * 
     * @param c the new client to add to the database
     * @return the generated id for the new client or -1 if an error occurred
     */
    public int addClient(Client c)
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        int ccode = -1;
        try
        {
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
            ccode = c.getId();
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
        return ccode;
    }
    
    /**
     * Returns a list of all the clients in the database.
     * 
     * @return the list of clients
     */
    public List<Client> findAllClients()
    {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        return clients;
    }
    
    /**
     * Returns the client with the id cid.
     * 
     * @param cid the id of the client to find in the database
     * @return the client if found, null otherwise
     */
    public Client findClientById(int cid)
    {
        Client c = null;
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            session.beginTransaction();
            c = (Client) session.get(Client.class, cid);
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
     * Updates a client.
     * 
     * @param c the client to update in the database
     */
    public void updateClient(Client c)
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
     * Removes a client.
     * 
     * @param c the client to remove from the database
     */
    public void deleteClient(Client c)
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
    
    // TODO: Client findClientByIdWithCourseSession(int cid)
}