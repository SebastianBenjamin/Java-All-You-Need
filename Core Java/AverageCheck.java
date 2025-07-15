import java.util.*;

public class AverageCheck {

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        boolean boo = true;

        while (boo) {
            System.out.println("\n+--------------------------------------+");
            System.out.println("|           Average Checker            |");
            System.out.println("+--------------------------------------+");
            System.out.print("\nHow many numbers do you want to check? : ");
            int n = ui.nextInt();
            double[] numArray = new double[n];
            double average = 0;
            double sum = 0;

            for (int i = 0; i < n; i++) {
                System.out.print("\n => Enter number " + (i + 1) + " : ");
                numArray[i] = ui.nextDouble();
                sum = sum + numArray[i];
            }

            average = sum / n;
            System.out.println("\n+--------------------------------------+");
            System.out.println(" Average = " + average);
            System.out.print("\n Numbers above Average are: ");

            for (int i = 0; i < n; i++) {
                if (numArray[i] > average) {
                    System.out.print(" " + numArray[i] + " (at index " + (i + 1) + ") ");
                }
            }

            System.out.println("\n+--------------------------------------+");
            System.out.print("\nDo you want to check another set of numbers?\n 1: Yes\n 2: No\nYour Selection: ");
            int selection = ui.nextInt();
			
            if (selection != 1) {
				boo = false;
				System.out.println("\n+--------------------------------------+");
                System.out.println(" Exiting the program! Thank you for using Average Checker!");
            }
        }

        ui.close();
    }
}
