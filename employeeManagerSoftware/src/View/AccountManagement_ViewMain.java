package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AccountViewListener;
import Data.DatabaseConnection;
import Model.Account;
import Model.Department;
import Utils.Utils;

public class AccountManagement_ViewMain extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameSearchBox;
    private DefaultTableModel tableModel;
    ArrayList<Account> arr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement_ViewMain frame = new AccountManagement_ViewMain();
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
	public AccountManagement_ViewMain() {
		this.loadAccountData();
		String[] columnNames = {
	            "Tên tài khoản", "Mật khẩu"
	        };
	    this.tableModel = new DefaultTableModel(columnNames, 0);

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
        employeeButton.setBounds(8, 155, 150, 40);
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
        positionButton.setBounds(8, 205, 150, 40);
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
        departmentButton.setBounds(8, 255, 150, 40);
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
        salaryButton.setBounds(8, 305, 150, 40);
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
        reportButton.setBounds(8, 355, 150, 40);
        panel_1.add(reportButton);
        
        JButton accountButton = new JButton("Tài khoản");
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
        accountButton.setBounds(8, 405, 150, 40);
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
        homeButton.setBounds(8, 105, 150, 40);
        panel_1.add(homeButton);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(177, 0, 885, 54);
        contentPane.add(panel_2);
        
        JButton addEmployeeButton = new JButton("Thêm");
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AccountManagement_Add newFrame = new AccountManagement_Add();
                newFrame.setVisible(true);
                dispose();
            }
        });
        addEmployeeButton.setBounds(120, 9, 78, 37);
        addEmployeeButton.setBackground(new Color(255, 255, 255));
        addEmployeeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		addEmployeeButton.setBackground(new Color(100, 181, 246));
        		addEmployeeButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 addEmployeeButton.setBackground(Color.WHITE);
        		 addEmployeeButton.setForeground(Color.BLACK);
             }
        });
        panel_2.setLayout(null);
        addEmployeeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel_2.add(addEmployeeButton);
        
        JButton editEmployeeButton = new JButton("Sửa\r\n");
        editEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AccountManagement_Edit newFrame = new AccountManagement_Edit();
                newFrame.setVisible(true);
                dispose();
            }
        });
        editEmployeeButton.setBounds(208, 9, 69, 37);
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
        
        JButton removeEmployeeButton = new JButton("Xóa");
        removeEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AccountManagement_Remove newFrame = new AccountManagement_Remove();
                newFrame.setVisible(true);
                dispose();
            }
        });
        removeEmployeeButton.setBounds(287, 9, 69, 37);
        removeEmployeeButton.setBackground(new Color(255, 255, 255));
        removeEmployeeButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		removeEmployeeButton.setBackground(new Color(100, 181, 246));
        		removeEmployeeButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 removeEmployeeButton.setBackground(Color.WHITE);
        		 removeEmployeeButton.setForeground(Color.BLACK);
             }
        });
        removeEmployeeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        removeEmployeeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel_2.add(removeEmployeeButton);
        
        usernameSearchBox = new JTextField();
        usernameSearchBox.setText("Nhập username"); // Đặt placeholder ban đầu
        usernameSearchBox.setForeground(Color.GRAY); // Màu văn bản placeholder
        usernameSearchBox.setBounds(621, 9, 154, 37);
        usernameSearchBox.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        panel_2.add(usernameSearchBox);
        
        usernameSearchBox.setColumns(10);
        usernameSearchBox.addFocusListener((FocusListener) new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameSearchBox.getText().equals("Nhập username")) {
                	usernameSearchBox.setText("");
                	usernameSearchBox.setForeground(Color.BLACK);
                    usernameSearchBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameSearchBox.getText().isEmpty()) {
                	usernameSearchBox.setText("Nhập username");
                	usernameSearchBox.setForeground(Color.GRAY);
                    usernameSearchBox.setFont(new Font("Segoe UI", Font.ITALIC, 12));
                }
            }
        });
        
        JButton employeeSearchButton = new JButton("Tìm kiếm");
        ActionListener ac = new AccountViewListener(this);
        employeeSearchButton.addActionListener(ac);
        employeeSearchButton.setBounds(785, 7, 100, 40);
        employeeSearchButton.setBackground(new Color(255, 255, 255));
        employeeSearchButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		employeeSearchButton.setBackground(new Color(100, 181, 246));
        		employeeSearchButton.setForeground(Color.BLACK);
        	}
        	
        	 @Override
             public void mouseExited(MouseEvent e) {
        		 employeeSearchButton.setBackground(Color.WHITE);
        		 employeeSearchButton.setForeground(Color.BLACK);
             }
        });
        employeeSearchButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel_2.add(employeeSearchButton);
        
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
        panel_3.setBounds(177, 64, 885, 498);
        contentPane.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JTable employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        panel_3.add(scrollPane, BorderLayout.CENTER);
        loadDataTable();
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(224, 255, 255));
        panel_4.setBounds(166, 0, 896, 562);
        contentPane.add(panel_4);
    
	}
	
	public void loadAccountData() {
        this.arr = DatabaseConnection.AccountQuery("select * from Account");
    }
	public void loadDataTable()
	{
		for (int i = 0; i < this.arr.size(); i++) {
	        Account acc = this.arr.get(i);
	        this.tableModel.addRow(new Object[]{
	            Utils.decrypt(acc.getUsername()),
	            acc.getPassword()
	        });
	    }
	}
	public void account_search() {
	    String searchUsername = usernameSearchBox.getText().trim();
	    if (searchUsername.isEmpty() || searchUsername.equals("Nhập username")) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    searchUsername = Utils.encrypt(searchUsername);

	    boolean accountFound = false;
	    for(Account acc : this.arr)
	    {
	    	if(acc.getUsername().equals(searchUsername))
	    	{
	    		accountFound = true;
            	AccountManagement_Search searchResultFrame = new AccountManagement_Search(acc.getUsername(), acc.getPassword());
                searchResultFrame.setVisible(true);
                this.dispose();
                break;
	    	}
	    }
	    
	    if (!accountFound) {
	        JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}

}
