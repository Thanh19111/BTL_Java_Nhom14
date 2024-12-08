package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PositionSalaryManagement {
	
	private ArrayList<Position> positionList;
	private static final String FILE_NAME = "D:\\Position.txt";
	
	public PositionSalaryManagement() {
		positionList = new ArrayList<>();
	}
	
	public void loadFromFile() {
		
        positionList.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                	
                	int positionID = Integer.parseInt(parts[0]);
                    String positionName = parts[1];
                    double positionSalary = Double.parseDouble(parts[2]);
                    
                    Position x = new Position(positionID, positionName, positionSalary);
                    positionList.add(x);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	 
	public void saveToFile() {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
	            for (Position x : positionList) {
	                writer.write(x.toString());
	                writer.newLine();
	            }
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
	 
    public void displayPositions() {
    	this.loadFromFile();
        System.out.printf("%-5s %-20s %-15s %n", "ID", "Name", "Salary");
        for (Position x : positionList) {
        	System.out.printf("%-5d %-20s %-15.2f %n", x.getPositionID(), x.getPositionName(), x.getPositionSalary());
        }
    }
    
    public int positionSalaryEdit(String id, String salary) {
    	this.loadFromFile();
        for (Position x : positionList) {
            if (x.getPositionID() == Integer.parseInt(id)) {
                x.setPositionSalary(Double.parseDouble(salary));
                this.saveToFile();
                return 1;
            }
        }
        return 2;
    }
}