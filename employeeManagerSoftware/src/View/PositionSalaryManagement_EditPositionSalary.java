package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.editPositionSalaryListener;
import Data.DatabaseConnection;
import Model.Position;
import PositionSalaryManagementTest.PositionSalaryManagement_Main;
import Utils.Utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;

public class PositionSalaryManagement_EditPositionSalary extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel sụaLuongChucVuText;
    private JTextField idTextField;
    private JTextField salaryTexField;
    private PositionSalaryManagement_Main psmm;
    private JTextField positionNameTextField;

    private DefaultTableModel tableModel;
    private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionSalaryManagement_EditPositionSalary frame = new PositionSalaryManagement_EditPositionSalary();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void loadPosition()
	{
		tableModel.setRowCount(0);
	    ArrayList<Position> arrayList = DatabaseConnection.Pos("SELECT * from Position");
	    for (int i = 0; i < arrayList.size(); i++) {
	        Position pos = arrayList.get(i);
	        tableModel.addRow(new Object[]{
	            Utils.decrypt(String.valueOf(pos.getPositionID())),
	            pos.getPositionName(),
	            pos.getPositionSalary()
	        });
	    }
	}
    public PositionSalaryManagement_EditPositionSalary() {
    	String[] columnNames = {
                "ID", "Chức vụ","Lương"
    	};
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
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new editPositionSalaryListener(this);
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
        confirmButton.setBounds(10, 253, 125, 41);
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
        		 salaryTexField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(170, 253, 125, 41);
        panel_2.add(cancelButton);
        
        JLabel idText = new JLabel("ID chức vụ cần sửa");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(10, 20, 207, 30);
        panel_2.add(idText);
        
        salaryTexField = new JTextField();
        salaryTexField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTexField.setColumns(10);
        salaryTexField.setBounds(10, 179, 285, 41);
        panel_2.add(salaryTexField);
        
        JLabel salaryText = new JLabel("Mức lương mới");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(10, 122, 207, 30);
        panel_2.add(salaryText);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(25, 118, 210));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PositionSalaryManagement_View newFrame = new PositionSalaryManagement_View();
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
        
        sụaLuongChucVuText = new JLabel("SỬA LƯƠNG CHỨC VỤ");
        sụaLuongChucVuText.setForeground(new Color(255, 255, 255));
        sụaLuongChucVuText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        sụaLuongChucVuText.setBounds(415, 21, 242, 61);
        panel_1.add(sụaLuongChucVuText);
        tableModel = new DefaultTableModel(columnNames, 0);
 table_1 = new JTable(tableModel);
        
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.rowAtPoint(evt.getPoint());
                
                idTextField.setText(table_1.getValueAt(row, 0).toString());
                
                positionNameTextField.setText(table_1.getValueAt(row, 1).toString());
                salaryTexField.setText(table_1.getValueAt(row, 2).toString());
            	}
        })
        ;
        
        table_1.setBounds(462, 47, 590, 213);
        panel_2.add(table_1);
        
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(392, 20, 406, 496);
        panel_2.add(scrollPane);
        
        idTextField = new JTextField();
        panel_2.add(idTextField);
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setColumns(10);
        idTextField.setBounds(10, 60, 285, 41);
        
        loadPosition();
        }
    
    
    public void editPositionSalary() {
    	String id = idTextField.getText().trim();
        String salary = salaryTexField.getText().trim();

        // Check for empty fielads
        if (id.isEmpty()|| salary.isEmpty()) {      
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = psmm.editSalary(id, salary);
        if (res == 1) {
    		JOptionPane.showMessageDialog(this, "Cập nhật mức lương mới thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    	}
    	else if (res == 2) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại.", "Lỗi", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
   
}
