package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class FrmQuanLyNhanVien extends JFrame {
	public FrmQuanLyNhanVien() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1166, 41);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 428, 325);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 13, 115, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ tên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 57, 115, 31);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(10, 101, 115, 31);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CMND:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(10, 145, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Ngày vào làm:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(10, 189, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(152, 19, 253, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 63, 253, 25);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 107, 253, 25);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 151, 253, 25);
		panel_1.add(textField_3);
		
		txtNgayVaoLam = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
		txtNgayVaoLam.setValue(new Date());
		txtNgayVaoLam.setColumns(10);
		txtNgayVaoLam.setBounds(152, 195, 160, 25);
		panel_1.add(txtNgayVaoLam);
		
		JButton btnNewButton = new JButton("Pick a date");
		btnNewButton.setBounds(320, 195, 85, 25);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 233, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);
		
		txtNgaySinh = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
		txtNgaySinh.setValue(new Date());
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(152, 239, 160, 25);
		panel_1.add(txtNgaySinh);
		
		JButton btnNewButton_1 = new JButton("Pick a date");
		btnNewButton_1.setBounds(320, 239, 85, 25);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 277, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(152, 283, 253, 25);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(448, 46, 330, 325);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblImage = new JLabel("");
		lblImage.setBounds(50, 10, 230, 230);
		panel_2.add(lblImage);
		
		JButton btnNewButton_2 = new JButton("Select Image");
		btnNewButton_2.setBounds(95, 250, 140, 40);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(788, 46, 388, 325);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Thêm");
		btnNewButton_3.setBounds(127, 45, 120, 30);
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Sửa");
		btnNewButton_3_1.setBounds(127, 187, 120, 30);
		panel_3.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Xóa");
		btnNewButton_3_2.setBounds(127, 258, 120, 30);
		panel_3.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_3 = new JButton("Thống kê");
		btnNewButton_3_3.setBounds(127, 116, 120, 30);
		panel_3.add(btnNewButton_3_3);
		
		JLabel lblTime = new JLabel("15:40:30 AM");
		lblTime.setBounds(252, 10, 126, 31);
		panel_3.add(lblTime);
		lblTime.setEnabled(false);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 418, 1166, 235);
		getContentPane().add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		String[] colHeader = { "Mã nhân viên", "Tên nhân viên", "SĐT", "CMND", "Ngày vào làm","Ngày sinh" };
		modelNhanVien = new DefaultTableModel(colHeader,0);
		tableNhanVien = new JTable(modelNhanVien);
		panel_4.add(new JScrollPane(tableNhanVien),BorderLayout.CENTER);
		
		JButton btnNewButton_4 = new JButton("Tìm kiếm nhân viên");
		btnNewButton_4.setBounds(10, 381, 123, 30);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\phanTanVer3.0\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\synchronize_30px.png"));
		btnNewButton_5.setBounds(1136, 374, 40, 40);
		getContentPane().add(btnNewButton_5);
		
		
		//ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\phanTanVer3.0\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Logo\\boy512.png");
		ImageIcon scaleIcon = scaleImage(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\phanTanVer3.0\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Logo\\boy512.png"));
		lblImage.setIcon(scaleIcon);
	}

	private ImageIcon scaleImage(ImageIcon icon) {
		//scaling image fit in jtable
		java.awt.Image img = icon.getImage();
		java.awt.Image imgScale =img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(imgScale);
		return scaleIcon;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFormattedTextField txtNgayVaoLam;
	private JFormattedTextField txtNgaySinh;
	private JLabel lblImage;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
