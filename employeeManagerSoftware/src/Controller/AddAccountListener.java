package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AccountManagement_Add;

public class AddAccountListener implements ActionListener {
	private AccountManagement_Add ama;
	
	public AddAccountListener(AccountManagement_Add acv) {
		this.ama = acv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ama.add_Account();
	}
	
}
