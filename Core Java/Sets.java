import java.util.*;

public class Sets{
   
    public static void main(String[]args){
    int ui,no;
    int setValues[];
    String allSets[];
    int allmax[];
    boolean boo=true;
    Scanner UserIn=new Scanner(System.in);
    while(boo){
    System.out.println();
    System.out.println("+-----------------------------------------------------+");
    System.out.println("|           Create & find maximum value in SETS       |");
    System.out.println("|-----------------------------------------------------|");
    System.out.println("|          Note: Values should be an Integer          |");
    System.out.println("+-----------------------------------------------------+");

    System.out.println();
    System.out.print(" Enter how many Sets you want to create : ");
    ui=UserIn.nextInt();
    System.out.println();
    allSets=new String[ui];
    allmax=new int[ui];
  for(int i=0;i<ui;i++){
    System.out.println();
     System.out.print(" Enter total number of values for Set "+ (i+1) +" : ");
    no=UserIn.nextInt();
   setValues= new int[no];    
   

     for(int j=0;j<no;j++){
      System.out.println();
     System.out.print("  -> Enter Value-"+(j+1)+" of Set "+(i+1)+" : ");
setValues[j]=UserIn.nextInt();
        }

maxval newar=new maxval();
allSets[i]=Arrays.toString(setValues);
allmax[i]=newar.maxmum(setValues,no);

 }
 System.out.println();
 System.out.println("+------------------------------------------Result-----------------------------------------+");
 for(int i=0;i<allSets.length;i++){
  System.out.println();
  System.out.println(" Set "+(i+1)+" : "+allSets[i].replace('[', '{').replace(']', '}'));
  System.out.println();
  System.out.println(" Largest Integer in Set "+(i+1)+" : "+allmax[i]);
  System.out.println();
 }
 System.out.println("+-----------------------------------------------------------------------------------------+");
System.out.println();
System.out.print(" Do you want to create and check more Sets \n 1: Yes \n 2: No\n Your selection : ");
ui=UserIn.nextInt();
if(ui!=1){
  boo=false;
  System.out.println();
                System.out.println(" Exiting the Sets Program. Goodbye!");
                System.out.println("+--------------------------------------------------+");
                UserIn.close();
              }
             
            }
    }
 }

class maxval{

static int maxmum(int arey[],int len){  
Arrays.sort(arey);

 return arey[len-1];
}
}