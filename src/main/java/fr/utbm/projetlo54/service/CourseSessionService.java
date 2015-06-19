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
     * 
     * @param csid the id of the course session
     * @return a course session
     */
    public CourseSession getCourseSessionByIdWithLocation(int csid){
        HibernateCourseSessionDAO hcsdao = new HibernateCourseSessionDAO();
        CourseSession cs = new CourseSession();
        cs = hcsdao.findCourseSessionByIdWithLocationAndCourse(csid);
        return cs;
    }
}
