import java.io.*;
import java.util.*;

public class CopyCreatePaste {
    public static void main(String[] args) {

        String fileToFind = args[0].trim();
        File file = new File(fileToFind);

        if (file.exists()) {
            System.out.println("File found! Copying contents...");

            try {
                Scanner readFile = new Scanner(file);
                File newFile = new File("CopyPastedFile.txt");

                if (newFile.createNewFile()) {
                    System.out.println("New file 'CopyPastedFile.txt' created successfully.");
                } else {
                    System.out.println("File 'CopyPastedFile.txt' already exists. Contents will be overwritten.");
            }

                FileWriter fwr = new FileWriter(newFile);
                
                while (readFile.hasNextLine()) {
                    fwr.write(readFile.nextLine() );
                }

                System.out.println("Content copied successfully to 'CopyPastedFile.txt'.");
                
                fwr.close();
                readFile.close();

            } catch (IOException e) {
                System.out.println("An error occurred during file operations. Please try again.");
                e.printStackTrace();
            }

        } else {
            System.out.println("The specified file does not exist. Please check the path and try again.");
        }

        System.out.println("\nThank you for using the CopyCreatePaste Program!");
     
    }
}
