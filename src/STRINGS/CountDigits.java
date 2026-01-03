package STRINGS;

public class CountDigits {
    public static void main(String[] args) {
        int n = 1000;
        String s = "";
        s += n;
        System.out.println(s.length());
        Double d = 0000.45325;
        String dn = "" + d;
        System.out.println(dn.length());

        int n1 = Integer.parseInt(s);
        System.out.println(n1);
    }
}
