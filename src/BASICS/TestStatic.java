package BASICS;
/**Demonstrates Static variables, methods and blocks*/
public class TestStatic {
    static int a = 3;
    static int b;
    static void meth(int x){
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    static{
        System.out.println("Static box initialized!");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}
