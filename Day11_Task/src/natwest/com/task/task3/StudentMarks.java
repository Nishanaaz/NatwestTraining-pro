package natwest.com.task.task3;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks you want to store: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            marks.add(sc.nextInt());
        }

        int max = marks.stream().max(Integer::compareTo).orElseThrow();

        double average = marks.stream().mapToInt(Integer::intValue).average().orElse(0);

        // Printing the max
        System.out.println("Highest: " +max );

        // Printing the average
        System.out.println("Average: " + average);

        System.out.println("3rd student marks: "+marks.get(3-1));
        System.out.println("Sorted Marks: "+marks.stream().sorted().toList());

    }

}
