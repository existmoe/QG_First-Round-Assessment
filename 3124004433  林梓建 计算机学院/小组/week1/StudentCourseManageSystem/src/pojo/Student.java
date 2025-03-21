package pojo;

public class Student {
    private int sid; // 学生ID（主键）
    private int selectNumber; // 选课数量（最大5门）
    private String selectDescription; // 选课描述
    private String phoneNumber; // 手机号

    public Student() {}

    public Student(int sid, int selectNumber, String selectDescription, String phoneNumber) {
        this.sid = sid;
        this.selectNumber = selectNumber;
        this.selectDescription = selectDescription;
        this.phoneNumber = phoneNumber;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(int selectNumber) {
        this.selectNumber = selectNumber;
    }

    public String getSelectDescription() {
        return selectDescription;
    }

    public void setSelectDescription(String selectDescription) {
        this.selectDescription = selectDescription;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
