package OOPS;
import java.util.Scanner;
public class studentClass {
    //Creating a new data type

    public static void main(String args[]) {
        System.out.println("Hello World!");
        student s = new student();
        s.rln = 16;
        s.percent = 89.22;
        s.name = "Sachin singh";
        System.out.println("Name : "+ s.name + "\nRln: " + s.rln + "\npercent: "+ s.percent);

        Scanner sc = new Scanner(System.in);
        student s2 = new student("Sachin", 45, 76);
//        s2.name = sc.next();
//        s2.rln = sc.nextInt();
//        s2.percent = sc.nextInt();

        System.out.println(s2.count);
        System.out.println(student.count);
    }
}
