package MULTI_THREADING.ExtendingThread;

class NewThread extends Thread{
    NewThread(){
        super("Demo Thread");
        System.out.println("Child Thread: " + this);
        start();
    }
    public void run(){
        try{
            for(int i = 5; i> 0; i--){
                System.out.println("Child Thread: " + i);
                Thread.sleep(5000);
            }
        }catch(InterruptedException e){
            System.out.println("Child Interrupted");
        }
        System.out.println("Exiting Child Thread.....");
    }
}


public class ExtendThread {
    public static void main(String[] args) {
        new NewThread();
        try{
            for(int i = 5; i> 0; i--){
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Main Thread Interrupted!");
        }
        System.out.println("Exiting Main thread.....");
    }
}
