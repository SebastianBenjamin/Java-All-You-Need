import java.util.*;

public class PasswordChecker{

public static void main(String[]args){
 	
	Scanner ui=new Scanner(System.in);
boolean boo=true;
while(boo){
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                 Password Checker                 |");
        System.out.println("+--------------------------------------------------+");
System.out.println();
System.out.print("Enter your Password : ");

        String uspsw=ui.nextLine().toLowerCase().trim();
        if(PasswordCheck(uspsw)){
                System.out.println("           ++++ Password is valid ! ++++");
                System.out.println("                    -----");
                System.out.println("                   |     |");
                System.out.println("                   |      ");
                System.out.println("                   |_____ ");
                System.out.println("                  ||     ||");
                System.out.println("                  ||  0  ||");
                System.out.println("                    -----");
        }
else{
        System.out.println("        ****** Password is not valid! ******");
        display();
}	

System.out.println("\n+--------------------------------------------------+\n");

   System.out.print("Do you want to check another password ? \n 1: Yes\n 2: No\nYour Selection : ");
            int selection = ui.nextInt();
ui.nextLine();
            if (selection != 1) {
                boo = false;
        System.out.println("+--------------------------------------------------+");
                System.out.println("      Exiting the Program. Thank you!");
        System.out.println("+--------------------------------------------------+");

            }
        }

ui.close();
}
public static boolean PasswordCheck(String uspsw){
  int uspswlen=uspsw.length();
        
                char[] alphabets={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                char[] numbers={'0','1','2','3','4','5','6','7','8','9'};
                char[] charac={' ','!','@','#','&','~','$','*',':','.','-','%'};
                int digcheck=0;
                boolean alphaboo=false;
                boolean numboo=false;
                boolean charboo=true;
         System.out.println("\n+--------------------------------------------------+\n");
        if(uspswlen<8){ return false;}
        else{
        for(int i=0;i<uspswlen;i++){
                for(int j=0;j<alphabets.length;j++){
                if(uspsw.charAt(i)==alphabets[j]){ alphaboo=true; }}
        for(int c=0;c<charac.length;c++){
                if(uspsw.charAt(i)==charac[c]){charboo=false; break; }}
                for(int k=0;k<numbers.length;k++){
                if(uspsw.charAt(i)==numbers[k]){ digcheck++; if(digcheck>=2){numboo=true; break;} } }
         }
        }
        if(numboo&&alphaboo&&charboo){return true;}
      else{return false;}      
 }
        public static void display(){
System.out.println("                    -----");
System.out.println("                   |     |");
System.out.println("                   |     |");
System.out.println("                   |_____|");
System.out.println("                  ||     ||");
System.out.println("                  ||  0  ||");
System.out.println("                    -----");
        }
} 