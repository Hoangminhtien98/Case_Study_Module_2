package _Model;

public class Employ {
    private String eCode;
    private String name;
    private int age;
    private String gender;
    private int phone;
    private String email;
    private double salary;
    private boolean status;

    public Employ() {
    }

    public Employ(String eCode, String name, int age, String gender, int phone, String email, double salary, boolean status) {
        this.eCode = eCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.status = status;
    }

    public String getECode() {
        return eCode;
    }


    public String getName() {
        return name;
    }




    public double getSalary() {
        return salary;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String show() {
        return eCode + "," + name +","+ age + "," + gender + "," + phone +","+email +","+ salary +","+ status;
    }

    @Override
    public String toString() {
        return "Info nhân viên{:" +
                "eCode='" + eCode + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gendor='" + gender + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
