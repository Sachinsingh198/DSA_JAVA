package Hashing.GfG;

import java.util.HashSet;

public class Sest_STL {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(77); set.add(65); set.add(21); set.add(2);
        set.add(11); set.add(45); set.add(3); set.add(18);
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(set.contains(21));
        System.out.println(set.contains(190));
        set.remove(21);
        System.out.println(set.contains(21));
    }
}
