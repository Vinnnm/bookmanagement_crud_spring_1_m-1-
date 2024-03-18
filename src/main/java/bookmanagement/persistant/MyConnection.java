package bookmanagement.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookdb_1_m";
			String username="root";
			String password="root";
			con=DriverManager.getConnection(url,username,password);
			
			
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found  :"+e);

			
		}catch(SQLException e) {
			System.out.println("SQL Exception :"+e);
		}
		
		return con;
		
	}

}
