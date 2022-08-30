package UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmChucVu extends JFrame {
	public FrmChucVu() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1026, 40);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ CHỨC VỤ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 50, 555, 170);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã chức vụ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 36, 100, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên chức vụ: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(20, 103, 119, 31);
		panel_1.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(165, 40, 338, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 105, 338, 25);
		panel_1.add(textField_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(575, 50, 441, 170);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(178, 20, 85, 30);
		panel_1_1.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(178, 70, 85, 30);
		panel_1_1.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(178, 120, 85, 30);
		panel_1_1.add(btnSa);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_2.setBounds(10, 231, 1006, 246);
		getContentPane().add(panel_1_2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	
	

}
