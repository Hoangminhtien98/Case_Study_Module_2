package _Manager;

import _Main.Validate;
import _Model.Employee;
import _Model.EmployeeFullTime;
import _Model.EmployeePartTime;
import _ReadAndWriteFileText.ReadAndWriteFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerEmployee {
    ArrayList<Employee> employees = ReadAndWriteFile.readFile("src/FileTxt/QLNV.txt");
    Scanner scanner = new Scanner(System.in);
    SortNV sortNV = new SortNV();
    Validate validate = new Validate();


    public ManagerEmployee() throws IOException {
    }

    public void showStatus(Boolean status) {
        for (Employee e : employees) {
            if (e.isStatus() == status) {
                e.display();
            }
        }
    }

    public void findByName(String name) {
        for (Employee e : employees) {
            if (e.getName().contains(name)) {
                e.display();
            }
        }
    }

    public void findStatus(String name) {
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                e.displayStatus();
            }
        }
    }

    public void displayAll() {
        for (Employee e : employees) {
            e.display();
        }
    }

    public void addNVFullTime() throws IOException {
        String idNv = getIDNv();
        String nameNv = getNameNv();
        String ageNv = getAgeNv();
        String phoneNv = getPhoneNv();
        String emailNv = getEmailNv();
        boolean status = isStatusNv();
        System.out.println("Nhập số tiền thưởng: ");
        double tienThuong = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tiền phạt: ");
        double tienPhat = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập lương cứng: ");
        double luongCung = Double.parseDouble(scanner.nextLine());
        employees.add(new EmployeeFullTime(idNv, nameNv, ageNv, phoneNv, emailNv, status, tienThuong, tienPhat, luongCung));
        ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
        System.out.println("Thêm nhân viên thành công!!");
    }

    public void addNVPartTime() throws IOException {
        String idNv = getIDNv();
        String nameNv = getNameNv();
        String ageNv = getAgeNv();
        String phoneNv = getPhoneNv();
        String emailNv = getEmailNv();
        boolean status = isStatusNv();
        System.out.println("Nhập số giờ làm: ");
        int time = Integer.parseInt(scanner.nextLine());
        employees.add(new EmployeePartTime(idNv, nameNv, ageNv, phoneNv, emailNv, status, time));
        ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
        System.out.println("Thêm nhân viên thành công!!");

    }

    public void updateEmployee(String id) throws IOException {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                String idNv = getIDNv();
                String nameNv = getNameNv();
                String ageNv = getAgeNv();
                String phoneNv = getPhoneNv();
                String emailNv = getEmailNv();
                boolean status = isStatusNv();
                e.setId(idNv);
                e.setName(nameNv);
                e.setAge(ageNv);
                e.setPhone(phoneNv);
                e.setEmail(emailNv);
                e.setStatus(status);
                if (e instanceof EmployeeFullTime) {
                    System.out.println("Nhập số tiền thưởng: ");
                    double tienThuong = Double.parseDouble(scanner.nextLine());
                    ((EmployeeFullTime) e).setSoTienThuong(tienThuong);
                    System.out.println("Nhập số tiền phạt: ");
                    double tienPhat = Double.parseDouble(scanner.nextLine());
                    ((EmployeeFullTime) e).setSoTienPhat(tienPhat);
                    System.out.println("Nhập lương cứng: ");
                    double luongCung = Double.parseDouble(scanner.nextLine());
                    ((EmployeeFullTime) e).setLuongCung(luongCung);
                    ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
                } else if (e instanceof EmployeePartTime) {
                    System.out.println("Nhập số giờ làm: ");
                    int time = Integer.parseInt(scanner.nextLine());
                    ((EmployeePartTime) e).setWorkingTime(time);
                    ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
                }
            }
        }
    }

    public void writeFile() throws IOException {
        ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
    }

    public void sortNV() {
        employees.sort(sortNV);
    }

    public void deleteEmployee() throws IOException {
        System.out.println("Nhập ID nhân viên cần xóa: ");
        String idNv = scanner.nextLine();
        employees.removeIf(x -> x.getId().equals(idNv));
        ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
    }


    private String getIDNv() {
        while (true) {
            System.out.println("Nhập mã nhân viên:(CGxxx)");
            String idNv = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateID(idNv);
            for (Employee e : employees) {
                if (e.getId().equals(idNv)) {
                    System.out.println("Mã nhân viên đã tồn tại! Vui lòng nhập ID khác!");
                    exist = true;
                }
            }
            if (!isValid) {
                System.err.println("Mã nhân viên khoog hợp lệ. VUi lòng nhập lại!\n" + "Mã nhân viên phải bắt đầu bằng CG + số!!");
                exist = true;
            }
            if (!exist)
                return idNv;
        }
    }

    private String getNameNv() {
        while (true) {
            System.err.println("Nhập tên nhân viên: ");
            String nameNV = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateName(nameNV);
            if (!isValid) {
                System.err.println("Tên nhân viên không hợp lệ!Vui lòng nhập lại!\n" + "Tên nhân viên chỉ có các kí tự A-Z,a-z");
                exist = true;
            }
            if (!exist) {
                return nameNV;
            }
        }
    }

    private String getAgeNv() {
        while (true) {
            System.out.println("Tuổi nhân viên: ");
            String ageNV = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateAge(ageNV);
            if (!isValid) {
                System.err.println("Tuổi nhân viên không hợp lệ. Vui lòng nhập lại!\n" + "Tuổi nhân viên phải là số!!");
                exist = true;
            }
            if (!exist) {
                return ageNV;
            }
        }
    }

    private String getPhoneNv() {
        while (true) {
            System.out.println("Nhập số điện thoại( 9 số hoặc 10 số): ");
            String phoneNV = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validatePhone(phoneNV);
            if (!isValid) {
                System.err.println("Số điện thoại không hợp lệ!Vui lòng nhập lại\n" + "Số điện thoại phải bắt đầu bằng số 0!");
                exist = true;
            }
            if (!exist) {
                return phoneNV;
            }
        }
    }

    private String getEmailNv() {
        while (true) {
            System.out.println("Nhập địa chỉ email: (abc@gmail.com");
            String email = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateEmail(email);
            if (!isValid) {
                System.out.println("Định dạng email không hợp lệ. Vui lòng nhập lại!");
                exist = true;
            }
            if (!exist) {
                return email;
            }
        }
    }

    private boolean isStatusNv() {
        System.out.println("Nhập trạng thái: ");
        return Boolean.parseBoolean(scanner.nextLine());
    }
}


