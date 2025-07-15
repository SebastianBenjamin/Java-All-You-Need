package MyPackages.RemoveIdentical;
import java.util.*;
public class PackageRemoveIdentical{
    public  void RemoveIdentical() {
    
        
            Scanner UI =new Scanner(System.in);
        System.out.println("+----------------------------------------+");
        System.out.println("| Consecutve Identical Character Remover |");
        System.out.println("+----------------------------------------+");
        System.out.println();
        System.out.println(" Enter the Sentence you want to remove Consecutve identical charachters :");
        System.out.println();
        String sentence = UI.nextLine();
        System.out.println();
        System.out.println(" The Sentence you have Entered is : '" +sentence.trim()+"'");
        System.out.println();
        String result="";
        System.out.println(" Length of the Sentence you have Entered is : '" +sentence.trim().length()+"'");
    System.out.println();
    
    if(sentence.trim().length()>0){
        for(int i=0;i<sentence.length();i++){
        if(i==0){
            result+=sentence.charAt(i);
        }
        else{
       if(sentence.charAt(i)!=sentence.charAt(i-1)){
        result+=sentence.charAt(i);
       }
        }}
        System.out.println(" Result with removed all the Consecutve identical characters : '"+result+"'");
        
        System.out.println();
        System.out.println("+--------------------------------------------------+");
       
        
     } 
    else{
        System.out.println();
        System.out.println("*************** Empty Input ! **************");
        System.out.println();
    }
    }
}