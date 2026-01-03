package Hashing.HashMap;

import java.util.HashMap;
import java.util.Set;

public class HashhingUsingMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

//        System.out.println(map);
//
//        map.put("China", 180);
//        System.out.println(map);
//        System.out.println(map.get("India"));
//        System.out.println(map.containsKey("China"));
//
//        for(String el : map.keySet()){
//            System.out.println(el  + " "  + map.get(el));
//        }
//        System.out.println();
//        for(HashMap.Entry<String, Integer> e :map.entrySet()){
//            System.out.println(e.getKey() + " : " + e.getValue() );
//        }
//
//        Set<String> keys = map.keySet();
//        for(String key : keys){
//            System.out.println(key + " : " + map.get(key));
//        }

        map.remove("China");
        System.out.println(map);
    }
}
