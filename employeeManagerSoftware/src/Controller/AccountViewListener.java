
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.AccountManagement_ViewMain;

public class AccountViewListener implements ActionListener{

	private AccountManagement_ViewMain am;
	
	public AccountViewListener(AccountManagement_ViewMain am) {
		super();
		this.am = am;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		am.account_search();
	}

}
