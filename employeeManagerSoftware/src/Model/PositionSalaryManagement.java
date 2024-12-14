package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Data.DatabaseConnection;

public class PositionSalaryManagement {
	
	private ArrayList<Position> positionList = new ArrayList<Position>();
	
	
	public PositionSalaryManagement(){
	       loadPositions();
	    }  
	    public void loadPositions() {
	    	positionList.clear();
	    	positionList = DatabaseConnection.Pos("select * from Position");
	    }
	   
    public void displayPositions() {
    	loadPositions();
        System.out.printf("%-5s %-20s %-15s %n", "ID", "Name", "Salary");
        for (Position x : positionList) {
        	System.out.printf("%-5d %-20s %-15.2f %n", x.getPositionID(), x.getPositionName(), x.getPositionSalary());
        }
    }
    
    public int positionSalaryEdit(String id, String salary) {
    	ArrayList<Employee> arrayList = DatabaseConnection.EmployeeQuery("Select * from Employee Where employeeId = " + id);
    	if(!arrayList.isEmpty())
    	{
    		String sql = "EXECUTE EditSalary " + id +","+salary+"";
			DatabaseConnection.PositionExec(sql);
			System.out.print("Cập nhật thành công");
            return 1;
        }
        return 2;
    }
    
}