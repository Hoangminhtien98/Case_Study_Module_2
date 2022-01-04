package _Manager;

import _Main.Validate;
import _Model.Employee;
import _ReadAndWriteFileText.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerEmployee {
    ArrayList<Employee> employees = ReadAndWriteFile.readFile("src/FileTxt/QLNV.txt");
    Scanner scanner = new Scanner(System.in);
    SortNV sortNV = new SortNV();
    Validate validate = new Validate();

    public ManagerEmployee()  {
    }
    public void showStatus() {

    }
    public void findByName(){

    }
    public void findStatus(String name){

    }
    public void displayAll(){

    }
    public void addEmployeeFullTime() {

    }
    public void addEmployeePartTime() {

    }
    public void writeFile() throws IOException {
        ReadAndWriteFile.writeFile("src/FileTxt/QLNV.txt", employees);
    }

    public void sortNV() {
        employees.sort(sortNV);
    }
}
