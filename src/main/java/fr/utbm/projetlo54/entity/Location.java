/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

/**
 *
 * @author java
 */
public class Location {
 
    private int Id;
    private String city;
    
    public void Location(){
        
    }
    
    public void Location(int id, String city){
        this.setId(id);
        this.setCity(city);
    }

    /**
     * @return the Id
     */
    public int getId() {
        return this.Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString(){
        return "\nCity : "+this.city+" ID : "+this.Id;
    }
}
