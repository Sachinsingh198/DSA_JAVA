package STRING;
/*Demonstrates variable length arguments*/
public class VarArgs {
    static void varTest(int ... v){
        System.out.println("Number of arguments: " + v.length + " Contents");
        for(int x : v){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //Notice how varTest() can be called with a variable number of arguments
        varTest(10); // 1 arg
        varTest(1,2,3); // 3 arg
        varTest(); // no arg
     }
}
