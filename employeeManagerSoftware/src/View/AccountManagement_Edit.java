package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import AccountManagementTest.AccountManagement_Main;
import Controller.EditAccountListener;
import Data.DatabaseConnection;
import Model.Account;
import Utils.Utils;

public class AccountManagement_Edit extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel suaThongTinTaiKhoanText;
    private JLabel lblNewLabel_1;
    private JTextField newPasswordTextField;
    private AccountManagement_Main amm = new AccountManagement_Main();

    private DefaultTableModel tableModel;
    private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement_Edit frame = new AccountManagement_Edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void loadAccountData()
	{
		tableModel.setRowCount(0);
	    ArrayList<Account> arrayList = DatabaseConnection.AccountQuery("select * from Account");
	    for (int i = 0; i < arrayList.size(); i++) {
	        Account acc = arrayList.get(i);
	        tableModel.addRow(new Object[]{
	            Utils.decrypt(acc.getUsername()),
	            acc.getPassword()
	        });
	    }
	}
	/**
	 * Create the frame.
	 */
	public AccountManagement_Edit() {
		setTitle("Quản Lý Nhân Viên");
		String[] columnNames = {
                "Tài khoản", "Mật khẩu"
            };
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1076, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 91, 1062, 472);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        usernameTextField.setBounds(53, 150, 285, 30);
        panel_2.add(usernameTextField);
        usernameTextField.setColumns(10);
        
        JLabel nhapTenTaiKhoanText = new JLabel("Nhập tên tài khoản cần sửa");
        nhapTenTaiKhoanText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapTenTaiKhoanText.setBounds(52, 114, 278, 30);
        panel_2.add(nhapTenTaiKhoanText);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new EditAccountListener(this);
        confirmButton.addActionListener(ac);
        confirmButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		confirmButton.setBackground(new Color(100, 181, 246));
        		confirmButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 confirmButton.setBackground(Color.WHITE);
        		 confirmButton.setForeground(Color.BLACK);
             }
        });
        confirmButton.setBackground(new Color(255, 255, 255));
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        confirmButton.setBounds(51, 301, 134, 41);
        panel_2.add(confirmButton);
        
            cancelButton = new JButton("Hủy bỏ");
            cancelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    cancelButton.setBackground(new Color(255, 61, 0));
                    cancelButton.setForeground(Color.BLACK);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    cancelButton.setBackground(Color.WHITE);
                    cancelButton.setForeground(Color.BLACK);
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    usernameTextField.setText("");
                    newPasswordTextField.setText("");
                }
            });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(213, 301, 125, 41);
        panel_2.add(cancelButton);
        
        lblNewLabel_1 = new JLabel("Mật khẩu mới");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(53, 190, 278, 30);
        panel_2.add(lblNewLabel_1);
        
        newPasswordTextField = new JTextField();
        newPasswordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        newPasswordTextField.setColumns(10);
        newPasswordTextField.setBounds(53, 230, 285, 30);
        panel_2.add(newPasswordTextField);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AccountManagement_ViewMain newFrame = new AccountManagement_ViewMain();
                newFrame.setVisible(true);
                dispose();
            }
        });
        backButton.setBackground(new Color(255, 255, 255));
        backButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		backButton.setBackground(new Color(100, 181, 246));
        		backButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 backButton.setBackground(Color.WHITE);
        		 backButton.setForeground(Color.BLACK);
             }
        });
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setBounds(952, 36, 100, 37);
        panel_1.add(backButton);
        
        suaThongTinTaiKhoanText = new JLabel("SỬA THÔNG TIN TÀI KHOẢN");
        suaThongTinTaiKhoanText.setForeground(new Color(255, 255, 255));
        suaThongTinTaiKhoanText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        suaThongTinTaiKhoanText.setBounds(393, 21, 296, 61);
        panel_1.add(suaThongTinTaiKhoanText);
        
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                usernameTextField.setText(table_1.getValueAt(row, 0).toString());
                
                newPasswordTextField.setText(table_1.getValueAt(row, 1).toString());
                
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(365, 61, 687, 355);
        panel_2.add(scrollPane);
        
        loadAccountData();
	}
	public void edit_account() {
		String username = usernameTextField.getText();
        String password = newPasswordTextField.getText();
        if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (password.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		int res = amm.editAccount(username, password);
		if (res == 2) {
			JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			usernameTextField.setText("");
	    	newPasswordTextField.setText("");
			loadAccountData();
		}
		else if (res == 1) {
			JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 3) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 4) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
}
