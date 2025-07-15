import java.sql.*;
import java.util.*;
class OracleInsert{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter address: ");
		String address = sc.nextLine();
		System.out.println("Enter contact: ");
		String contact = sc.nextLine();
		try{
			Connection con = null;
			String servername = "172.16.20.20";
			String portnumber = "1521";
			String sid = "orcl";
			String url = "jdbc:oracle:thin:@//"+ servername + ":" + portnumber + "/" + sid;
			String username = "c##mcaorc9";
			String password = "mcaorc9";
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement("insert into cust(customer_id,cust_name,address,contact) values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, contact);
			int i = ps.executeUpdate();
			System.out.println(i + " Record inserted");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}