package frontend;

import entity.User;
import utils.JDBCUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserProgram {
    public static void main(String[] args) throws IOException, SQLException {
        JDBCUtils.checkConnection();
        UserFunction function = new UserFunction();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Mời bạn chọn chức năng");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Thoát chương trình");
            int menu = scanner.nextInt();
            if (menu == 1) {
                User user = function.login();
                try {
                    if (user.getRole() == User.Role.MANAGER) {
                        function.showManagerMenu();
                    }
                } catch (Exception e) {
                    System.out.println("Bạn không đủ quyền truy cập hoặc nhập sai password");
                }
            } else if (menu == 2) {
                return;
            } else {
                System.out.println("Vui lòng chọn đúng chức năng");

            }
        }
    }
}


