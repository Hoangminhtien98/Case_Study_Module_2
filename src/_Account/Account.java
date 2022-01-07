package _Account;

public class Account {
    protected String username;
    protected String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public void displayAccount() {
        System.out.println("Account{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                '}');
    }
    public String write() {
        return username + "," + password;
    }
}
