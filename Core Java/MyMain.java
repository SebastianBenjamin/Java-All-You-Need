class Circle {
  public double x, y;
  public double r;

  
  public Circle(double x, double y, double r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  
  public double circumference() {
    return 2 * 3.14 * r;
  }

  
  public double area() {
    return 3.14 * r * r;
  }
}

public class MyMain {
  public static void main(String args[]) {
  
    Circle aCircle = new Circle(10, 20, 5);

    
    double area = aCircle.area();
    double circumf = aCircle.circumference();

    
    System.out.println("Radius = " + aCircle.r + " Area = " + area);
    System.out.println("Radius = " + aCircle.r + " Circumference = " + circumf);
  }
}
