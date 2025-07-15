import java.util.*;

public class leapYearChecker {
    public static void main(String[] args) {
        Scanner uI = new Scanner(System.in);
    
        boolean boo1 = true;
        boolean boo2 = true;

        while (boo1) {
            boo2 = true;
            StringBuffer totalYears = new StringBuffer();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Leap Year Checker                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("|Enter years below (type a negative number to stop)|");
            System.out.println("+--------------------------------------------------+");
            System.out.println();

            int yearin;
            while (boo2) {
                yearin = uI.nextInt();

                if (yearin < 0) {
                    boo2 = false;
                } else {
                    totalYears.append(yearin + " ");
                }
            }

            StringTokenizer space = new StringTokenizer(totalYears.toString(), " ");
            String[] totalYears_Array = new String[space.countTokens()];
            int count = 0;
            while (space.hasMoreTokens()) {
                totalYears_Array[count++] = space.nextToken();
            }

            System.out.println();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                    Results                       |");
            System.out.println("+--------------------------------------------------+");

            for (int i = 0; i < totalYears_Array.length; i++) {
                if (isLeapYear(Integer.valueOf(totalYears_Array[i]))) {
                    System.out.println(" " + totalYears_Array[i] + " is a leap year!");
                } else if (totalYears_Array[i].length() > 4 || totalYears_Array[i].length() < 4) {
                    System.out.println(" " + totalYears_Array[i] + " is not a valid year!");
                } else {
                    System.out.println(" " + totalYears_Array[i] + " is not a leap year!");
                }
            }

            System.out.println("+--------------------------------------------------+");
            System.out.print("Do you want to check more years?\n 1: Yes\n 2: No\n Your Selection: ");
            int selection = uI.nextInt();
            if (selection != 1) {
                boo1 = false;
                System.out.println();
                System.out.println("Exiting the Leap Year Checker Program. Goodbye!");
                System.out.println("+--------------------------------------------------+");
            }
        }
    }

    public static boolean isLeapYear(int year) {
       if(year%4==0){
        if (year %100==0){
            return year%400==0;
        }
        else return true;
       }
       else return false;
    }
}
