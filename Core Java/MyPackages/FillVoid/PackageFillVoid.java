package MyPackages.FillVoid;
import java.util.*;
public class PackageFillVoid {
    public  void FillVoid() {
 
        Scanner uI = new Scanner(System.in);


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
            
            }

           
         
                
            
      

        
    }
}
