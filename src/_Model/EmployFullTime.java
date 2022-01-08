package _Model;

public class EmployFullTime extends Employ {
    private int dayOn;
    private int dayOff;
    private double overTime;

    public EmployFullTime() {
    }

    public EmployFullTime(String eCode, String name, int age, String gender, int phone, String email, double salary, boolean status, int dayOn, int dayOff, double overTime) {
        super(eCode, name, age, gender, phone, email, salary, status);
        this.dayOn = dayOn;
        this.dayOff = dayOff;
        this.overTime = overTime;
    }


    public double salaryMonth() {
        return getSalary() * ((this.dayOn - this.dayOff) * 8) + getSalary() * this.overTime;
    }

    @Override
    public String show() {
        return super.show() + "," + dayOn + "," + dayOff + "," + overTime;
    }

    @Override
    public String toString() {
        return " Thông tin Nhân Viên FullTime{ " + super.toString() +
                "dayOn=" + dayOn +
                ", dayOff=" + dayOff +
                ", overTime=" + overTime +
                '}';
    }
}
