package INHERITENCE;
//A Simple demonstration of abstract
abstract class Abs
{
    abstract void callMe();  // an abstract method
    void callMeToo(){
        System.out.println("This the concrete Method");
    }
}

class Derived extends Abs{
    void callMe(){
        System.out.println("B's implementation of callMe");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        Derived b = new Derived();
        b.callMe();
        b.callMeToo();
    }
}
