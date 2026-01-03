package EXPERIMENT;
import java.util.Scanner;

public class CalculateAge {
    private static int daysInMonth(int month, int year) {

        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 1) { // February is at index 1
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return 29; // Leap year
            }
        }
        return daysInMonths[month];
    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int[] dob = new int[3] ;
        System.out.print("Enter the date of Birth: ");
        dob[0] = scr.nextInt();
        System.out.print("Enter the month of Birth: ");
        dob[1] = scr.nextInt();
        System.out.print("Enter the year of Birth: ");
        dob[2] = scr.nextInt();

        System.out.println("Enter Today's date");
        int[] presentDate = new int[3] ;
        System.out.print("Enter date: ");
        presentDate[0] = scr.nextInt();
        System.out.print("Enter month: ");
        presentDate[1] = scr.nextInt();
        System.out.print("Enter year: ");
        presentDate[2] = scr.nextInt();

        int[] age = new int[3];

        age[0] = presentDate[2] - dob[2];  //years

        if (presentDate[1] < dob[1] || (presentDate[1] == dob[1] && presentDate[0] < dob[0])) {
            age[0]--;
        }

        age[1] = presentDate[1] - dob[1]; //month
        if (presentDate[1] < dob[1]) {
            age[1] += 12;
        }

        age[2] = presentDate[0] - dob[0];  //years
        if (presentDate[0] < dob[0]) {
            age[1]--;
            age[2] += daysInMonth(presentDate[1] - 1, presentDate[2]);
        }

        System.out.println("Your age is: " + age[0] + " years, " + age[1] + " months, and " + age[2] + " days.");
    }

}