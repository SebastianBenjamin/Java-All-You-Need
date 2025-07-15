import java.sql.*;
public class JDBCCallableInOut{
	public static void main(String[]args){
	try{
		
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");
		CallableStatement cstmt =con.prepareCall("{?= call squareFun(?)}");
		cstmt.registerOutParameter(1,Types.INTEGER);
		cstmt.setInt(2,200);
			
		System.out.println();
		cstmt.execute();
		System.out.println("Square = "+cstmt.getInt(1));
	

		}catch(Exception e){   e.printStackTrace();}
	



	}


}