package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.editPositionSalaryListener;
import PositionSalaryManagementTest.PositionSalaryManagement_Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import java.awt.Color;

public class PositionSalaryManagement_EditPositionSalary extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel sụaLuongChucVuText;
    private JTextField idTextField;
    private JTextField salaryTexField;
    private PositionSalaryManagement_Main psmm;
    

    public PositionSalaryManagement_EditPositionSalary() {
    	this.psmm = new PositionSalaryManagement_Main();
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
        confirmButton.setBounds(393, 410, 125, 41);
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
        cancelButton.setBounds(555, 410, 125, 41);
        panel_2.add(cancelButton);
        
        JLabel idText = new JLabel("ID chức vụ cần sửa");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(393, 11, 207, 30);
        panel_2.add(idText);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setColumns(10);
        idTextField.setBounds(392, 51, 285, 41);
        panel_2.add(idTextField);
        
        salaryTexField = new JTextField();
        salaryTexField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTexField.setColumns(10);
        salaryTexField.setBounds(393, 149, 285, 41);
        panel_2.add(salaryTexField);
        
        JLabel salaryText = new JLabel("Mức lương mới");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(393, 109, 207, 30);
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
