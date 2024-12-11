package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.DepartmentManagement_Remove;

public class RemoveDepartmentListener implements ActionListener{

	private DepartmentManagement_Remove dmr;

	public RemoveDepartmentListener(DepartmentManagement_Remove dmr) {
		this.dmr = dmr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dmr.remove_department();
	}

}
