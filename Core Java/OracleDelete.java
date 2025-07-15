import java.sql.*;
import java.util.*;

class OracleDelete {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter customer id to delete: ");
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
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM cust WHERE customer_id = ?");
            
            ps.setInt(1, id);
            
            int i = ps.executeUpdate();
            
            if (i > 0) {
                System.out.println(i + " Record deleted");
            } else {
                System.out.println("No record found with the provided customer id.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
