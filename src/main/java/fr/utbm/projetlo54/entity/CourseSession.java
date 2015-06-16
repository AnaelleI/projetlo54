/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.entity;

import java.util.Date;

/**
 *
 * @author java
 */
public class CourseSession {
    
    private int Id;
    private Date startDate;
    private Date endDate;
    private String course;
    private int location;
    
    public void CourseSession(){
        
    }
    
    public void CourseSession(int id, Date startDate, Date endDate, String course, int location){
        this.setId(id);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setCourse(course);
        this.setLocation(location);
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
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the courseCode
     */
    public String getCourse() {
        return this.course;
    }

    /**
     * @param course the courseCode to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the location
     */
    public int getLocation() {
        return this.location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(int location) {
        this.location = location;
    }
    
    
    @Override
    public String toString(){
    return "\nStart Date : "+this.startDate+
    "\nEnd Date : "+this.endDate+
    "\nCode : "+this.course+
    "\nLocation : "+this.location;
    }
}
