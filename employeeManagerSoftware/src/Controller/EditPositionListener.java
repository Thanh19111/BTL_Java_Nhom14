package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionManagement_EditPosition;

public class EditPositionListener implements ActionListener{

	private PositionManagement_EditPosition pmep;
	
	public EditPositionListener(PositionManagement_EditPosition pmep) {
		this.pmep = pmep;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pmep.edit_Position();
	}

}
