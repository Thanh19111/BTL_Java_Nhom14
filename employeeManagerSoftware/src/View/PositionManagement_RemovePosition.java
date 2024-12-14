package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.RemovePositionListener;
import Data.DatabaseConnection;
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

public class PositionManagement_RemovePosition extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private PositionManagement_Main pmm = new PositionManagement_Main();
    private DefaultTableModel tableModel;
    private JTable table_1;
    private JTextField positionNameTextField;
    private JTextField salaryTextField;
	/**
	 * Launch the application.
	 */
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionManagement_RemovePosition frame = new PositionManagement_RemovePosition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  
    public PositionManagement_RemovePosition (){
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
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(0, 81, 1062, 472);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setBounds(10, 50, 285, 30);
        panel_2.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel nhapIdText = new JLabel("Nhập ID");
        nhapIdText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        nhapIdText.setBounds(10, 0, 125, 30);
        panel_2.add(nhapIdText);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new RemovePositionListener(this);
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
        confirmButton.setBounds(10, 139, 125, 41);
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
        cancelButton.setBounds(170, 139, 125, 41);
        panel_2.add(cancelButton);
        
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
        backButton.setBounds(952, 31, 100, 37);
        panel_1.add(backButton);
      
        JLabel lblNewLabel_6 = new JLabel("XÓA CHỨC VỤ");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(460, 20, 186, 53);
        panel_1.add(lblNewLabel_6);
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
        scrollPane.setBounds(305, 7, 716, 455);
        panel_2.add(scrollPane);
        
        loadPosition();
    }
    
    public void remove_position() {
    	String id = idTextField.getText();
    	if (id.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
    	int res = pmm.removePosition(id);
    	if (res == 1) {
	        JOptionPane.showMessageDialog(this, "Xóa chức vụ thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        loadPosition();
	    } else if (res == 2) {
	        JOptionPane.showMessageDialog(this, "ID không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
    }
    private void loadPosition()
   	{
   		tableModel.setRowCount(0);
   	    ArrayList<Position> arrayList = DatabaseConnection.Pos("SELECT * from Position");
   	    for (int i = 0; i < arrayList.size(); i++) {
   	        Position pos = arrayList.get(i);
   	        tableModel.addRow(new Object[]{
   	            pos.getPositionID(),
   	            pos.getPositionName(),
   	            pos.getPositionSalary()
   	        });
   	    }
   	}
}
