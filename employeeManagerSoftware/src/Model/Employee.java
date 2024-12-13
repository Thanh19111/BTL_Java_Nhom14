package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data.DatabaseConnection;
import Utils.Utils;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String birthDate;
    private String gender;
    private String hometown;
    private String phoneNumber;
    private String hireDate;
    private double salary;
    private float overtimeHours;
    private int employeePosition;
    private int employeeDepartment;

    public Employee() {}

    public Employee(int employeeId, String employeeName, String birthDate, String gender, String hometown, String phoneNumber, String hireDate, float overtimeHours, int employeePosition, int employeeDepartment) {
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
//        this.salary = salaryCalculation();
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
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

    public int getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(int employeePosition) {
        this.employeePosition = employeePosition;
    }

    public int getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(int employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


    public boolean positionIDCheck(int positionID) {
    
        ArrayList<Position> arr = DatabaseConnection.PositionQuery("select * from Position");
        //System.out.print(arr);
        for (Position position : arr) {
			if(position.getPositionID() == positionID)
			{
				return true;
			}
		}
        return false;
    	
    }
    
    public boolean departmentIDCheck(int department) {
        ArrayList<Department> arr = DatabaseConnection.DepartmentQuery("select * from Department");
        //System.out.print(arr);
        for (Department deparment : arr) {
			if(deparment.getDepartmentID() == department)
			{
				return true;
			}
		}
        return false;
    }
    
    public int input(String id, String name, String birthDate, String gender, String homeTown, 
    					String phoneNumber, String hỉreDate1, String salary, String overTimeHour, String positionID, String departmentID)
    {
    	
    	this.setEmployeeId(Integer.parseInt(id));
    	
		this.setEmployeeName(name);
		this.setSalary(Double.parseDouble(salary));
		
		

		
		this.setBirthDate(birthDate);
		this.setGender(gender);
		
		this.setHometown(homeTown);
		
		this.setPhoneNumber(phoneNumber);
		
		

		
		
		this.setHireDate(hỉreDate1);
		
		this.setOvertimeHours(Float.parseFloat(overTimeHour));
		
		Boolean check = positionIDCheck(Integer.parseInt(positionID));
		
		if (check == false) {
			return 3;
		}
		else this.setEmployeePosition(Integer.parseInt(positionID));
		
		Boolean check1 = departmentIDCheck(Integer.parseInt(departmentID));
		if (check1 == false) {
			return 4;
		}
		else this.setEmployeeDepartment(Integer.parseInt(departmentID));
		
		return 5;
    }
}