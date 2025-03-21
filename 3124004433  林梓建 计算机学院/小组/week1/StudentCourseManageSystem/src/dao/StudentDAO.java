package dao;

import pojo.Student;
import utils.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
    private static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());

    /**
     * 通过学生ID查询学生信息
     * @param sid 学生ID
     * @return Optional<Student>
     */
    public Optional<Student> getStudentById(int sid) {
        String sql = "SELECT * FROM students WHERE sid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sid);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToStudent(rs));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving student by ID", e);
        }
        return Optional.empty();
    }

    /**
     * 添加学生信息
     * @param student 学生对象
     * @return 是否添加成功
     */
    public boolean insertStudent(Student student) {
        String sql = "INSERT INTO students (select_number, select_description, phone_name) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getSelectNumber());
            stmt.setString(2, student.getSelectDescription());
            stmt.setString(3, student.getPhoneNumber());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting student", e);
        }
        return false;
    }

    /**
     * 删除学生
     * @param sid 学生ID
     * @return 是否删除成功
     */
    public boolean deleteStudent(int sid) {
        String sql = "DELETE FROM students WHERE sid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sid);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting student", e);
        }
        return false;
    }

    /**
     * 更新学生信息
     * @param student 学生对象
     * @return 是否更新成功
     */
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET select_number = ?, select_description = ?, phone_name = ? WHERE sid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getSelectNumber());
            stmt.setString(2, student.getSelectDescription());
            stmt.setString(3, student.getPhoneNumber());
            stmt.setInt(4, student.getSid());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating student", e);
        }
        return false;
    }

    /**
     * 获取所有学生信息
     * @return 学生列表
     */
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                studentList.add(mapResultSetToStudent(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all students", e);
        }
        return studentList;
    }

    /**
     * 结果集转换为 Student 对象
     */
    private Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("sid"),
                rs.getInt("select_number"),
                rs.getString("select_description"),
                rs.getString("phone_name")
        );
    }
}
