import java.sql.*;
import java.util.*;

public class JDBCDelete {

    public static void main(String[] args) {

        Scanner ui = new Scanner(System.in);

        try {
    
           
            Class.forName("com.mysql.cj.jdbc.Driver");


           
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");

            System.out.println("\n+---------------------------------------------+");
            System.out.println("|           JDBC Student Data Deletion        |");
            System.out.println("+---------------------------------------------+\n");

            Statement stmt = con.createStatement();

            System.out.print("  Enter the ID of the record to delete: ");
            String Id = ui.nextLine();
            
          
            String query = "DELETE FROM studentdetails WHERE Sid='" + Id + "'";
            
            
            if (stmt.executeUpdate(query) == 1) {
                System.out.println("\nDeletion Success!");
            } else {
                System.out.println("\nNo record found with the provided ID.");
            }

            System.out.println("\n+---------------------------------------------+");
            System.out.println("                   Thank You !");
            System.out.println("+---------------------------------------------+");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ui.close();
        }
    }
}
