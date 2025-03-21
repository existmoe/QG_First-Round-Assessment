package pojo;

import java.util.Date;

public class Course {
    private int cid; // 课程ID（主键）
    private String courseName; // 课程名称
    private double credit; // 学分
    private String time; // 上课时间
    private Date startTime; // 开课时间

    public Course() {}

    public Course(int cid, String courseName, double credit, String time, Date startTime) {
        this.cid = cid;
        this.courseName = courseName;
        this.credit = credit;
        this.time = time;
        this.startTime = startTime;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
