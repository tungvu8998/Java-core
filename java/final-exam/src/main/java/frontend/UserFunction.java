package frontend;

import backend.controller.IUserController;
import backend.controller.UserController;
import entity.User;
import utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserFunction {
    private IUserController controller = new UserController();

    public void showManagerMenu() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn chọn chức năng");
            System.out.println("1.Đăng xuất");
            System.out.println("2.Hiển thị danh sách manager");
            System.out.println("3.Tìm kiếm employee theo project ID");
            int menu = scanner.nextInt();

            if (menu == 1) {
                return;
            } else if (menu == 2) {
                findManager();
            } else if (menu == 3) {
                findByProjectId();
            } else {
                System.out.println("Vui lòng chọn đúng chức năng");

            }
        }
    }

    public void findByProjectId() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào projectId cần tìm ");
        int projectId = scanner.nextInt();
        User user = controller.findByProjectId(projectId);
        System.out.println("+------+--------------------+--------------------+--------------------+--------------------+");
        System.out.println("|  ID  |     FULL_NAME      |       EMAIL        |       PASSWORD     |          ROLE      |");
        System.out.println("+------+--------------------+--------------------+--------------------+--------------------+");
        if (user == null) {
            System.out.printf("| %-4s | %-18s | %-18s | %-18s | %-18s |%n", "null", "null", "null", "null", "null");

        } else {
            System.out.printf("| %-4s | %-18s | %-18s | %-18s | %-18s |%n", user.getId(), user.getFullName(), user.getEmail(), user.getPassword(), user.getRole());
        }

    }

    public void findManager() throws SQLException, IOException {
        List<User> user = controller.findManager();

        System.out.println("+------+--------------------+--------------------+--------------------+--------------------+");
        System.out.println("|  ID  |     FULL_NAME      |       EMAIL        |       PASSWORD     |          ROLE      |");
        System.out.println("+------+--------------------+--------------------+--------------------+--------------------+");
        if (user.isEmpty()) {
            System.out.printf("| %-4s | %-18s | %-18s | %-18s | %-18s |%n", "null", "null", "null", "null", "null");

        } else {
            for (User user1 : user) {
                System.out.printf("| %-4s | %-18s | %-18s | %-18s | %-18s |%n", user1.getId(), user1.getFullName(), user1.getEmail(), user1.getPassword(), user1.getRole());
                System.out.println("+------+--------------------+--------------------+--------------------+--------------------+");
            }
        }
    }
    public User login() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào email (VD: abc@gmail.com)");
        String email = ScannerUtils.inputEmail();
        System.out.println("Nhập vào password (từ 6 đến 12 ký tư ");
        String password = ScannerUtils.inputPassword();
        return controller.login(email, password);

    }
}
