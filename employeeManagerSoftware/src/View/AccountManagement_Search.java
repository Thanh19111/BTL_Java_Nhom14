package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.DatabaseConnection;
import Model.Account;
import Utils.Utils;

public class AccountManagement_Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static String username;
	protected static String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement_Search frame = new AccountManagement_Search(username, password);
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
	public AccountManagement_Search(String username, String password) {
		setTitle("Quản Lý Nhân Viên");

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

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBounds(177, 64, 885, 498);
        contentPane.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        // Define column names
        String[] columnNames = {
            "Tên tài khoản", "Mật khẩu"
        };
        

        // Data with search results
        Object[][] data = {
            {Utils.decrypt(username), password}
        };

        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create a JTable with the table model
        JTable employeeTable = new JTable(tableModel);
        employeeTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));

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
                AccountManagement_ViewMain newFrame = new AccountManagement_ViewMain();
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
        panel_4.setLayout(null);
        backButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        backButton.setBounds(10, 14, 100, 37);
        panel_4.add(backButton);
    
	}

}
