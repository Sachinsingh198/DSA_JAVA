package MULTI_THREADING.Synchronization;

class CallMe{
    synchronized void call(String msg){
        System.out.print(" [" + msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("Interrupted!");
        }
        System.out.println("] ");
    }
}

class Caller implements Runnable{
    String msg;
    CallMe target;
    Thread t;
    public Caller(CallMe target, String msg){
        this.target = target;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        target.call(msg);
    }
}
public class Sync {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World!");

        // wait for thread
        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }
        catch(InterruptedException e){
            System.out.println("Interrupted!");
        }
    }
}
