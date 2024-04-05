package natwest.com.task.task1;

import natwest.com.task.task1.Wrestler;
import natwest.com.task.task1.WrestlerImplementation;

import java.util.ArrayList;

public class WrestlerMain {
    public static void main(String[] args) {
        ArrayList<Wrestler> wrestlers = new ArrayList<>();
        wrestlers.add(new Wrestler(10,"Rahul",220,7,43));
        wrestlers.add(new Wrestler(11,"Nisha",100,5,50));
        wrestlers.add(new Wrestler(12,"Ankit",290,8,60));
        wrestlers.add(new Wrestler(13,"Priyanka",56,9,70));
        wrestlers.add(new Wrestler(14,"Sohit",168,6,63));
        wrestlers.add(new Wrestler(15,"Preeti",92,7,83));
        wrestlers.add(new Wrestler(16,"Vanshika",180,10,63));

        WrestlerImplementation wrestlerImplementation = new WrestlerImplementation();

        System.out.println("..........Count Of Wrestlers.....................................");
        System.out.println(wrestlerImplementation.countAllWrestler(wrestlers));
        System.out.println();

        System.out.println("............count Of All Wrestler Whose Weight Is Greater Than 200...........................");
        System.out.println(wrestlerImplementation.countOfAllWrestlerWhoseWeightIsGreaterThan200(wrestlers));
        System.out.println();

        System.out.println("....display All Wrestler Base On Height In Descending Order.....................");
        System.out.println(wrestlerImplementation.displayAllWrestlerBaseOnHeightInDescendingOrder(wrestlers));
        System.out.println();

        System.out.println(".......find All the Name Starts With S..................... ");
        System.out.println(wrestlerImplementation.findAlltheNameStartsWithS(wrestlers));
        System.out.println();

        System.out.println("......display All Wrestler In Ascending Whose Weight Greater Than 150..................");
        System.out.println(wrestlerImplementation.displayAllWrestlerInAscendingWhoseWeightGreaterThan150(wrestlers));
    }
}
