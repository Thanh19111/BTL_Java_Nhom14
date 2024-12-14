package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.EditEmployeeListener;
import Data.DatabaseConnection;
import Model.Account;
import Model.Employee;
import Utils.Utils;
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

public class EmployeeManagement_EditEmployee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField IDTextField;
    private JTextField nameTextField;
    private JTextField birthDateTextField;
    private JTextField genderTextField;
    private JTextField hometownTextField;
    private JTextField phoneNumberTextField;
    private JTextField hireDateTextField;
    private JLabel departmentNameText;
    private JLabel overtimeHourText;
    private JLabel hireDateText;
    private JTextField overtimeHourTextField;
    private JTextField positionNameTextField;
    private JTextField departmentNameTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private EmployeeManagement_Main emm;
    private JTextField nhapIdTextField;
    private DefaultTableModel tableModel;
    private JTable table_1;
    private JTextField salaryTextField;  
    private JLabel lblHSLng;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagement_Edit frame = new DepartmentManagement_Edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
    public EmployeeManagement_EditEmployee() {
		setTitle("Quản Lý Nhân Viên");
    	this.emm = new EmployeeManagement_Main();
		this.init();
		setVisible(true);
	}
    
    public void init() {
    	String[] columnNames = {
                "ID", "Tên ", "Ngày sinh", "Giới tính","Quê quán","Số điện thoại","Ngày vào làm","Lương","tăng ca","chức vụ","Phòng ban"
            };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1350, 735);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 91, 1336, 607);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameTextField.setBounds(23, 132, 163, 30);
        panel_2.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel nameText = new JLabel("Tên");
        nameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameText.setBounds(23, 92, 45, 30);
        panel_2.add(nameText);
        
        JLabel birthDateText = new JLabel("Ngày sinh");
        birthDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateText.setBounds(23, 172, 108, 30);
        panel_2.add(birthDateText);
        
        birthDateTextField = new JTextField();
        birthDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateTextField.setColumns(10);
        birthDateTextField.setBounds(23, 212, 163, 30);
        panel_2.add(birthDateTextField);
        
        JLabel genderText = new JLabel("Giới tính");
        genderText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderText.setBounds(23, 252, 87, 30);
        panel_2.add(genderText);
        
        genderTextField = new JTextField();
        genderTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderTextField.setColumns(10);
        genderTextField.setBounds(23, 292, 163, 30);
        panel_2.add(genderTextField);
        
        JLabel hometownText = new JLabel("Quê quán");
        hometownText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hometownText.setBounds(23, 332, 108, 30);
        panel_2.add(hometownText);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(23, 454, 163, 30);
        panel_2.add(salaryTextField);
        
        hometownTextField = new JTextField();
        hometownTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hometownTextField.setColumns(10);
        hometownTextField.setBounds(23, 372, 163, 30);
        panel_2.add(hometownTextField);
        
        JLabel phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(228, 17, 163, 30);
        panel_2.add(phoneNumberText);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(228, 65, 163, 30);
        panel_2.add(phoneNumberTextField);
        
        JLabel posirionNameText = new JLabel("Chức vụ");
        posirionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        posirionNameText.setBounds(228, 252, 97, 30);
        panel_2.add(posirionNameText);
        
        hireDateTextField = new JTextField();
        hireDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateTextField.setColumns(10);
        hireDateTextField.setBounds(228, 132, 163, 30);
        panel_2.add(hireDateTextField);
        
        departmentNameText = new JLabel("Phòng ban");
        departmentNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameText.setBounds(228, 334, 125, 26);
        panel_2.add(departmentNameText);
        
        overtimeHourText = new JLabel("Số giờ tăng ca");
        overtimeHourText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourText.setBounds(228, 173, 135, 29);
        panel_2.add(overtimeHourText);
        
        hireDateText = new JLabel("Ngày vào làm ");
        hireDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateText.setBounds(228, 93, 143, 29);
        panel_2.add(hireDateText);
        
        overtimeHourTextField = new JTextField();
        overtimeHourTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourTextField.setColumns(10);
        overtimeHourTextField.setBounds(228, 212, 163, 30);
        panel_2.add(overtimeHourTextField);
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setColumns(10);
        positionNameTextField.setBounds(228, 292, 163, 30);
        panel_2.add(positionNameTextField);
        
        departmentNameTextField = new JTextField();
        departmentNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameTextField.setColumns(10);
        departmentNameTextField.setBounds(228, 372, 163, 30);
        panel_2.add(departmentNameTextField);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new EditEmployeeListener(this);
        confirmButton.addActionListener(ac);
        confirmButton.setBackground(new Color(255, 255, 255));
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
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        confirmButton.setBounds(34, 519, 135, 41);
        panel_2.add(confirmButton);
        
        cancelButton = new JButton("Hủy bỏ");
        cancelButton.setBackground(new Color(255, 255, 255));
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
        		 nhapIdTextField.setText("");
        		 nameTextField.setText("");
        		 birthDateTextField.setText("");
        		 genderTextField.setText("");
        		 hometownTextField.setText("");
        		 phoneNumberTextField.setText("");
        		 hireDateTextField.setText("");
        		 overtimeHourTextField.setText("");
        		 positionNameTextField.setText("");
        		 departmentNameTextField.setText("");
             }
        });
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(245, 519, 125, 41);
        panel_2.add(cancelButton);
        
        nhapIdTextField = new JTextField();
        nhapIdTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIdTextField.setColumns(10);
        nhapIdTextField.setBounds(23, 65, 163, 30);
        panel_2.add(nhapIdTextField);
        
        JLabel nhapIdText = new JLabel("ID nhân viên");
        nhapIdText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIdText.setBounds(23, 17, 201, 26);
        panel_2.add(nhapIdText);
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                nhapIdTextField.setText(table_1.getValueAt(row, 0).toString()); 
                nameTextField.setText(table_1.getValueAt(row, 1).toString()); 
                birthDateTextField.setText(table_1.getValueAt(row, 2).toString()); 
                genderTextField.setText(table_1.getValueAt(row, 3).toString()); 
                hometownTextField.setText(table_1.getValueAt(row, 4).toString()); 
                phoneNumberTextField.setText(table_1.getValueAt(row, 5).toString()); 
                hireDateTextField.setText(table_1.getValueAt(row, 6).toString()); 
                salaryTextField.setText(table_1.getValueAt(row, 7).toString()); 
                overtimeHourTextField.setText(table_1.getValueAt(row, 8).toString()); 
                positionNameTextField.setText(table_1.getValueAt(row, 9).toString()); 
                departmentNameTextField.setText(table_1.getValueAt(row, 10).toString()); 
                
                
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(417, 17, 907, 395);
        panel_2.add(scrollPane);
        
        lblHSLng = new JLabel("Hệ số lương");
        lblHSLng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblHSLng.setBounds(23, 412, 163, 30);
        panel_2.add(lblHSLng);
        
        loadEmployeeData();
    	
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1336, 92);
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
        backButton.setBounds(1226, 31, 100, 37);
        panel_1.add(backButton);
        
        JLabel lblNewLabel_6 = new JLabel("SỬA THÔNG TIN NHÂN VIÊN");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(541, 20, 303, 53);
        panel_1.add(lblNewLabel_6);
        
    }
    
    public void edit_employee () {
    	String id = nhapIdTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String birthDate = birthDateTextField.getText().trim();
        String gender = genderTextField.getText().trim();
        String homeTown = hometownTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String hireDate = hireDateTextField.getText().trim();
        String overTimeHour = overtimeHourTextField.getText().trim();
        String positionName = positionNameTextField.getText().trim();
        String departmentName = departmentNameTextField.getText().trim();
        String salaryString =salaryTextField.getText().trim();
        // Check for empty fielads
        if (id.isEmpty()|| name.isEmpty() || birthDate.isEmpty() || gender.isEmpty() ||
            homeTown.isEmpty() || phoneNumber.isEmpty() || hireDate.isEmpty() ||
            overTimeHour.isEmpty() || positionName.isEmpty() || departmentName.isEmpty() || salaryString.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = emm.editEmployee(id, name, birthDate, gender, homeTown, 
    			phoneNumber, hireDate, salaryString, overTimeHour, positionName, departmentName);
        if (res == 1) {
    		JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 2) {
    		JOptionPane.showMessageDialog(this, "Ngày vào làm không hợp lệ.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 3) {
    		JOptionPane.showMessageDialog(this, "Không tồn tại chức vụ đã nhập.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 4) {
    		JOptionPane.showMessageDialog(this, "Không tồn tại phòng ban đã nhập.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 5) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 6) {
    		JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		loadEmployeeData();
    	}
    }
}
