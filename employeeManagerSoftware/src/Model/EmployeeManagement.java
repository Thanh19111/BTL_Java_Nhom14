package Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeManagement {

	List<Employee> employees;
    private static final String FILE_NAME = "D:\\Employee.txt";
    private static final String FILE_NAME1 = "D:\\Position.txt";
    private static final String FILE_NAME2 = "D:\\Department.txt";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    
    public EmployeeManagement() {
		employees = new ArrayList<>();
	}

	private List<Employee> loadEmployees() {
		employees.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] parts = line.split(",");
            	if (parts.length == 11) {
            		int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Date birthDate = new Date();
					try {
						birthDate = DATE_FORMAT.parse(parts[2]);
					} 
					catch (ParseException e) {
						e.printStackTrace();
					}
                    String gender = parts[3];
                    String hometown = parts[4];
                    String phoneNumber = parts[5];
                    Date hireDate = new Date();
					try {
						hireDate = DATE_FORMAT.parse(parts[6]);
					} 
					catch (ParseException e) {
						e.printStackTrace();
					}
                    float overtimeHours = Float.parseFloat(parts[8]);
                    
                    String positionName = parts[9];
                    Position employeePosition = positionNameCheck(positionName);
       
                    String departmentName = parts[10];
                    Department employeeDeparment = departmentNameCheck(departmentName);
                    
                    Employee employee = new Employee(id, name, birthDate, gender, hometown, phoneNumber, hireDate, overtimeHours, employeePosition, employeeDeparment);
                    employees.add(employee);
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int addEmployee(Employee newEmployee) {
    	this.loadEmployees();
    	for (Employee employee : employees) {
    		if (employee.getEmployeeId() == newEmployee.getEmployeeId()) {
    			return 6;
    		}
    	}
        employees.add(newEmployee);
        saveEmployees();
        return 7;
    }

    public int removeEmployee(int id) {
    	this.loadEmployees();
        for (Employee employee : employees) {
        	if (employee.getEmployeeId() == id) {
        		employees.remove(employee);
        		saveEmployees();
        		return 1;
        	}
        }
        return 2;
    }
    
    public Position positionNameCheck(String positionName) {
    	Position employeePosition;
    	try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME1))) {
            String line;
			while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                	if (parts[1].equals(positionName)) {
                		int positionID = Integer.parseInt(parts[0]);
                        String positionName1 = parts[1];
                        double positionSalary = Double.parseDouble(parts[2]);
                        employeePosition = new Position(positionID, positionName1, positionSalary);
                        return employeePosition;
                	}
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    	return employeePosition = new Position();
    }
    
    public Department departmentNameCheck(String departmentName) {
    	Department employeeDepartment;
    	try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME2))) {
            String line;
			while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                	if (parts[1].equals(departmentName)) {
                		int departmentID = Integer.parseInt(parts[0]);
                        String departmentName1 = parts[1];
                        String departmentAddress = parts[2];
                        String departmentPhoneNumber = parts[3];
                        employeeDepartment = new Department(departmentID, departmentName1, departmentAddress, departmentPhoneNumber);
                        return employeeDepartment;
                	}
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    	return employeeDepartment = new Department();
    }
    
    public int editEmployee(String id, String name, String bỉrthDate, String gender, String homeTown, 
							String phoneNumber, String hỉreDate, String overTimeHour, String positionName, String departmentName) {
    	this.loadEmployees();
    	int found = 0;
        for (Employee employee : employees) {
        	if (employee.getEmployeeId() == Integer.parseInt(id)) {
        		
        		employee.setEmployeeName(name);

                String birthDateString = bỉrthDate;
            	try {
                    Date birthDate2 = DATE_FORMAT.parse(birthDateString);
                    employee.setBirthDate(birthDate2);
                }
            	catch (ParseException e) {
                    System.out.println("Ngay sinh khong hop le.");
                    return 1;
                }
        		
        		employee.setGender(gender);
        		
        		employee.setHometown(homeTown);
        		
        		employee.setPhoneNumber(phoneNumber);
        		
                String hireDateString = hỉreDate;
            	try {
                    Date hireDate2 = DATE_FORMAT.parse(hireDateString);
                    employee.setHireDate(hireDate2);
                } 
            	catch (ParseException e) {
                    System.out.println("Ngay vao lam khong hop le.");
                    return 2;
                }
        		
        		employee.setOvertimeHours(Float.parseFloat(overTimeHour));
        		
        		Position check = positionNameCheck(positionName);
        		if (check.getPositionID() == 0) {
        			return 3;
        		}
        		else employee.setEmployeePosition(check);
        		
        		Department check1 = departmentNameCheck(departmentName);
        		if (check1.getDepartmentID() == 0) {
        			return 4;
        		}
        		else employee.setEmployeeDepartment(check1);
        		
        		saveEmployees();
        		found = 1;
        		break;
        	}
        }
        if (found == 0) return 5;
        else return 6;
    }
    
    public void employeeDisplay() {
    	this.loadEmployees();
    	for (Employee employee : employees) {
    		System.out.println(employee.toString());
    	}
    }

}