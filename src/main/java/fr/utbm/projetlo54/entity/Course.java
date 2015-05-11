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
public class Course {
    
    private int code;
    private String title;
    
    public void Course(){
        
    }
    
    public void Course(int code, String title){
        this.setCode(code);
        this.setTitle(title);
    }

    /**
     * @return the code
     */
    public int getCode() {
        return this.code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
