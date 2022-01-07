package _Main;

import _Account.Account;
import _Account.Register;
import _Account.SaveAccount;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Login {
    static Scanner scanner = new Scanner(System.in);
    static List<Account> accounts;
    static {
        try {
            accounts = SaveAccount.readFile("src/account.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void login() throws IOException {
        Register regLog = new Register();
        while (true) {
            System.out.println("|Chương Trình Quản Lý Nhân Viên|");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("3. Thoát khỏi chương trình");
            int choiceLog = Integer.parseInt(scanner.nextLine());
            if (choiceLog == 1) {
                while (true) {
                    System.out.println("Đăng nhập");
                    System.out.println("Nhập username");
                    String user = scanner.nextLine();
                    System.out.println("Nhập password");
                    String pass = scanner.nextLine();
                    if (regLog.login(user, pass)) {
                        break;
                    }
                }
                break;
            } else if (choiceLog == 2) {
                while (true) {
                    System.out.println("Đăng ký tài khoản!");
                    System.out.println("Nhập username");
                    String user = scanner.nextLine();
                    System.out.println("Nhập password");
                    String pass = scanner.nextLine();
                    if (regLog.register(user, pass)){
                        break;
                    }
                }
            } else if (choiceLog == 3) {
                System.out.println("Đang thoát chương trình....");
                System.exit(0);
            }
        }
    }

}
