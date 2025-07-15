import java.util.*;

interface inShapes {
    double surfacearea();
    double Volume();

    
}
class Sphere implements inShapes{

    double area,r,vol;
    final double PI=Math.PI;
     
    Sphere(double rad){
    r=rad;
}

   public double surfacearea(){
    area=4*PI*r*r;
    return area;
}

   public double Volume(){
    vol=(4/3)*(PI*r*r*r);
    return vol;
}

}
class Cube implements inShapes{
    double area,a,vol;

    Cube(double aa){
    a=aa;
}

   public double surfacearea(){
    area=6*(a*a);
    return area;
}
   public double Volume(){
    vol=a*a*a;
    return vol;
}

}


class Prism implements inShapes{
    double area,a,b,c,vol;

    Prism(double l,double br,double h){
    a=l;b=br;c=h;
}
   public double surfacearea(){
    area=2*((a*b)+(b*c)+(c*a));
    return area;
}

   public double Volume(){
    vol=a*b*c;
    return vol;
}

}


class Cylinder implements inShapes{
    double area,r,h,vol;

    final double PI=Math.PI;

 Cylinder(double ra,double he){
    r=ra;h=he;
}

   public double surfacearea(){
    area=2*PI*r*(r+h);
    return area;
}

   public double Volume(){
    vol=PI*r*r*h;
    return vol;
}

}


public class InterfaceShapes {

    public static void main(String args[]){

        Scanner ui = new Scanner(System.in);System.out.println();
        
        int selection;
        double length,breadth,height,side,radius;
        boolean boo=true;
        while(boo){
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("-----------------Area and Volume of Shapes Using Interfaces----------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println();
        System.out.println(" Select Menu: ");
        System.out.println();
        System.out.println("  1: Sphere ");
        System.out.println("  2: Cube ");
        System.out.println("  3: Prism ");
        System.out.println("  4: Cylinder ");
        System.out.println("  5: Exit ");
        System.out.println();
        System.out.println("Please input the index of your selection from the above menu");
        System.out.print(" your selection :");
        selection=ui.nextInt();
        
            switch(selection){
        
          case 1:
          System.out.println();
          System.out.println("--------------------------Area and Volume of Sphere------------------------");
          System.out.println();
          System.out.print("Enter radius : ");
          radius=ui.nextDouble();
          Sphere mySphere = new Sphere(radius); 
        System.out.printf("Surface Area of Sphere = %8.2f  Sqm  \nVolume of Sphere = %8.2f m^3",mySphere.surfacearea(),mySphere.Volume());
        System.out.println("\n Do you want to continue ?\n  1:Yes \n  2:No");
        
        selection=ui.nextInt();
        
        if(selection==1){
        boo=true;
        }
        else{
        boo=false;
        }
          break;
        
          case 2:
          System.out.println();
          System.out.println("--------------------------Area and Volume of Cube------------------------");
          System.out.println();
          System.out.print("Enter Side : ");
          side=ui.nextDouble();
          Cube myCube = new Cube(side);
        System.out.printf("Surface Area of Cube = %8.2f  Sqm  \nVolume of Cube = %8.2f m^3",myCube.surfacearea(),myCube.Volume());
        System.out.println("\n Do you want to continue ?\n  1:Yes \n  2:No");
        
        selection=ui.nextInt();
        
        if(selection==1){
        boo=true;
        }
        else{
        boo=false;
        }
          break;
        
          case 3:
          System.out.println();
          System.out.println("--------------------------Area and Volume of Prism------------------------");
          System.out.println();
          System.out.print("Enter Length : ");
          length=ui.nextDouble();
          System.out.println();
          System.out.print("Enter Breadth : ");
          breadth=ui.nextDouble();
          System.out.println();
          System.out.print("Enter Heigth : ");
          height=ui.nextDouble();
          System.out.println();
          Prism myPrism = new Prism(length,breadth,height);
        System.out.printf("Surface Area of Prism = %8.2f  Sqm  \nVolume of Prism = %8.2f m^3",myPrism.surfacearea(),myPrism.Volume());
        System.out.println("\n Do you want to continue ?\n  1:Yes \n  2:No");
        
        selection=ui.nextInt();
        
        if(selection==1){
        boo=true;
        }
        else{
        boo=false;
        }
          break;
        
          case 4:
          System.out.println();
          System.out.println("--------------------------Area and Volume of Cylinder------------------------");
          System.out.println();
          System.out.print("Enter Radius : ");
          radius=ui.nextDouble();
          System.out.println();
          System.out.print("Enter Length : ");
          length=ui.nextDouble();
          System.out.println();
         
          Cylinder myCylinder = new Cylinder(radius,length);
        System.out.printf("Surface Area of Cylinder = %8.2f  Sqm  \nVolume of Cylinder = %8.2f m^3",myCylinder.surfacearea(),myCylinder.Volume());
        System.out.println("\n Do you want to continue ?\n  1:Yes \n  2:No");
        
        selection=ui.nextInt();
        
        if(selection==1){
        boo=true;
        }
        else{
            
        boo=false;
        }
          break;
        
          case 5:
          System.out.println("Exiting the program");
        boo=false;
        ui.close();
         break;
         default:
        break;
        
        }
        }}
        
        
        
}