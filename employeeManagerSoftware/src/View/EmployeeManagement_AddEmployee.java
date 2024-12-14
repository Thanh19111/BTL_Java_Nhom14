package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AddEmployeeListener;
import Data.DatabaseConnection;
import Model.Department;
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

public class EmployeeManagement_AddEmployee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField IDTextField;
    private JTextField nameTextField;
    private JTextField birthDateTextField;
    private JTextField genderTextField;
    private JTextField homeTownTextField;
    private JTextField phoneNumberTextField;
    private JLabel positionNameText;
    private JLabel departmentNamText;
    private JLabel overtimeHourText;
    private JTextField hireDateTextField;
    private JTextField overtimeHourTextField;
    private JTextField salaryTextField;  
    private JTextField positionNameTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JTextField departmentNameTextField;
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
					EmployeeManagement_AddEmployee frame = new EmployeeManagement_AddEmployee();
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
    public EmployeeManagement_AddEmployee() {
		setTitle("Quản Lý Nhân Viên");
    	
    	this.emm = new EmployeeManagement_Main();
		this.init();
		setVisible(true);
	}
    
    public void init() {
    	String[] columnNames = {
                "ID", "Tên ", "Ngày sinh", "Giới tính","Quê quán","Số điện thoại","Ngày vào làm","Lương","tăng ca","Mã chức vụ","Mã phòng ban"
            };
		
		
		tableModel = new DefaultTableModel(columnNames, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1357, 794);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 91, 1343, 656);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        IDTextField = new JTextField();
        IDTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        IDTextField.setBounds(10, 63, 174, 30);
        panel_2.add(IDTextField);
        IDTextField.setColumns(10);
        
        JLabel IDText = new JLabel("ID");
        IDText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        IDText.setBounds(10, 23, 45, 30);
        panel_2.add(IDText);
        
        JLabel nameText = new JLabel("Tên");
        nameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameText.setBounds(10, 103, 174, 30);
        panel_2.add(nameText);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameTextField.setColumns(10);
        nameTextField.setBounds(10, 143, 174, 30);
        panel_2.add(nameTextField);
        
        JLabel birthDateText = new JLabel("Ngày sinh");
        birthDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateText.setBounds(10, 183, 230, 35);
        panel_2.add(birthDateText);
        
        birthDateTextField = new JTextField();
        birthDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateTextField.setColumns(10);
        birthDateTextField.setBounds(10, 228, 174, 30);
        panel_2.add(birthDateTextField);
        
        JLabel genderText = new JLabel("Giới tính");
        genderText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderText.setBounds(10, 268, 163, 30);
        panel_2.add(genderText);
        
        genderTextField = new JTextField();
        genderTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderTextField.setColumns(10);
        genderTextField.setBounds(10, 308, 174, 30);
        panel_2.add(genderTextField);
        
        JLabel homeTownText = new JLabel("Quê quán");
        homeTownText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        homeTownText.setBounds(10, 348, 163, 30);
        panel_2.add(homeTownText);
        
        homeTownTextField = new JTextField();
        homeTownTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        homeTownTextField.setColumns(10);
        homeTownTextField.setBounds(10, 388, 174, 30);
        panel_2.add(homeTownTextField);
        
        JLabel phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(217, 23, 152, 30);
        panel_2.add(phoneNumberText);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(217, 63, 186, 30);
        panel_2.add(phoneNumberTextField);
        
        positionNameText = new JLabel("Chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(217, 272, 201, 26);
        panel_2.add(positionNameText);
        
        departmentNamText = new JLabel("Phòng ban");
        departmentNamText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNamText.setBounds(215, 349, 188, 29);
        panel_2.add(departmentNamText);
        
        overtimeHourText = new JLabel("Số giờ tăng ca\r\n");
        overtimeHourText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourText.setBounds(217, 189, 152, 29);
        panel_2.add(overtimeHourText);
        
        hireDateTextField = new JTextField();
        hireDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateTextField.setColumns(10);
        hireDateTextField.setBounds(217, 143, 186, 30);
        panel_2.add(hireDateTextField);
        
        overtimeHourTextField = new JTextField();
        overtimeHourTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourTextField.setColumns(10);
        overtimeHourTextField.setBounds(217, 228, 186, 30);
        panel_2.add(overtimeHourTextField);
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setColumns(10);
        positionNameTextField.setBounds(217, 308, 186, 30);
        panel_2.add(positionNameTextField);
        
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(10, 468, 186, 30);
        panel_2.add(salaryTextField);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new AddEmployeeListener(this);
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
        confirmButton.setBounds(42, 563, 135, 41);
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
        		 IDTextField.setText("");
        		 nameTextField.setText("");
        		 birthDateTextField.setText("");
        		 genderTextField.setText("");
        		 homeTownTextField.setText("");
        		 phoneNumberTextField.setText("");
        		 hireDateTextField.setText("");
        		 overtimeHourTextField.setText("");
        		 positionNameTextField.setText("");
        		 departmentNameTextField.setText("");
             }
        });
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(244, 563, 125, 41);
        panel_2.add(cancelButton);
        
        departmentNameTextField = new JTextField();
        departmentNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameTextField.setColumns(10);
        departmentNameTextField.setBounds(217, 388, 186, 30);
        panel_2.add(departmentNameTextField);
        
        JLabel hireDateText = new JLabel("Ngày vào làm");
        hireDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateText.setBounds(217, 104, 174, 29);
        panel_2.add(hireDateText);
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                IDTextField.setText(table_1.getValueAt(row, 0).toString()); 
                nameTextField.setText(table_1.getValueAt(row, 1).toString());                
                birthDateTextField.setText(table_1.getValueAt(row, 2).toString());
                genderTextField.setText(table_1.getValueAt(row, 3).toString());
                homeTownTextField.setText(table_1.getValueAt(row, 4).toString());
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
        scrollPane.setBounds(427, 47, 906, 404);
        panel_2.add(scrollPane);
        
        JLabel lblLng = new JLabel("Lương");
        lblLng.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblLng.setBounds(10, 428, 163, 30);
        panel_2.add(lblLng);
        
        loadEmployeeData();
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1343, 92);
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
        backButton.setBounds(1233, 31, 100, 37);
        panel_1.add(backButton);
        
        JLabel themMoiNhanVienText = new JLabel("THÊM NHÂN VIÊN MỚI");
        themMoiNhanVienText.setForeground(new Color(255, 255, 255));
        themMoiNhanVienText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        themMoiNhanVienText.setBounds(563, 20, 238, 53);
        panel_1.add(themMoiNhanVienText);
        
    }
    
    public void add_employee() {
    	String id = IDTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String birthDate = birthDateTextField.getText().trim();
        String gender = genderTextField.getText().trim();
        String homeTown = homeTownTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String hireDate = hireDateTextField.getText().trim();
        String overTimeHour = overtimeHourTextField.getText().trim();
        String positionName = positionNameTextField.getText().trim();
        String departmentName = departmentNameTextField.getText().trim();
        String salaryString = salaryTextField.getText().trim();
        
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(birthDate);
//        System.out.println(gender);
//        System.out.println(homeTown);
//        System.out.println(phoneNumber);
//        System.out.println(hireDate);
//        System.out.println(overTimeHour);
//        System.out.println(positionName);
//        System.out.println(departmentName);
        

        // Check for empty fields
        if (id.isEmpty() || name.isEmpty() || birthDate.isEmpty() || gender.isEmpty() ||
            homeTown.isEmpty() || phoneNumber.isEmpty() || hireDate.isEmpty() ||
            overTimeHour.isEmpty() || positionName.isEmpty() || departmentName.isEmpty() || salaryString.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    	
    	int res = emm.addEmployee(id, name, birthDate, gender, homeTown, 
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
    	else if (res == 6) {
    		JOptionPane.showMessageDialog(this, "Trùng ID", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 7) {
    		JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		loadEmployeeData();
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
