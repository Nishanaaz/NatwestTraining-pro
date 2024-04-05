package natwest.com.collection.list;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ListClass {
    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>();
         fruits.add("apple");
         fruits.add("banana");
         fruits.addFirst("pineapple");
         fruits.addLast("Pomegranate");
         System.out.println(fruits);

    }
}
