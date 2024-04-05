package natwest.com.collection.streamApi;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreamApi {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for(int num: nums){
            if(num%2==0)
            System.out.println(num);
        }

        System.out.println("Stream Api-----------------------------------");
        nums.stream().filter(n->n%2==0).forEach(s-> System.out.println(s));


        Collections.sort(nums);  //we can sort easily as implementation has already defined.



    }
}
