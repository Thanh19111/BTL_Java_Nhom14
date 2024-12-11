package View;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    public HomePage() {
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
        panel_2.setBackground(new Color(224, 255, 255));
        panel_2.setBounds(165, 0, 897, 563);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JButton employeeButton_2 = new JButton("Nhân viên");
        employeeButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EmployeeManagement_View newFrame = new EmployeeManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        employeeButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		employeeButton_2.setBackground(new Color(100, 181, 246));
        		employeeButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 employeeButton_2.setBackground(Color.WHITE);
        		 employeeButton_2.setForeground(Color.BLACK);
             }
        });
        employeeButton_2.setBackground(new Color(255, 255, 255));
        employeeButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        employeeButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        employeeButton_2.setBounds(41, 64, 380, 130);
        ImageIcon icon = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Employee_Icon.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(113, 133, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        employeeButton_2.setIcon(scaledIcon);
        employeeButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        employeeButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        employeeButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        employeeButton_2.setIconTextGap(8);
        panel_2.add(employeeButton_2);
        
        JButton departmentButton_2 = new JButton("Phòng ban");
        departmentButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DepartmentManagement_ViewMain newFrame = new DepartmentManagement_ViewMain();
                newFrame.setVisible(true);
                dispose();
            }
        });
        departmentButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		departmentButton_2.setBackground(new Color(100, 181, 246));
        		departmentButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 departmentButton_2.setBackground(Color.WHITE);
        		 departmentButton_2.setForeground(Color.BLACK);
             }
        });
        departmentButton_2.setBackground(new Color(255, 255, 255));
        departmentButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        departmentButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        departmentButton_2.setBounds(41, 246, 380, 130);
        ImageIcon icon1 = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Department_Icon.png");
        Image img1 = icon1.getImage();
        Image scaledImg1 = img1.getScaledInstance(105, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);
        departmentButton_2.setIcon(scaledIcon1);
        departmentButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        departmentButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        departmentButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        departmentButton_2.setIconTextGap(15);
        panel_2.add(departmentButton_2);
        
        JButton reportButton_2 = new JButton("Thống kê");
        reportButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Report_View newFrame = new Report_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        reportButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		reportButton_2.setBackground(new Color(100, 181, 246));
        		reportButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 reportButton_2.setBackground(Color.WHITE);
        		 reportButton_2.setForeground(Color.BLACK);
             }
        });
        reportButton_2.setBackground(new Color(255, 255, 255));
        reportButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        reportButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        reportButton_2.setBounds(41, 423, 380, 130);
        ImageIcon icon3 = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Report_Icon.png");
        Image img3 = icon3.getImage();
        Image scaledImg3 = img3.getScaledInstance(80, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImg3);
        reportButton_2.setIcon(scaledIcon3);
        reportButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        reportButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        reportButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        reportButton_2.setIconTextGap(40);
        panel_2.add(reportButton_2);
        
        JButton positionButton_2 = new JButton("Chức vụ");
        positionButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PositionManagement_View newFrame = new PositionManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        positionButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		positionButton_2.setBackground(new Color(100, 181, 246));
        		positionButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 positionButton_2.setBackground(Color.WHITE);
        		 positionButton_2.setForeground(Color.BLACK);
             }
        });
        positionButton_2.setBackground(new Color(255, 255, 255));
        positionButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        positionButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        positionButton_2.setBounds(477, 64, 380, 130);
        ImageIcon icon2 = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Position_Icon.png");
        Image img2 = icon2.getImage();
        Image scaledImg2 = img2.getScaledInstance(85, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImg2);
        positionButton_2.setIcon(scaledIcon2);
        positionButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        positionButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        positionButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        positionButton_2.setIconTextGap(47);
        panel_2.add(positionButton_2);
        
        JButton salaryButton_2 = new JButton("Lương");
        salaryButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PositionSalaryManagement_View newFrame = new PositionSalaryManagement_View();
                newFrame.setVisible(true);
                dispose();
            }
        });
        salaryButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		salaryButton_2.setBackground(new Color(100, 181, 246));
        		salaryButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 salaryButton_2.setBackground(Color.WHITE);
        		 salaryButton_2.setForeground(Color.BLACK);
             }
        });
        salaryButton_2.setBackground(new Color(255, 255, 255));
        salaryButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        salaryButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        salaryButton_2.setBounds(477, 246, 380, 130);
        ImageIcon icon4 = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Salary_Icon.png");
        Image img4 = icon4.getImage();
        Image scaledImg4 = img4.getScaledInstance(72, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(scaledImg4);
        salaryButton_2.setIcon(scaledIcon4);
        salaryButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        salaryButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        salaryButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        salaryButton_2.setIconTextGap(67);
        panel_2.add(salaryButton_2);
        
        JButton accountButton_2 = new JButton("Tài khoản");
        accountButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AccountManagement_ViewMain newFrame = new AccountManagement_ViewMain();
                newFrame.setVisible(true);
                dispose();
            }
        });
        accountButton_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		accountButton_2.setBackground(new Color(100, 181, 246));
        		accountButton_2.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 accountButton_2.setBackground(Color.WHITE);
        		 accountButton_2.setForeground(Color.BLACK);
             }
        });
        accountButton_2.setBackground(new Color(255, 255, 255));
        accountButton_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        accountButton_2.setBounds(477, 423, 380, 130);
        ImageIcon icon5 = new ImageIcon("D:\\Study\\Code\\Java\\employeeManagerSoftware_Group10\\Account_Icon.png");
        Image img5 = icon5.getImage();
        Image scaledImg5 = img5.getScaledInstance(85, 70, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(scaledImg5);
        accountButton_2.setIcon(scaledIcon5);
        accountButton_2.setHorizontalTextPosition(SwingConstants.RIGHT);
        accountButton_2.setVerticalTextPosition(SwingConstants.CENTER);
        accountButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        accountButton_2.setIconTextGap(40);
        panel_2.add(accountButton_2);
        
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
    }
}
