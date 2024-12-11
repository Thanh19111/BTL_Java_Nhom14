package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.AddPositionListener;
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

public class PositionManagement_AddPosition extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField positionNameTextField;
    private JTextField salaryTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private PositionManagement_Main pmm;
    
    public PositionManagement_AddPosition() {
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
        
        idTextField = new JTextField();
        idTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idTextField.setBounds(393, 47, 285, 30);
        panel_2.add(idTextField);
        idTextField.setColumns(10);
        
        JLabel idText = new JLabel("ID");
        idText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        idText.setBounds(392, 11, 207, 30);
        panel_2.add(idText);
        
        JLabel positionNameText = new JLabel("Tên chức vụ");
        positionNameText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameText.setBounds(392, 87, 152, 30);
        panel_2.add(positionNameText);
        
        positionNameTextField = new JTextField();
        positionNameTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        positionNameTextField.setColumns(10);
        positionNameTextField.setBounds(393, 123, 285, 30);
        panel_2.add(positionNameTextField);
        
        JLabel salaryText = new JLabel("Lương");
        salaryText.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryText.setBounds(392, 167, 207, 30);
        panel_2.add(salaryText);
        
        salaryTextField = new JTextField();
        salaryTextField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        salaryTextField.setColumns(10);
        salaryTextField.setBounds(393, 203, 285, 30);
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
        
    }
    
    public void add_position() {
    	String id = idTextField.getText().trim();
        String positionName = positionNameTextField.getText().trim();
        String salary = salaryTextField.getText().trim();

        if (id.isEmpty() || positionName.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hết các trường dữ liệu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int res = pmm.addPosition(id, positionName, salary);
        if (res == 1) {
        	JOptionPane.showMessageDialog(this, "ID đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else if (res == 2) {
        	JOptionPane.showMessageDialog(this, "Thêm chức vụ thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
