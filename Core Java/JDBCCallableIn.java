import java.sql.*;
public class JDBCCallableIn{
	public static void main(String[]args){
	try{
		
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");
		CallableStatement cstmt =con.prepareCall("{call studentdetails(?)}");
		cstmt.setInt(1,1001);
		ResultSet rs =cstmt.executeQuery();
		while(rs.next()){
				
		System.out.println();
		System.out.println("Student Id :"+rs.getString(1));
		System.out.println("Student Name :"+rs.getString(2));
		System.out.println("Student Mobile :"+rs.getString(3));
		System.out.println("Student Email :"+rs.getString(4));
		System.out.println("Student Java :"+rs.getInt(5));
		System.out.println("Student Python :"+rs.getInt(6));
		System.out.println("Student C :"+rs.getInt(7));
			}

		}catch(Exception e){   e.printStackTrace();}
	



	}


}