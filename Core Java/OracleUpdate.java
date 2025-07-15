import java.sql.*;
import java.util.*;

class OracleUpdate {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter customer id to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        
        System.out.println("Enter new name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter new address: ");
        String address = sc.nextLine();
        
        System.out.println("Enter new contact: ");
        String contact = sc.nextLine();
        
        try {
            Connection con = null;
            String servername = "172.16.20.20";
            String portnumber = "1521";
            String sid = "orcl";
            String url = "jdbc:oracle:thin:@//" + servername + ":" + portnumber + "/" + sid;
            String username = "c##mcaorc6";
            String password = "mcaorc6";
            
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(
                "UPDATE cust SET cust_name = ?, address = ?, contact = ? WHERE customer_id = ?");
            
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, contact);
            ps.setInt(4, id);
            
            int i = ps.executeUpdate();
            
            if (i > 0) {
                System.out.println(i + " Record updated");
            } else {
                System.out.println("No record found with the provided customer id.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
