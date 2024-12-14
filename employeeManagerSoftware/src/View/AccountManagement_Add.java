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
import Controller.AddAccountListener;
import Data.DatabaseConnection;
import Model.Account;
import Model.Department;
import Utils.Utils;
import net.miginfocom.layout.CC;

public class AccountManagement_Add extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel ThemMoiTaiKhoanText;
    private AccountManagement_Main amm;

    private DefaultTableModel tableModel;
    private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement_Add frame = new AccountManagement_Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountManagement_Add() {
		setTitle("Quản Lý Nhân Viên");
		/////////////////////////////////////////////////
		String[] columnNames = {
				"Tài khoản", "Mật khẩu"
            };
		
		
		tableModel = new DefaultTableModel(columnNames, 0);
		////////////////////////////////////////////////
		amm = new AccountManagement_Main();
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
        usernameTextField.setBounds(37, 147, 285, 30);
        panel_2.add(usernameTextField);
        usernameTextField.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Tên tài khoản");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblNewLabel.setBounds(36, 111, 207, 30);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(36, 187, 152, 30);
        panel_2.add(lblNewLabel_1);
        
        passwordTextField = new JTextField();
        passwordTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(37, 223, 285, 30);
        panel_2.add(passwordTextField);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new AddAccountListener(this);
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
        confirmButton.setBounds(35, 316, 134, 41);
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
                 passwordTextField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(197, 316, 125, 41);
        panel_2.add(cancelButton);
        
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
        
        ThemMoiTaiKhoanText = new JLabel("THÊM MỚI TÀI KHOẢN");
        ThemMoiTaiKhoanText.setForeground(new Color(255, 255, 255));
        ThemMoiTaiKhoanText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        ThemMoiTaiKhoanText.setBounds(410, 21, 242, 61);
        panel_1.add(ThemMoiTaiKhoanText);
        
        
        //////////////////////////////////////////////////////////////////////////
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                usernameTextField.setText(table_1.getValueAt(row, 0).toString());
                
                passwordTextField.setText(table_1.getValueAt(row, 1).toString());
                
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(365, 61, 687, 355);
        panel_2.add(scrollPane);
        
        loadAccountData();
        ////////////////////////////////////////////////////////////////////////////////////////////
    
	}
	public void add_Account() {
	    String username = usernameTextField.getText().trim();
	    String password = passwordTextField.getText().trim();

	    if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    if (password.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    int res = amm.signUp(username, password);
	    if (res == 1) {
	        JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } else if (res == 2) {
	    	usernameTextField.setText("");
	    	passwordTextField.setText("");
	    	loadAccountData();
	        JOptionPane.showMessageDialog(this, "Thêm mới tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	    } else if (res == 3) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    } else if (res == 4) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}
	////////////////////////////////////////////////////////////////////////////////////////////
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
	///////////////////////////////////////////////////////////////////////////////////////////////////

}
