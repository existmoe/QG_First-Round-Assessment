package service;

import dao.*;
import pojo.*;
import java.util.List;

public class AdminService {
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public boolean updateStudentPhone(int sid, String newPhone) {
        return studentService.updateStudentPhone(sid, newPhone);
    }

    public boolean updateCourseCredit(int cid, double newCredit) {
        return courseService.getCourseById(cid) != null &&
                courseService.updateCourse(new Course(cid, null, newCredit, null, null));
    }

    public List<StudentCourse> getCourseStudents(int cid) {
        return new StudentCourseDAO().getStudentsByCourseId(cid);
    }
}
