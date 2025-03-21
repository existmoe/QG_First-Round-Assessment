package pojo;

public class User {
    private int userId;//用户ID
    private String userName;//用户名
    private String password;//密码
    private String identity;//身份

    public User() {}

    public User(int userId, String userName, String password, String identity) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.identity = identity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
