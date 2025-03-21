package service;

import dao.*;
import pojo.*;
import java.util.List;

public class CourseService {
    private final CourseDAO courseDAO = new CourseDAO();

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public Course getCourseById(int courseId) {
        return courseDAO.getCourseById(courseId);
    }

    public boolean addCourse(Course course) {
        return courseDAO.insertCourse(course);
    }

    public boolean updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }

    public boolean deleteCourse(int courseId) {
        return courseDAO.deleteCourse(courseId);
    }
}
