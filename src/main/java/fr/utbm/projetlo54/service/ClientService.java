/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.service;
import fr.utbm.projetlo54.entity.Client;
import fr.utbm.projetlo54.repository.HibernateClientDAO;
/**
 *
 * @author Justine Ventalon
 */
public class ClientService 
{
      
    /**
     * Returns the client with the requested id.
     * 
     * @param cid the id of the client
     * @return the client requested
     */
    public Client getClientByIdWithCourseSession(int cid){
        HibernateClientDAO hcdao = new HibernateClientDAO();
        Client cli;
        cli = hcdao.findClientByIdWithCourseSession(cid);
        return cli;
    }
    /**
     * Registers the client.
     * 
     * @param c the client to register
     * @return the id of the new client or -1 if registration failed
     */
    public int registerClient(Client c){
        HibernateClientDAO hcdao = new HibernateClientDAO();
        int cid = hcdao.addClient(c);
        return cid;
    }
}
