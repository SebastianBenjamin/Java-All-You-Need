import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        boolean boo = false;

        System.out.println("\n+--------------------------------------------------+");
        System.out.println("|                Palindrome Checker                |");
        System.out.println("+--------------------------------------------------+");
        System.out.print("\nEnter a  Word to check whether it is a palindrome or not : ");
        String word = ui.nextLine();
        char[] Arr = new char[word.length()];
        char[] Arr_rev = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            Arr[i] = word.toLowerCase().charAt(i);
            Arr_rev[((word.length() - 1) - i)] = word.toLowerCase().charAt(i);
        }

        for (int i = 0; i < word.length(); i++) {
            if (Arr[i] == Arr_rev[i]) {
                boo = true;
            } else {
                boo = false;
                break; 
            }
        }

 System.out.println("\n+--------------------------------------------------+");

        if (boo) {
            System.out.println("\nWord '" + word + "' is a Palindrome");
        } else {
            System.out.println("\nWord '" + word + "' is not a Palindrome");
        }

        System.out.println("\n+--------------------------------------------------+");
        ui.close();
    }
}
