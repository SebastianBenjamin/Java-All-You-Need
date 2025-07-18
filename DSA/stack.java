import java.util.*;
public class stack {
    public static void main(String[] args) {
      Scanner ui =new Scanner(System.in);
      String expression=ui.nextLine();
      String result="";
      ArrayList<Character> list=new ArrayList<>();
      for(int i=0;i<expression.length();i++){
        char character=expression.charAt(i);
        if(Character.isAlphabetic(character)){
          result+=String.valueOf(character);
        }else{
          if(character=='('&&list.contains(')')||list.contains('(')&&character==')'){
            list.clear();
          }else if(character=='['&&list.contains(']')||list.contains('[')&&character==']'){
             
            list.clear();
          }else if(character=='{'&&list.contains('}')||list.contains('{')&&character=='}'){
              
            list.clear();
          }else{
            list.add(character);
          }
        }
      }
      System.out.print(result );
       list.forEach(System.out::print);
    }    
}
