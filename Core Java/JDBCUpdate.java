import java.sql.*;
import java.util.*;

public class JDBCUpdate {

    public static void main(String[] args) {
        
        Scanner ui = new Scanner(System.in);

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");


            System.out.println("\n+---------------------------------------------+");
            System.out.println("|          JDBC Student Data Updation         |");
            System.out.println("+---------------------------------------------+\n");

          
                Statement stmt = con.createStatement();



		System.out.print("  ID: ");
                String Id = ui.nextLine();
System.out.println();
            System.out.println("+---------------------------------+");
            System.out.println("| Which column you want to update |");
            System.out.println("+---------------------------------+");
            System.out.println("|         1: Name                 |");
            System.out.println("|         2: Mobile               |");
            System.out.println("|         3: Email                |");
            System.out.println("|         4: Java      		  |");
            System.out.println("|         5: Python   	          |");
            System.out.println("|         6: C                	  |");
            System.out.println("+---------------------------------+\n");
            System.out.print("\n Your Selection : ");
		String Column=ui.nextLine();
	   System.out.print("\n Value : ");
		String Value="";

                switch (Column){
 		case "1": 
			Column="Sname";
			Value=ui.nextLine();
			break;
		case "2":
			Column="Smobile";
			Value=ui.nextLine();
			break;
		case "3":
			Column="Semail";
			Value=ui.nextLine();
			break;
		case "4":
			Column="Java";
			Value=ui.nextLine();
			
			break;
		case "5":
			Column="Python";
			Value=ui.nextLine();
			break;
		case "6":
			Column="Cprogram";
			Value=ui.nextLine();
			break;
		}
                
                String query = "UPDATE studentdetails SET "+Column+"='"+Value+"' where Sid='"+Id+"'";
                
                if (stmt.executeUpdate(query) == 1) {
                    System.out.println("\nUpdation Success!");
                } else {
                    System.out.println("\nUpdation Failed!");
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
