package main;

import dao.*;
import pojo.*;
import service.*;
import view.*;
import java.util.List;
import java.util.Scanner;

public class AdminController {
    private final Scanner scanner = new Scanner(System.in);
    private final AdminService adminService = new AdminService();
    private final AdminMenu adminMenu = new AdminMenu();

    // 初始化DAO实例
    private final CourseDAO courseDAO = new CourseDAO();
    private final StudentDAO studentDAO = new StudentDAO();
    private final StudentCourseDAO studentCourseDAO = new StudentCourseDAO();

    public void startAdminService() {
        while (true) {
            adminMenu.showAdminMenu();
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> displayAllStudents();
                case 2 -> updateStudentPhone();
                case 3 -> displayAllCourses();
                case 4 -> updateCourseCredit();
                case 5 -> displayCourseStudents();
                case 6 -> displayStudentCourses();
                case 7 -> { return; }
                default -> System.out.println("无效输入！");
            }
        }
    }

    private void displayAllStudents() {
        List<Student> students = adminService.getAllStudents();
        System.out.println("\n==== 学生列表 ====");
        System.out.printf("%-6s %-15s %-15s\n", "学号", "已选课程数", "手机号");
        students.forEach(s ->
                System.out.printf("%-6d %-15d %-15s\n",
                        s.getSid(), s.getSelectNumber(), s.getPhoneNumber()));
    }

    private void updateStudentPhone() {
        System.out.print("输入要修改的学生ID：");
        int sid = Integer.parseInt(scanner.nextLine());
        System.out.print("输入新手机号：");
        String newPhone = scanner.nextLine();

        if (adminService.updateStudentPhone(sid, newPhone)) {
            System.out.println("手机号修改成功！");
        } else {
            System.out.println("修改失败，请检查学生ID！");
        }
    }

    // case3: 查询所有课程
    private void displayAllCourses() {
        List<Course> courses =  courseDAO.getAllCourses();
        System.out.println("\n==== 全部课程列表 ====");
        System.out.printf("%-4s %-20s %-6s %-15s %-15s\n",
                "ID", "课程名称", "学分", "上课时间", "开课日期");
        courses.forEach(c ->
                System.out.printf("%-4d %-20s %-6.1f %-15s %tF\n",
                        c.getCid(),
                        c.getCourseName(),
                        c.getCredit(),
                        c.getTime(),
                        c.getStartTime()));
    }

    // case4: 修改课程学分
    private void updateCourseCredit() {
        System.out.print("输入要修改的课程ID：");
        int cid = Integer.parseInt(scanner.nextLine());
        System.out.print("输入新的学分值：");
        double newCredit = Double.parseDouble(scanner.nextLine());

        if (adminService.updateCourseCredit(cid, newCredit)) {
            System.out.println("学分修改成功！");
        } else {
            System.out.println("修改失败，请检查课程ID！");
        }
    }

    // case5: 查询某课程的学生名单
    private void displayCourseStudents() {
        System.out.print("输入课程ID：");
        int cid = Integer.parseInt(scanner.nextLine());

        List<StudentCourse> scList = studentCourseDAO.getStudentsByCourseId(cid);
        if (scList.isEmpty()) {
            System.out.println("该课程暂无学生选课");
            return;
        }

        System.out.println("\n==== 课程学生名单 ====");
        System.out.printf("%-6s %-15s\n", "学生ID", "手机号");
        scList.forEach(sc -> {
            Student s = new StudentDAO().getStudentById(sc.getStudentId()).orElse(null);
            if (s != null) {
                System.out.printf("%-6d %-15s\n", s.getSid(), s.getPhoneNumber());
            }
        });
    }

    // case6: 查询某学生的选课情况
    private void displayStudentCourses() {
        System.out.print("输入学生ID：");
        int sid = Integer.parseInt(scanner.nextLine());

        List<StudentCourse> scList = studentCourseDAO.getCoursesByStudentId(sid);
        if (scList.isEmpty()) {
            System.out.println("该学生暂无选课记录");
            return;
        }

        System.out.println("\n==== 学生选课详情 ====");
        System.out.printf("%-4s %-20s\n", "课程ID", "课程名称");
        scList.forEach(sc -> {
            Course c = courseDAO.getCourseById(sc.getCourseId());
            if (c != null) {
                System.out.printf("%-4d %-20s\n", c.getCid(), c.getCourseName());
            }
        });
    }
}