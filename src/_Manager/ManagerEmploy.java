package _Manager;

import _Model.Employ;
import _Model.EmployFullTime;
import _Model.EmployPartTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerEmploy {
    public List<Employ> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    final String EM_Full_Time = "full";
    final String NV_Part_Time = "part";
    File employ = new File("NhanVien.txt");
    File employFull = new File("NhanVienFullTime.txt");
    File employPart = new File("NhanVienPartTime.txt");
    String titleEmploy = "eCode, name, age, gender, phone, email, salary, status";
    String titleFT = "eCode, name, age, gender, phone, email, salary, status, dayOn, dayOff, overTime";
    String titlePT = "eCode, name, age, gender, phone, email, salary, status, timeWork";
    static BufferedWriter bufferedWriter1;
    static BufferedReader bufferedReader1;
    static BufferedWriter bufferedWriter2;
    static BufferedReader bufferedReader2;

    public void add(Employ employ) {
        list.add(employ);
    }

    public Employ creat(String type) {


        String eCode = getString();
        String name = getString2();
        int age = getAge();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        int phone = getPhone();
        String email = getString1();
        double salary = getSalary();
        boolean status = isaBoolean();
        if (type.equals(EM_Full_Time)) {
            System.out.println("Nhập số ngày làm việc");
            int dayOn = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số ngày nghỉ");
            int dayOff = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số giờ OT");
            double overTime = Double.parseDouble(scanner.nextLine());
            return new EmployFullTime(eCode, name, age, gender, phone, email, salary, status, dayOn, dayOff, overTime);
        } else {
            System.out.println("Nhập tổng thời gian làm việc theo giờ");
            double timeWork = Double.parseDouble(scanner.nextLine());
            return new EmployPartTime(eCode, name, age, gender, phone, email, salary, status, timeWork);
        }
    }

    private String getString2() {
        while (true) {
            String name = getString3();
            if (name != null) {
                return name;
            } else {
                System.out.println("Nhập lại");
            }
        }
    }

    private String getString3() {
        while (true) {
            System.out.println("Nhập họ tên");
            String name = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\D{5,}");
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return name;
            } else {
                System.out.println("Nhập lại name");
            }
        }
    }

    private boolean isaBoolean() {
        while (true) {
            try {
                System.out.println("Nhập trạng thái nhân viên-\\true: đang làm, \\false: đã nghỉ!");
                boolean status = Boolean.parseBoolean(scanner.nextLine());
                return status;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập \\true hoặc \\false!");
            }

        }
    }

    private double getSalary() {
        while (true) {
            try {
                System.out.println("Nhập lương theo giờ");
                double salary = Double.parseDouble(scanner.nextLine());
                return salary;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại lương kiểu thập phân");
            }
        }

    }

    private String getString1() {
        while (true) {
            System.out.println("Nhập Email Nhân Viên- Theo Định dạng: abc@gmail.com");
            String email = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.println(email + " không hợp lệ!");
                System.out.println("Vui lòng nhập lại email");
            }
        }

    }

    private int getPhone() {
        while (true) {
            int phone = getPhone1();
            Pattern pattern = Pattern.compile("^[0-9]+$");
            Matcher matcher = pattern.matcher(String.valueOf(phone));
            if (matcher.matches()) {
                return phone;
            } else {
                System.out.println("Vui long nhập lại sđt!");
            }

        }

    }

    private int getPhone1() {
        while (true) {
            try {
                System.out.println("Nhập số điện thoại (10 hoặc 11 số) của nhân viên-VD: 09xxxxxxxx");
                int phone = Integer.parseInt(scanner.nextLine());
                return phone;
            } catch (Exception e) {
                System.out.println("Nhập lại phone kiểu số!");
            }
        }
    }

    private String getString() {
        while (true) {
            System.out.println("Nhập Mã Nhân Viên- Theo Định dạng: CGMD123456");
            String eCode = scanner.nextLine();
            boolean check = false;
            for (Employ nv : list) {
                if (nv.getECode().equals(eCode)) {
                    System.out.println("Mã nhân viên đã tồn tại,vui lòng nhập lại");
                    check = true;
                }
            }
            if (check) {
                continue;
            }
            Pattern pattern = Pattern.compile("^CGMD\\d{6}$");
            Matcher matcher = pattern.matcher(eCode);
            if (matcher.matches()) {
                return eCode;
            } else {
                System.out.println("Vui lòng nhập lại mã- CGMD là bắt buộc");
            }
        }

    }

    private int getAge() {
        while (true) {
            try {
                System.out.println("Nhập tuổi nhân viên");
                int age = Integer.parseInt(scanner.nextLine());
                return age;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập lại tuổi kiểu số!");
            }
        }
    }

    public void find(String name) {
        boolean temp = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println(list.get(i).toString());
                temp = true;
            }
        }
        if (!temp) {
            System.out.println("Không tìm thấy tên");
        }
    }

    public void findStatus(String name) {
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println("Trạng thái nhân viên " + list.get(i).getName() + " là: " + list.get(i).isStatus());
                check = true;
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy tên nhân viên");
        }
    }

    public void edit(String eCode) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getECode().equals(eCode)) {
                if (list.get(i) instanceof EmployFullTime) {
                    list.set(i, creatEDit(eCode, "full"));
                    return;
                } else if (list.get(i) instanceof EmployPartTime) {
                    list.set(i, creatEDit(eCode, "part"));
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy mã nhân viên");
    }

    public Employ creatEDit(String eCodeEdit, String type) {

        String eCode = eCodeEdit;
        String name = getString2();
        int age = getAge();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        int phone = getPhone();
        String email = getString1();
        double salary = getSalary();
        boolean status = isaBoolean();
        if (type.equals(EM_Full_Time)) {
            System.out.println("Nhập số ngày làm việc");
            int dayOn = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số ngày nghỉ");
            int dayOff = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số giờ OT");
            double overTime = Double.parseDouble(scanner.nextLine());
            return new EmployFullTime(eCode, name, age, gender, phone, email, salary, status, dayOn, dayOff, overTime);
        } else {
            System.out.println("Nhập tổng thời gian làm việc theo giờ");
            double timeWork = Double.parseDouble(scanner.nextLine());
            return new EmployPartTime(eCode, name, age, gender, phone, email, salary, status, timeWork);
        }
    }

    public void delete(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.remove(list.get(i));
                i--;
            }
        }
    }

    public void updateStatus(String eCode, boolean status) {
        for (Employ nv : list) {
            if (nv.getECode().equals(eCode)) {
                nv.setStatus(status);
            }
        }
    }

    public void writeFile() {
        try {
            FileWriter fileWriter1 = new FileWriter(employFull);
            bufferedWriter1 = new BufferedWriter(fileWriter1);
            bufferedWriter1.write(titleFT);
            for (Employ nv : list) {
                if (nv instanceof EmployFullTime) {
                    bufferedWriter1.newLine();
                    bufferedWriter1.write(nv.show());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter2 = new FileWriter(employPart);
            bufferedWriter2 = new BufferedWriter(fileWriter2);
            bufferedWriter2.write(titlePT);
            for (Employ nv : list) {
                if (nv instanceof EmployPartTime) {
                    bufferedWriter2.newLine();
                    bufferedWriter2.write(nv.show());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Employ> readFile() {
        ArrayList<Employ> list = new ArrayList<>();
        if (!employFull.exists()) {
            try {
                employFull.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!employPart.exists()) {
            try {
                employPart.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileReader fileReader1 = new FileReader(employFull);
            bufferedReader1 = new BufferedReader(fileReader1);
            String line1 = bufferedReader1.readLine();
            while ((line1 = bufferedReader1.readLine()) != null) {
                String[] arrStr1 = line1.split(",");
                list.add(new EmployFullTime(arrStr1[0], arrStr1[1], Integer.parseInt(arrStr1[2]), arrStr1[3], Integer.parseInt(arrStr1[4]), arrStr1[5], Double.parseDouble(arrStr1[6]), Boolean.parseBoolean(arrStr1[7]), Integer.parseInt(arrStr1[8]), Integer.parseInt(arrStr1[9]), Double.parseDouble(arrStr1[10])));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader2 = new FileReader(employPart);
            bufferedReader2 = new BufferedReader(fileReader2);
            String line2 = bufferedReader2.readLine();
            while ((line2 = bufferedReader2.readLine()) != null) {
                String[] arrStr2 = line2.split(",");
                list.add(new EmployPartTime(arrStr2[0], arrStr2[1], Integer.parseInt(arrStr2[2]), arrStr2[3], Integer.parseInt(arrStr2[4]), arrStr2[5], Double.parseDouble(arrStr2[6]), Boolean.parseBoolean(arrStr2[7]), Double.parseDouble(arrStr2[8])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

}
