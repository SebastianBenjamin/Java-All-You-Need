import java.util.*;

public class wordReverse {

    public static void main(String[] args) {
        boolean boo = true;
        Scanner uI = new Scanner(System.in);

        while (boo) {
            System.out.println();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|            Word Reverse Program                  |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|     Enter a word or sentence to reverse          |");
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            System.out.print(" Enter your word or sentence: ");
            String gotWord = uI.nextLine().trim();
            String[] myArray = gotWord.split(" ");
            String[] rarray = new String[myArray.length];
            String myVal = "";

            for (int i = 0; i < myArray.length; i++) {
                myVal = "";
                for (int j = myArray[i].length() - 1; j >= 0; j--) {
                    myVal += myArray[i].charAt(j);
                }
                rarray[i] = myVal;
            }

            System.out.println();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                Reversed Output:                  |");
            System.out.println("+--------------------------------------------------+");
            for(int i=(rarray.length-1);i>=0;i--){
                System.out.print(rarray[i]+" ");
            }
            System.out.println();
            System.out.println("+--------------------------------------------------+");

            System.out.println();
            System.out.print(" Do you want to reverse another word or sentence? \n 1: Yes \n 2: No\n Your selection: ");
            int selection = uI.nextInt();
            uI.nextLine();

            if (selection != 1) {
                boo = false;
                System.out.println();
                System.out.println(" Exiting the Word Reverse Program. Goodbye!");
                System.out.println("+--------------------------------------------------+");
            }
        }

        uI.close();
    }
}
