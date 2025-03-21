package service;

import dao.*;
import pojo.*;
import java.util.List;

public class StudentService {
    private final StudentDAO studentDAO = new StudentDAO();
    private final StudentCourseDAO scDAO = new StudentCourseDAO();

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public boolean updateStudentPhone(int sid, String newPhone) {
        return studentDAO.getStudentById(sid)
                .map(student -> {
                    student.setPhoneNumber(newPhone);
                    return studentDAO.updateStudent(student);
                })
                .orElse(false);
    }

    public List<StudentCourse> getStudentCourses(int sid) {
        return scDAO.getCoursesByStudentId(sid);
    }

    public boolean selectCourse(int sid, int courseId) {
        if (getSelectedCount(sid) >= 5) {
            throw new IllegalStateException("选课数量已达上限（5门）");
        }
        StudentCourse sc = new StudentCourse(0, sid, courseId);
        return scDAO.insertStudentCourse(sc);
    }

    private int getSelectedCount(int sid) {
        return scDAO.getCoursesByStudentId(sid).size();
    }
}