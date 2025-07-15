import java.util.*;
 public class gramAna{
  
  public static void main(String[]args){

  Random ran= new Random();

  Scanner uI=new Scanner(System.in);

  System.out.print(" Enter Word : ");

  String word=uI.nextLine().trim();

  char[] words=new char[word.length()];

 int len=word.length();

 int factval=1;
 
for (int i=len;i>0;i--){

factval*=i;

}

System.out.println("Factorial : "+factval);

  for(int i=0;i<word.length();i++){

          words[i]=word.charAt(i);

    }


 System.out.println(words);

   }
 }