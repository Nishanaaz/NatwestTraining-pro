package natwest.com.collection.task;

import java.util.Objects;

public class Employee implements  Comparable<Employee>{
    String name;
    String employeeId;
    int salary;
    String dept;
    int age;

    public Employee(String name, String employeeId, int salary,String dept,int age) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
        this.dept = dept;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Employee =  [" +
                "name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", salary=" + salary +
                ']';
    }

    @Override
    public int compareTo(Employee o) {
        if(this.age>o.age) return 1;
        else if(this.age<o.age) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(employeeId, employee.employeeId) && Objects.equals(dept, employee.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employeeId, salary, dept, age);
    }
}
