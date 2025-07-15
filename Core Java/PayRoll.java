import java.util.*;

interface NetPayCalculation {
    void grossPayCalculation();
    void taxCalculation();
    float netPayCalculation();
}

class Employee {
    int ID_No;
    String Name, DOJ, Designation, PAN_No, Department;
    float Basic_pay;
    Scanner ui = new Scanner(System.in);

    void get_Data() {
        System.out.println();
        System.out.println("+--------------------------------------------------+");
        System.out.println("|               Employee Data Entry                |");
        System.out.println("+--------------------------------------------------+");
System.out.println();
        System.out.print(" Enter ID                     : ");
        ID_No = ui.nextInt();
        ui.nextLine(); 

        System.out.print(" Enter Name                   : ");
        Name = ui.nextLine();

        System.out.print(" Enter Date of Joining (DOJ)  : ");
        DOJ = ui.nextLine();

        System.out.print(" Enter Designation            : ");
        Designation = ui.nextLine();

        System.out.print(" Enter Department             : ");
        Department = ui.nextLine();

        System.out.print(" Enter PAN Number             : ");
        PAN_No = ui.nextLine();

        System.out.print(" Enter Basic Pay (in Rupees)  : ");
        Basic_pay = ui.nextFloat();
        ui.nextLine();
    }
}

public class PayRoll extends Employee implements NetPayCalculation {
    float gross_pay, Taxable_amount, Net_pay;

    public void grossPayCalculation() {
        float DA, HRA;
        DA = Basic_pay * 0.50f;
        HRA = Basic_pay * 0.20f;
        gross_pay = Basic_pay + DA + HRA;
    }

    public void taxCalculation() {
float annualincome=gross_pay*12;
        if (annualincome >= 100000 && annualincome < 200000) {
            Taxable_amount = gross_pay * 0.20f;
        } else if (annualincome > 200000) {
            Taxable_amount = gross_pay * 0.30f;
        } else {
            Taxable_amount = 0;
        }
    }

    public float netPayCalculation() {
        grossPayCalculation();
        taxCalculation();
        Net_pay = gross_pay - Taxable_amount;
        return Net_pay;
    }

    public void display_details() {
        System.out.println();
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                Employee Payroll Details          |");
        System.out.println("+--------------------------------------------------+");
System.out.println();
        System.out.println(" ID               : " + ID_No);
        System.out.println(" Name             : " + Name);
        System.out.println(" Date of Joining  : " + DOJ);
        System.out.println(" Designation      : " + Designation);
        System.out.println(" Department       : " + Department);
        System.out.println(" PAN Number       : " + PAN_No);
        System.out.println(" Basic Pay        : " + Basic_pay+" Rs");
        System.out.println(" Gross Pay        : " + gross_pay+" Rs");
        System.out.println(" Taxable Amount   : " + Taxable_amount+" Rs");
        System.out.println(" Net Pay          : " + netPayCalculation()+" Rs");
System.out.println();
        System.out.println("+--------------------------------------------------+");
        System.out.println("|         Payroll Calculation Completed            |");
        System.out.println("+--------------------------------------------------+");
System.out.println();        
    }

    public static void main(String[] args) {
        boolean boo = true;
        Scanner ui = new Scanner(System.in);

        while (boo) {
            PayRoll employee1 = new PayRoll();
            employee1.get_Data();
            employee1.netPayCalculation();
            employee1.display_details();

            System.out.print("Do you want to enter details for another employee? \n 1: Yes\n 2: No\nYour Selection : ");
            int selection = ui.nextInt();
            if (selection != 1) {
                boo = false;
        System.out.println("+--------------------------------------------------+");
                System.out.println("      Exiting the Program. Thank you!");
        System.out.println("+--------------------------------------------------+");

            }
        }
    }
}
