package _Main;

import _Manager.ManagerAcc;
import _Manager.ManagerEmploy;
import _Model.Employ;
import _Model.EmployFullTime;
import _Model.EmployPartTime;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerEmploy managerEmploy = new ManagerEmploy();
        ManagerAcc managerAcc = new ManagerAcc();
        while (true) {
            int a= managerAcc.login();
            if(a==1){
                while (true) {
                    System.out.println("|-----------------------MENU-----------------------|");
                    System.out.println("|0. Thoát Chương Trình-----------------------------|");
                    System.out.println("|1. Thêm nhân viên---------------------------------|");
                    System.out.println("|2. Tìm kiếm nhân viên theo name-------------------|");
                    System.out.println("|3. Kiểm tra trạng thái nhân viên theo name--------|");
                    System.out.println("|4. Sửa thông tin nhân viên------------------------|");
                    System.out.println("|5. Xóa nhân viên khỏi hệ thống--------------------|");
                    System.out.println("|6. Update lại trạng thái của nhân viên------------|");
                    System.out.println("|7. Tính lương nhân viên theo part time, full time-|");
                    System.out.println("|8. Hiện thị danh sách nhân viên theo trạng thái---|");
                    System.out.println("|9. Hiển thị toàn bộ thông tin nhân viên-----------|");
                    System.out.println("|10. Ghi file Text.txt-----------------------------|");
                    System.out.println("|11. Đọc file Text.txt-----------------------------|");
                    System.out.println("|12. Đăng xuất tài khoản---------------------------|");
                    System.out.println("=>Chose1: ");
                    managerEmploy.list = managerEmploy.readFile();//Xem lại đoạn này
                    int choice = -1;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Nhập lại lựa chọn");
                        continue;
                    }
                    if (choice == 12){
                        break;
                    }

                    switch (choice) {
                        case 0:
                            System.exit(0);
                            break;
                        case 1:
                            while (true) {
                                int choice1 = getChoice1();
                                if (choice1 == 1) {
                                    Employ employ = managerEmploy.creat("full");
                                    managerEmploy.add(employ);
                                    break;
                                } else if (choice1 == 2) {
                                    Employ employ = managerEmploy.creat("part");
                                    managerEmploy.add(employ);
                                    break;
                                } else {
                                    System.out.println("Lựa chọn " + choice1 + " không nằm trong list, vui lòng chọn lại!");
                                }
                            }
                            managerEmploy.writeFile();// xem lại đoạn này
                            break;
                        case 2:
                            System.out.println("Nhập tên cần tìm kiếm");
                            System.out.println("Nhập \\exit để về menu chính");
                            String name = scanner.nextLine();
                            if (name.equals("exit")) {
                                continue;
                            }
                            Pattern pattern = Pattern.compile("\\D{5,}");
                            Matcher matcher = pattern.matcher(name);
                            if (matcher.matches()) {
                                managerEmploy.find(name);
                            } else {
                                System.out.println("Tên không đúng định dạng");
                            }
                            break;
                        case 3:
                            System.out.println("Nhập tên cần kiểm tra trạng thái");
                            System.out.println("Nhập \\exit để về menu chính");
                            String name3 = scanner.nextLine();
                            if (name3.equals("exit")) {
                                continue;
                            }
                            Pattern pattern3 = Pattern.compile("\\D{5,}");
                            Matcher matcher3 = pattern3.matcher(name3);
                            if (matcher3.matches()) {
                                managerEmploy.findStatus(name3);
                            } else {
                                System.out.println("Tên không đúng định dạng");
                            }
                            break;
                        case 4:
                            System.out.println("Nhập mã nhân viên cần sửa thông tin(sẽ sửa toàn bộ thông tin)");
                            String eCode = null;
                            try {
                                eCode = scanner.nextLine();
                            } catch (Exception e) {
                                System.out.println("Mã không đúng định dạng");
                            }
                            managerEmploy.edit(eCode);
                            managerEmploy.writeFile();
                            break;
                        case 5:
                            System.out.println("Nhập tên cần xóa-Lưu ý sẽ xóa tất cả nhân viên có tên giống nhau");
                            String name5 = scanner.nextLine();
                            managerEmploy.delete(name5);
                            managerEmploy.writeFile();
                            break;
                        case 6:
                            System.out.println("Nhận mã nhân viên cần thay đổi trạng thái");
                            String eCode6 = scanner.nextLine();
                            System.out.println("Nhập trạng thái muốn chuyển sang");
                            boolean status6 = Boolean.parseBoolean(scanner.nextLine());
                            managerEmploy.updateStatus(eCode6, status6);
                            managerEmploy.writeFile();
                            break;
                        case 7:
                            for (Employ nv : managerEmploy.list) {
                                if (nv instanceof EmployFullTime) {
                                    System.out.println(nv + " Lương Tháng: " + ((EmployFullTime) nv).salaryMonth());
                                } else if (nv instanceof EmployPartTime) {
                                    System.out.println(nv + " Lương Tháng: " + ((EmployPartTime) nv).salaryMonth());
                                }
                            }
                            break;
                        case 8:
                            for (Employ nv : managerEmploy.list) {
                                System.out.println("Mã nhân viên: " + nv.getECode() + ", Họ tên: " + nv.getName() + ", Status: " + nv.isStatus());
                            }
                            break;
                        case 9:
                            for (Employ nv : managerEmploy.list) {
                                System.out.println(nv);
                            }
                            break;
                        case 10:
                            managerEmploy.writeFile();
                            break;
                        case 11:
                            System.out.println("Hệ Thông Auto Read File");
                            managerEmploy.list = managerEmploy.readFile();
                            break;
                    }
                }
            }else if(a==2){
                while (true) {
                    System.out.println("|-----------------------MENU-----------------------|");
                    System.out.println("|1. Tìm kiếm nhân viên theo name-------------------|");
                    System.out.println("|2. Kiểm tra trạng thái nhân viên theo name--------|");
                    System.out.println("|3. Tính lương nhân viên theo part time, full time-|");
                    System.out.println("|4. Hiện thị danh sách nhân viên theo trạng thái---|");
                    System.out.println("|5. Hiển thị toàn bộ thông tin nhân viên-----------|");
                    System.out.println("|6. Đăng xuất tài khoản----------------------------|");
                    System.out.println("|7. Thoát Chương Trình-----------------------------|");
                    System.out.println("|--------------------------------------------------|");
                    System.out.println("=>Chose: ");
                    managerEmploy.list = managerEmploy.readFile();//Xem lại đoạn này
                    int choice = -1;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Nhập lại lựa chọn");
                        continue;
                    }
                    if (choice == 6){
                        break;
                    }

                    switch (choice) {
                        case 7:
                            System.exit(0);
                            break;
                        case 1:
                            System.out.println("Nhập tên cần tìm kiếm");
                            System.out.println("Nhập \\exit để về menu chính");
                            String name = scanner.nextLine();
                            if (name.equals("exit")) {
                                continue;
                            }
                            Pattern pattern = Pattern.compile("\\D{5,}");
                            Matcher matcher = pattern.matcher(name);
                            if (matcher.matches()) {
                                managerEmploy.find(name);
                            } else {
                                System.out.println("Tên không đúng định dạng");
                            }
                            break;
                        case 2:
                            System.out.println("Nhập tên cần kiểm tra trạng thái");
                            System.out.println("Nhập \\exit để về menu chính");
                            String name3 = scanner.nextLine();
                            if (name3.equals("exit")) {
                                continue;
                            }
                            Pattern pattern3 = Pattern.compile("\\D{5,}");
                            Matcher matcher3 = pattern3.matcher(name3);
                            if (matcher3.matches()) {
                                managerEmploy.findStatus(name3);
                            } else {
                                System.out.println("Tên không đúng định dạng");
                            }
                            break;
                        case 3:
                            for (Employ nv : managerEmploy.list) {
                                if (nv instanceof EmployFullTime) {
                                    System.out.println(nv + " Lương Tháng: " + ((EmployFullTime) nv).salaryMonth());
                                } else if (nv instanceof EmployPartTime) {
                                    System.out.println(nv + " Lương Tháng: " + ((EmployPartTime) nv).salaryMonth());
                                }
                            }
                            break;
                        case 4:
                            for (Employ nv : managerEmploy.list) {
                                System.out.println("Mã nhân viên: " + nv.getECode() + ", Họ tên: " + nv.getName() + ", Status: " + nv.isStatus());
                            }
                            break;
                        case 5:
                            for (Employ nv : managerEmploy.list) {
                                System.out.println(nv);
                            }
                            break;
                    }
                }
            }

        }
    }

    private static int getChoice1() {
        Scanner scanner= new Scanner(System.in);
        while (true){
            try{
                System.out.println("1. Thêm nhân viên FullTime");
                System.out.println("2. Thêm nhân viên PartTime");
                int choice1= Integer.parseInt(scanner.nextLine());
                return choice1;
            }catch (Exception e){
                System.out.println("Vui lòng chọn lại");
            }
        }
    }
}
