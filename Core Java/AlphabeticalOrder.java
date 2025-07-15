import java.util.*;

public class AlphabeticalOrder {
    public static void main(String[] args) {    
        Scanner UI = new Scanner(System.in);
        boolean boo=true;
        while (boo) {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                  Words in Alphabetical Order                  |");
        System.out.println("+---------------------------------------------------------------+");
        System.out.println();
        System.out.print(" Enter the sentence you want to arrange words in alphabetical order : ");
        String uSentence = UI.nextLine().trim().toLowerCase();
        String[] myArray = uSentence.split(" ");
        Arrays.sort(myArray);
        System.out.println();
        System.out.println(" The sentence you have entered : ' "+uSentence+" '");
        System.out.println();
        System.out.println("+----------------------------RESULT-----------------------------+");
        System.out.println();
        System.out.print(" Words of given sentence in Alphabetical order : ");
       for(int i=0;i<myArray.length;i++){
        System.out.print(myArray[i]+" ");
       }
       System.out.println();
       System.out.println("+---------------------------------------------------------------+");
       System.out.println();
      System.out.print(" Do you want to rearrange another sentence ?\n\n 1:Yes \n 2:No \n Your selection: ");
      int selection=UI.nextInt();
      if(selection==1){
        boo=true;
      }
      else{
        boo=false;
        System.out.println();
                System.out.println(" Exiting the Alphabetical Order Program. Goodbye!");
                System.out.println("+--------------------------------------------------+");
      }
       UI.close();
    }
    }
}
