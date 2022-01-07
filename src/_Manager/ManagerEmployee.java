package _Manager;

import _Main.Validate;
import _Model.Employee;
import _Model.EmployeeFullTime;
import _Model.EmployeePartTime;
import _ReadAndWriteFileText.ReadAndWriteFile;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ManagerEmployee {
    List<Employee> employees = ReadAndWriteFile.readFile("src/QLNV.txt");
    static Scanner scanner = new Scanner(System.in);
    static SortEmp sortEmp = new SortEmp();
    static Validate validate = new Validate();


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

    public void addEmployFullTime() throws IOException {
        String idEmp = getIDEmp();
        String nameEmp = getNameEmp();
        String ageEmp = getAgeEmp();
        String phoneEmp = getPhoneEmp();
        String emailEmp = getEmailEmp();
        boolean status = isStatusEmp();
        System.out.println("Nhập số tiền thưởng: ");
        double tienThuong = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tiền phạt: ");
        double tienPhat = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập lương cứng: ");
        double luongCung = Double.parseDouble(scanner.nextLine());
        employees.add(new EmployeeFullTime(idEmp, nameEmp, ageEmp, phoneEmp, emailEmp, status, tienThuong, tienPhat, luongCung));
        ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
        System.out.println("Thêm nhân viên thành công!!");
    }

    public void addEmployPartTime() throws IOException {
        String idNv = getIDEmp();
        String nameNv = getNameEmp();
        String ageNv = getAgeEmp();
        String phoneNv = getPhoneEmp();
        String emailNv = getEmailEmp();
        boolean status = isStatusEmp();
        System.out.println("Nhập số giờ làm: ");
        int time = Integer.parseInt(scanner.nextLine());
        employees.add(new EmployeePartTime(idNv, nameNv, ageNv, phoneNv, emailNv, status, time));
        ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
        System.out.println("Thêm nhân viên thành công!!");

    }

    public void updateEmployee(String id) throws IOException {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                String idEmp = getIDEmp();
                String nameEmp = getNameEmp();
                String ageEmp = getAgeEmp();
                String phoneEmp = getPhoneEmp();
                String emailEmp = getEmailEmp();
                boolean status = isStatusEmp();
                e.setId(idEmp);
                e.setName(nameEmp);
                e.setAge(ageEmp);
                e.setPhone(phoneEmp);
                e.setEmail(emailEmp);
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
                    ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
                } else if (e instanceof EmployeePartTime) {
                    System.out.println("Nhập số giờ làm: ");
                    int time = Integer.parseInt(scanner.nextLine());
                    ((EmployeePartTime) e).setWorkingTime(time);
                    ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
                }
            }
        }
    }

    public void writeFile() throws IOException {
        ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
    }

    public void sortEmp() {

        employees.sort(sortEmp);
    }

    public void deleteEmployee() throws IOException {
        System.out.println("Nhập ID nhân viên cần xóa: ");
        String idNv = scanner.nextLine();
        employees.removeIf(x -> x.getId().equals(idNv));
        ReadAndWriteFile.writeFile("src/QLNV.txt", employees);
    }


    private String getIDEmp() {
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
                System.err.println("Mã nhân viên không hợp lệ. VUi lòng nhập lại!\n" + "Mã nhân viên phải bắt đầu bằng CG + số!!");
                exist = true;
            }
            if (!exist)
                return idNv;
        }
    }

    private String getNameEmp() {
        while (true) {
            System.err.println("Nhập tên nhân viên: ");
            String nameEmp = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateName(nameEmp);
            if (!isValid) {
                System.err.println("Tên nhân viên không hợp lệ!Vui lòng nhập lại!\n" + "Tên nhân viên chỉ có các kí tự A-Z,a-z");
                exist = true;
            }
            if (!exist) {
                return nameEmp;
            }
        }
    }

    private String getAgeEmp() {
        while (true) {
            System.out.println("Tuổi nhân viên: ");
            String ageEmp = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validateAge(ageEmp);
            if (!isValid) {
                System.err.println("Tuổi nhân viên không hợp lệ. Vui lòng nhập lại!\n" + "Tuổi nhân viên phải là số!!");
                exist = true;
            }
            if (!exist) {
                return ageEmp;
            }
        }
    }

    private String getPhoneEmp() {
        while (true) {
            System.out.println("Nhập số điện thoại( 9 số hoặc 10 số): ");
            String phoneEmp = scanner.nextLine();
            boolean exist = false;
            boolean isValid = validate.validatePhone(phoneEmp);
            if (!isValid) {
                System.err.println("Số điện thoại không hợp lệ!Vui lòng nhập lại\n" + "Số điện thoại phải bắt đầu bằng số 0!");
                exist = true;
            }
            if (!exist) {
                return phoneEmp;
            }
        }
    }

    private String getEmailEmp() {
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

    private boolean isStatusEmp() {
        System.out.println("Nhập trạng thái: ");
        return Boolean.parseBoolean(scanner.nextLine());
    }
}


