import java.util.*;

abstract class Shape{

abstract double surfacearea();
abstract double perimeter();

}


class Rhombus extends Shape{
    double area,a,b,per;

    Rhombus(double l,double br){
    a=l;b=br;
}
    double surfacearea(){
    area=a*b;
    return area;
}

    double perimeter(){
    per=4*a;
    return per;
}

}




public class RhombusCal{
    public static void main(String args[]){

Scanner ui = new Scanner(System.in);System.out.println();

int selection;
double length,breadth;
boolean boo=true;
while(boo){
System.out.println();
System.out.println("---------------------------------------------------------------------------");
System.out.println("------------------------Area and Perimeter of Rhombus----------------------");
System.out.println("---------------------------------------------------------------------------");
System.out.println();

  System.out.println("Enter Length : ");
  length=ui.nextDouble();
  System.out.println("Enter Breadth : ");
  breadth=ui.nextDouble();

  Rhombus myRhombus = new Rhombus(length,breadth);
System.out.printf("Surface Area of Rhombus = %8.2f  Sqm  \nPerimeter of Rhombus = %8.2f m^3",myRhombus.surfacearea(),myRhombus.perimeter());
System.out.println("\n Do you want to continue ?\n  1:Yes \n  2:No");

selection=ui.nextInt();

if(selection==1){
boo=true;
}
else{
boo=false;
}

    
}}



}