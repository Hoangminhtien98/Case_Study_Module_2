package _Manager;

import _Model.Employee;

import java.util.Comparator;

public class SortEmp implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
