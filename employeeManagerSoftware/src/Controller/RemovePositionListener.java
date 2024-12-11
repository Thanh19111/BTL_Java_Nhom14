package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionManagement_RemovePosition;

public class RemovePositionListener implements ActionListener{

	private PositionManagement_RemovePosition pmrp;
	
	public RemovePositionListener(PositionManagement_RemovePosition pmrp) {
		this.pmrp = pmrp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pmrp.remove_position();
	}

}
