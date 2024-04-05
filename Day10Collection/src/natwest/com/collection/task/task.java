package natwest.com.collection.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rahul","232",324,"hr",12));
        employees.add(new Employee("Jhanvi","234",324,"hr",13));
        employees.add(new Employee("Deepika","23231232",3412,"manager",15));
        employees.add(new Employee("Deepa","232132",32489,"manager",17));
        employees.add(new Employee("Nisha","231232",89412,"manager",34));

//        Collections.sort(employees);
//        employees.forEach(System.out::println);

        Collections.sort(employees,new ComparableClasses());
        employees.forEach(System.out::println);

//        for(Employee i: employees){
//            System.out.println(i);
//        }
//
//        System.out.println("using foreach--------------------------------");
//        employees.forEach(e-> System.out.println(e));
//
//        System.out.println("Using Method reference.......................");
//        employees.forEach(System.out::println);
//
//
//        System.out.println("Filter manager department........................");
//        employees.stream().filter(e->e.getDept().equalsIgnoreCase("manager")).forEach(System.out::println);
//
//        System.out.println("Count of hr department...............................");
//        long countOfHr = employees.stream().filter(e->e.getDept().equalsIgnoreCase("hr")).count();
//        System.out.println("Count of hr: "+countOfHr);
//
//
//        System.out.println("................................................................");
//        System.out.println("Manager increase by 10 percent and want to collect the it as list");
//        employees.stream().filter(e->e.getDept().equalsIgnoreCase("manager"))
//                .map(e->e+" "+e.getSalary()+e.getSalary()*0.10).forEach(System.out::println);
//
//
//        System.out.println("Salary greater than 30000...............................");
//        List<Employee> employeeList = employees.stream().filter(e->e.getSalary()>30000).collect(Collectors.toList());
//        employeeList.forEach(System.out::println);
//
//        System.out.println("hr department employees name only....................................................");
//        employees.stream().filter(e->e.getDept().equalsIgnoreCase("hr")).map(e->e.getName()).forEach(System.out::println);
//
//
//        System.out.println("Sorting the employee by age if salary is same then by name");
//        employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);
//
//
//        System.out.println("reverse sorted...................................................................");
//        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
//

    }
}
