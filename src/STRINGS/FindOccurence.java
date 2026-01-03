package STRINGS;
import java.util.Scanner;
/*To find the occurence of each character in java*/
public class FindOccurence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine().toLowerCase(); // Convert input to lowercase for simplicity

        int vowels = 0, consonants = 0, digits = 0, spaces = 0, others = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': // Vowel cases
                    vowels++;
                    break;
                case 'b':
                case 'c':
                case 'd':
                case 'f':
                case 'g':
                case 'h':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z': // Consonant cases
                    consonants++;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': // Digit cases
                    digits++;
                    break;
                case ' ': // Space case
                    spaces++;
                    break;
                default: // Any other character
                    others++;
                    break;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Spaces: " + spaces);
        System.out.println("Other characters: " + others);
    }
}
