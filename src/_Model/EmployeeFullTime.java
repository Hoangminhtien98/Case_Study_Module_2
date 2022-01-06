package _Model;

public class EmployeeFullTime extends Employee{
    private double soTienThuong;
    private double soTienPhat;
    private double luongCung;


    public EmployeeFullTime(String id, String name, String age, String phone, String email, boolean status, double soTienThuong, double soTienPhat, double luongCung) {
        super(id, name, age, phone, email, status);
        this.soTienThuong = soTienThuong;
        this.soTienPhat = soTienPhat;
        this.luongCung = luongCung;
    }

    public void setSoTienThuong(double soTienThuong) {
        this.soTienThuong = soTienThuong;
    }

    public void setSoTienPhat(double soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }
    public double tinhLuongFullTime(){
        return luongCung + (soTienThuong - soTienPhat);
    }

    @Override
    public String toString() {
        return "EmployeeFullTime{" + super.toString() +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", soTienThuong=" + soTienThuong +
                ", soTienPhat=" + soTienPhat +
                ", luongCung=" + luongCung +
                ", lương=" + tinhLuongFullTime() +
                '}';
    }
}
