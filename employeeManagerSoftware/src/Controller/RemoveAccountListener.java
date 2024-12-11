package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AccountManagement_Remove;

public class RemoveAccountListener implements ActionListener{

	private AccountManagement_Remove amr;
	
	public RemoveAccountListener(AccountManagement_Remove amr) {
		this.amr = amr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		amr.remove_account();
	}

}
