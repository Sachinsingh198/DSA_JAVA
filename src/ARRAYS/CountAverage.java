package ARRAYS;
import java.util.*;
public class CountAverage {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList("Hindi", "English", "Science", "Mathematics", "Social Science"));
        for(String subject : subjects){
            System.out.print("Enter marks obtained in " + subject + ": " );
            int el = scr.nextInt();
            marks.add(el);
        }
        int average = 0;
        int total = 0;
        for(int mark: marks){
            total += mark;
        }
        average = total / 5;
        System.out.println("Average marks: " + average);
        
    }
}
