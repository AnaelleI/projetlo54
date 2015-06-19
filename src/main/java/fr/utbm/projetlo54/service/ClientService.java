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
     * return a client cli
     * @param cid the id of the client
     * @return the client requested
     */
    public Client getClientByIdWithCourseSession(int cid){
        HibernateClientDAO hcdao = new HibernateClientDAO();
        Client cli = null;
        cli = hcdao.findClientByIdWithCourseSession(cid);
        return cli;
    }
    /**
     * register a client c
     * @param c the client we want to register
     */
    public void registerClient(Client c){
        HibernateClientDAO hcdao = new HibernateClientDAO();
        hcdao.addClient(c);
    }
}
