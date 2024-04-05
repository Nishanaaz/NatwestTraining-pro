package natwest.com.collection.LinkedaHashset;

import natwest.com.collection.task.Employee;

import java.util.HashSet;

public class LinkedHashSetSet {

    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();
        strings.add("Nisha");
        strings.add("Muskan");
        strings.add("Nisha");
        System.out.println(strings);

        HashSet<Employee> employeesHashSet = new HashSet<>();
        employeesHashSet.add(new Employee("Rahul","232",324,"hr",12));
        employeesHashSet.add(new Employee("Rahul","232",324,"hr",12));
        System.out.println(employeesHashSet);


    }
}
