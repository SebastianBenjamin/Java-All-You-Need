import java.util.*;
class Rectangle{
static float height;
static float width;
static void CalArea(){
System.out.println("Area= " + height*width);
}
}
public class myRectangle{
public static void main (String [] args){
Rectangle r1 = new Rectangle();
Rectangle r2 = new Rectangle();

Scanner sc = new Scanner (System.in);

System.out.print("Enter height: ");
r1.height =  sc.nextFloat();
System.out.print("Enter width: ");
r1.width = sc.nextFloat();

Rectangle.CalArea();


System.out.print("Enter height: ");
r2.height =  sc.nextFloat();
System.out.print("Enter width: ");
r2.width = sc.nextFloat();


Rectangle.CalArea();

}}