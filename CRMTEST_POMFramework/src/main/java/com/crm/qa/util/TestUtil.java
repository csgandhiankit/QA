package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static Connection con;
	public static Statement smt;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ankit.gandhi\\Documents\\workspace\\CRMTEST_POMFramework\\src\\main\\java\\com\\crm\\qa\\testdata\\CRMTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// System.out.println(data[i][k]);
			}
		}

		return data;

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	public static Connection DBConnector() throws ClassNotFoundException, SQLException {
		// load driver jar class
		Class.forName("dbDriver");
		System.out.println("Driver loaded");

		// Create connection
		con = DriverManager.getConnection("jdbc:mysql://"+prop.getProperty("dbhost") + ":" + prop.getProperty("dbport") + "/" + prop.getProperty("dbname"), prop.getProperty("dbUser"), prop.getProperty("dbpass"));
		System.out.println("Connected to MySQL DB");
		return con;

	}

	public static ResultSet DBQuery(String query) throws SQLException {
		// create statement
		smt = con.createStatement();

		// execute query
		query = "select * from city";
		ResultSet rs = smt.executeQuery(query);
		System.out.println(rs);
		return rs;
	}

	public static Connection DBCLose() throws SQLException {
		// close the connection
		con.close();
		System.out.println("DB connection close..");
		return con;

	}

}
