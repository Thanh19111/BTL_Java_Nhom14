package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Report {
	
	private HashMap<String, Integer> hashMap;
	private HashMap<String, Double> hashMap2;
	private static final String FILE_NAME = "D:\\Employee.txt";
	private static final String FILE_NAME2 = "D:\\Position.txt";

	public Report() {
		this.hashMap = new HashMap<>();;
		this.hashMap2 = new HashMap<>();
	}

	public int totalEmployee() {
		int sum = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while ((reader.readLine()) != null) {
                sum++;
            }
            return sum;
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
		return sum;
	}
	
	public void totalEmployeeByPosition() {
		hashMap.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 11) {
                	String positionCheck = parts[9];
                    if (hashMap.containsKey(positionCheck)) {
                    	int currentValue = hashMap.get(positionCheck);
                    	hashMap.put(positionCheck, currentValue+1);
                    }
                    else {
                    	hashMap.put(positionCheck, 1);
                    }
                }
            }
            
            if (hashMap.isEmpty()) System.out.println("Danh sach nhan vien rong");
            else {
            	System.out.printf("%-20s %-5s %n", "Chuc vu", "So luong nhan vien");
                for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.printf("%-20s %-5d %n", key, value);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void salaryByPosition() {
		hashMap2.clear();
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME2))) {
			
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                	String positionCheck = parts[1];
                	double positionSalary = Double.parseDouble(parts[2]);
                    if (!hashMap.containsKey(positionCheck)) {
                    	hashMap2.put(positionCheck, positionSalary);
                    }
                }
            }
            
            if (hashMap2.isEmpty()) System.out.println("Danh sach chuc vu rong");
            else {
            	System.out.printf("%-20s %-15s %n", "Chuc vu", "Muc luong");
                for (HashMap.Entry<String, Double> entry : hashMap2.entrySet()) {
                    String key = entry.getKey();
                    Double value = entry.getValue();
                    System.out.printf("%-20s %-15.2f %n", key, value);
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}