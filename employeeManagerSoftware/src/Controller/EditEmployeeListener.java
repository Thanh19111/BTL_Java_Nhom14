package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.EmployeeManagement_EditEmployee;

public class EditEmployeeListener implements ActionListener{

	private EmployeeManagement_EditEmployee emee;
	
	public EditEmployeeListener(EmployeeManagement_EditEmployee emee) {
		this.emee = emee;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		emee.edit_employee();
	}
	
}
