package STRINGS;

public class PassingStringToMethod {
    public static void change(String x){
        x = "Singh";
        System.out.println(x);
        return;
    }
    public static void main(String[] args) {
        String x = "Sachin";
        System.out.println(x);

        change(x);
        System.out.println(x);
    }
}
