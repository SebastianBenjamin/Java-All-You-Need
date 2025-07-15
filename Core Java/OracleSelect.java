import java.sql.*;
import java.util.*;

class OracleSelect {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Enter customer id to retrieve (or press 0 to display all records): ");
        int id = sc.nextInt();
        
        try {
            
            Connection con = null;
            String servername = "172.16.20.20";
            String portnumber = "1521";
            String sid = "orcl";
            String url = "jdbc:oracle:thin:@//" + servername + ":" + portnumber + "/" + sid;
            String username = "c##mcaorc6";
            String password = "mcaorc6";
            
            con = DriverManager.getConnection(url, username, password);
            
          
            String sql;
            if (id == 0) {
      
                sql = "SELECT * FROM cust";
            } else {
               
                sql = "SELECT * FROM cust WHERE customer_id = ?";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            
          
            if (id != 0) {
                ps.setInt(1, id);
            }
            
            ResultSet rs = ps.executeQuery();
            
           
            boolean recordFound = false;
            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String customerName = rs.getString("cust_name");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                
                System.out.println("Customer ID: " + customerId);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Address: " + address);
                System.out.println("Contact: " + contact);
                System.out.println("----------------------------");
                
                recordFound = true;
            }
            
            if (!recordFound) {
                System.out.println("No records found for the given customer id.");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
