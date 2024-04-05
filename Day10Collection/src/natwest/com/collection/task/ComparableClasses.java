package natwest.com.collection.task;

import java.util.Comparator;

class ComparableClasses implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
         return (o1.getName().compareTo(o2.getName())) ;
    }
}

//public class ComparableClasses {
//}
