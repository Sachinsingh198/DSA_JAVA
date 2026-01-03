package STRING;
// Using
public class VarArgs2 {
    static void varTest(String msg, int ... v){
        System.out.print(msg + v.length + " Contents: ");
        for(int x: v){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        varTest("One vararg: ", 10);
        varTest("Three varargs: ", 1,2,3);
        varTest("No varargs: ");
    }
}
