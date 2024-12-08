package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DepartmentManagement {
	
	private ArrayList<Department> departments;
	private static final String FILE_NAME = "D:\\Department.txt";
	
	public DepartmentManagement() {
		this.departments = new ArrayList<>();
	}
	
	public void loadFromFile() {
		
        departments.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                	
                	int departmentID = Integer.parseInt(parts[0]);
                    String departmentName = parts[1];
                    String departmentAddress = parts[2];
                    String departmentPhoneNumber = parts[3];
                    
                    Department x = new Department(departmentID, departmentName, departmentAddress, departmentPhoneNumber);
                    departments.add(x);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Department x : departments) {
                writer.write(x.toString());
                writer.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public int addDepartment(Department x) {
		this.loadFromFile();
		for (Department y : departments) {
			if (y.getDepartmentID() == x.getDepartmentID()) {
				return 1;
			}
		}
		departments.add(x);
		this.saveToFile();
		return 2;
	}
	
	public int removeDepartment(String id) {
		this.loadFromFile();
		for (Department department : departments) {
			if (department.getDepartmentID() == Integer.parseInt(id)) {
				departments.remove(department);
				this.saveToFile();
				return 1;
			}
		}
		return 2;
	}
	
	public int editDepartment(String id, String positionName, String address, String phontNumber) {
		this.loadFromFile();
		for (Department department : departments) {
			if (department.getDepartmentID() == Integer.parseInt(id)) {
				department.setDepartmentName(positionName);
				department.setDepartmentAddress(address);
				department.setDepartmentPhoneNumber(phontNumber);
				this.saveToFile();
				return 1;
			}
		}
		return 2;
	}
	
	public void departmentDisplay() {
		this.loadFromFile();
		for (Department department : departments) {
			System.out.println(department.toString());
		}
	}
	
	public boolean departmentSearch(int ID) {
		this.loadFromFile();
		for (Department department : departments) {
			if (department.getDepartmentID() == ID) {
				System.out.println(department.toString());
				return true;
			}
		}
		return false;
	}
	
}