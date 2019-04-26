import java.sql.*;
import java.util.*;

class Main{
	
	public static void main(String args[]){  
		try{
			String url = "jdbc:mysql://vergil.u.washington.edu:5624/cc";
			String user = "cc"; //plz don't abuse
			String pass = "ccpassword";
			
			String sqlinsertTestTable = "INSERT INTO test (columnA, columnC) VALUES('banana', 'notabanana')";
			String sqlSelectAllTestTable = "SELECT * FROM user;";
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url, user, pass);
			
			Statement stmt = con.createStatement();  
			int m = stmt.executeUpdate(sqlinsertTestTable);
			if (m == 1) System.out.println("Insert Success!");
			ResultSet rs = stmt.executeQuery(sqlSelectAllTestTable);
			while(rs.next())  {
				System.out.print("Row: ");
				System.out.println(rs.getInt("pretendkey")+"  "+rs.getString("columnB")+"  "+rs.getInt("columnC")
		+ " " + rs.getString("columnD"));
			}
			con.close();  
		} catch(Exception e){
			System.out.println(e);
		}
	}  
}