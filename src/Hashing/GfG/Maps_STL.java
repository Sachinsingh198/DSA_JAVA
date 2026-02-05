package Hashing.GfG;

import java.util.HashMap;

public class Maps_STL {
    public static void main(String[] args) {
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("Sachin", 20); map.put("Aditya", 19);
        map.put("Vivek", 17); map.put("Deepika", 25);
        System.out.println(map + " " + map.size());
        System.out.println(map.remove("Vivek"));
        System.out.println(map.get("Sachin"));
        map.put("Aditya", 21);
        System.out.println(map + " " + map.size());
        System.out.println(map.containsKey("Vivek"));
    }
}
