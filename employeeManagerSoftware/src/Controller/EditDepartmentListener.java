package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.DepartmentManagement_Edit;

public class EditDepartmentListener implements ActionListener{

	private DepartmentManagement_Edit dme;

	public EditDepartmentListener(DepartmentManagement_Edit dme) {
		this.dme = dme;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dme.edit_department();
	}

}
