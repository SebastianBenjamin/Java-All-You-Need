import MyPackages.Anagram.*;
import MyPackages.FillVoid.*;
import MyPackages.FindReplacce.*;
import MyPackages.ForbiddenReplace.*;
import MyPackages.RemoveIdentical.*;
import MyPackages.ReverseLetterByLetter.*;
import MyPackages.ReverseWordByWord.*;
import MyPackages.SentenceCheck.*;
import MyPackages.SentenceExtract.*;
import java.util.*;

public class AllStringPrograms {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        boolean boo = true;

        while (boo) {
            System.out.println("\n+--------------------------------------------------------------------------------------------+");
            System.out.println("|                                        STRING PROGRAMS                                     |");
            System.out.println("+--------------------------------------------------------------------------------------------+");
            System.out.println();
            System.out.println("\n+------------------------------------------+");
            System.out.println("|                   Menu                   |");
            System.out.println("+------------------------------------------+");
            System.out.println("| Please select an option below:           |");
            System.out.println("| 1: Anagram                               |");
            System.out.println("| 2: Fill Void                             |");
            System.out.println("| 3: Find and Replace                      |");
            System.out.println("| 4: Forbidden Replace                     |");
            System.out.println("| 5: Remove Identical                      |");
            System.out.println("| 6: Reverse Letter by Letter              |");
            System.out.println("| 7: Reverse Word by Word                  |");
            System.out.println("| 8: Sentence Check                        |");
            System.out.println("| 9: Sentence Extract                      |");
            System.out.println("| 0: Exit                                  |");
            System.out.println("+------------------------------------------+");
            System.out.print("\n => Enter your choice: ");

            int choice = ui.nextInt(); // Get user input for choice
ui.nextLine();
            switch (choice) {
                case 1:
                    PackageAnagram obj1 = new PackageAnagram();
                    obj1.Anagram();
                    break;
                case 2:
                    PackageFillVoid obj2 = new PackageFillVoid();
                    obj2.FillVoid();
                    break;
                case 3:
                    PackageFindReplace obj3 = new PackageFindReplace();
                    obj3.FindReplace();
                    break;
                case 4:
                    PackageForbiddenReplace obj4 = new PackageForbiddenReplace();
                    obj4.ForbiddenReplace();
                    break;
                case 5:
                    PackageRemoveIdentical obj5 = new PackageRemoveIdentical();
                    obj5.RemoveIdentical();
                    break;
                case 6:
                    PackageReverselbl obj6 = new PackageReverselbl();
                    obj6.ReverseLetterByLetter();
                    break;
                case 7:
                    PackageReversewbw obj7 = new PackageReversewbw();
                    obj7.ReverseWordByWord();
                    break;
                case 8:
                    PackageSentenceCheck obj8 = new PackageSentenceCheck();
                    obj8.SentenceCheck();
                    break;
                case 9:
                    PackageSentenceExtract obj9 = new PackageSentenceExtract();
                    obj9.SentenceExtract();
                    break;
                case 0:
                    boo = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 9.");
                    break;
            }
            // ui.nextLine();
            if(boo){
                System.out.println();
            System.out.print("Do you want to perform another operation? \n 1: Yes \n 0: No \n=> Your Selection : ");
            choice=ui.nextInt();
            ui.nextLine();
            if (choice != 1) {
                boo=false;
                
            }}
        }
        if(boo==false){
            System.out.println();
            System.out.println("+------------------------------------------+");
            System.out.println();
            System.out.println("Exiting the program. Thank you!");
            System.out.println();
            System.out.println("+------------------------------------------+");
        }
        
        ui.close(); // Close the scanner
    }
}
