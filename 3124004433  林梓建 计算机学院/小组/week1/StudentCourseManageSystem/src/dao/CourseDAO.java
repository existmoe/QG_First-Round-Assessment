package dao;

import pojo.Course;
import utils.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAO {
    private static final Logger LOGGER = Logger.getLogger(CourseDAO.class.getName());

    /*
     * 查询所有课程信息
     * 返回courseList集合；若没查询到，返回null
     */
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        //创建一个空的courseList集合
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();//获取数据库连接
             PreparedStatement stmt = conn.prepareStatement(sql);//预编译SQL语句
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {//遍历结果集
                courses.add(mapResultSetToCourse(rs));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching courses", e);
            throw new RuntimeException(e);
        }
        return courses;
    }

    /*
    * 根据ID获取课程信息
    * 返回course对象；若没查询到，返回null
    */
    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM courses WHERE course_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCourse(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error fetching course by ID", e);
            throw new RuntimeException(e);
        }
        return null;
    }

    /*
    * 添加课程
    * 返回true表示添加成功，false表示添加失败
     */
    public boolean insertCourse(Course course) {
        String sql = "INSERT INTO courses (course_name, credit, time, start_time) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setCourseParameters(stmt, course);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error inserting course", e);
            throw new RuntimeException(e);
        }
    }

    /*
    * 更新课程信息
    * 返回true表示更新成功，false表示更新失败
    */
    public boolean updateCourse(Course course) {
        String sql = "UPDATE courses SET course_name = ?, credit = ?, time = ?, start_time = ? WHERE course_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            setCourseParameters(stmt, course);
            stmt.setInt(5, course.getCid());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating course", e);
            throw new RuntimeException(e);
        }
    }

    /*
    * 删除课程
    * 返回true表示删除成功，false表示删除失败
    */
    public boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting course", e);
            throw new RuntimeException(e);
        }
    }
    /*
    * 通用的ResultSet解析方法
    */
    private Course mapResultSetToCourse(ResultSet rs) throws SQLException {
        return new Course(
                rs.getInt("course_id"),
                rs.getString("course_name"),
                rs.getDouble("credit"),
                rs.getString("time"),
                rs.getTimestamp("start_time")
        );
    }
    /*
     * 设置 PreparedStatement 的参数
     * 用于添加和更新课程信息
     */
    private void setCourseParameters(PreparedStatement stmt, Course course) throws SQLException {
        stmt.setString(1, course.getCourseName());
        stmt.setDouble(2, course.getCredit());
        stmt.setString(3, course.getTime());
        stmt.setTimestamp(4, new Timestamp(course.getStartTime().getTime()));
    }
}
