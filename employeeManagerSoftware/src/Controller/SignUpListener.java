package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.SignUp;

public class SignUpListener implements ActionListener{
		private SignUp signUp;

		public SignUpListener(SignUp signUp) {
			this.signUp = signUp;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			signUp.sign_Up();
		}	
}
