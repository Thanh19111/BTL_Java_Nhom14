package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AddEmployeeListener;
import employeeManagementTest.EmployeeManagement_Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

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
    private JTextField positionNameTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JTextField departmentNameTextField;
    private EmployeeManagement_Main emm;

    public EmployeeManagement_AddEmployee() {
    	this.emm = new EmployeeManagement_Main();
		this.init();
		setVisible(true);
	}
    
    public void init() {
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
        
        IDTextField = new JTextField();
        IDTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        IDTextField.setBounds(96, 46, 285, 30);
        panel_2.add(IDTextField);
        IDTextField.setColumns(10);
        
        JLabel IDText = new JLabel("ID");
        IDText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        IDText.setBounds(96, 10, 45, 30);
        panel_2.add(IDText);
        
        JLabel nameText = new JLabel("Tên");
        nameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameText.setBounds(96, 87, 298, 30);
        panel_2.add(nameText);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameTextField.setColumns(10);
        nameTextField.setBounds(96, 123, 285, 30);
        panel_2.add(nameTextField);
        
        JLabel birthDateText = new JLabel("Ngày sinh (dd/MM/yyyy)");
        birthDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateText.setBounds(96, 167, 254, 30);
        panel_2.add(birthDateText);
        
        birthDateTextField = new JTextField();
        birthDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateTextField.setColumns(10);
        birthDateTextField.setBounds(96, 203, 285, 30);
        panel_2.add(birthDateTextField);
        
        JLabel genderText = new JLabel("Giới tính");
        genderText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderText.setBounds(96, 247, 225, 30);
        panel_2.add(genderText);
        
        genderTextField = new JTextField();
        genderTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderTextField.setColumns(10);
        genderTextField.setBounds(96, 283, 285, 30);
        panel_2.add(genderTextField);
        
        JLabel homeTownText = new JLabel("Quê quán");
        homeTownText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        homeTownText.setBounds(96, 328, 163, 30);
        panel_2.add(homeTownText);
        
        homeTownTextField = new JTextField();
        homeTownTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        homeTownTextField.setColumns(10);
        homeTownTextField.setBounds(96, 364, 285, 30);
        panel_2.add(homeTownTextField);
        
        JLabel phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(692, 10, 152, 30);
        panel_2.add(phoneNumberText);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(692, 46, 285, 30);
        panel_2.add(phoneNumberTextField);
        
        positionNameText = new JLabel("Chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(692, 249, 201, 26);
        panel_2.add(positionNameText);
        
        departmentNamText = new JLabel("Phòng ban");
        departmentNamText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNamText.setBounds(692, 329, 188, 29);
        panel_2.add(departmentNamText);
        
        overtimeHourText = new JLabel("Số giờ tăng ca\r\n");
        overtimeHourText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourText.setBounds(692, 168, 152, 29);
        panel_2.add(overtimeHourText);
        
        hireDateTextField = new JTextField();
        hireDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateTextField.setColumns(10);
        hireDateTextField.setBounds(692, 123, 285, 30);
        panel_2.add(hireDateTextField);
        
        overtimeHourTextField = new JTextField();
        overtimeHourTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourTextField.setColumns(10);
        overtimeHourTextField.setBounds(692, 203, 285, 30);
        panel_2.add(overtimeHourTextField);
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setColumns(10);
        positionNameTextField.setBounds(692, 283, 285, 30);
        panel_2.add(positionNameTextField);
        
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
        confirmButton.setBounds(393, 410, 135, 41);
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
        cancelButton.setBounds(555, 410, 125, 41);
        panel_2.add(cancelButton);
        
        departmentNameTextField = new JTextField();
        departmentNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameTextField.setColumns(10);
        departmentNameTextField.setBounds(692, 364, 285, 30);
        panel_2.add(departmentNameTextField);
        
        JLabel hireDateText = new JLabel("Ngày vào làm (dd/MM/yyyy)");
        hireDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateText.setBounds(692, 88, 271, 29);
        panel_2.add(hireDateText);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(25, 118, 210));
        panel_1.setBounds(0, 0, 1062, 92);
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
        backButton.setBounds(0, 0, 100, 37);
        panel_1.add(backButton);
        
        JLabel themMoiNhanVienText = new JLabel("THÊM NHÂN VIÊN MỚI");
        themMoiNhanVienText.setForeground(new Color(255, 255, 255));
        themMoiNhanVienText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        themMoiNhanVienText.setBounds(425, 20, 238, 53);
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

        // Check for empty fields
        if (id.isEmpty() || name.isEmpty() || birthDate.isEmpty() || gender.isEmpty() ||
            homeTown.isEmpty() || phoneNumber.isEmpty() || hireDate.isEmpty() ||
            overTimeHour.isEmpty() || positionName.isEmpty() || departmentName.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
    	
    	int res = emm.addEmployee(id, name, birthDate, gender, homeTown, 
    			phoneNumber, hireDate, overTimeHour, positionName, departmentName);
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
    	}
    }
}
