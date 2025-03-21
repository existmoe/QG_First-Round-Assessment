package dao;

import pojo.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/*
 * 进行用户表的数据库操作
 */
public class UserDAO {
    /*
     *通过用户名查询用户信息
     * 返回User 对象；若没查询到，返回null
     */
    public User getUserByUserName(String userName) {
        //定义SQL
        String sql = "SELECT * FROM users WHERE user_name = ?";
        try (Connection conn = DBUtil.getConnection();//获取数据库连接
             PreparedStatement stmt = conn.prepareStatement(sql)) {//预编译SQL语句
            //设置参数值
            stmt.setString(1, userName);
            //执行查询
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {//如果查询到结果
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("identity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 用户注册
     * 返回是否成注册成功(boolean)
     */
    public boolean insertUser(User user) throws Exception {
        String sql = "INSERT INTO users (user_name, password, identity) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            //设置参数值
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getIdentity());
            int rows = stmt.executeUpdate();//执行插入并返回受影响的行数
            if (rows > 0) {//如果插入成功
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getInt(1));
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * 根据用户名和新密码更新用户密码
     * 返回是否更新成功(boolean)
     */
    public boolean updatePassword(String userName, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE user_name = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            //设置参数值
            stmt.setString(1, newPassword);
            stmt.setString(2, userName);
            return stmt.executeUpdate() > 0; // 返回是否更新成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * 根据用户名删除用户信息
     * 返回是否删除成功(boolean)
     */
    public boolean deleteUser(String userName) {
        String sql = "DELETE FROM users WHERE user_name = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            //设置参数值
            stmt.setString(1, userName);
            return stmt.executeUpdate() > 0; // 返回是否删除成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * 获取所有用户信息
     * 返回userList集合
     */
    public List<User> getAllUsers() {
        //创建一个空的userList集合
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {//如果查询到结果
                //将查询到的用户信息封装成User对象，并添加到userList集合中
                userList.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("identity")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;//返回userList集合
    }

}
