/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

import java.util.Set;

/**
 *
 * @author Anaëlle Isola
 */
public class Course {
    
    private String code;
    private String title;
    private Set<CourseSession> courseSessions;
    
    public void Course(){
        
    }
    
    public void Course(String code, String title){
        this.setCode(code);
        this.setTitle(title);
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
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

    /**
     * @return the list of course sessions
     */
    public Set<CourseSession> getCourseSessions() 
    {
        return courseSessions;
    }
    
    /**
     * @param courseSessions the list of course sessions to set
     */
    public void setCourseSessions(Set<CourseSession> courseSessions) 
    {
        this.courseSessions = courseSessions;
    }
    
    
    @Override
    public String toString(){
        return "\nCode : "+this.code+
                "\nLocation : "+this.title;
    }
    
}
