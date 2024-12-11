package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.DepartmentManagement_Add;

public class AddDepartmentListener implements ActionListener {

	private DepartmentManagement_Add dma;
	
	public AddDepartmentListener(DepartmentManagement_Add dma) {
		this.dma = dma;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dma.add_department();
	}

}
