package STRINGS;

public class ReverseStringBuilder {
    public static void main(String[] args) {
        String s = "Devesh";
        StringBuilder sb = new StringBuilder(s);
        sb.append(" Jain");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}
