package Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Data.DatabaseConnection;
import Utils.Utils;

public class EmployeeManagement {

	List<Employee> employees;
    
    public EmployeeManagement() {
		employees = new ArrayList<>();
	}
    public void loadFromDatabase() {
        employees.clear();
        employees = DatabaseConnection.EmployeeQuery("select * from Employee");
    }
	
	public int addEmployee(Employee x) {
		ArrayList<Employee> arrayList = DatabaseConnection.EmployeeQuery("select * from Employee");
		for (Employee d : arrayList) {
			if (d.getEmployeeId() == x.getEmployeeId()) {
				return 6;
			}
		}

		String sql = "EXECUTE AddEmployee " +
	             x.getEmployeeId() + ", " +
	             "N'" + x.getEmployeeName() + "', " +
	             "'" + x.getBirthDate() + "', " +
	             "N'" + x.getGender() + "', " +
	             "N'" + x.getHometown() + "', " +
	             "N'" + x.getPhoneNumber() + "', " +
	             "'" + x.getHireDate() + "', " +
	             x.getSalary() + ", " +
	             x.getOvertimeHours() + ", " +
	             "N'" + x.getEmployeePosition() + "', " +
	             "N'" + x.getEmployeeDepartment() + "'";
		
		DatabaseConnection.DeparmentExecProc(sql);
		return 7;
	}



    public int removeEmployee(String id) {
    	int find = Integer.parseInt(id);
		this.loadFromDatabase();
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == find) {
	
				////////////////////////////////////////////////////////
				String sql = "EXECUTE DeleteEmployee " + find;
				DatabaseConnection.EmployeeExecProc(sql);
				///////////////////////////////////////////////////////
				return 1;
			}
		}
		return 2;
	}

    public int editEmployee(String id, String name, String birthDate, String gender, String homeTown, 
							String phoneNumber, String hireDate, String salary, String overTimeHour, String positionName, String departmentName) {
   
    	this.loadFromDatabase();
    	int find = Integer.parseInt(id);
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == find) {
				//////////////////////////////////////////////////////////////////////////
				String sql = "EXECUTE UpdateEmployee " +
			             id + ", " +
			             "N'" + name + "', " +
			             "'" + birthDate + "', " +
			             "N'" + gender + "', " +
			             "N'" + homeTown+ "', " +
			             "N'" + phoneNumber + "', " +
			             "'" + hireDate + "', " +
			             salary + ", " +
			             overTimeHour + ", " +
			             "N'" + positionName + "', " +
			             "N'" + departmentName + "'";
				
				DatabaseConnection.DeparmentExecProc(sql);
				/////////////////////////////////////////////////////
				return 6;
			}
		}
		return 5;
	}
    
 	public boolean EmployeeSearch(int ID) {
		ArrayList<Employee> arrayList = DatabaseConnection.EmployeeQuery("select * from Employee");
		for (Employee employee : arrayList) {
			if (employee.getEmployeeId() == ID) {
				return true;
			}
		}
		return false;
	}
 	
 	public ArrayList<Employee> getAllEmployee()
 	{
 		return DatabaseConnection.EmployeeQuery("select * from Employee");
 	}

}