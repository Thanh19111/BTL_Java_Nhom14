package Model;
import java.util.*;

import Data.DatabaseConnection;

public class PositionManagement {
	
	 private ArrayList<Position> positions = new ArrayList<Position>();

    public PositionManagement(){
       loadPositions();
    }  
    public void loadPositions() {
    	positions.clear();
        positions = DatabaseConnection.Pos("select * from Position");
    }
    
    public int addPosition(int id, String pos, Double salar) {
    	loadPositions();
        if (positions == null) {
            positions = new ArrayList<>();
            
        }
     
        for (Position pq : positions) {
            if (pq.getPositionID() == id) {
                System.out.println("ID đã tồn tại.");
                return 1; 
            }
        }

        String sql = "EXECUTE AddPosition " + id + ", '" + pos + "', " + salar;
        DatabaseConnection.PositionExec(sql);
        System.out.println("Thêm thành công.");
        return 2;
    }
    public int removePosition(String id){
    	ArrayList<Position> arrayList = DatabaseConnection.PositionQuery("select * from Position");
    	for (Position ps : arrayList)
    	{
    		if(ps.getPositionID() == Integer.parseInt(id))
    		{
    		    String sql = "EXECUTE DeletePosition "+id+"";
    			 DatabaseConnection.PositionExec(sql);
    			System.out.print("Xóa tài khoản thành công");
    			return 1;
    		}
    	}
    	return 2;
    	
    	}

    
    public int editPosition(String id, String positionName, String salary) {
    	
    	ArrayList<Position> arrayList = DatabaseConnection.PositionQuery("select * from Position");
    	for (Position ps : arrayList)
    	{
    		if(ps.getPositionID() == Integer.parseInt(id))
    		{
    			String sql = "EXECUTE UpdatePosition " + id +","+positionName+","+salary+"";
    			DatabaseConnection.PositionExec(sql);
    			System.out.print("Sửa tài khoản thành công");
    			return 1;
    		}
    	}
    	return 2;
    }
    
    public void displayPosition(){
    	loadPositions();
    	if (positions.isEmpty())
    	{
    		System.out.println("Không có tài khoản nào trong hệ thống.");
    	} else {
            System.out.println("Danh sách tài khoản:");
            for (Position ps : positions) {
                System.out.println(ps.toString());
            }
        }
    }
    public ArrayList<Position> getPositions() {
        return DatabaseConnection.Pos("SELECT * from Position");
}
}