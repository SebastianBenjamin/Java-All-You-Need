package MyPackages.ReverseWordByWord;
import java.util.*;
public class PackageReversewbw {
    public  void ReverseWordByWord() {
     
        Scanner uI = new Scanner(System.in);


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
            
          
                System.out.println();
               
            System.out.println("+--------------------------------------------------+");

           
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
