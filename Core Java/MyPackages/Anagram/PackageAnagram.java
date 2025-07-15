package MyPackages.Anagram;
import java.util.*;

public class PackageAnagram {
   
public void Anagram(){
  
    Scanner uI = new Scanner(System.in);
    StringBuffer Word1 = new StringBuffer();
    StringBuffer Word2 = new StringBuffer();
    String u_Word1;
    String u_Word2;

    
    System.out.println("+--------------------------------------------------+");
    System.out.println("|               Anagram Checker                    |");
    System.out.println("+--------------------------------------------------+");
    System.out.println();
    
    
    System.out.print("Enter word 1 : ");
    u_Word1 = uI.nextLine().trim();
    
    
    System.out.print("Enter word 2 : ");
    u_Word2 = uI.nextLine().trim();

    
    StringTokenizer space1 = new StringTokenizer(u_Word1, " .!?");
    StringTokenizer space2 = new StringTokenizer(u_Word2, " .!?");
    
    while (space1.hasMoreTokens()) {
        String myWord = space1.nextToken();
        Word1.append(myWord);
    }
    while (space2.hasMoreTokens()) {
        String myWord = space2.nextToken();
        Word2.append(myWord);
    }

    
    char[] letters1 = new char[Word1.toString().length()];
    char[] letters2 = new char[Word2.toString().length()];
    for (int i = 0; i < letters1.length; i++) {
        letters1[i] = Word1.charAt(i);
    }
    for (int i = 0; i < letters2.length; i++) {
        letters2[i] = Word2.charAt(i);
    }

    
    for (int i = 0; i < letters1.length; i++) {
        for (int j = i + 1; j < letters1.length; j++) {
            if (letters1[i] > letters1[j]) {
                char temp = letters1[i];
                letters1[i] = letters1[j];
                letters1[j] = temp;
            }
        }
    }

    
    for (int i = 0; i < letters2.length; i++) {
        for (int j = i + 1; j < letters2.length; j++) {
            if (letters2[i] > letters2[j]) {
                char temp = letters2[i];
                letters2[i] = letters2[j];
                letters2[j] = temp;
            }
        }
    }

    
    System.out.println();
    System.out.println("+--------------------------------------------------+");
    if (Arrays.equals(letters1, letters2)) {
        System.out.println("|                 Words are anagrams!              |");
    } else {
        System.out.println("|            Words are NOT anagrams!               |");
    }
    System.out.println("+--------------------------------------------------+");

   


}
}
