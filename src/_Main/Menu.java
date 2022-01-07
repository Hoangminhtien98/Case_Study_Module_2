package _Main;

import _Account.Register;
import _Manager.ManagerEmployee;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    private static Boolean getStatus() {
        System.out.println("Nhập trạng thái:");
        return Boolean.parseBoolean(scanner.nextLine());
    }

    private static String getNameEmp(Scanner scanner) {
        System.out.println("Nhập tên Nhân viên: ");
        return scanner.nextLine();
    }

    public static void menu() throws IOException {
        while (true) {
            ManagerEmployee managerEmp = new ManagerEmployee();
            Register register = new Register();
            System.out.println("=====================================================");
            System.out.println("||-----------***Menu Quản Lý Nhân Viên***-----------||");
            System.out.println("||>1. Xem danh sách nhân viên theo trạng thái       ||");
            System.out.println("||>2. Xem danh sách toàn bộ nhân viên               ||");
            System.out.println("||>3. Thêm mới                                      ||");
            System.out.println("||>4. Cập nhật                                      ||");
            System.out.println("||>5. Xóa                                           ||");
            System.out.println("||>6.Tìm kiếm nhân viên                             ||");
            System.out.println("||>7. Kiểm tra trạng thái nhân viên                 ||");
            System.out.println("||>8. Cập nhật trạng thái nhân viên                 ||");
            System.out.println("||>9. Hiển thị thông tin tài khoản                  ||");
            System.out.println("||>10. Xóa Tài khoản!                               ||");
            System.out.println("||>11. Đăng xuất                                    ||");
            System.out.println("||>0. Exit                                          ||");
            System.out.println("||>Nhập lựa chọn của bạn                            ||");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("=====================================================");
            switch (choice) {
                case 1:
                    System.out.println("Danh sách nhân viên theo trạng thái!");
                    boolean status = getStatus();
                    managerEmp.showStatus(status);
                    break;
                case 2:
                    System.out.println("Danh sách toàn bộ nhân viên");
                    managerEmp.displayAll();
                    managerEmp.writeFile();
                    break;
                case 3:
                    System.out.println("1.Nhân viên Full Time");
                    System.out.println("2.Nhân viên Part Time");
                    int choiceEmployee = Integer.parseInt(scanner.nextLine());
                    switch (choiceEmployee) {
                        case 1:
                            managerEmp.addEmployFullTime();
                            break;
                        case 2:
                            managerEmp.addEmployPartTime();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Nhập ID nhân viên: ");
                    String idEmp = scanner.nextLine();
                    managerEmp.updateEmployee(idEmp);
                    break;
                case 5:
                    System.out.println("Xóa nhân viên");
                    managerEmp.deleteEmployee();
                    break;
                case 6:
                    System.out.println("Danh sách nhân viên theo tên!");
                    String nameEmploy = getNameEmp(scanner);
                    managerEmp.findByName(nameEmploy);
                    break;
                case 7:
                    System.out.println("Trạng thái nhân viên theo tên!");
                    String nameEmploy1 = getNameEmp(scanner);
                    managerEmp.findStatus(nameEmploy1);
                    break;
                case 8:
                    System.out.println("Nhập mã nhân viên: ");
                    String idEmploy = scanner.nextLine();
                    managerEmp.updateEmployee(idEmploy);
                    break;
                case 9:
                    System.out.println("Hiển thị thông tin tài khoản!");
                    System.out.println("Nhập tên tài khoản cần hiển thị");
                    String username = scanner.nextLine();
                    register.AccountInfo(username);
                    break;
                case 10:
                    System.out.println("Xóa tài khoản");
                    register.deleteAccount();
                    break;
                case 11:
                    System.out.println("Đăng xuất.....");
            }
        }
    }
}
