package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.DatabaseConnection;
import Model.Account;
import Model.Department;
import Model.Employee;
import Model.Position;
import Utils.Utils;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.Connection;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PositionSalaryManagement_View extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private  DefaultTableModel tableModel; 
    ArrayList<Position> pos;
    ArrayList<Employee> employees;
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionSalaryManagement_View frame = new PositionSalaryManagement_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public PositionSalaryManagement_View() {
    	setTitle("Quản Lý Nhân Viên");
    	loadPositionData();
    	loadEmployeeData();
    	
    	String[] columnNames = {
                "ID", "Tên", "Ngày sinh","Giới tính","Địa chỉ", "Số điện thoại","Ngày làm việc", "Hệ số lương", "Lương cơ bản",
                "Tăng ca(h)", "Chức vụ", "Phòng ban","Lương"
    	};
	    this.tableModel = new DefaultTableModel(columnNames, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1148, 615);
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
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Report_View newFrame = new Report_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
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
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(177, 0, 957, 54);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JButton editEmployeeButton = new JButton("Sửa\r\n");
        editEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PositionSalaryManagement_EditEmployeeSalary newFrame = new PositionSalaryManagement_EditEmployeeSalary();
                newFrame.setVisible(true);
                dispose();
            }
        });
        editEmployeeButton.setBounds(120, 9, 69, 37);
        editEmployeeButton.setBackground(new Color(255, 255, 255));
        editEmployeeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		editEmployeeButton.setBackground(new Color(100, 181, 246));
        		editEmployeeButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 editEmployeeButton.setBackground(Color.WHITE);
        		 editEmployeeButton.setForeground(Color.BLACK);
             }
        });
        editEmployeeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        editEmployeeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel_2.add(editEmployeeButton);
        
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
        backButton.setBounds(10, 9, 100, 37);
        panel_2.add(backButton);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBounds(177, 66, 947, 432);
        contentPane.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JTable employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        
        // Add the JScrollPane to panel_2
        panel_3.add(scrollPane, BorderLayout.SOUTH);
        loadPosition();
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBounds(166, 0, 896, 482);
        contentPane.add(panel_4);
    }
    
    public void loadPositionData() {
        this.pos = DatabaseConnection.Pos("SELECT * from Position");
    }
    public void loadEmployeeData()
    {
    	this.employees = DatabaseConnection.EmployeeQuery("select *from Employee");
    }
    
    private void loadPosition()
   	{
    	String sqlString = "select Employee.employeeId,Employee.employeeName,Employee.birthDate,Employee.gender,Employee.hometown,Employee.phoneNumber,Employee.hireDate,Employee.salary,Position.positionSalary as LuongCB, Employee.overtimeHours,Position.positionName,Department.departmentName,Position.positionSalary * Employee.salary as Luong\r\n"
				+ "from Employee inner join Department\r\n"
				+ "	on Employee.departmentID = Department.departmentID\r\n"
				+ "inner join Position\r\n"
				+ "	on Employee.positionID = Position.positionID\r\n"
				+ "";
		

    	ResultSet rSet = DatabaseConnection.QueryAll(sqlString);
		
		try {
			while(rSet.next())
			{
				int id = rSet.getInt(1);
				String name = rSet.getString(2);
				String birth = rSet.getString(3);
				String gender = rSet.getString(4);
				String home = rSet.getNString(5);
				String phone = rSet.getNString(6);
				String hire = rSet.getString(7);
				float hsluong = rSet.getFloat(8);
				float luongcb = rSet.getFloat(9);
				Float overhours = rSet.getFloat(10);
				String pnam = rSet.getNString(11);
				String dname = rSet.getNString(12);
				float luong = rSet.getFloat(13);
				
				tableModel.addRow(
						new Object[] {
								id,name,birth,gender,home,phone,hire,hsluong,luongcb,overhours,pnam,dname,luong
						}
						);
			}
			
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
   	}

   	
    
}
