package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Data.DatabaseConnection;

public class Report_View extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField totalEmployee;
    private DefaultTableModel tableModel;
    private DefaultTableModel tableModel2;

    public Report_View() {
    	setTitle("Quản Lý Nhân Viên");
        String[] columnNames = { "ID", "chức vụ", "số lượng nhân viên", "tổng lương" };
        tableModel = new DefaultTableModel(columnNames, 0);
        String[] columnNames2 = { "ID phòng ban", "tên phòng ban", "số lượng nhân viên", "tổng lương" };
        tableModel2 = new DefaultTableModel(columnNames2, 0);
        this.init();
        getNumberOfEmployee();
        setVisible(true);
	}

    public void init() {
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
        
        String logoPath = "D:\\Users\\Downloads\\lg.png";
        ImageIcon logoIcon = new ImageIcon(logoPath);
        Image logoImage = logoIcon.getImage();
        Image scaledLogoImage = logoImage.getScaledInstance(105, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        panel_1.setLayout(null);
        JLabel logo = new JLabel(scaledLogoIcon);
        logo.setBounds(8, 5, 150, 50);
        panel_1.add(logo);
        
        JButton employeeButton = new JButton("Nhân viên");
        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeManagement_View newFrame = new EmployeeManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        employeeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		employeeButton.setBackground(new Color(100, 181, 246));
        		employeeButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 employeeButton.setBackground(Color.WHITE);
        		 employeeButton.setForeground(Color.BLACK);
             }
        });
        employeeButton.setBackground(new Color(255, 255, 255));
        employeeButton.setPreferredSize(new Dimension(150, 40));
        employeeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        employeeButton.setBounds(8, 114, 150, 40);
        panel_1.add(employeeButton);
        
        JButton positionButton = new JButton("Chức vụ");
        positionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PositionManagement_View newFrame = new PositionManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        positionButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		positionButton.setBackground(new Color(100, 181, 246));
        		positionButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 positionButton.setBackground(Color.WHITE);
        		 positionButton.setForeground(Color.BLACK);
             }
        });
        positionButton.setBackground(new Color(255, 255, 255));
        positionButton.setPreferredSize(new Dimension(150, 40));
        positionButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        positionButton.setBounds(8, 164, 150, 40);
        panel_1.add(positionButton);
        
        JButton departmentButton = new JButton("Phòng ban");
        departmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DepartmentManagement_ViewMain newFrame = new DepartmentManagement_ViewMain();
                newFrame.setVisible(true);
                dispose();
            }
        });
        departmentButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		departmentButton.setBackground(new Color(100, 181, 246));
        		departmentButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 departmentButton.setBackground(Color.WHITE);
        		 departmentButton.setForeground(Color.BLACK);
             }
        });
        departmentButton.setBackground(new Color(255, 255, 255));
        departmentButton.setPreferredSize(new Dimension(150, 40));
        departmentButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        departmentButton.setBounds(8, 214, 150, 40);
        panel_1.add(departmentButton);
        
        JButton salaryButton = new JButton("Lương");
        salaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PositionSalaryManagement_View newFrame = new PositionSalaryManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        salaryButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		salaryButton.setBackground(new Color(100, 181, 246));
        		salaryButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 salaryButton.setBackground(Color.WHITE);
        		 salaryButton.setForeground(Color.BLACK);
             }
        });
        salaryButton.setBackground(new Color(255, 255, 255));
        salaryButton.setPreferredSize(new Dimension(150, 40));
        salaryButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salaryButton.setBounds(8, 264, 150, 40);
        panel_1.add(salaryButton);
        
        JButton reportButton = new JButton("Thống kê");
        reportButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		reportButton.setBackground(new Color(100, 181, 246));
        		reportButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 reportButton.setBackground(Color.WHITE);
        		 reportButton.setForeground(Color.BLACK);
             }
        });
        reportButton.setBackground(new Color(255, 255, 255));
        reportButton.setPreferredSize(new Dimension(150, 40));
        reportButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        reportButton.setBounds(8, 314, 150, 40);
        panel_1.add(reportButton);
        
        JButton accountButton = new JButton("Tài khoản");
        accountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountManagement_ViewMain newFrame = new AccountManagement_ViewMain();
                newFrame.setVisible(true);
                dispose();
            }
        });
        accountButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		accountButton.setBackground(new Color(100, 181, 246));
        		accountButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 accountButton.setBackground(Color.WHITE);
        		 accountButton.setForeground(Color.BLACK);
             }
        });
        accountButton.setBackground(new Color(255, 255, 255));
        accountButton.setPreferredSize(new Dimension(150, 40));
        accountButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        accountButton.setBounds(8, 364, 150, 40);
        panel_1.add(accountButton);
        
        JButton logoutButton = new JButton("Đăng xuất");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login newFrame = new Login();
                newFrame.setVisible(true);
                dispose();
            }
        });
        logoutButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		logoutButton.setBackground(new Color(100, 181, 246));
        		logoutButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 logoutButton.setBackground(Color.WHITE);
        		 logoutButton.setForeground(Color.BLACK);
             }
        });
        logoutButton.setBackground(new Color(255, 255, 255));
        logoutButton.setPreferredSize(new Dimension(150, 40));
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        logoutButton.setBounds(8, 513, 150, 40);
        panel_1.add(logoutButton);
        
        JButton homeButton = new JButton("Trang chủ\r\n");
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage newFrame = new HomePage();
                newFrame.setVisible(true);
                dispose();
            }
        });
        homeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		homeButton.setBackground(new Color(100, 181, 246));
        		homeButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 homeButton.setBackground(Color.WHITE);
        		 homeButton.setForeground(Color.BLACK);
             }
        });
        homeButton.setBackground(new Color(255, 255, 255));
        homeButton.setPreferredSize(new Dimension(150, 40));
        homeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        homeButton.setBounds(8, 64, 150, 40);
        panel_1.add(homeButton);

        // Code cho các button

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(177, 0, 885, 54);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tổng số lượng nhân viên");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblNewLabel.setBounds(10, 10, 234, 34);
        panel_2.add(lblNewLabel);

        totalEmployee = new JTextField();
        totalEmployee.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        totalEmployee.setBounds(238, 10, 100, 36);
        panel_2.add(totalEmployee);
        totalEmployee.setColumns(10);


        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage newFrame = new HomePage();
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
        backButton.setBounds(785, 12, 100, 37);
        panel_2.add(backButton);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(224, 255, 255));
        panel_3.setBounds(177, 64, 885, 498);
        contentPane.add(panel_3);
        panel_3.setLayout(new GridLayout(2, 1, 0, 10));

        JTable table_1 = new JTable(tableModel);
        table_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(table_1);
        panel_3.add(scrollPane);
        

        JTable table_2 = new JTable(tableModel2);
        table_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        loadEmployeeData();
        // Add the table to a JScrollPane
        JScrollPane scrollPane2 = new JScrollPane(table_2);
        panel_3.add(scrollPane2); 
   

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBounds(166, 0, 896, 562);
        contentPane.add(panel_4);
        loadPositionData();
    }
    
//bang 1 : id nhanvien , chuc vu , so luong , tong luong
//bang 2 : id phong ban , ten phong ban , so luong , tong luong
    public void loadEmployeeData() {
        String sql = "SELECT " +
                     "p.positionID AS 'ID Chức vụ', " +
                     "p.positionName AS 'Chức vụ', " +
                     "COUNT(e.employeeID) AS 'Số lượng', " +
                     "SUM(p.positionSalary) AS 'Tổng lương' " +
                     "FROM Employee e " +
                     "INNER JOIN Position p ON e.positionID = p.positionID " +
                     "GROUP BY p.positionID, p.positionName";

        ResultSet rSet = DatabaseConnection.QueryAll(sql);
        try {
            while (rSet.next()) {
                int id = rSet.getInt("ID Chức vụ");
                String name = rSet.getString("Chức vụ");
                int count = rSet.getInt("Số lượng");
                float total = rSet.getFloat("Tổng lương");

                // Thêm dữ liệu vào bảng
                tableModel.addRow(new Object[]{id, name, count, total});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    	public void loadPositionData() {
    	    String sql2 = "SELECT " +
    	                 "Department.departmentID, " +
    	                 "Department.departmentName, " +
    	                 "COUNT(emp.employeeID) AS employeeCount, " +
    	                 "SUM(p.positionSalary * emp.salary) AS totalSalary " +
    	                 "FROM Department " +
    	                 "INNER JOIN Employee emp ON Department.departmentID = emp.departmentID " +
    	                 "INNER JOIN Position p ON emp.positionID = p.positionID " +
    	                 "GROUP BY Department.departmentID, Department.departmentName;";
    	    ResultSet rSet = DatabaseConnection.QueryAll(sql2);
    	    try {
    	        while (rSet.next()) {
    	            int id = rSet.getInt("departmentID");
    	            String name = rSet.getString("departmentName");
    	            int count = rSet.getInt("employeeCount");
    	            float total = rSet.getFloat("totalSalary");
    	            tableModel2.addRow(new Object[]{id, name, count, total});
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	

    }

    public void getNumberOfEmployee() {
        int total = DatabaseConnection.getTotalEmployee();
        totalEmployee.setText(Integer.toString(total));
    }


}
