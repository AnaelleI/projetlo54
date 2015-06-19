/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projetlo54.service;

import fr.utbm.projetlo54.entity.Course;
import fr.utbm.projetlo54.repository.HibernateCourseDAO;
import fr.utbm.projetlo54.entity.Location;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Justine Ventalon
 */
public class CourseService 
{
    /**
     * Returns a list of all the courses.
     * 
     * @return the list of courses
     */
    public List<Course> getAllCourses()
    {
        HibernateCourseDAO hcdao = new HibernateCourseDAO();
        List<Course> courses = hcdao.findAllCourses();        
        return courses;
    }
    
    public List<Object[]> getAllCoursesWithNextCourseSessions()
    {
        HibernateCourseDAO hcdao = new HibernateCourseDAO();
        List<Object[]> courses = hcdao.findAllCoursesWithNextCourseSessions(); 
        return courses;
    }
   
    public List<Object[]> getCoursesByCriteriaWithNexCourseSessions(String titleKeyword, Location l, Date d)
    {
        HibernateCourseDAO hcdao = new HibernateCourseDAO();
        List<Object[]> courses;
        courses = hcdao.findCoursesByCritariaWithNextCourseSessions(titleKeyword, d, l);
        return courses;
    }
}
