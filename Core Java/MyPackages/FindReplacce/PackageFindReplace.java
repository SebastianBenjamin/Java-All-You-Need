package MyPackages.FindReplacce;
import java.util.*;
public class PackageFindReplace {
    public  void FindReplace() {
        Scanner uI = new Scanner(System.in);
        boolean boo2 = true;

            String line = "";
            StringBuffer para = new StringBuffer();
            String[] myWords;
            int findCount = 0;
            StringBuffer result = new StringBuffer();

            System.out.println("+--------------------------------------------------+");
            System.out.println("|                 Find Replace Program             |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("| Enter your paragraph. Type '404' on a new line   |");
            System.out.println("| to end the input.                                |");
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            boo2 = true;
            while (boo2) {
                line = uI.nextLine().trim();

                if (line.equals("404")) {
                    boo2 = false;
                } else {
                    line = " " + line+" \n";
                    para.append(line);
                }
            }

            System.out.println();
            System.out.print("Enter word to Find: ");
            String findWord = uI.nextLine().trim();

            StringTokenizer Token_space = new StringTokenizer(para.toString(), " .");
            myWords = new String[Token_space.countTokens()];

            int count = 0;
            while (Token_space.hasMoreTokens()) {
                String myTok = Token_space.nextToken();
                StringTokenizer Token_404 = new StringTokenizer(myTok, "404");

                if (Token_404.hasMoreTokens()) {
                    myWords[count] = Token_404.nextToken();
                } else {
                    myWords[count] = myTok;
                }
                count++;
            }

            for (int i = 0; i < myWords.length; i++) {
                if (myWords[i].equals(findWord)) {
                    findCount++;
                }
            }

            System.out.println();
            System.out.println("+--------------------------------------------------+");
            System.out.println(" found of count word '" + findWord + "' : " + findCount);
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            if (findCount != 0) {
                System.out.print("Do you want to replace the word '" + findWord + "' with another word?\n 1: Yes\n 2: No\nYour Selection: ");
                int Selection = uI.nextInt();
                uI.nextLine();
                
                if (Selection == 1) {
                    System.out.println();
                    System.out.print("Replace with: ");
                    String replaceWord = uI.nextLine();

                    for (int i = 0; i < (myWords.length - 1); i++) {
                        if (myWords[i].equals(findWord)) {
                            result.append(replaceWord + " ");
                        } else {
                            result.append(myWords[i] + " ");
                        }
                    }

                    System.out.println();
                    System.out.println("+--------------------------------------------------+");
                    System.out.println(" Result paragraph: ");
                    for(int i=0;i<result.length();i++){
                        if(i==0){
                            System.out.print(" "+result.charAt(i));
                        }
                        else{
                            System.out.print(result.charAt(i));
                        }
                      
                     }
                    
                }
            } else {
                System.out.println("+--------------------------------------------------+");
                System.out.println();
                System.out.println(" No words found!");
                
            }
System.out.println();
            System.out.println("+--------------------------------------------------+");
           
    }
}
