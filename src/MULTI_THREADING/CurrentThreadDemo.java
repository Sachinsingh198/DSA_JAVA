package MULTI_THREADING;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Current Thread: " + t);

        //change the name of the thread
        t.setName("My Thread");
        System.out.println("After changing the name : "+ t);
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.isAlive());

//        System.out.println(t.join());
        try{
            for(int n = 5; n > 0; n--){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            System.out.println("Main thread interrupted!");
        }
        System.out.println(t.isAlive());
    }
}
