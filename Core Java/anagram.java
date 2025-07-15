import java.util.*;

public class anagram {
    public static void main(String[] args) {
        boolean boo = true;
        Scanner uI = new Scanner(System.in);

        while (boo) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                Anagram Checker                   |");
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            System.out.print(" Enter Word 1: ");
            String word1 = uI.nextLine().trim();
            System.out.println();
            System.out.print(" Enter Word 2: ");
            String word2 = uI.nextLine().trim();

            System.out.println();
            if (word1.length() == word2.length()) {
                char[] Ar1 = word1.toCharArray();
                char[] Ar2 = word2.toCharArray();

                Arrays.sort(Ar1);
                Arrays.sort(Ar2);

                if (Arrays.equals(Ar1, Ar2)) {
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("|           The words are anagrams!                |");
                    System.out.println("+--------------------------------------------------+");
                } else {
                    System.out.println("+--------------------------------------------------+");
                    System.out.println("|        The words are NOT anagrams!               |");
                    System.out.println("+--------------------------------------------------+");
                }
            } else {
                System.out.println("+--------------------------------------------------+");
                System.out.println("|      The words are NOT anagrams (unequal length) |");
                System.out.println("+--------------------------------------------------+");
            }
            System.out.println();
            System.out.print(" Do you want to check more words for anagrams? \n 1: Yes \n 2: No\n Your selection: ");
            int selection = uI.nextInt();
            uI.nextLine();
            if (selection != 1) {
                boo = false;
                System.out.println();
                System.out.println(" Exiting the Anagram Checker Program. Goodbye!");
                System.out.println("+--------------------------------------------------+");
            }
            uI.close();
        }
    }
}
