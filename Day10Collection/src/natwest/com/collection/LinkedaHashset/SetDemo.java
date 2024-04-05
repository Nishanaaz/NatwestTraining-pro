package natwest.com.collection.LinkedaHashset;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("Nisha");
        stringHashSet.add("Muskan");
        stringHashSet.add("Alisha");
        stringHashSet.add("Aaisha");
        System.out.println(stringHashSet);

        LinkedHashSet<String> stringLinkedHashSet = new LinkedHashSet<>();
        stringLinkedHashSet.add("Nisha");
        stringLinkedHashSet.add("Muskan");
        stringLinkedHashSet.add("Alisha");
        stringLinkedHashSet.add("Aaisha");
        System.out.println(stringLinkedHashSet);

        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.add("Nisha");
        stringTreeSet.add("Muskan");
        stringTreeSet.add("Alisha");
        stringTreeSet.add("Aaisha");
        System.out.println(stringTreeSet);

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Nisha",1);
        hashMap.put("Muskan",2);
        hashMap.put("Alisha",3);
        hashMap.put("Fareen",4);
        System.out.println(hashMap);

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("Nisha",1);
        treeMap.put("Muskan",2);
        treeMap.put("Alisha",3);
        treeMap.put("Fareen",4);
        System.out.println(treeMap);

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Nisha",1);
        linkedHashMap.put("Muskan",2);
        linkedHashMap.put("Alisha",3);
        linkedHashMap.put("Fareen",4);
        System.out.println(linkedHashMap);

    }
}
