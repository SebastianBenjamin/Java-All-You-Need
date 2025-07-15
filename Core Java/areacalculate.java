import java.util.Scanner;

public class areacalculate {
  public static void main(String[] args) {

    Scanner getIn = new Scanner(System.in);
    while (true) {
      double area, radius, side, length, breadth;
      System.out.println("------------------------------");
      System.out.println("-------------AREA-------------");
      System.out.println("------------------------------");
      System.out.println("Choose a shape to find area :");

      System.out.println("1: Rectangle");
      System.out.println("2: Circle");
      System.out.println("3: Square");
      System.out.println("4: Parallelogram");
      System.out.println("5: Triangle");

      int selection = getIn.nextInt();

      switch (selection) {
        case 1:

          System.out.println("Choosed Rectangle");
          System.out.println("Enter length:");
          length = getIn.nextDouble();
          System.out.println("Enter width:");
          breadth = getIn.nextDouble();
          Rectangle myRectangle = new Rectangle(length, breadth);
          area = myRectangle.area();
          System.out.println("Area of Rectangle = " + area);
          break;

        case 2:
          System.out.println("Choosed Circle");
          System.out.println("Enter radius:");
          radius = getIn.nextDouble();
          Circle myCircle = new Circle(radius);
          area = myCircle.area();
          System.out.println("Area of Circle = " + area);
          break;

        case 3:
          System.out.println("Choosed Square");
          System.out.println("Enter side:");
          side = getIn.nextDouble();
          Square mySquare = new Square(side);
          area = mySquare.area();
          System.out.println("Area of Square = " + area);
          break;

        case 4:
          System.out.println("Choosed Parallelogram");
          System.out.println("Enter length:");
          length = getIn.nextDouble();
          System.out.println("Enter breadth:");
          breadth = getIn.nextDouble();
          Parallelogram myParallelogram = new Parallelogram(length, breadth);
          area = myParallelogram.area();
          System.out.println("Area of Parallelogram = " + area);
          break;

        case 5:
          System.out.println("Choosed Triangle");
          System.out.println("Enter length:");
          length = getIn.nextDouble();
          System.out.println("Enter breadth:");
          breadth = getIn.nextDouble();
          Triangle myTriangle = new Triangle(length, breadth);
          area = myTriangle.area();
          System.out.println("Area of Triangle = " + area);
          break;

        default:
          System.out.println("No shape Selected or Invalid Selection");
          getIn.close();

      }
    }
  }
}

abstract class Shape {
  abstract double area();
}

class Rectangle extends Shape {
  public double rLength, rWidth, rArea;

  public Rectangle(double rlen, double rwid) {
    rLength = rlen;
    rWidth = rwid;
  }

  public double area() {
    rArea = rLength * rWidth;
    return rArea;
  }
}

class Circle extends Shape {
  final double pI = 3.14159;
  public double r, cArea;

  public Circle(double ra) {
    r = ra;
  }

  public double area() {
    cArea = pI * r * r;
    return cArea;
  }
}

class Square extends Shape {
  public double s, sArea;

  public Square(double sd) {
    s = sd;
  }

  public double area() {
    sArea = s * s;
    return sArea;
  }
}

class Parallelogram extends Shape {
  public double b, h, pArea;

  public Parallelogram(double ba, double he) {
    b = ba;
    h = he;
  }

  public double area() {
    pArea = b * h;
    return pArea;
  }
}

class Triangle extends Shape {
  public double b, h, tArea;

  public Triangle(double ba, double he) {
    b = ba;
    h = he;
  }

  public double area() {
    tArea = 0.5 * b * h;
    return tArea;
  }
}