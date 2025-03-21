package main;

import dao.*;
import pojo.*;
import service.*;
import view.*;
import java.util.List;
import java.util.Scanner;
// 学生控制器
public class StudentController {
    private final int currentUserId;
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();
    private final StudentMenu studentMenu = new StudentMenu();

    // 初始化DAO实例
    private final CourseDAO courseDAO = new CourseDAO();
    private final StudentCourseDAO studentCourseDAO = new StudentCourseDAO();
    private final StudentDAO studentDAO = new StudentDAO();

    public StudentController(int userId) {
        this.currentUserId = userId;
    }
    // 学生菜单
    public void startStudentService() {
        while (true) {
            studentMenu.showStudentMenu();
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> displayAvailableCourses();
                case 2 -> handleCourseSelection();
                case 3 -> handleCourseWithdrawal();
                case 4 -> displaySelectedCourses();
                case 5 -> updateStudentPhone();
                case 6 -> { return; }
                default -> System.out.println("无效输入！");
            }
        }
    }
    // case1: 查看可选课程
    private void displayAvailableCourses() {
        List<Course> courses = new CourseDAO().getAllCourses();
        System.out.println("\n==== 可选课程列表 ====");
        System.out.printf("%-4s %-20s %-6s %-15s\n",
                "ID", "课程名称", "学分", "上课时间");
        courses.forEach(c ->
                System.out.printf("%-4d %-20s %-6.1f %-15s\n",
                        c.getCid(), c.getCourseName(),
                        c.getCredit(), c.getTime()));
    }
    // case2: 选课
    private void handleCourseSelection() {
        System.out.print("请输入要选择的课程ID：");
        int courseId = Integer.parseInt(scanner.nextLine());

        if (studentService.selectCourse(currentUserId, courseId)) {
            System.out.println("选课成功！");
        } else {
            System.out.println("选课失败，请检查课程ID或选课限制！");
        }
    }

    // case3: 退选课程
    private void handleCourseWithdrawal() {
        displaySelectedCourses();
        System.out.print("输入要退选的课程ID：");
        int cid = Integer.parseInt(scanner.nextLine());

        if (studentCourseDAO.deleteStudentCourse(currentUserId, cid)) {
            System.out.println("退选成功！");
            updateSelectCount(-1); // 更新选课数量
        } else {
            System.out.println("退选失败，请检查课程ID！");
        }
    }

    // case4: 查看已选课程
    private void displaySelectedCourses() {
        List<StudentCourse> scList = studentCourseDAO.getCoursesByStudentId(currentUserId);
        if (scList.isEmpty()) {
            System.out.println("您还没有选择任何课程");
            return;
        }

        System.out.println("\n==== 已选课程列表 ====");
        System.out.printf("%-4s %-20s %-6s %-15s\n",
                "ID", "课程名称", "学分", "上课时间");
        scList.forEach(sc -> {
            Course c = courseDAO.getCourseById(sc.getCourseId());
            if (c != null) {
                System.out.printf("%-4d %-20s %-6.1f %-15s\n",
                        c.getCid(),
                        c.getCourseName(),
                        c.getCredit(),
                        c.getTime());
            }
        });
    }

    // case5: 修改手机号
    private void updateStudentPhone() {
        Student student = studentDAO.getStudentById(currentUserId)
                .orElseThrow(() -> new RuntimeException("学生不存在"));

        System.out.print("输入新手机号：");
        String newPhone = scanner.nextLine();

        if (studentService.updateStudentPhone(currentUserId, newPhone)) {
            System.out.println("手机号修改成功！");
        } else {
            System.out.println("修改失败，请检查格式！");
        }
    }

    // 更新选课数量
    private void updateSelectCount(int delta) {
        studentDAO.getStudentById(currentUserId).ifPresent(s -> {
            s.setSelectNumber(s.getSelectNumber() + delta);
            studentDAO.updateStudent(s);
        });
    }
}