/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.service;

import fr.utbm.projetlo54.entity.Course;
import fr.utbm.projetlo54.repository.HibernateCourseDAO;
import java.util.List;

/**
 *
 * @author Justine Ventalon
 */
public class CourseService 
{
    public List<Course> getAllCourses()
    {
        HibernateCourseDAO hcdao = new HibernateCourseDAO();
        List<Course> courses = hcdao.findAllCourses();        
        return courses;
    }
    
    // TODO: List<Object[]> getAllCoursesWithNextCourseSessions()
    // TODO: List<Object[]> getCoursesByCriteriaWithNextCourseSessions(String titleKeyword, Location l, Date d)
}
