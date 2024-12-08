package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PositionManagement {
	
	 private static final String FILE_NAME = "D:\\Position.txt";
     private ArrayList<Position> positions;
    
    public PositionManagement(){
        this.positions = new ArrayList<Position>();
    }
    
    public void loadFromFile() {
		
    	positions.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                	
                	int positionID = Integer.parseInt(parts[0]);
                    String positionName = parts[1];
                    double positionSalary = Double.parseDouble(parts[2]);
                    
                    Position position = new Position(positionID, positionName, positionSalary);
                    positions.add(position);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Position position : positions) {
                writer.write(position.toString());
                writer.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public int addPosition(Position x){
    	loadFromFile();
    	for (Position position : positions) {
    		if (position.getPositionID() == x.getPositionID()) {
    			return 1;
    		}
    	}
        this.positions.add(x);
        saveToFile();
        return 2;
    }
    
    public int removePosition(String id){
    	this.loadFromFile();
    	for (Position position : positions) {
    		if (position.getPositionID() == Integer.parseInt(id)) {
    			positions.remove(position);
    			this.saveToFile();
    			return 1;
    		}
    	}
    	return 2;
    }
    
    public int editPosition(String id, String positionName, String salary) {
    	this.loadFromFile();
        for(Position position : positions){
            if(position.getPositionID() == Integer.parseInt(id)){
            	position.setPositionName(positionName);
            	position.setPositionSalary(Double.parseDouble(salary));
            	this.saveToFile();
                return 1;
            }
        }
        return 2;
    }
    
    public void displayPosition(){
    	this.loadFromFile();
    	if (positions == null) System.out.println("Danh sach chuc vu rong");
        for(Position position : positions){
            System.out.println(position.toString());
        }
    }
}