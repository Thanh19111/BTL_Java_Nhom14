package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.EmployeeManagement_View;

public class EmployeeViewListener implements ActionListener{

	private EmployeeManagement_View emmv;
	
	public EmployeeViewListener(EmployeeManagement_View emmv) {
		this.emmv = emmv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		emmv.employee_search();
	}

}
