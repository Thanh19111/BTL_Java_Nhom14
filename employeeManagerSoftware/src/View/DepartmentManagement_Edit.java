package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import Controller.EditDepartmentListener;
import Data.DatabaseConnection;
import DepartmentManagementTest.DepartmentManagement_Main;
import Model.Department;

public class DepartmentManagement_Edit extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField positionNameTextField;
    private JTextField addressTextField;
    private JTextField phoneNumberTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel suaThongTinPhongBanText;
    private DepartmentManagement_Main dmm;
    private JTextField idTextField;
    private DefaultTableModel tableModel;
    private JTable table_1;

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

	/**
	 * Create the frame.
	 */
	public DepartmentManagement_Edit() {
		setTitle("Quản Lý Nhân Viên");
		
		dmm = new DepartmentManagement_Main();
		String[] columnNames = {
                "ID", "Tên phòng ban", "Địa chỉ", "Số điện thoại"
            };
		
		
		tableModel = new DefaultTableModel(columnNames, 0);

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
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setBounds(64, 150, 285, 30);
        panel_2.add(positionNameTextField);
        positionNameTextField.setColumns(10);
        
        JLabel positionNameText = new JLabel("Tên phòng ban");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(64, 110, 207, 30);
        panel_2.add(positionNameText);
        
        JLabel addressText = new JLabel("Địa chỉ");
        addressText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addressText.setBounds(65, 190, 152, 30);
        panel_2.add(addressText);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        addressTextField.setColumns(10);
        addressTextField.setBounds(65, 230, 285, 30);
        panel_2.add(addressTextField);
        
        JLabel phoneNumberText = new JLabel("Số điện thoại");
        phoneNumberText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberText.setBounds(65, 270, 207, 30);
        panel_2.add(phoneNumberText);
        
        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(65, 310, 285, 30);
        panel_2.add(phoneNumberTextField);
        
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new EditDepartmentListener(this);
        confirmButton.addActionListener(ac);
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
        confirmButton.setBackground(new Color(255, 255, 255));
        confirmButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        confirmButton.setBounds(64, 380, 134, 41);
        panel_2.add(confirmButton);
        
        cancelButton = new JButton("Hủy bỏ");
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
        		 positionNameTextField.setText("");
        		 addressTextField.setText("");
        		 phoneNumberTextField.setText("");
        		 idTextField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(226, 380, 125, 41);
        panel_2.add(cancelButton);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setColumns(10);
        idTextField.setBounds(64, 74, 285, 30);
        panel_2.add(idTextField);
        
        JLabel idText = new JLabel("Nhập ID phòng ban cần sửa\r\n");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(64, 37, 260, 30);
        panel_2.add(idText);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                idTextField.setText(table_1.getValueAt(row, 0).toString());
                
                positionNameTextField.setText(table_1.getValueAt(row, 1).toString());
                
                addressTextField.setText(table_1.getValueAt(row, 2).toString());
                
                phoneNumberTextField.setText(table_1.getValueAt(row, 3).toString());
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(365, 61, 687, 355);
        panel_2.add(scrollPane);
        
        loadDepartmentData();
        
        
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	DepartmentManagement_ViewMain newFrame = new DepartmentManagement_ViewMain();
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
        backButton.setBounds(962, 36, 100, 37);
        panel_1.add(backButton);
        
        suaThongTinPhongBanText = new JLabel("SỬA THÔNG TIN PHÒNG BAN\t");
        suaThongTinPhongBanText.setForeground(new Color(255, 255, 255));
        suaThongTinPhongBanText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        suaThongTinPhongBanText.setBounds(390, 21, 296, 61);
        panel_1.add(suaThongTinPhongBanText);
        
	}
	public void loadDepartmentData() {
		tableModel.setRowCount(0);
	    ArrayList<Department> arrayList = DatabaseConnection.DepartmentQuery("select * from Department");
	    for (int i = 0; i < arrayList.size(); i++) {
	        Department department = arrayList.get(i);
	        tableModel.addRow(new Object[]{
	            department.getDepartmentID(),
	            department.getDepartmentName(),
	            department.getDepartmentAddress(),
	            department.getDepartmentPhoneNumber()
	        });
	    }
	}
	public void edit_department() {
    	String id = idTextField.getText();
		String positionName = positionNameTextField.getText();
        String address = addressTextField.getText();
        String phontNumber = phoneNumberTextField.getText();
        if (id.isEmpty() || positionName.isEmpty() || address.isEmpty() ||phontNumber.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
		int res = dmm.editDepartment(id, positionName, address, phontNumber);		/* lưu ý: code các chức năng lúc đầu cần phải sửa đổi để phù hợp 
																					với cách chạy thông qua giao diện thay vì màn hình console */
		if (res == 1) {
			loadDepartmentData();
			JOptionPane.showMessageDialog(this, "Sửa phòng ban thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (res == 2) {
			JOptionPane.showMessageDialog(this, "ID không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
    }

}
