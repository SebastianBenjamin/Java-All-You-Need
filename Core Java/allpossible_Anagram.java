import java.util.Random;
import java.util.Scanner;

public class allpossible_Anagram {
    public static void main(String[] args) {
        Scanner userIn = new Scanner(System.in);
        System.out.print("Enter Word: ");
        String uW = userIn.nextLine();
        Random random = new Random();
userIn.close();
        System.out.println("LENGTH: " + uW.length());
        int factorialvalue = factorial(uW.length());
        System.out.println("Factorial: " + factorialvalue);

        // char[] uW_psbWordArray = new char[factorialvalue];  // Not used, can be removed later
        char[] uW_charArray = new char[uW.length()];
        int[] uW_indArray = new int[uW.length()];
        String[] uW_TindArray = new String[factorialvalue];
        // String pseudoWord = "";

        

        // Fill uW_charArray with characters from the input word
        for (int i = 0; i < uW.length(); i++) {
            uW_charArray[i] = uW.charAt(i);
        }

        // Loop to generate random indices and permutations
        for (int i = 0; i < factorialvalue; i++) {
            // Reset uW_indArray for each permutation
            for (int ii = 0; ii < uW.length(); ii++) {
                int randomIndex;
                boolean isUnique;
                
                // Ensure the randomIndex is unique for this permutation
                do {
                    randomIndex = random.nextInt(uW.length());
                    isUnique = true;
                    for (int iii = 0; iii < ii; iii++) {
                        if (uW_indArray[iii] == randomIndex) {
                            isUnique = false;
                            break;
                        }
                    }
                } while (!isUnique);
                
                uW_indArray[ii] = randomIndex;
            }

            // Convert uW_indArray to a string and store it if it's unique
            String currentPermutation = getPermutation(uW_indArray, uW_charArray);
            boolean alreadyExists = false;

            // Check if the permutation already exists in uW_TindArray
            for (int f = 0; f < i; f++) {
                if (uW_TindArray[f] != null && uW_TindArray[f].equals(currentPermutation)) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                uW_TindArray[i] = currentPermutation;
            } else {
                i--;  // If duplicate, retry for this slot
            }
        }

        // Print the generated permutations
        for (int i = 0; i < uW_TindArray.length; i++) {
            if (uW_TindArray[i] != null) {
                System.out.println("        "+ uW_TindArray[i]);
            }
        }

        System.out.println("uW_TindArray length: " + uW_TindArray.length);
    }

    // Helper function to get the permutation string from indices
    static String getPermutation(int[] indices, char[] chars) {
        StringBuilder result = new StringBuilder();
        for (int index : indices) {
            result.append(chars[index]);
        }
        return result.toString();
    }

    // Factorial function
    static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
