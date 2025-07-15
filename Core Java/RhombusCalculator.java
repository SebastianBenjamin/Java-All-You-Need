import java.util.*;

abstract class Shape {
    abstract double surfacearea();
    abstract double perimeter();
}

class Rhombus extends Shape {
    double a, b;

    Rhombus(double l, double br) {
        a = l;
        b = br;
    }

    double surfacearea() {
        return a * b;
    }

    double perimeter() {
        return 4 * a;
    }
}

public class RhombusCalculator {
    public static void main(String args[]) {
        Scanner ui = new Scanner(System.in);
        int selection;
        double length, breadth;
        boolean boo = true;

        while (boo) {
            System.out.println();
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("------------------------Area and Perimeter of Rhombus----------------------");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println();

            System.out.print("Enter Length : ");
            length = ui.nextDouble();
            System.out.print("Enter Breadth : ");
            breadth = ui.nextDouble();

            Rhombus myRhombus = new Rhombus(length, breadth);
            System.out.printf("Surface Area of Rhombus = %8.2f Sqm  \nPerimeter of Rhombus = %8.2f m\n", myRhombus.surfacearea(), myRhombus.perimeter());
            System.out.println("\nDo you want to continue?\n1: Yes\n2: No");
            selection = ui.nextInt();

            boo = (selection == 1);
        }
        ui.close();
    }
}
