/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

/**
 *
 * @author Anaëlle Isola
 */
public class Client {
    
    private int Id;
    private String lastName;
    private String firstName;
    private String address;
    private String phone;
    private String email;
    private String sessionID;
    
    public void Client(){
        
   }
    
    public void Client(int id, String lastname, String firstname, String address, String phone, String email, String sessionId){
        this.setId(id);
        this.setLastName(lastname);
        this.setFirstName(firstname);
        this.setAddress(address);
        this.setPhone(phone);
        this.setEmail(email);
        this.setSessionID(sessionId);
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
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the address
     */
    public String getAddress() 
    {
        return this.address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) 
    {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() 
    {
        return this.phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the sessionID
     */
    public String getSessionID() {
        return this.sessionID;
    }

    /**
     * @param sessionID the sessionID to set
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    
    @Override
    public String toString(){
        return "\nLast Name : "+this.lastName+
    "\nFirst Name : "+this.firstName+
    "\nAddress : "+this.address+
    "\nPhone :"+this.phone+
    "\nMail : "+this.email;
    }
}
