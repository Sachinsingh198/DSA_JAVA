package INHERITENCE;

/*Dynamic Method Dispatch*/
class A{
    void callMe(){
        System.out.println("Inside class A's method");
    }
}

class B extends A{
    void callMe(){
        System.out.println("Inside class B's method");
    }
}

class C extends A{
    void callMe(){
        System.out.println("Inside class C's method");
    }
}

public class Dispatch {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        A r;
        r = a;
        r.callMe();

        r = b;
        r.callMe();

        r = c;
        r.callMe();
    }
}
