/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.service;

import fr.utbm.projetlo54.entity.Location;
import fr.utbm.projetlo54.repository.HibernateLocationDAO;
import java.util.List;

/**
 *
 * @author Justine Ventalon
 */
public class LocationService 
{
    public List<Location> getAllLocations()
    {
        HibernateLocationDAO hldao = new HibernateLocationDAO();
        List<Location> locations = hldao.findAllLocations();        
        return locations;
    }

    public List<Location> getLocations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
