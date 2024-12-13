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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AddDepartmentListener;
import Data.DatabaseConnection;
import DepartmentManagementTest.DepartmentManagement_Main;
import Model.Department;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DepartmentManagement_Add extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField idTextField;
    public JTextField postionNameTextField;
    public JTextField addressTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel themMoiPhongBanText;
    public JTextField phoneNumberTextField;
    private JLabel phoneNumberText;
    private DepartmentManagement_Main dmm;
    
    private DefaultTableModel tableModel;
    private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					DepartmentManagement_Add frame = new DepartmentManagement_Add();
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
	public DepartmentManagement_Add() {
		
		String[] columnNames = {
                "ID", "Tên phòng ban", "Địa chỉ", "Số điện thoại"
            };
		
		
		tableModel = new DefaultTableModel(columnNames, 0);
		
		this.dmm = new DepartmentManagement_Main();
		
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
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setBounds(41, 69, 285, 30);
        panel_2.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel idText = new JLabel("ID");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(40, 33, 207, 30);
        panel_2.add(idText);
        
        JLabel positonNameText = new JLabel("Tên phòng ban");
        positonNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positonNameText.setBounds(40, 109, 152, 30);
        panel_2.add(positonNameText);
        
        postionNameTextField = new JTextField();
        postionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        postionNameTextField.setColumns(10);
        postionNameTextField.setBounds(41, 145, 285, 30);
        panel_2.add(postionNameTextField);
        
        JLabel addressText = new JLabel("Địa chỉ\r\n");
        addressText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addressText.setBounds(40, 189, 207, 30);
        panel_2.add(addressText);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addressTextField.setColumns(10);
        addressTextField.setBounds(41, 225, 285, 30);
        panel_2.add(addressTextField);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new AddDepartmentListener(this);
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
        confirmButton.setBounds(41, 375, 134, 41);
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
        		 idTextField.setText("");
        		 postionNameTextField.setText("");
        		 addressTextField.setText("");
        		 phoneNumberTextField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(203, 375, 125, 41);
        panel_2.add(cancelButton);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(41, 308, 285, 30);
        panel_2.add(phoneNumberTextField);
        
        phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(41, 272, 207, 30);
        panel_2.add(phoneNumberText);
        
        /////////////////////////////////////////////////////////////////////////////
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                idTextField.setText(table_1.getValueAt(row, 0).toString());
                
                postionNameTextField.setText(table_1.getValueAt(row, 1).toString());
                
                addressTextField.setText(table_1.getValueAt(row, 2).toString());
                
                phoneNumberTextField.setText(table_1.getValueAt(row, 3).toString());
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(365, 61, 687, 355);
        panel_2.add(scrollPane);
        
        loadDepartmentData();
        ////////////////////////////////////////////////////////////////////////
       
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 57, 0));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DepartmentManagement_ViewMain newFrame = new DepartmentManagement_ViewMain();
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
        backButton.setBounds(962, 36, 100, 37);
        panel_1.add(backButton);
        
        themMoiPhongBanText = new JLabel("THÊM MỚI PHÒNG BAN");
        themMoiPhongBanText.setForeground(new Color(255, 255, 255));
        themMoiPhongBanText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        themMoiPhongBanText.setBounds(410, 21, 242, 61);
        panel_1.add(themMoiPhongBanText);
        
        
        
        
    
	}
	public void add_department() {
    	String id = idTextField.getText().trim();
        String positionName = postionNameTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();

        if (id.isEmpty() || positionName.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = dmm.addDepartment(id, positionName, address, phoneNumber);
        if (res == 1) {
        	JOptionPane.showMessageDialog(this, "ID đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else if (res == 2) {
        	JOptionPane.showMessageDialog(this, "Thêm phòng ban thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        	idTextField.setText("");
            postionNameTextField.setText("");
            addressTextField.setText("");
            phoneNumberTextField.setText("");
        	loadDepartmentData();
        }
        else if(res == 3)
        {
        	JOptionPane.showMessageDialog(this, "ID phải là số nguyên", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
	//////////////////////////////////////////////////////////////////////
	public void loadDepartmentData() {
		tableModel.setRowCount(0);
	    ArrayList<Department> arrayList = DatabaseConnection.DepartmentQuery("select * from Department");
	    for (int i = 0; i < arrayList.size(); i++) {
	        Department department = arrayList.get(i);
	        tableModel.addRow(new Object[]{
	            department.getDepartmentID(),
	            department.getDepartmentName(),
	            department.getDepartmentAddress(),
	            department.getDepartmentPhoneNumber()
	        });
	    }
	}
	///////////////////////////////////////////////////////////////////////
}
