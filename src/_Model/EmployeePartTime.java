package _Model;

public class EmployeePartTime extends Employee{

    private int workingTime;

    public EmployeePartTime() {
    }

    public EmployeePartTime(String id, String name, int age, String phone, String email, boolean status, int workingTime) {
        super(id, name, age, phone, email, status);
        this.workingTime = workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public double tinhLuongPartTime() {
        return workingTime * 100000;
    }

    @Override
    public String toString() {
        return "EmployeePartTime{" + super.toString() +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", workingTime=" + workingTime +
                ", lương=" + tinhLuongPartTime() +
                '}';
    }
}
