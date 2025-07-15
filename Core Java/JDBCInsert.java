import java.sql.*;
import java.util.*;

public class JDBCInsert {

    public static void main(String[] args) {
        
        Scanner ui = new Scanner(System.in);

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");
		boolean boo=true;
while(boo){

            System.out.println("\n+---------------------------------------------+");
            System.out.println("|        JDBC  Student Data Insertion         |");
            System.out.println("+---------------------------------------------+\n");

           
            System.out.print("How many data you want to insert: ");
            int count = ui.nextInt();
            ui.nextLine(); 

          
            for (int i = 0; i < count; i++) {
                Statement stmt = con.createStatement();

                System.out.println("\n+---------------------------------------------+");
                System.out.println("                  Student " + (i + 1));
                System.out.println("+---------------------------------------------+\n");

               
                System.out.print("Name: ");
                String Name = ui.nextLine();
System.out.println();
                System.out.print("ID: ");
                String Id = ui.nextLine();
System.out.println();
                System.out.print("Mobile: ");
                String Mobile = ui.nextLine();
System.out.println();
                System.out.print("Email: ");
                String Email = ui.nextLine();
System.out.println();
                System.out.print("Java: ");
                int Java = ui.nextInt();
                ui.nextLine(); 
System.out.println();
                System.out.print("Python: ");
                int Python = ui.nextInt();
                ui.nextLine(); 
System.out.println();
                System.out.print("C: ");
                int C = ui.nextInt();
                ui.nextLine(); 
System.out.println();
                
                String query = "INSERT INTO studentdetails " +
                               "VALUES ('" + Id + "', '" + Name + "', '" + Mobile + "', '" + Email + "', " + Java + ", " + Python + ", " + C + ")";

                
                if (stmt.executeUpdate(query) == 1) {
                    System.out.println("Student "+(i+1)+" Value Insertion Success!");
                } else {
                    System.out.println("Student "+(i+1)+" Value Insertion Failed!");
                }
            }

   System.out.println("+---------------------------------------------+");
 System.out.print("\nWant to add more ? \n 1:Yes\n 2:No \nYour Selection:");

if(ui.nextInt()!=1){boo=false;}
}
System.out.println("+---------------------------------------------+");
System.out.println("                   Thank You !");
System.out.println("+---------------------------------------------+");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ui.close();
        }
    }
}
