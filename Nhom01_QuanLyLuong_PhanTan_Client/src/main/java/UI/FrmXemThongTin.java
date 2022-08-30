package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrmXemThongTin extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable tblBangLuong;
	private DefaultTableModel modelBangLuong;
	private JTable tblBangPhat;
	private DefaultTableModel modelBangPhat;
	String[] colBangLuong = { "Lương cơ bản", "Số ngày làm được", "Ngày tính lương","Tổng lương"};
	String[] colBangPhat = { "Tên mức phạt", "Tiền khoản phạt","Ngày phạt"};
	public FrmXemThongTin() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1156, 41);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("XEM THÔNG TIN NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 51, 300, 267);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\phanTanVer3.0\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\penguin64.png"));
		lblNewLabel_1.setBounds(50, 41, 180, 185);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setToolTipText("Thông tin nhân viên");
		panel_2.setBounds(320, 51, 826, 267);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 35, 127, 22);
		panel_2.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(138, 34, 260, 24);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ tên:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 92, 127, 22);
		panel_2.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(138, 92, 260, 24);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(10, 149, 127, 22);
		panel_2.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(138, 150, 260, 24);
		panel_2.add(textField_2);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("CMND:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1.setBounds(10, 206, 127, 22);
		panel_2.add(lblNewLabel_2_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(138, 208, 260, 24);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Địa chỉ:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(428, 31, 127, 22);
		panel_2.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(556, 30, 260, 24);
		panel_2.add(textField_4);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Ngày vào làm:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(428, 88, 127, 22);
		panel_2.add(lblNewLabel_2_1_2);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(556, 88, 260, 24);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_2.setBounds(428, 145, 127, 22);
		panel_2.add(lblNewLabel_2_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(556, 146, 260, 24);
		panel_2.add(textField_6);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1.setBounds(428, 202, 127, 22);
		panel_2.add(lblNewLabel_2_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(556, 204, 260, 24);
		panel_2.add(textField_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "B\u1EA3ng l\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 328, 397, 225);
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		modelBangLuong = new DefaultTableModel(colBangLuong,0);
		tblBangLuong = new JTable(modelBangLuong);
		panel_3.add(new JScrollPane(tblBangLuong));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "B\u1EA3ng ph\u1EA1t", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(417, 328, 397, 225);
		getContentPane().add(panel_4);
		
		modelBangPhat = new DefaultTableModel(colBangPhat,0);
		panel_4.setLayout(new BorderLayout(0, 0));
		tblBangPhat = new JTable(modelBangPhat);
		panel_4.add(new JScrollPane(tblBangPhat));
		
		
	}
}
