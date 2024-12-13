package Model;
import java.util.ArrayList;

import Data.DatabaseConnection;
import Utils.Utils;

public class DepartmentManagement {
	
	private ArrayList<Department> departments;
	
	public DepartmentManagement() {
		this.departments = new ArrayList<>();
	}
	
	public void loadFromDatabase() {
        departments.clear();
        departments = DatabaseConnection.DepartmentQuery("select * from Department");
    }
	
	public int addDepartment(Department x) {
		this.loadFromDatabase();
		for (Department d : departments) {
			if (d.getDepartmentID() == x.getDepartmentID()) {
				return 1;
			}
		}
		
		departments.add(x);
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		String sql = "EXECUTE AddDepartment " + x.getDepartmentID() + ", N'" + x.getDepartmentName() +"'" + ", N'" + x.getDepartmentAddress() +"'" + ", N'" + x.getDepartmentPhoneNumber() + "'";
		////////////////////////////////////////////////////////////////////////////////////////////
		DatabaseConnection.DeparmentExecProc(sql);
		return 2;
	}
	
	public int removeDepartment(String id) {
		this.loadFromDatabase();
		
		Integer integer = Utils.parseIntegerOrNull(id);
		
		if(integer == null)
		{
			return 3;
		}
		for (Department department : departments) {
			if (department.getDepartmentID() == integer) {
	
				////////////////////////////////////////////////////////
				String sql = "EXECUTE DeleteDepartment " + id;
				DatabaseConnection.DeparmentExecProc(sql);
				///////////////////////////////////////////////////////
				return 1;
			}
		}
		return 2;
	}
	
	public int editDepartment(String id, String name, String address, String phoneNumber) {
		this.loadFromDatabase();
		Integer in = Utils.parseIntegerOrNull(id);
		if(in==null)
		{
			return 3;
		}
		
		for (Department department : departments) {
			if (department.getDepartmentID() == in) {
				//////////////////////////////////////////////////////////////////////////
				String sql = "EXECUTE UpdateDepartment " + id + ", N'" + name +"'" + ", N'" + address +"'" + ", N'" + phoneNumber + "'";
				DatabaseConnection.DeparmentExecProc(sql);
				/////////////////////////////////////////////////////
				return 1;
			}
		}
		return 2;
	}
	
	public void departmentDisplay() {
		this.loadFromDatabase();
		for (Department department : departments) {
			System.out.println(department.toString());
		}
	}
	
	public boolean departmentSearch(int ID) {
		this.loadFromDatabase();
		for (Department department : departments) {
			if (department.getDepartmentID() == ID) {
				System.out.println(department.toString());
				return true;
			}
		}
		return false;
	}
	
}