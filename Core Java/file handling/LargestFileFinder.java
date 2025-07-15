import java.io.*;
import java.util.*;

public class LargestFileFinder {

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        boolean boo = true;
        while (boo) {
            try{
        System.out.println("\n+---------------------------------------------+");
        System.out.println("|                Largest File Finder          |");
        System.out.println("+---------------------------------------------+\n");

      
            System.out.print(" Please enter the folder path to search: ");
            String folderPath = ui.nextLine();
            File folder = new File(folderPath);
            System.out.println("\n+---------------------------------------------+");
            
            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();
                String fName = "";
                String fPath = "";
                long fSize = 0;
               
                    for (File file : files) {
                        long fileSize = file.length();
                        if (fileSize > fSize) {
                            fSize = fileSize;
                            fName = file.getName();
                            fPath=file.getAbsolutePath();
                            
                    }
                    
                }
                System.out.println("Largest File Found:");
                System.out.println(" File Name: " + fName);
                System.out.println(" File Size: " + fSize + " bytes");
                System.out.println(" File Path: " +fPath);
                
            } else {
                
                System.out.println("The specified path is either invalid or not a directory.");
            }
            System.out.println("+---------------------------------------------+");
            System.out.print("\nWould you like to search another folder?\n 1: Yes\n 2: No\nYour selection: ");
            int selection = ui.nextInt();
            ui.nextLine();  
            if (selection != 1) {
                boo = false;
                System.out.println("\n+---------------------------------------------+");
                System.out.println("Thank you for using the Largest File Finder!");
                System.out.println("+---------------------------------------------+");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

        ui.close();
    }
}
