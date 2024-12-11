package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Account;
import Model.Department;

public class DatabaseConnection {

	
	
	
	public static ArrayList<Department> DepartmentQuery(String sql)
	{
		ArrayList<Department> arr = new ArrayList<Department>();
		try {
			
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Department department = new Department();
				department.setDepartmentID(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
				department.setDepartmentAddress(rs.getString(3));
				department.setDepartmentPhoneNumber(rs.getString(4));
				arr.add(department);
			}
		    
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
		return arr;
	}
	public static void DeparmentExecProc(String sql)
	{
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    // sửa DESKTOP-9JGGVQQ\\SQLEXPRESS thành tên server, sửa 1433 thành cổng của server, databaseName bằng tên database muốn truy cập
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    
			Statement statement = connection.createStatement();
			int resultSet = statement.executeUpdate(sql);
			
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
	}
	public static ArrayList<Account> AccountQuery(String sql)
	{
		ArrayList<Account> arr = new ArrayList<Account>();
		try {
			
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next())
			{
				Account acc = new Account();
				acc.setUsername(rs.getString(1));
				acc.setPassword(rs.getString(2));
				arr.add(acc);
			}
		    
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
		return arr;
	}
	public static void AccountExecProc(String sql)
	{
		try {
			
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    // sửa DESKTOP-9JGGVQQ\\SQLEXPRESS thành tên server, sửa 1433 thành cổng của server, databaseName bằng tên database muốn truy cập
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    
			Statement statement = connection.createStatement();
			int rs = statement.executeUpdate(sql);
			
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
	}
}
