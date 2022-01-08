package _Model;

public class EmployPartTime extends Employ {
    private double timeWork;

    public EmployPartTime() {
    }

    public EmployPartTime(String eCode, String name, int age, String gender, int phone, String email, double salary, boolean status, double timeWork) {
        super(eCode, name, age, gender, phone, email, salary, status);
        this.timeWork = timeWork;
    }


    public double salaryMonth() {
        return getSalary() * this.timeWork;
    }

    @Override
    public String show() {
        return super.show() + "," + this.timeWork;
    }

    @Override
    public String toString() {
        return " Thông tin Nhân viên PartTime{" + super.toString() +
                "timeWork=" + this.timeWork +
                '}';
    }
}
