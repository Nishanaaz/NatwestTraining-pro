package natwest.com.collection.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<String> bag1 = new ArrayList<>(Arrays.asList());
        bag1.add("Biscuit");
        bag1.add("Lays");
        bag1.add("Ice-cream");
        bag1.add("Biryani");
        bag1.add("Chapatti");

        ArrayList<String> bag2 = new ArrayList<>(Arrays.asList());
        bag2.add("Biscuit");
        bag2.add("Lays");
        bag2.add("Ice-cream");
        bag2.add("Biryani");
        bag2.add("Chapatti");
        bag2.add("Chai");
        bag2.add("SoftDrink");


        bag1.removeAll(bag2);
        bag1.addAll(bag2);

        System.out.println("Elements of bag1: "+bag1);
        Collections.sort(bag1);

        }

}
