
package MULTI_THREADING.ImplementingRunnable;

class NewMultiThread implements Runnable{
    Thread t;
    String threadname;
    NewMultiThread(String threadname){
        this.threadname = threadname;
        t = new Thread(this, threadname);
        System.out.println("NewMulti Thread: " + t);
        t.start();
    }
    public void run(){
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(threadname + " : " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println(threadname + " interrupted!");
        }
        System.out.println(threadname + " Exiting......");
    }
}
public class MultiThread {
    public static void main(String[] args) {
        NewMultiThread ob1 = new NewMultiThread("One"); //create a new thread
        NewMultiThread ob2 = new NewMultiThread("Two");
        NewMultiThread ob3 = new NewMultiThread("Three");
        System.out.println("Thread One is alive: "+ ob1.t.isAlive());
        System.out.println("Thread Two is alive: "+ ob2.t.isAlive());
        System.out.println("Thread Three is alive: "+ ob3.t.isAlive());

        //wait for thread to finish
        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        }catch(InterruptedException e){
            System.out.println("Main Thread Interrupted!");
        }
        System.out.println("Thread One is alive: "+ ob1.t.isAlive());
        System.out.println("Thread Two is alive: "+ ob2.t.isAlive());
        System.out.println("Thread Three is alive: "+ ob3.t.isAlive());
        System.out.println("Main Thread exiting....");
    }
}
