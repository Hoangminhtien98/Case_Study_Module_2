package _ReadAndWriteFileText;

import _Model.Employee;
import _Model.EmployeeFullTime;
import _Model.EmployeePartTime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadAndWriteFile {
    public static void writeFile(String path, List<Employee> products) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employ : products) {
                if (employ instanceof EmployeeFullTime) {
                    bufferedWriter.write(((EmployeeFullTime) employ).writeEmployFullTime());
                } else if (employ instanceof EmployeePartTime) {
                    bufferedWriter.write(((EmployeePartTime) employ).writeEmployPartTime());
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            bufferedWriter.close();
        }
    }

    public static ArrayList<Employee> readFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        ArrayList<Employee> list = new ArrayList<>();
        try {
            FileReader  fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] str = line.split(",");
                if (str.length >= 8) {
                    list.add(new EmployeeFullTime(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Double.parseDouble(str[6]), Double.parseDouble(str[7]), Double.parseDouble(str[8])));
                } else if (str.length >= 6) {
                    list.add(new EmployeePartTime(str[0], str[1], str[2], str[3], str[4], Boolean.parseBoolean(str[5]), Integer.parseInt(str[6])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedReader != null;
            bufferedReader.close();
        }
        return list;
    }
}
