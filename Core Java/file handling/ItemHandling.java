import java.util.*;
import java.io.*;

public class ItemHandling {
        public static void main(String[] args)throws IOException,FileNotFoundException {
            File myFile= new File("E:\\KJSIM\\Sem 1\\CJ\\Benjamin_Sebastian_MCA-2024-26_Java (1)\\item.dat");
            Scanner fileLine=new Scanner(myFile);
            int lineno=0;
            while(fileLine.hasNext()){
                lineno++;
                fileLine.nextLine();
            } fileLine.close();

            Scanner fileGet=new Scanner(myFile);
            String[] itemId=new String[lineno];
            String[] itemName=new String[lineno];
            String[] itemQuantity=new String[lineno];
            String[] itemPrice=new String[lineno];
            int ii=0;
while (fileGet.hasNextLine()) {
    String line=fileGet.nextLine();
    StringTokenizer comma=new StringTokenizer(line,",");
    int k=0;
while (comma.hasMoreTokens()) {
    switch (k) {
        case 0:
            itemId[ii]=comma.nextToken();
            break;
        case 1:
            itemName[ii]=comma.nextToken();
            break;
        case 2:
        itemPrice[ii]=comma.nextToken();
        break;
        case 3:
        itemQuantity[ii]=comma.nextToken();
        break;
    
        default:
            break;
    }
    k++;
}
ii++;

}
System.out.println("+-----------------------------------------------------------------------------------+");
System.out.println("|                                   ITEM HANDLING                                   |");
System.out.println("+-----------------------------------------------------------------------------------+");
System.out.println();
System.out.println("+--------------------------------+");
System.out.println("|           Select Menu          |");
System.out.println("+--------------------------------+");
System.out.println("| 1:Search by name               |");
System.out.println("| 2:Display with total cost      |");
System.out.println("| 3:Find Costliest item          |");
System.out.println("+--------------------------------+");
System.out.print(" => Choose(1-3) from menu:");
Scanner ui=new Scanner(System.in);
int selection=ui.nextInt();
switch (selection) {
    case 1:
        search(itemId, itemName, itemPrice, itemQuantity);
        break;
    case 2:
    display(itemId, itemName, itemPrice, itemQuantity);
    break;
    case 3:
    costliest(itemId, itemName, itemPrice, itemQuantity);
        
        break;

    default:
    ui.close();
        break;
}

fileGet.close();
    }
    public static void display(String[] i,String[]n,String[] p,String[] q){
      if(i.length==n.length&&n.length==p.length&&p.length==q.length){
        int sum=0;
for(int k=0;k<i.length;k++){
    if(k==0){
        System.out.println("  +-------------------------------------------------+");

        System.out.println("  |"+i[k]+"   |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],8)+"|"+"Total Cost |");
        System.out.println("  +-------------------------------------------------+");
    }
    else{
        int am=Integer.valueOf(p[k])*Integer.valueOf(q[k]);
        sum+=am;
        System.out.println("  |"+i[k]+" |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],8)+"|"+fill(String.valueOf(am),11)+"|");
        System.out.println("  +-------------------------------------------------+");
        
    }
}
System.out.println("  |                   Total             |"+sum+"     |");
System.out.println("  +-------------------------------------------------+");
          
      }
    }
    public static void search(String[] i,String[]n,String[] p,String[] q){
Scanner ui=new Scanner(System.in);
System.out.print("\n Enter Item Name or Names :");
String name=ui.nextLine().toLowerCase();
StringTokenizer comma=new StringTokenizer(name,",");
String[] fname=new String[comma.countTokens()]; boolean found=false;
int o=0;
while(comma.hasMoreTokens()){
fname[o++]=comma.nextToken().trim();
}

for(int k=0;k<i.length;k++){
    if(k==0){
        System.out.println("  +--------------------------------------+");
        System.out.println("  |"+i[k]+"   |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],9)+"|");
        System.out.println("  +--------------------------------------+");
    }
    else{
       
                
for(int l=0;l<fname.length;l++){
   
    if(fname[l].toLowerCase().equals(n[k].toLowerCase())){   
        System.out.println("  |"+i[k]+" |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],9)+"|");
        found=true;
}

}
}
}
if(!found){System.out.println(" Item/Items '"+name+"' Not Found");}
ui.close();
System.out.println("  +--------------------------------------+");
    }
    public static void costliest(String[] i,String[]n,String[] p,String[] q){
        int a=0;
        for (int k = 1; k < p.length; k++) {
            int b=Integer.valueOf(p[k]);
            if ( b> a) {
                a = b;
            }
        }
        System.out.println("\n Costliest Amount = "+a);
for(int k=0;k<i.length;k++){
    if(k==0){
        System.out.println("\n  +--------------------------------------+");
        System.out.println("  |"+i[k]+"   |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],9)+"|");
        System.out.println("  +--------------------------------------+");
    }
    else if(Integer.valueOf(p[k])==a){
        System.out.println("  |"+i[k]+" |"+fill(n[k],15)+"|"+fill(p[k],6)+"|"+fill(q[k],9)+"|");
        System.out.println("  +--------------------------------------+");

    }
}

    }

    public static String fill(String mys,int i){
  while(mys.length()<i){
    mys+=" ";
  }
        return mys;
    }
    }

