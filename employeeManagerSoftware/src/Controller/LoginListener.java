package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Login;

public class LoginListener implements ActionListener{

	private Login login;
	
	public LoginListener(Login login) {
		this.login = login;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		login.log_in(); //Code đc thực hiện khi nút Login đc bấm
	}
	
}
