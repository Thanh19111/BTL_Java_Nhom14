package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Account;
import Model.Department;
import Model.Employee;
import Model.Position;

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
	public static ArrayList<Employee> EmployeeQuery(String sql)
	{
		ArrayList<Employee> arr = new ArrayList<Employee>();
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
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setBirthDate(rs.getDate(3).toString());
				employee.setGender(rs.getString(4));
				employee.setHometown(rs.getString(5));
				employee.setPhoneNumber(rs.getString(6));
				employee.setHireDate(rs.getDate(7).toString());
				employee.setSalary(rs.getDouble(8));
				employee.setOvertimeHours(rs.getFloat(9));
				employee.setEmployeePosition(rs.getInt(10));
				employee.setEmployeeDepartment(rs.getInt(11));
				arr.add(employee);
				
			}
			System.out.println(rs);
		    
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
		return arr;
	}
	public static void EmployeeExecProc(String sql)
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
	
	public static void PositionExecProc(String sql)
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
	public static ArrayList<Position> PositionQuery(String sql)
	{
		ArrayList<Position> arr = new ArrayList<Position>();
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
				Position position = new Position();
				position.setPositionID(rs.getInt(1));
				position.setPositionName(rs.getString(2));
				position.setPositionSalary(rs.getDouble(3));
				arr.add(position);
				
			}
			System.out.println(rs);
		    
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
		return arr;
	}

	public static ArrayList<Position> Pos(String sql)
	{
		ArrayList<Position> pss = new ArrayList<Position>();
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    // sửa DESKTOP-9JGGVQQ\\SQLEXPRESS thành tên server, sửa 1433 thành cổng của server, databaseName bằng tên database muốn truy cập
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		//"jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true"
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
			{
				Position ps = new Position();
				ps.setPositionID(rs.getInt(1));
				ps.setPositionName(rs.getString(2));
				ps.setPositionSalary(rs.getDouble(3));
				pss.add(ps);
			}
		   
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}return pss;
	}
	
	public static void PositionExec(String sql)
	{
		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    // sửa DESKTOP-9JGGVQQ\\SQLEXPRESS thành tên server, sửa 1433 thành cổng của server, databaseName bằng tên database muốn truy cập
		    String url = "jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true";
		//"jdbc:sqlserver://DESKTOP-9JGGVQQ\\SQLEXPRESS:1433;databaseName=QuanLyNhanVien;encrypt=true;trustServerCertificate=true"
		    String username = "sa";
		    String password = "abc123";
		    
		    Connection connection = DriverManager.getConnection(url, username, password);
		    
			Statement statement = connection.createStatement();
			int set = statement.executeUpdate(sql);
			
		} catch (Exception e) {
		    System.out.println("Kết nối thất bại!");
		    e.printStackTrace();
		}
	}
	
}
