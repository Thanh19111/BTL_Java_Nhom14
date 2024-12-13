package View;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import AccountManagementTest.AccountManagement_Main;
import Controller.LoginListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextfield;
	private JTextField passwordTextfield;
	private AccountManagement_Main amm;
	
	public Login() {		//Hàm này lúc đầu là hàm main
		this.amm = new AccountManagement_Main();
		this.init();
		setVisible(true);
	}

	public void init() {			//Hàm này ban đầu là hàm khởi tạo
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
		
		String logoPath = "D:\\Users\\Downloads\\lg.png";
                ImageIcon logoIcon = new ImageIcon(logoPath);
                Image logoImage = logoIcon.getImage();
                Image scaledLogoImage = logoImage.getScaledInstance(340, 140, Image.SCALE_SMOOTH);
                ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
                panel_1.setLayout(null);
                JLabel logo = new JLabel(scaledLogoIcon);
                logo.setBounds(10, 146, 352, 332);
                panel_1.add(logo);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(402, 0, 484, 563);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel loginText = new JLabel("LOGIN");
		loginText.setForeground(new Color(71, 167, 206));
		loginText.setFont(new Font("Segoe UI", Font.BOLD, 45));
		loginText.setBounds(175, 63, 146, 83);
		panel_2.add(loginText);
		
		JLabel noAccountText = new JLabel("I don't have an account");
		noAccountText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		noAccountText.setBounds(111, 498, 178, 38);
		panel_2.add(noAccountText);
		
		JButton signUpButton = new JButton("Sign Up");
                
		signUpButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SignUp signUpFrame = new SignUp();
                    signUpFrame.setVisible(true);		
                    dispose();		
                    }
                });
		
		signUpButton.setBounds(279, 498, 117, 38);
		panel_2.add(signUpButton);
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpButton.setBackground(new Color(71, 167, 206));
		signUpButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		signUpButton.setForeground(new Color(255, 255, 255));
		
		usernameTextfield = new JTextField();
		usernameTextfield.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		usernameTextfield.setBounds(111, 197, 285, 50);
		panel_2.add(usernameTextfield);
		usernameTextfield.setColumns(10);
		
		passwordTextfield = new JTextField();
		passwordTextfield.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordTextfield.setColumns(10);
		passwordTextfield.setBounds(111, 307, 285, 50);
		panel_2.add(passwordTextfield);
		
		JButton loginButton = new JButton("Login\r\n");
		/* 2 dòng code kế tiếp chịu trách nhiệm chuyển sang loginListener (controller của giao diện này) khi nút loginButton 
		đc bấm */
		ActionListener ac = new LoginListener(this);
		loginButton.addActionListener(ac);
		
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		loginButton.setBackground(new Color(71, 167, 206));
		loginButton.setBounds(111, 385, 117, 38);
		panel_2.add(loginButton);
		
		JLabel usernameText = new JLabel("Username\r\n");
		usernameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		usernameText.setBounds(111, 157, 90, 30);
		panel_2.add(usernameText);
		
		JLabel passwordText = new JLabel("Password\r\n");
		passwordText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		passwordText.setBounds(111, 267, 90, 30);
		panel_2.add(passwordText);
	}
	
	//phương thức đc thêm vào để sử dụng tại controller loginListener
	public void log_in() {
		String username = usernameTextfield.getText();
        String password = passwordTextfield.getText();
        if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không được để tài khoản trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (password.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không được để mật khẩu trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
		int res = amm.login(username, password);		/* lưu ý: code các chức năng lúc đầu cần phải sửa đổi để phù hợp 
														với cách chạy thông qua giao diện thay vì màn hình console */
		if (res == 2) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			HomePage homePage = new HomePage();
            homePage.setVisible(true);
            this.dispose();
		}
		else if (res == 1) {
			JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 3) {
			JOptionPane.showMessageDialog(this, "Mật khẩu sai!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 4) {
	        JOptionPane.showMessageDialog(this, "Không được để tài khoản trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } else if (res == 5) {
	        JOptionPane.showMessageDialog(this, "Không được để mật khẩu trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
