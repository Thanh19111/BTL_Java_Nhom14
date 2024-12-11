package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.DepartmentManagement_ViewMain;

public class DepartmentViewListener implements ActionListener {

	private DepartmentManagement_ViewMain dmvm;
		
	public DepartmentViewListener(DepartmentManagement_ViewMain dmvm) {
		this.dmvm = dmvm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dmvm.department_search();
	}

}
