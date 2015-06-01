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
    private Course course;
    private Location location;
    
    public void CourseSession(){
        
    }
    
    public void CourseSession(int id, Date startDate, Date endDate, Course course, Location location){
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
    public Course getCourse() {
        return this.course;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
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
