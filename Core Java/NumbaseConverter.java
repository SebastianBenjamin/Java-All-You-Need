import java.util.*;

public class NumbaseConverter {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        boolean boo = true;

        while (boo) {
            System.out.println("+--------------------------------------+");
            System.out.println("|         Number Base Converter        |");
            System.out.println("+--------------------------------------+");
              System.out.print("|  => Enter a decimal number: ");
            int decimalp = ui.nextInt();
            int decimal = decimalp;

            System.out.println("+--------------------------------------+");
            System.out.println("| Convert to:                          |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1: Binary                            |");
            System.out.println("| 2: Octal                             |");
            System.out.println("| 3: Decimal                           |");
            System.out.println("| 4: Hexadecimal                       |");
            System.out.println("| 5: Base 36                           |");
            System.out.println("| 6: Exit                              |");
            System.out.println("+--------------------------------------+");
            System.out.print("Your selection: ");
            int selection = ui.nextInt();
            int base = 0;

            String basename = "";
            switch (selection) {
                case 1:
                    basename = "Binary";
                    base = 2;
                    break;
                case 2:
                    basename = "Octal";
                    base = 8;
                    break;
                case 3:
                    basename = "Decimal";
                    base = 10;
                    break;
                case 4:
                    basename = "Hexadecimal";
                    base = 16;
                    break;
                case 5:
                    basename = "Base 36";
                    base = 36;
                    break;
                case 6:
                    boo=false;
            System.out.println("+--------------------------------------+");
            System.out.println(" Exiting the Number Base Converter program. Goodbye!");
            System.out.println("+--------------------------------------+");
                    break;
                  
                default:
                    System.out.println("Invalid selection. Please try again.");
                    continue;
            }
if(boo){
            StringBuffer result = new StringBuffer();
            while (decimal > 0) {
                int v = decimal % base;
                if (v < 10) { 
                    result.append((char) (v + 48));
                } else {
                    result.append((char) (v + 55));
                }
                decimal = decimal / base;
            }

            StringBuffer resultrev = new StringBuffer();
            for (int i = 0; i < result.toString().length(); i++) {
                resultrev.append(result.toString().charAt(result.toString().length() - (1 + i)));
            }
            System.out.println("\n" + basename + " value of " + decimalp + " is: " + resultrev);
            System.out.println("+--------------------------------------+");
            
            System.out.print("\nDo you want to convert another number? \n 1: Yes\n 2: No\nYour selection: ");
            int ch = ui.nextInt();
            if (!boo||ch != 1) {
                boo = false;
            System.out.println("+--------------------------------------+");
            System.out.println(" Exiting the Number Base Converter program. Goodbye!");
            System.out.println("+--------------------------------------+");
                ui.close(); 
            }}
            System.out.println();
        }
    }
}
