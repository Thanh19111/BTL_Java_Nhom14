package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    	loadPositions();
        for (Position x : positionList) {
            if (x.getPositionID() == Integer.parseInt(id)) {
            	String sql = "EXECUTE UpdateSal " + id +","+salary+"";
    			DatabaseConnection.PositionExec(sql);
    			System.out.print("Sửa tài khoản thành công");
                return 1;
            }
        }
        return 2;
    }
    
}