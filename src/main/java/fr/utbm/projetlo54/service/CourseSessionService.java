/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.service;

import fr.utbm.projetlo54.entity.CourseSession;
import fr.utbm.projetlo54.repository.HibernateCourseSessionDAO;

/**
 *
 * @author Justine Ventalon
 */
public class CourseSessionService 
{
    /**
     * Returns the CourseSession corresponding with the requested id.
     * Loads its associated location and course too.
     * 
     * @param csid the id of the course session
     * @return a course session
     */
    public CourseSession getCourseSessionById(int csid){
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        CourseSession cs;
        cs = hcsdao.findCourseSessionByIdWithLocationAndCourse(csid);
        return cs;
    }
}
