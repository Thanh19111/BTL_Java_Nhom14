package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EditPositionListener;
import PositonManagementTest.PositionManagement_Main;

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

public class PositionManagement_EditPosition extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField positionNameTextField;
    private JTextField salaryTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel suaThongTinChucVuText;
    private PositionManagement_Main pmm;
    private JTextField idTextField;

    public PositionManagement_EditPosition() {
    	this.pmm = new PositionManagement_Main();
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
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setBounds(392, 123, 285, 30);
        panel_2.add(positionNameTextField);
        positionNameTextField.setColumns(10);
        
        JLabel positionNameText = new JLabel("Tên chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(392, 83, 207, 30);
        panel_2.add(positionNameText);
        
        JLabel salaryText = new JLabel("Lương");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(392, 160, 152, 30);
        panel_2.add(salaryText);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(392, 200, 285, 30);
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
        confirmButton.setBounds(393, 410, 134, 41);
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
        cancelButton.setBounds(555, 410, 125, 41);
        panel_2.add(cancelButton);
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setColumns(10);
        idTextField.setBounds(392, 47, 285, 30);
        panel_2.add(idTextField);
        
        JLabel idText = new JLabel("Nhập ID chức vụ cần sửa");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(392, 7, 236, 30);
        panel_2.add(idText);
        
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
        
        suaThongTinChucVuText = new JLabel("SỬA THÔNG TIN CHỨC VỤ");
        suaThongTinChucVuText.setForeground(new Color(255, 255, 255));
        suaThongTinChucVuText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        suaThongTinChucVuText.setBounds(403, 21, 296, 61);
        panel_1.add(suaThongTinChucVuText);
        
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
    	}
    	else if (res == 2) {
    		JOptionPane.showMessageDialog(this, "ID không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    	}
    }
}
