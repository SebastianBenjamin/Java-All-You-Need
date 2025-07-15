import java.util.*;
public class identicalReplace {
     public static void main(String[] args) {
    
    boolean boo=true;
    while(boo){
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
    System.out.println("------------------------------------------");
    System.out.println();
    System.out.println(" Select Options :\n 1:Check new sentence or String\n 2:Exit\n Select an option from above to continue.");
    int Select=UI.nextInt();
    System.out.println();
    System.out.println("------------------------------------------");
    if(Select==1){boo=true; System.out.println(" Selected : Check new Sentence");}
    else{boo=false; System.out.println(" Selected : Exit");
    UI.close();
}
    System.out.println();
    
 } 
else{
    System.out.println();
    System.out.println("*************** Empty Input ! **************");
    System.out.println();
}
}}
}
