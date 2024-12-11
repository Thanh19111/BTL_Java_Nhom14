package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EditEmployeeListener;
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

public class EmployeeManagement_EditEmployee extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
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

    public EmployeeManagement_EditEmployee() {
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
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameTextField.setBounds(96, 124, 285, 30);
        panel_2.add(nameTextField);
        nameTextField.setColumns(10);
        
        JLabel nameText = new JLabel("Tên");
        nameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nameText.setBounds(96, 84, 45, 30);
        panel_2.add(nameText);
        
        JLabel birthDateText = new JLabel("Ngày sinh (dd/MM/yyyy)");
        birthDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateText.setBounds(96, 164, 298, 30);
        panel_2.add(birthDateText);
        
        birthDateTextField = new JTextField();
        birthDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        birthDateTextField.setColumns(10);
        birthDateTextField.setBounds(96, 204, 285, 30);
        panel_2.add(birthDateTextField);
        
        JLabel genderText = new JLabel("Giới tính");
        genderText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderText.setBounds(96, 244, 207, 30);
        panel_2.add(genderText);
        
        genderTextField = new JTextField();
        genderTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        genderTextField.setColumns(10);
        genderTextField.setBounds(96, 284, 285, 30);
        panel_2.add(genderTextField);
        
        JLabel hometownText = new JLabel("Quê quán");
        hometownText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hometownText.setBounds(96, 324, 225, 30);
        panel_2.add(hometownText);
        
        hometownTextField = new JTextField();
        hometownTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hometownTextField.setColumns(10);
        hometownTextField.setBounds(96, 364, 285, 30);
        panel_2.add(hometownTextField);
        
        JLabel phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(692, 10, 163, 30);
        panel_2.add(phoneNumberText);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(692, 46, 285, 30);
        panel_2.add(phoneNumberTextField);
        
        JLabel posirionNameText = new JLabel("Chức vụ");
        posirionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        posirionNameText.setBounds(692, 243, 152, 30);
        panel_2.add(posirionNameText);
        
        hireDateTextField = new JTextField();
        hireDateTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateTextField.setColumns(10);
        hireDateTextField.setBounds(692, 123, 285, 30);
        panel_2.add(hireDateTextField);
        
        departmentNameText = new JLabel("Phòng ban");
        departmentNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameText.setBounds(692, 330, 201, 26);
        panel_2.add(departmentNameText);
        
        overtimeHourText = new JLabel("Số giờ tăng ca");
        overtimeHourText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        overtimeHourText.setBounds(692, 168, 188, 29);
        panel_2.add(overtimeHourText);
        
        hireDateText = new JLabel("Ngày vào làm (dd/MM/yyyy)");
        hireDateText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        hireDateText.setBounds(692, 88, 285, 29);
        panel_2.add(hireDateText);
        
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
        
        departmentNameTextField = new JTextField();
        departmentNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        departmentNameTextField.setColumns(10);
        departmentNameTextField.setBounds(692, 364, 285, 30);
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
        cancelButton.setBounds(555, 410, 125, 41);
        panel_2.add(cancelButton);
        
        nhapIdTextField = new JTextField();
        nhapIdTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIdTextField.setColumns(10);
        nhapIdTextField.setBounds(96, 44, 285, 30);
        panel_2.add(nhapIdTextField);
        
        JLabel nhapIdText = new JLabel("Nhập ID nhân viên cần sửa ");
        nhapIdText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIdText.setBounds(96, 12, 285, 26);
        panel_2.add(nhapIdText);
        
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
        
        JLabel lblNewLabel_6 = new JLabel("SỬA THÔNG TIN NHÂN VIÊN");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(400, 20, 303, 53);
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

        // Check for empty fielads
        if (id.isEmpty()|| name.isEmpty() || birthDate.isEmpty() || gender.isEmpty() ||
            homeTown.isEmpty() || phoneNumber.isEmpty() || hireDate.isEmpty() ||
            overTimeHour.isEmpty() || positionName.isEmpty() || departmentName.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = emm.editEmployee(id, name, birthDate, gender, homeTown, 
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
    	else if (res == 5) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 6) {
    		JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
}
