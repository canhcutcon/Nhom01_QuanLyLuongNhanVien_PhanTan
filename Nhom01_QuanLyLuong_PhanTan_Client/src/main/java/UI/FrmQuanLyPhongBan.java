package UI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class FrmQuanLyPhongBan extends JFrame {
	
	JTable tblPhongBan;
	DefaultTableModel modelPhongBan;
	String[] colHeader = { "Mã phòng ban", "Tên phòng ban", "Mã nv quản lý"};
	
	
	public FrmQuanLyPhongBan() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 988, 41);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHÒNG BAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 51, 611, 272);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng ban:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 43, 135, 33);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên phòng ban:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 119, 135, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quản lý phòng ban:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 195, 190, 33);
		panel_1.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(191, 49, 369, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(191, 123, 369, 25);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 197, 369, 25);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(644, 51, 344, 272);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(129, 41, 100, 35);
		panel_2.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(129, 193, 100, 35);
		panel_2.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(129, 117, 100, 35);
		panel_2.add(btnSa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 333, 978, 220);
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		modelPhongBan = new DefaultTableModel(colHeader,0);
		tblPhongBan = new JTable(modelPhongBan);
		panel_3.add(new JScrollPane(tblPhongBan));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
}
