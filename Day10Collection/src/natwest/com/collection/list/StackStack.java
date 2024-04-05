package natwest.com.collection.list;

import java.util.Stack;

public class StackStack {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("apple");
        names.add("Jaanki");
        names.push("Fareen");
        names.push("Nisha");
        names.peek();
        names.pop();
        System.out.println(names);
    }
}
