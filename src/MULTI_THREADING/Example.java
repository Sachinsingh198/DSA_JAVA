package MULTI_THREADING;

//extending to thread class

class Demo extends Thread{
    public void run(){
        System.out.println("Thread is Running");
    }
}
public class Example {
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        Demo t1 = new Demo();
        t1.start(); //starts the thread
        double timeTaken = (System.nanoTime() - startTime)/ 1_000_000_000.0;
        System.out.println("Time taken: " + timeTaken);
     }
}
