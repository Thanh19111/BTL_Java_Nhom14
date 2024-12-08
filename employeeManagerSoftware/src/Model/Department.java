package Model;

import java.util.Scanner;

public class Department {
	
	private int departmentID;
	private String departmentName;
	private String departmentAddress;
	private String departmentPhoneNumber;
	
	public Department() {
		this.departmentID = 0;
		this.departmentName = "";
		this.departmentAddress = "";
		this.departmentPhoneNumber = "";
	}
	
	public Department(int departmentID, String departmentName, String departmentAddress, String departmentPhoneNumber) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentPhoneNumber = departmentPhoneNumber;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentAddress() {
		return departmentAddress;
	}
	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}
	
	public String getDepartmentPhoneNumber() {
		return departmentPhoneNumber;
	}
	public void setDepartmentPhoneNumber(String departmentPhoneNumber) {
		this.departmentPhoneNumber = departmentPhoneNumber;
	}

	@Override
	public String toString() {
		return departmentID + "," + departmentName + "," + departmentAddress + "," + departmentPhoneNumber;
	}
	
	public void input(Scanner sc) {
		System.out.println("Nhap ID: ");
		this.setDepartmentID(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhap ten phong ban: ");
		this.setDepartmentName(sc.nextLine());
		System.out.println("Nhap dia chi: ");
		this.setDepartmentAddress(sc.nextLine());
		System.out.println("Nhap so dien thoai: ");
		this.setDepartmentPhoneNumber(sc.nextLine());
	}
	
}