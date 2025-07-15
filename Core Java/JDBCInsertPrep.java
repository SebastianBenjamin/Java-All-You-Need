import java.sql.*;
import java.util.*;

public class JDBCInsertPrep {

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
  PreparedStatement pstmt = con.prepareStatement("INSERT INTO studentdetails VALUES (?, ?, ?, ?,?,?, ?)");

          
            for (int i = 0; i < count; i++) {
              
                System.out.println("\n+---------------------------------------------+");
                System.out.println("                  Student " + (i + 1));
                System.out.println("+---------------------------------------------+\n");

               
                System.out.print("Name: ");
                pstmt.setString(2,ui.nextLine());
System.out.println();
                System.out.print("ID: ");
                 pstmt.setString(1,ui.nextLine());
System.out.println();
                System.out.print("Mobile: ");
                 pstmt.setString(3,ui.nextLine());
System.out.println();
                System.out.print("Email: ");
                 pstmt.setString(4,ui.nextLine());
System.out.println();
                System.out.print("Java: ");
                 pstmt.setInt(5,ui.nextInt());
                ui.nextLine(); 
System.out.println();
                System.out.print("Python: ");
                pstmt.setInt(6,ui.nextInt());
                ui.nextLine(); 
System.out.println();
                System.out.print("C: ");
                pstmt.setInt(7,ui.nextInt());
                ui.nextLine(); 
System.out.println();
                
               

                
                if (pstmt.executeUpdate() == 1) {
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
