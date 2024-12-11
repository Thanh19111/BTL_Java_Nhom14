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

import Controller.RemoveDepartmentListener;
import Data.DatabaseConnection;
import DepartmentManagementTest.DepartmentManagement_Main;
import Model.Department;

public class DepartmentManagement_Remove extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private DepartmentManagement_Main dmm;
    private DefaultTableModel tableModel;
    private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagement_Remove frame = new DepartmentManagement_Remove();
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
	public DepartmentManagement_Remove() {

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
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(0, 91, 1062, 472);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setBounds(36, 158, 285, 30);
        panel_2.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel idText = new JLabel("Nhập ID");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(36, 118, 125, 30);
        panel_2.add(idText);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new RemoveDepartmentListener(this);
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
        confirmButton.setBounds(36, 234, 125, 41);
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
        		 idTextField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(198, 234, 125, 41);
        panel_2.add(cancelButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 57, 0));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
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
        backButton.setBounds(936, 31, 100, 37);
        panel_1.add(backButton);
        
        JLabel xoaPhongBanText = new JLabel("XÓA PHÒNG BAN");
        xoaPhongBanText.setForeground(new Color(255, 255, 255));
        xoaPhongBanText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        xoaPhongBanText.setBounds(450, 20, 186, 53);
        panel_1.add(xoaPhongBanText);
        
        tableModel = new DefaultTableModel(columnNames, 0);
 
        
        table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                idTextField.setText(table_1.getValueAt(row, 0).toString());
                
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(365, 61, 687, 355);
        panel_2.add(scrollPane);
        
        loadDepartmentData();
        
	}
	public void remove_department() {
    	String id = idTextField.getText();
    	if (id.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
    	int res = dmm.removeDepartment(id);
    	if (res == 1) {
    		JOptionPane.showMessageDialog(this, "Xóa phòng ban thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		loadDepartmentData();
    	}
    	else if (res == 2) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	}
   
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

}
