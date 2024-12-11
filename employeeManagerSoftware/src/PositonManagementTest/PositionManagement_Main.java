package PositonManagementTest;

import Model.Position;
import Model.PositionManagement;

public class PositionManagement_Main {

	private PositionManagement pm;
	
	public PositionManagement_Main() {
	    this.pm = new PositionManagement();
	}

        
    public int addPosition(String id, String positionName, String salary) {
    	Position ps = new Position(Integer.parseInt(id), positionName, Double.parseDouble(salary));
    	return pm.addPosition(ps);
    }
    	
    public int removePosition(String id) {
    	return pm.removePosition(id);
    }
    
    public int editPosition(String id, String positionName, String salary) {
    	return pm.editPosition(id, positionName, salary);
    }
            
}