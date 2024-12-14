package main;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.DatabaseConnection;
import View.Login;

public class Main {
	public static void main(String[] args) {

		Login loginView = new Login();
	
		String sqlString = "select Employee.employeeId,Employee.employeeName,Employee.birthDate,Employee.gender,Employee.hometown,Employee.phoneNumber,Employee.hireDate,Employee.salary,Position.positionSalary as LuongCB, Employee.overtimeHours,Position.positionName,Department.departmentName,Position.positionSalary * Employee.salary as Luong\r\n"
				+ "from Employee inner join Department\r\n"
				+ "	on Employee.departmentID = Department.departmentID\r\n"
				+ "inner join Position\r\n"
				+ "	on Employee.positionID = Position.positionID\r\n"
				+ "";
		

		
		ResultSet rSet = DatabaseConnection.QueryAll(sqlString);
		
		try {
			while(rSet.next())
			{
				int id = rSet.getInt(1);
				String name = rSet.getString(2);
				String birth = rSet.getString(3);
				String gender = rSet.getString(4);
				String home = rSet.getNString(5);
				String phone = rSet.getNString(6);
				String hire = rSet.getString(7);
				float hsluong = rSet.getFloat(8);
				float luongcb = rSet.getFloat(9);
				Float overhours = rSet.getFloat(10);
				String pnam = rSet.getNString(11);
				String dname = rSet.getNString(12);
				float luong = rSet.getFloat(13);
				
				
				
				System.out.println(id + " " + name + " " + birth + " " + gender + " " + home + " " + phone + " " + hire + " " + hsluong + " " + luongcb + " "
						+ " " + overhours + " "+ pnam + " " + dname + " " + luong);
			}
			
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		
	}
}
