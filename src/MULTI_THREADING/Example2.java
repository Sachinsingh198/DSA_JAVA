package MULTI_THREADING;

//implementing runnable interface
class Demo1 implements Runnable{
    public void run(){
        System.out.println("Thread is running!");
    }
}

public class Example2 {
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        Thread t1 = new Thread(new Demo1());
        t1.start(); //starts the thread
        double timeTaken = (System.nanoTime() - startTime)/ 1_000_000_000.0;
        System.out.println("Time taken: " + timeTaken);
    }
}
