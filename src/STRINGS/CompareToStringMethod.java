package STRINGS;

public class CompareToStringMethod {
    public static void main(String[] args) {
        String a = "raghav";
        String b = "preet";
        System.out.println(a.compareTo(b));// r - p

        String s = "harmeet";
        String t = "harsh";
        System.out.println(s.compareTo(t)); // m - s

        String x = "harshitam";
        String y = "harsh";
        System.out.println(x.compareTo(y));// y is the substring of x, therfore here the number of remaining characters in the string x will be printed

        System.out.println(('a' - 'b'));
    }
}
