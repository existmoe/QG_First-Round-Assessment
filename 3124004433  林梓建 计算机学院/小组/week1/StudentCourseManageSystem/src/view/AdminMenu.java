package view;

public class AdminMenu {
    //管理员菜单
    public void showAdminMenu(){
        System.out.println("===== 管理员菜单 =====");
        System.out.println("1. 查询所有学生");
        System.out.println("2. 修改学生手机号");
        System.out.println("3. 查询所有课程");
        System.out.println("4. 修改课程学分");
        System.out.println("5. 查询某课程的学生名单");
        System.out.println("6. 查询某学生的选课情况");
        System.out.println("7. 退出");
        System.out.println("请选择操作（输入 1-7）：");
    }
}
