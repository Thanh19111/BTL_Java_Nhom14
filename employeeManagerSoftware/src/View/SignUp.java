package View;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AccountManagementTest.AccountManagement_Main;
import Controller.SignUpListener;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private AccountManagement_Main amm;

	public SignUp() {
		amm = new AccountManagement_Main();
		this.init();
		setVisible(true);
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(71, 167, 206));
		panel_1.setBounds(0, 0, 402, 563);
		contentPane.add(panel_1);
		
		String logoPath = "D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\FPT_Software_logo.png";
        ImageIcon logoIcon = new ImageIcon(logoPath);
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(340, 140, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        panel_1.setLayout(null);
        JLabel logo = new JLabel(scaledLogoIcon);
        logo.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        logo.setBounds(44, 198, 303, 144);
        panel_1.add(logo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(402, 0, 484, 563);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel signUpText = new JLabel("SIGN UP");
		signUpText.setForeground(new Color(71, 167, 206));
		signUpText.setFont(new Font("Segoe UI", Font.BOLD, 45));
		signUpText.setBounds(156, 63, 202, 83);
		panel_2.add(signUpText);
		
		JLabel haveAccountText = new JLabel("I have an account");
		haveAccountText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		haveAccountText.setBounds(111, 498, 178, 38);
		panel_2.add(haveAccountText);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // quay lại giao diện login
                dispose(); // Đóng giao diện này
                Login loginFrame = new Login();
                loginFrame.setVisible(true);
            }
        });
		loginButton.setBounds(241, 497, 117, 38);
		panel_2.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBackground(new Color(71, 167, 206));
		loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		loginButton.setForeground(new Color(255, 255, 255));
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		usernameTextField.setBounds(111, 197, 285, 50);
		panel_2.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		passwordTextField = new JTextField();
		passwordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(111, 307, 285, 50);
		panel_2.add(passwordTextField);
		
		JButton signUpButton = new JButton("Sign Up");
		//chuyển sang controller khi nhân nút signup
		ActionListener ac = new SignUpListener(this);
		signUpButton.addActionListener(ac);
		signUpButton.setForeground(Color.WHITE);
		signUpButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		signUpButton.setBackground(new Color(71, 167, 206));
		signUpButton.setBounds(111, 385, 117, 38);
		panel_2.add(signUpButton);
		
		JLabel usernameText = new JLabel("Username\r\n");
		usernameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		usernameText.setBounds(111, 157, 90, 30);
		panel_2.add(usernameText);
		
		JLabel passwordText = new JLabel("Password\r\n");
		passwordText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordText.setBounds(111, 267, 90, 30);
		panel_2.add(passwordText);
	}
	
	public void sign_Up() {
	    String username = usernameTextField.getText();
	    String password = passwordTextField.getText();

	    if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không được để tài khoản trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (password.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không được để mật khẩu trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    int res = amm.signUp(username, password);
	    if (res == 1) {
	        JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } else if (res == 2) {
	        JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    } else if (res == 3) {
	        JOptionPane.showMessageDialog(this, "Không được để tài khoản trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } else if (res == 4) {
	        JOptionPane.showMessageDialog(this, "Không được để mật khẩu trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}

}
