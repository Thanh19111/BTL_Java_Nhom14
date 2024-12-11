package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.EmployeeManagement_RemoveEmployee;

public class RemoveEmployeeListener implements ActionListener{

	private EmployeeManagement_RemoveEmployee emre;
	
	public RemoveEmployeeListener(EmployeeManagement_RemoveEmployee emre) {
		super();
		this.emre = emre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		emre.remove_employee();
	}

}
