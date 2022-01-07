package _Account;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveAccount {
    public static void writeFile(String path, List<Account> products) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "User Name, Password";
            bufferedWriter.write(str);
            for (Account a : products) {
                bufferedWriter.newLine();
                bufferedWriter.write(a.write());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert bufferedWriter != null;
            bufferedWriter.close();
        }
    }
    public static List<Account> readFile(String path) throws IOException {
        BufferedReader bufferedReader = null;
        List<Account> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 2) {
                    list.add(new Account(str[0], str[1]));
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
