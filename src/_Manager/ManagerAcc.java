package _Manager;

import _Acc.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerAcc {
    List<Account> accList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    File account = new File("src/IOFile/Account.csv");
    String title = "UserName, PassWord, Role";
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

    public void addUser(Account account) {
        accList.add(account);
    }

    public Account creat() {

        String userName = getString();

        String passWord = getString1();
        String role = getString2();
        return new Account(userName, passWord, role);
    }

    private String getString2() {
        while (true) {
            System.out.println("Nhập role: 'User' hoặc 'Admin'");
            String role = scanner.nextLine();
            if (role.equals("User") || role.equals("Admin")) {
                return role;
            } else {
                System.out.println("Nhập lại role: chỉ 'User' hoặc 'Admin'");
            }
        }
    }

    private String getString1() {
        while (true) {
            System.out.println("Nhập Pass Word");
            String passWord = scanner.nextLine();
            Pattern pattern = Pattern.compile("^\\w.*$");
            Matcher matcher = pattern.matcher(passWord);
            if (matcher.matches()) {
                return passWord;
            } else {
                System.out.println("Tên PassWord phải có ít nhất 1 ký tự");
            }
        }
    }

    private String getString() {
        while (true) {
            System.out.println("Nhập User Name");
            String userName = scanner.nextLine();
            boolean check = false;
            for (Account acc : accList) {
                if (acc.getUser().equals(userName)) {
                    System.out.println("Tên tài khoản đã tồn tại,vui lòng nhập lại");
                    check = true;
                }
            }
            if (check) {
                continue;
            }
            Pattern pattern = Pattern.compile("^[a-zA-Z]{1}\\w{4}.*$");
            Matcher matcher = pattern.matcher(userName);
            if (matcher.matches()) {
                return userName;
            } else {
                System.out.println("Tên User phải có ít nhất 5 ký tự và bắt đầu bằng chữ");
            }
        }


    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(account);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(title);
            for (Account account : accList) {
                bufferedWriter.newLine();
                bufferedWriter.write(account.show());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Account> readFile() {
        ArrayList<Account> accList = new ArrayList<>();
        if (!account.exists()) {
            try {
                account.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader = new FileReader(account);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                accList.add(new Account(arr[0], arr[1], arr[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return accList;
    }

    public int login() {
        //Không được khoảng trắng và tk trùng nhau
        while (true) {
            int select = -1;
            try {
                System.out.println("----------------*MENU*----------------");
                System.out.println("1. Đăng nhập                          ");
                System.out.println("2. Thêm tài khoản mới                 ");
                System.out.println("3. Show thông tin Account đăng nhập   ");
                System.out.println("4. Xóa tài khoản đăng nhập            ");
                System.out.println("=>Chose: ");
                select = Integer.parseInt(scanner.nextLine());
                if (select != 1 && select != 2 && select != 3 && select != 4) {
                    System.out.println("Lựa chọn " + select + " không nằm trong lựa chọn");
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại");
            }
            if (select == 1) {
                System.out.println("Nhập UserName");
                String userName = scanner.nextLine();
                System.out.println("Nhập Pass Word");
                String passWord = scanner.nextLine();
                accList = readFile();
                for (Account account : accList) {
                    if (account.getUser().equals(userName) && account.getPassWord().equals(passWord) && account.getRole().equals("Admin")) {
                        return 1;
                    } else if (account.getUser().equals(userName) && account.getPassWord().equals(passWord) && account.getRole().equals("User")) {
                        return 2;
                    }
                }
                System.out.println("Tài khoản không đúng hoặc bạn chưa đăng ký");
            }
            if (select == 2) {
                Account account1 = null;
                accList = readFile();
                account1 = creat();
                addUser(account1);
                writeFile();
                System.out.println("Bạn đã đăng ký thành công");
            }
            if (select == 3) {
                accList = readFile();
                for (Account account : accList) {
                    System.out.println(account);
                }
            }
            if (select == 4) {
                System.out.println("Nhập tên tài khoản cần xóa->sẽ xóa hết các tk có tên này");
                String userName = scanner.nextLine();
                accList = readFile();
                for (int i = 0; i < accList.size(); i++) {
                    if (accList.get(i).getUser().equals(userName)) {
                        accList.remove(accList.get(i));
                        i--;
                    }
                }
                writeFile();
            }
        }
    }
}