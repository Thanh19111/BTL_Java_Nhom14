package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionSalaryManagement_EditPositionSalary;

public class editPositionSalaryListener implements ActionListener{

	private PositionSalaryManagement_EditPositionSalary psmeps;
	
	
	public editPositionSalaryListener(PositionSalaryManagement_EditPositionSalary psmeps) {
		this.psmeps = psmeps;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		psmeps.editPositionSalary();
	}
	
}
