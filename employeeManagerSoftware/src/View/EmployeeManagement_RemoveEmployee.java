package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.RemoveEmployeeListener;
import Data.DatabaseConnection;
import Model.Employee;
import employeeManagementTest.EmployeeManagement_Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

public class EmployeeManagement_RemoveEmployee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nhapIDTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private EmployeeManagement_Main emm;
    private DefaultTableModel tableModel;
    private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement_RemoveEmployee frame = new EmployeeManagement_RemoveEmployee();
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
    public EmployeeManagement_RemoveEmployee() {
    	this.emm = new EmployeeManagement_Main();
		this.init();
		setVisible(true);
	}
    
    public void init() {
    	String[] columnNames = {
    			"ID", "Tên ", "Ngày sinh", "Giới tính","Quê quán","Số điện thoại","Ngày vào làm","Lương","tăng ca","chức vụ","Phòng ban"
            };
		
		
		tableModel = new DefaultTableModel(columnNames, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1395, 753);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(0, 91, 1381, 615);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        nhapIDTextField = new JTextField();
        nhapIDTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIDTextField.setBounds(10, 175, 285, 30);
        panel_2.add(nhapIDTextField);
        nhapIDTextField.setColumns(10);
        
        JLabel nhapIDText = new JLabel("Nhập ID");
        nhapIDText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIDText.setBounds(10, 135, 125, 30);
        panel_2.add(nhapIDText);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new RemoveEmployeeListener(this);
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
        confirmButton.setBounds(10, 236, 125, 41);
        panel_2.add(confirmButton);
        
        cancelButton = new JButton("Hủy bỏ");
        cancelButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
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
        		 nhapIDTextField.setText("");
             }
        	
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(170, 236, 125, 41);
        panel_2.add(cancelButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(25, 118, 210));
        panel_1.setBounds(0, 0, 1381, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EmployeeManagement_View newFrame = new EmployeeManagement_View();
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
        backButton.setBounds(1271, 31, 100, 37);
        panel_1.add(backButton);
        
        JLabel lblNewLabel_6 = new JLabel("XÓA NHÂN VIÊN");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(601, 20, 163, 53);
        panel_1.add(lblNewLabel_6);
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                nhapIDTextField.setText(table_1.getValueAt(row, 0).toString());
                
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(327, 54, 1044, 408);
        panel_2.add(scrollPane);
        
        loadEmployeeData();
        
    }
    
    public void remove_employee() {
    	String id = nhapIDTextField.getText();
    	if (id.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Không được để ID trống!", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
    	int res = emm.removeEmployee(id);
    	if (res == 1) {
	        JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        loadEmployeeData();
	    } else if (res == 2) {
	        JOptionPane.showMessageDialog(this, "ID không tồn tại!", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
	    }
    }
    public void loadEmployeeData() {
		tableModel.setRowCount(0);
	    ArrayList<Employee> arrayList = DatabaseConnection.EmployeeQuery("select * from Employee");
	    for (int i = 0; i < arrayList.size(); i++) {
	        Employee employee = arrayList.get(i);
	        tableModel.addRow(new Object[]{
	            employee.getEmployeeId(),
	            employee.getEmployeeName(),
	            employee.getBirthDate(),
	            employee.getGender(),
	            employee.getHometown(),
	            employee.getPhoneNumber(),
	            employee.getHireDate(),
	            employee.getSalary(),
	            employee.getOvertimeHours(),
	            employee.getEmployeePosition(),
	            employee.getEmployeeDepartment()
	        });
	    }
	}
}
