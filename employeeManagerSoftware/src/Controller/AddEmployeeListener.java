package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.EmployeeManagement_AddEmployee;

public class AddEmployeeListener implements ActionListener{

	private EmployeeManagement_AddEmployee emae;

	public AddEmployeeListener(EmployeeManagement_AddEmployee emae) {
		this.emae = emae;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		emae.add_employee();
	}

}
