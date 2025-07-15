import java.util.*;

public class reverseProgram {
    public static void main(String[] args) {
        boolean boo = true;
        Scanner uI = new Scanner(System.in);

        while (boo) {
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                Sentence Reverser                 |");
            System.out.println("+--------------------------------------------------+");
            System.out.print(" Enter a sentence: ");
            String sentence = uI.nextLine();
            System.out.println();

            StringTokenizer space = new StringTokenizer(sentence, " ");
            String arrayOfWords="";
           
            
            while (space.hasMoreTokens()) {
                arrayOfWords += space.nextToken()+" ";
               
            }
          
            System.out.print(" Reversed sentence: "+  reverse(arrayOfWords));
            
          
System.out.println("\n");
            System.out.print(" Do you want to reverse another sentence?\n 1: Yes \n 2: No \n Your selection : ");
            int selection = uI.nextInt();
            uI.nextLine();
            if (selection != 1) {
                boo = false;
                System.out.println();
                System.out.println(" Exiting the Reverse program!");
            System.out.println("+--------------------------------------------------+");

            }
        }
    }

    public static String reverse(String gotString) {
        StringTokenizer space = new StringTokenizer(gotString, " ");
        String[] arrayOfWords=new String[space.countTokens()];
        int count=0;
        while (space.hasMoreTokens()) {
            arrayOfWords[count++]= space.nextToken();
        }
        
        String outString="";
        for (int i = arrayOfWords.length - 1; i >= 0; i--) {
            outString+= arrayOfWords[i]+" "; 
        }
        return outString;
    }
}
