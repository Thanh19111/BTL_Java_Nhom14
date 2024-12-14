package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.EditPositionListener;
import Data.DatabaseConnection;
import Model.Account;
import Model.Position;
import PositonManagementTest.PositionManagement_Main;
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

public class PositionManagement_EditPosition extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField positionNameTextField;
    private JTextField salaryTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel suaThongTinChucVuText;
    private PositionManagement_Main pmm = new PositionManagement_Main();
    private JTextField idTextField;
    private DefaultTableModel tableModel;
    private JTable table_1;
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionManagement_EditPosition frame = new PositionManagement_EditPosition();
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
    public PositionManagement_EditPosition(){
    	setTitle("Quản Lý Nhân Viên");
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
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setBounds(10, 120, 285, 30);
        panel_2.add(positionNameTextField);
        positionNameTextField.setColumns(10);
        
        JLabel positionNameText = new JLabel("Tên chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(10, 87, 207, 30);
        panel_2.add(positionNameText);
        
        JLabel salaryText = new JLabel("Lương");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(10, 160, 152, 30);
        panel_2.add(salaryText);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(10, 200, 285, 30);
        panel_2.add(salaryTextField);
        
    
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new EditPositionListener(this);
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
        confirmButton.setBounds(10, 278, 120, 36);
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
        		 positionNameTextField.setText("");
        		 salaryTextField.setText("");
             }
        });
        cancelButton.setBackground(new Color(255, 255, 255));
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
        cancelButton.setBounds(175, 278, 120, 36);
        panel_2.add(cancelButton);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setColumns(10);
        idTextField.setBounds(10, 47, 285, 30);
        panel_2.add(idTextField);
        
        JLabel idText = new JLabel("Nhập ID chức vụ cần sửa");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(10, 7, 236, 30);
        panel_2.add(idText);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1062, 92);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PositionManagement_View newFrame = new PositionManagement_View();
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
        backButton.setBounds(952, 36, 100, 37);
        panel_1.add(backButton);
        
        suaThongTinChucVuText = new JLabel("SỬA THÔNG TIN CHỨC VỤ");
        suaThongTinChucVuText.setForeground(new Color(255, 255, 255));
        suaThongTinChucVuText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        suaThongTinChucVuText.setBounds(403, 21, 296, 61);
        panel_1.add(suaThongTinChucVuText);
        
    
    tableModel = new DefaultTableModel(columnNames, 0);
    
    
    table_1 = new JTable(tableModel);
    
    table_1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = table_1.rowAtPoint(evt.getPoint());
            
            idTextField.setText(table_1.getValueAt(row, 0).toString());
            
            positionNameTextField.setText(table_1.getValueAt(row, 1).toString());
            salaryTextField.setText(table_1.getValueAt(row, 2).toString());
        	}
    })
    ;
    
    table_1.setBounds(462, 47, 590, 213);
    panel_2.add(table_1);
    
    JScrollPane scrollPane = new JScrollPane(table_1);
    scrollPane.setBounds(325, 47, 711, 355);
    panel_2.add(scrollPane);
    
    loadPosition();
    }
    public void edit_Position() {
    	String id = idTextField.getText().trim();    	
    	String Positionname = positionNameTextField.getText().trim();
        String salary = salaryTextField.getText().trim();
     
        if (id.isEmpty() || Positionname.isEmpty()|| salary.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = pmm.editPosition(id, Positionname, salary);
        if (res == 1) {
    		JOptionPane.showMessageDialog(this, "Cập nhật thông tin chức vụ thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    		loadPosition();
    	}
    	else if (res == 2) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	}
    }
}
