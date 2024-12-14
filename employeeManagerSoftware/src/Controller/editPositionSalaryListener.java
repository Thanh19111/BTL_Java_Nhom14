package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionSalaryManagement_EditEmployeeSalary;

public class editPositionSalaryListener implements ActionListener{

	private PositionSalaryManagement_EditEmployeeSalary psmeps;
	
	
	public editPositionSalaryListener(PositionSalaryManagement_EditEmployeeSalary psmeps) {
		this.psmeps = psmeps;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		psmeps.editPositionSalary();
	}
	
}
