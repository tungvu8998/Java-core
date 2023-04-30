package utils;

import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputEmail() {
        while (true) {
            try {

                String email = String.valueOf(scanner.next());
                if (email.contains("@gmail.com")) {
                    return email;
                } else {
                    System.out.println("Vui lòng nhập đúng định dạng");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập đúng định dạng");
            }

        }
    }
    public static String inputPassword() {
        while (true) {
            try {

                String password = String.valueOf(scanner.next());
                if (password.length() < 6 || password.length() > 12) {
                    System.out.println("Vui lòng nhập đúng định dạng");
                } else {
                    return password;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập đúng định dạng");
            }

        }
    }
}

