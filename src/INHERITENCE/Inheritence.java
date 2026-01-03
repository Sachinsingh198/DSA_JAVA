package INHERITENCE;

public class Inheritence {
    int i, j;
    void showij(){
        System.out.println("i and j : " + i + " " + j);
    }
}
class Child extends Inheritence{
    int k;
    void showk(){
        System.out.println("k: "+  k);
    }
    void sum(){
        System.out.println(" i + j + k : " + (i + j + k));
    }
}
class SimpleInheritence{
    public static void main(String[] args) {
        Inheritence superOb = new Inheritence();
        Child subOb = new Child();
        superOb.i  = 10;
        superOb.j = 20;
        System.out.println("Contents of superOb: ");
        superOb.showij();
        System.out.println();

        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;
        System.out.println("Contets of subob: ");
        subOb.showij();
        subOb.showk();
        System.out.println();
        System.out.println("Sum of i, j and k , int subOb: ");
        subOb.sum();
        System.out.println();

    }
}
