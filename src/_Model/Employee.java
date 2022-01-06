package _Model;

public class Employee {
    protected String id;
    protected String name;
    protected String age;
    protected String phone;
    protected String email;
    protected boolean status;

    public Employee() {
    }

    public Employee(String id, String name, String age, String phone, String email, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
    public void display(){
        System.out.println("NhanVien{" + "id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email + ", status" + status + '}');
    }
    public void displayStatus(){
        System.out.println("Tên nhân viên" + name + ", Trạng thái = " + status);
    }
}
