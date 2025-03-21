package dao;

import pojo.StudentCourse;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentCourseDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentCourseDAO.class.getName());

    // 添加学生选课记录
    public boolean insertStudentCourse(StudentCourse studentCourse) {
        String sql = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentCourse.getStudentId());
            stmt.setInt(2, studentCourse.getCourseId());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error inserting student course record", e);
        }
        return false;
    }

    // 根据学生ID和课程ID删除选课记录
    public boolean deleteStudentCourse(int studentId, int courseId) {
        String sql = "DELETE FROM student_courses WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, courseId);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error deleting student course record", e);
        }
        return false;
    }

    // 根据学生ID查询该学生的选课记录
    public List<StudentCourse> getCoursesByStudentId(int studentId) {
        String sql = "SELECT id, student_id, course_id FROM student_courses WHERE student_id = ?";
        List<StudentCourse> studentCourses = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                studentCourses.add(mapResultSetToStudentCourse(rs));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving courses by student ID", e);
        }
        return studentCourses;
    }

    // 根据课程ID查询该课程的所有学生选课记录
    public List<StudentCourse> getStudentsByCourseId(int courseId) {
        String sql = "SELECT id, student_id, course_id FROM student_courses WHERE course_id = ?";
        List<StudentCourse> studentCourses = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                studentCourses.add(mapResultSetToStudentCourse(rs));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving students by course ID", e);
        }
        return studentCourses;
    }

    // 查询所有学生选课记录
    public List<StudentCourse> getAllStudentCourses() {
        String sql = "SELECT id, student_id, course_id FROM student_courses";
        List<StudentCourse> studentCourses = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                studentCourses.add(mapResultSetToStudentCourse(rs));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all student courses", e);
        }
        return studentCourses;
    }

    // 统一封装 ResultSet 数据
    private StudentCourse mapResultSetToStudentCourse(ResultSet rs) throws Exception {
        return new StudentCourse(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("course_id")
        );
    }
}
