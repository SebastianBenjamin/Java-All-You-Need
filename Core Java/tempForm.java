import java.util.*;
public class tempForm{
public static void main(String[]args){
Scanner ui=new Scanner(System.in);
System.out.println();
System.out.print(" Enter Inside Temperature : ");
double temp1=ui.nextDouble()-5;
System.out.println();

System.out.print(" Enter Outside Temperature : ");
double temp2=ui.nextDouble();
System.out.println();

System.out.print(" Enter capacity : ");
int maxcount=ui.nextInt();
ui.nextLine();
System.out.println();

System.out.print(" Enter current count: ");
int count=ui.nextInt();
ui.nextLine();
System.out.println();

System.out.print(" Enter min Temperature : ");
double minTemp=ui.nextDouble();
ui.nextLine();
System.out.println();

System.out.print(" Enter max Temperature : ");
double maxTemp=ui.nextDouble();
ui.nextLine();
System.out.println();

double mappedVal=mapValue(count,0,maxcount,maxTemp,minTemp);

double avgTemp= (temp1+temp2)/2;

double setAcTemp=(mappedVal+avgTemp)/2;

System.out.print("AC temp to be set to : "+setAcTemp+" deg C");
System.out.println();
}
 public static double mapValue(double value, double minOld, double maxOld, double minNew, double maxNew) {
        return minNew + ((value - minOld) / (maxOld - minOld)) * (maxNew - minNew);
    }
}