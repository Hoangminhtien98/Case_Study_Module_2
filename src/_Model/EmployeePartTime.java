package _Model;

public class EmployeePartTime extends Employee{

    private int workingTime;



    public EmployeePartTime(String id, String name, String age, String phone, String email, boolean status, int workingTime) {
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
    public void display() {
        System.out.println("Nhân viên Parttime: " +
                "Mã nhân viên= " + id +
                ", Tên= " + name +
                ", Tuổi= " + age +
                ", Số điện thoại= " + phone +
                ", Địa chỉ email= " + email +
                ", Trạng thái= " + status +
                ", Số giờ làm= " + workingTime +
                ", Lương= " + tinhLuongPartTime());
    }
    public String writeEmployPartTime() {
        return id + "," + name + "," + age + "," + phone + "," + email + "," + status + "," + workingTime + "," + tinhLuongPartTime();
    }
}
