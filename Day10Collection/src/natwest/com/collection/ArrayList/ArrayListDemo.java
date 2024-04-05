package natwest.com.collection.ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args){
        ArrayList obj = new ArrayList<>();
        obj.add(1);
        obj.add(2);
        System.out.println(obj);

        ArrayList<Integer> obj1 = new ArrayList<>(11);
        obj1.add(8);
        obj1.add(18);
        obj1.add(81);
        obj1.add(181);
        obj1.add(811);
        obj1.remove(Integer.valueOf(8));
        System.out.println(obj1.size());



        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("PineApple");
        fruits.add(1,"Guava");
        System.out.println(fruits);
        System.out.println(fruits.contains("Apple"));
        System.out.println(fruits.set(0,"Papaya"));


        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);


        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(1);
        nums2.add(2);
        nums2.add(3);
        nums2.add(4);
        nums2.add(5);


        //RetainAll;
        System.out.println("Elements of nums: "+nums);
        System.out.println("Elements of num2: "+nums2);

        nums.addAll(nums2);
        System.out.println(nums);
        nums.removeAll(nums2);
        System.out.println("after remove "+nums);

        nums.retainAll(nums2);

    }
}
