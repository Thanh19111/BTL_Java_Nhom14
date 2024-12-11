package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AccountManagement_Edit;


public class EditAccountListener implements ActionListener {
	private AccountManagement_Edit ame;
	
	public EditAccountListener(AccountManagement_Edit ame) {
		this.ame = ame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ame.edit_account();
	}
	
}
