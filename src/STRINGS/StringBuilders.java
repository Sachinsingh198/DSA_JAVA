package STRINGS;

public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("String");
        System.out.println(s);
        s.append("Builder");
        System.out.println(s);
        System.out.println(s.length() + " "+ s.capacity());
        s.setCharAt(3,'o');
        System.out.println(s);
    }
}
