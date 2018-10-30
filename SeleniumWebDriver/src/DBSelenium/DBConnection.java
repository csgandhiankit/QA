package DBSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		// load driver jar class
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");

		// create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/gts_db01", "gts_test01", "11@one@11");
		System.out.println("Connected to MySQL DB");
		
		// create statement
		Statement st = con.createStatement();
		
		// execute query
		ResultSet rs = st.executeQuery("select * from city");
		System.out.println(rs);
		
		// run through each row of result for column
		while(rs.next()){
			String cityName = rs.getString("Name");
			System.out.println("City name is " + cityName);
		}
		
		// close connection
		con.close();
		
		
		
		
		
	}

}
