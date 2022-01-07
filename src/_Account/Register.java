package _Account;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Register {
    List<Account> accounts = SaveAccount.readFile("src/IOFile/account.csv");
    static Scanner scanner = new Scanner(System.in);

    public Register() throws IOException {

    }
    public boolean register (String username, String password) throws IOException {
        for (Account a : accounts) {
            if (a.getUsername().equals(username)) {
                System.err.println("Tài khoản đã tồn tại! Vui lòng nhập tài khoản khác!");
                return false;
            }
        }
        accounts.add(new Account(username, password));
        System.out.println("Đăng ký thành công!");
        SaveAccount.writeFile("src/IOFile/account.csv", accounts);
        return true;
    }
    public boolean login(String username, String password) {
        for (Account a : accounts) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!!");
                return true;
            }
        }
        System.err.println("Sai tài khoản hoặc mật khẩu. Vui lòng nhập lại!");
        return false;
    }
    public void deleteAccount() throws IOException {
        System.out.println("Nhập user name cần xóa: ");
        String username = scanner.nextLine();
        accounts.removeIf(x -> x.getUsername().equals(username));
        SaveAccount.writeFile("src/IOFile/account.csv", accounts);
    }
    public void AccountInfo(String name) {
        int check = -1;
        for (Account a : accounts) {
            if (a.getUsername().equals(name)) {
                a.displayAccount();
                check = 1;
            }
        }
        if (check < 1) {
            System.err.println("Tài khoản không tồn tại!!");
        }
    }
}
