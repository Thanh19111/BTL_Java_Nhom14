package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    private int employeeId;
    private String employeeName;
    private Date birthDate;
    private String gender;
    private String hometown;
    private String phoneNumber;
    private Date hireDate;
    private double salary;
    private float overtimeHours;
    private Position employeePosition;
    private Department employeeDepartment;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Employee() {}

    public Employee(int employeeId, String employeeName, Date birthDate, String gender, String hometown, String phoneNumber, Date hireDate, float overtimeHours, Position employeePosition, Department employeeDepartment) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hometown = hometown;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.overtimeHours = overtimeHours;
        this.employeePosition = employeePosition;
        this.employeeDepartment = employeeDepartment;
        this.salary = salaryCalculation();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public float getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(float overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public Position getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(Position employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public double salaryCalculation() {
        return employeePosition.getPositionSalary() + overtimeHours * 0.1;
    }

    @Override
    public String toString() {
        return employeeId + "," +
               employeeName + "," +
               DATE_FORMAT.format(birthDate) + "," +
               gender + "," +
               hometown + "," +
               phoneNumber + "," +
               DATE_FORMAT.format(hireDate) + "," +
               salary + "," +
               overtimeHours + "," +
               employeePosition.getPositionName() + "," +
               employeeDepartment.getDepartmentName();
    }
    
    public Position positionNameCheck(String positionName) {
    	final String FILE_NAME1 = "D:\\Position.txt";
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
    	final String FILE_NAME2 = "D:\\Department.txt";
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
    
    public int intput(String id, String name, String bỉrthDate, String gender, String homeTown, 
    					String phoneNumber, String hỉreDate, String overTimeHour, String positionName, String departmentName) {
    	
    	this.setEmployeeId(Integer.parseInt(id));
    	
		this.setEmployeeName(name);
		
        String birthDateString = bỉrthDate;
    	try {
            Date birthDate2 = DATE_FORMAT.parse(birthDateString);
            this.setBirthDate(birthDate2);
        } 
    	catch (ParseException e) {
            System.out.println("Ngay sinh khong hop le.");
            return 1;
        }    
		
		this.setGender(gender);
		
		this.setHometown(homeTown);
		
		this.setPhoneNumber(phoneNumber);
		
        String hireDateString = hỉreDate;
    	try {
            Date hireDate2 = DATE_FORMAT.parse(hireDateString);
            this.setHireDate(hireDate2);
        } 
    	catch (ParseException e) {
            System.out.println("Ngay vao lam khong hop le.");
            return 2;
        }
    	
    	float overTimeHour2 = Float.parseFloat(overTimeHour);
		this.setOvertimeHours(overTimeHour2);
		
		Position check = positionNameCheck(positionName);
		if (check.getPositionID() == 0) {
			return 3;
		}
		else this.setEmployeePosition(check);
		
		Department check1 = departmentNameCheck(departmentName);
		if (check1.getDepartmentID() == 0) {
			return 4;
		}
		else this.setEmployeeDepartment(check1);
		
		return 5;
    }
}