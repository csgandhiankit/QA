package DBSelenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompareDBLists {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loaded");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/gts_db01", "gts_test01", "11@one@11");
		
		System.out.println("Connected to MySQL DB");
		
		Statement smt = con.createStatement();
		
		//ResultSet rs = smt.executeQuery("select * from city");
		ResultSet rs1 = smt.executeQuery("select * from countrylanguage");
		
		List<String> actuallist = new ArrayList<String>();
		List<String> expectedlist = new ArrayList<String>();
		while(rs1.next())
		{
			//String cityname = rs.getString("Name");
			String code = rs1.getString("CountryCode");
			String lang = rs1.getString("Language");
//			System.out.println("City name is " + cityname);
			actuallist.add(code + ":" + lang);
			expectedlist.add(code + ":" + lang);
		}
		
		//List<String> expectedlist = actuallist;
		//expectedlist.add("Raleigh");
		
		System.out.println("Actual List: " + actuallist);
		System.out.println("Expect List: " + expectedlist);
		System.out.println(expectedlist.equals(actuallist));
		
		con.close();
	}

}