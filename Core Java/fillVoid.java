import java.util.*;

public class fillVoid{

    public static void main(String[] args) {
        boolean boo = true;
        Scanner uI = new Scanner(System.in);

        while (boo) {
            System.out.println();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|            Fill Void Program (Word Filler)       |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|     Enter a word (Max length: 20 characters)     |");
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            System.out.print(" Enter your word: ");
            String gotWord = uI.nextLine().trim();
            System.out.print(" What character you want to fill in void spaces ? : ");
            String gotChar=uI.nextLine();
            if (gotWord.length() > 20) {
                System.out.println();
                System.out.println(" Character limit exceeds 20! Please try again.");
            } else {
                char[] myChars = new char[20];
                for (int i = 0; i < 20; i++) {
                    if (i < gotWord.length()) {
                        myChars[i] = gotWord.charAt(i);
                    } else {
                        myChars[i] = gotChar.charAt(0); 
                    }
                }
                String outPut= new String(myChars);
                System.out.println();
                System.out.println(" Length of the Word ' "+gotWord+" ' is : "+gotWord.length());
                System.out.println();
                System.out.println("+---------------------------------------------------+");
                System.out.println("|                 Filled Output:                    |");
                System.out.println("|               " +outPut + "                |");
                System.out.println("+---------------------------------------------------+");
                System.out.println();
            }

           
            System.out.print(" Do you want to fill another word? \n 1: Yes \n 2: No \n Your selection: ");
            int selection = uI.nextInt();
            uI.nextLine();
            if (selection != 1) {
                boo = false;
                System.out.println();
                System.out.println("Exiting the Fill Void Program. Goodbye!");
                System.out.println("+---------------------------------------------------+");
            }
        }

        uI.close();
    }
}

