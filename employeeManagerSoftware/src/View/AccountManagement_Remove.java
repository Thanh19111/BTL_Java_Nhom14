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
import Controller.RemoveAccountListener;
import Data.DatabaseConnection;
import Model.Account;
import Utils.Utils;

public class AccountManagement_Remove extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JButton confirmButton;
    private JButton cancelButton;
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
					AccountManagement_Remove frame = new AccountManagement_Remove();
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
	public AccountManagement_Remove() {
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
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(0, 91, 1062, 472);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        usernameTextField.setBounds(60, 171, 252, 30);
        panel_2.add(usernameTextField);
        usernameTextField.setColumns(10);
        
        JLabel nhapTenTaiKhoanText = new JLabel("Nhập tên tài khoản");
        nhapTenTaiKhoanText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapTenTaiKhoanText.setBounds(60, 131, 186, 30);
        panel_2.add(nhapTenTaiKhoanText);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new RemoveAccountListener(this);
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
        	 @Override
             public void mouseClicked(MouseEvent e) {
                 usernameTextField.setText("");
             }
        });
        confirmButton.setBackground(new Color(255, 255, 255));
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        confirmButton.setBounds(43, 247, 125, 41);
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
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(205, 247, 125, 41);
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
        backButton.setBounds(952, 31, 100, 37);
        panel_1.add(backButton);
        
        JLabel lblNewLabel_6 = new JLabel("XÓA TÀI KHOẢN");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(450, 20, 186, 53);
        panel_1.add(lblNewLabel_6);
        
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                usernameTextField.setText(table_1.getValueAt(row, 0).toString());
                
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
	public void remove_account() {
    	String username = usernameTextField.getText();
    	if (username.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
    	int res = amm.removeAccount(username);
    	if (res == 1) JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	else if (res == 2) { 
    		JOptionPane.showMessageDialog(this, "Xóa tài khoản thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		loadAccountData();
    		this.usernameTextField.setText("");
    	}
    	else if (res == 3) JOptionPane.showMessageDialog(this, "Vui lòng nhập  hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

}
