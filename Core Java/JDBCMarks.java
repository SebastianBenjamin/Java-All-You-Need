import java.sql.*;
import java.util.*;

class JDBCMarks {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "");
            Statement stmt = Con.createStatement();

            
	    int a=0;
            
            ResultSet rs1 = stmt.executeQuery("select * from studentdetails");
	    while(rs1.next()){a++;}
	    ResultSet rs = stmt.executeQuery("select * from studentdetails");
	    int[] java = new int[a];
            int[] python = new int[a];
            int[] c = new int[a];
            String[] name = new String[a];
            int i = 0;
            System.out.println("\n +-------------------------------------------------------------------------------------------------------------+");
	    System.out.println(" |                                                   STUDENTS                                                  |");
            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");
            while (rs.next()) {
                java[i] = rs.getInt(5);
                python[i] = rs.getInt(6);
                c[i] = rs.getInt(7);
                name[i] = rs.getString(2);
                i++;

               System.out.println(" |  " + rs.getInt(1) + " | " + Fill(rs.getString(2),25) + " | " + Fill(rs.getString(3),25) + " | " + Fill(rs.getString(4),25) + " | " + Fill(String.valueOf(rs.getInt(5)),5) + " | " + Fill(String.valueOf(rs.getInt(6)),5) + " | " + Fill(String.valueOf(rs.getInt(7)),5) + " | ");
            }

            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");





ResultSet rsp = stmt.executeQuery("select * from studentdetails where (Java+Python+Cprogram)>=210");

            System.out.println("\n +-------------------------------------------------------------------------------------------------------------+");
	    System.out.println(" |                                                  DISTINCTION                                                |");
            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");
            while (rsp.next()) {
               
System.out.println(" |  " + rsp.getInt(1) + " | " + Fill(rsp.getString(2),25) + " | " + Fill(rsp.getString(3),25) + " | " + Fill(rsp.getString(4),25) + " | " + Fill(Integer.toString(rsp.getInt(5)),5) + " | " + Fill(Integer.toString(rsp.getInt(6)),5) + " | " + Fill(Integer.toString(rsp.getInt(7)),5) + " | ");
            }

            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");



	    ResultSet rsf = stmt.executeQuery("select * from studentdetails where (Java+Python+Cprogram)<210");
            System.out.println("\n +-------------------------------------------------------------------------------------------------------------+");
	    System.out.println(" |                                                    FAILED                                                   |");
            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");
            while (rsf.next()) {
                System.out.println(" |  " + rsf.getInt(1) + " | " + Fill(rsf.getString(2),25) + " | " + Fill(rsf.getString(3),25) + " | " + Fill(rsf.getString(4),25) + " | " + Fill(String.valueOf(rsf.getInt(5)),5) + " | " + Fill(String.valueOf(rsf.getInt(6)),5) + " | " + Fill(String.valueOf(rsf.getInt(7)),5) + " | ");
            }
 
            System.out.println(" +-------------------------------------------------------------------------------------------------------------+");






            Con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String Fill(String str,int val) {
        for (int i = 0; i < val; i++) {
            if (str.length() < i) {
                str += " ";
            }
        }
        return str;
    }
}
