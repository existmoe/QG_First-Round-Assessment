package main;

import dao.*;
import pojo.*;
import service.*;
import view.*;
import java.util.Scanner;

public class MainSystem {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final AdminService adminService = new AdminService();
    private final StudentService studentService = new StudentService();
    private User currentUser;

    public static void main(String[] args) {
        new MainSystem().startSystem();
    }

    private void startSystem() {
        while (true) {
            new MainMenu().showMainMenu();
            int choice = Integer.parseInt(scanner.nextLine().trim());

            switch (choice) {
                case 1 -> handleUserLogin();
                case 2 -> handleUserRegistration();
                case 3 -> {
                    System.out.println("系统已退出");
                    System.exit(0);
                }
                default -> System.out.println("无效输入，请重新选择！");
            }
        }
    }

    // 用户登录处理
    private void handleUserLogin() {
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();

        currentUser = userService.login(username, password);
        if (currentUser == null) {
            System.out.println("登录失败，请检查用户名或密码！");
            return;
        }

        switch (currentUser.getIdentity()) {
            case "admin" -> new AdminController().startAdminService();
            case "student" -> new StudentController(currentUser.getUserId()).startStudentService();
            default -> System.out.println("未知用户类型！");
        }
    }

    // 用户注册处理
    private void handleUserRegistration() {
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();
        System.out.print("请确认身份（student/admin）：");
        String identity = scanner.nextLine();

        User newUser = new User(0, username, password, identity);
        if (userService.register(newUser)) {
            System.out.println("注册成功！");
        } else {
            System.out.println("注册失败，用户名可能已存在！");
        }
    }
}