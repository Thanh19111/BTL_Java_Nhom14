package View;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import java.awt.Color;

public class EmployeeManagement_SearchResult extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public EmployeeManagement_SearchResult(String ID, String employeeName,
    										String birthDate, String gender, String homeTown, String phoneNumber, 
    										String hireDate, String salary, String overtimeHour, String positionName, 
    										String departmentName) {
		this.init(ID, employeeName, birthDate, gender, homeTown, phoneNumber, hireDate, salary, overtimeHour, 
					positionName, departmentName);
		setVisible(true);
	}

    public void init(String ID, String employeeName,
						String birthDate, String gender, String homeTown, String phoneNumber, 
						String hireDate, String salary, String overtimeHour, String positionName, 
						String departmentName) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1076, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 0, 167, 563);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        String logoPath = "D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\FPT_Software_logo.png";
        ImageIcon logoIcon = new ImageIcon(logoPath);
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(105, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        panel_1.setLayout(null);
        JLabel logo = new JLabel(scaledLogoIcon);
        logo.setBounds(36, 5, 95, 50);
        panel_1.add(logo);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBounds(177, 64, 885, 498);
        contentPane.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        // Define column names
        String[] columnNames = {
            "ID", "Tên", "Ngày sinh", "Giới tính", "Quê quán", "Số điện thoại", "Ngày vào làm", "Lương(tr)", "Tăng ca", "Chức vụ", "Phòng ban"
        };
        
        Object[][] data = {
                {ID, employeeName, birthDate, gender, homeTown, phoneNumber, hireDate, salary, overtimeHour, 
					positionName, departmentName}
            };
        
        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        
        // Create a JTable with the table model
        JTable employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        //Điều chỉnh độ rộng cột
        int[] columnWidths = {10, 105, 120, 60, 50, 65, 75, 90, 65, 60, 100, 100}; // Widths in pixels
        for (int i = 0; i < columnNames.length; i++) {
            employeeTable.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
        }
        
        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        
        // Add the JScrollPane to panel_2
        panel_3.add(scrollPane, BorderLayout.CENTER); 
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBounds(166, 0, 896, 562);
        contentPane.add(panel_4);
        
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
        panel_4.setLayout(null);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setBounds(10, 14, 100, 37);
        panel_4.add(backButton);
    }
}
