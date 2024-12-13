package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.AddPositionListener;
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

public class PositionManagement_AddPosition extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField positionNameTextField;
    private JTextField salaryTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private PositionManagement_Main pmm = new PositionManagement_Main();
    private DefaultTableModel tableModel;
    private JTable table_1;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PositionManagement_AddPosition frame = new PositionManagement_AddPosition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    public PositionManagement_AddPosition() {
    	String[] columnNames = {
                "ID", "Chức vụ","Lương"
    	};
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 91, 786, 472);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setBounds(10, 38, 285, 30);
        panel_2.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel idText = new JLabel("ID");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(30, 11, 207, 30);
        panel_2.add(idText);
        
        JLabel positionNameText = new JLabel("Tên chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(30, 87, 152, 30);
        panel_2.add(positionNameText);
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setColumns(10);
        positionNameTextField.setBounds(10, 114, 285, 30);
        panel_2.add(positionNameTextField);
        
        JLabel salaryText = new JLabel("Lương");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(30, 167, 207, 30);
        panel_2.add(salaryText);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(10, 194, 285, 30);
        panel_2.add(salaryTextField);
        
        confirmButton = new JButton("Xác nhận");
        ActionListener ac = new AddPositionListener(this);
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
        confirmButton.setBounds(10, 293, 134, 41);
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
        cancelButton.setBounds(170, 293, 125, 41);
        panel_2.add(cancelButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(25, 118, 210));
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
        backButton.setBounds(0, 0, 100, 37);
        panel_1.add(backButton);
        
        JLabel lblNewLabel_6 = new JLabel("THÊM CHỨC VỤ MỚI");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_6.setBounds(425, 20, 238, 53);
        panel_1.add(lblNewLabel_6);
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
        scrollPane.setBounds(305, 33, 406, 496);
        panel_2.add(scrollPane);
        
        loadPosition();
        }
    
    
    public void add_position() {
    	String id = idTextField.getText().trim();
        String positionName = positionNameTextField.getText().trim();
        String salary = salaryTextField.getText().trim();

        System.out.print(id);
        System.out.print(positionName);
        System.out.print(salary);
        
        
        if (id.isEmpty() || positionName.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = pmm.addPosition(Integer.parseInt(id), positionName, salary);
        if (res == 1) {
        	JOptionPane.showMessageDialog(this, "ID đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else if (res == 2) {
        	JOptionPane.showMessageDialog(this, "Thêm chức vụ thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        	loadPosition();
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
