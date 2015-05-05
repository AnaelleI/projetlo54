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
    private long address;
    private int phone;
    private String email;
    private String sessionID;
    
    public void Client(){
        
   }
    
    public void Client(int id, String lastname, String firstname, long address, int phone, String email, String sessionId){
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
        return Id;
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
        return lastName;
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
        return firstName;
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
    public long getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(long address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
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
        return sessionID;
    }

    /**
     * @param sessionID the sessionID to set
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    
}
