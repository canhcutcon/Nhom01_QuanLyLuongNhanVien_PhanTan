package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class FrmBangLuongNhanVien extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtThue;
	private JTextField txtSoNgayLam;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tbl_BangLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBangLuongNhanVien frame = new FrmBangLuongNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmBangLuongNhanVien() {
		setBackground(Color.WHITE);
		initGUI();
		setUI();

	}

	private void initGUI() {
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
	}

	private void setUI() {
	
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pnl_Input = new JPanel();
		pnl_Input.setBounds(10, 75, 622, 255);
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thuế");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 16, 151, 23);
		pnl_Input.add(lblNewLabel);
		
		txtThue = new JTextField();
		txtThue.setColumns(10);
		txtThue.setBounds(171, 16, 444, 23);
		pnl_Input.add(txtThue);
		
		JLabel lblNewLabel_1 = new JLabel("Số ngày làm được");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 50, 151, 23);
		pnl_Input.add(lblNewLabel_1);
		
		txtSoNgayLam = new JTextField();
		txtSoNgayLam.setColumns(10);
		txtSoNgayLam.setBounds(171, 50, 444, 23);
		pnl_Input.add(txtSoNgayLam);
		
		JLabel lblNewLabel_2 = new JLabel("Lương cơ bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 84, 151, 23);
		pnl_Input.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 84, 444, 23);
		pnl_Input.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày tính lương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 118, 151, 23);
		pnl_Input.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 118, 444, 23);
		pnl_Input.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Chứng chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 152, 151, 23);
		pnl_Input.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(171, 152, 444, 23);
		pnl_Input.add(textField_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("Mã phiếu phạt");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 186, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Mã nhân viên");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 220, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 188, 444, 22);
		pnl_Input.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(171, 222, 444, 22);
		pnl_Input.add(comboBox_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Bảng lương nhân viên");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(508, 11, 255, 44);
		panel.add(lblNewLabel_4_2_1_1);
		
		JPanel pnl_Control = new JPanel();
		pnl_Control.setBounds(646, 75, 622, 255);
		panel.add(pnl_Control);
		pnl_Control.setLayout(null);
		
		JButton btn_TinhLuong = new JButton("Tính lương");
		btn_TinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_TinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TinhLuong.setBounds(24, 11, 182, 33);
		pnl_Control.add(btn_TinhLuong);
		
		JButton btn_ThemLuong = new JButton("Thêm lương");
		btn_ThemLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ThemLuong.setBounds(24, 55, 182, 33);
		pnl_Control.add(btn_ThemLuong);
		
		
		JButton btn_ThongKeThang = new JButton("Tổng tháng");
		btn_ThongKeThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ThongKeThang.setBounds(92, 167, 114, 33);
		pnl_Control.add(btn_ThongKeThang);
		
		JButton btn_ThongKeNam = new JButton("Tổng năm");
		btn_ThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ThongKeNam.setBounds(92, 211, 114, 33);
		pnl_Control.add(btn_ThongKeNam);
		
		JComboBox cbb_Thang = new JComboBox();
		cbb_Thang.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbb_Thang.setSelectedIndex(0);
		cbb_Thang.setBounds(24, 167, 68, 33);
		pnl_Control.add(cbb_Thang);
		
		JComboBox cbb_Nam = new JComboBox();
		cbb_Nam.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		cbb_Nam.setSelectedIndex(12);
		cbb_Nam.setBounds(24, 211, 68, 33);
		pnl_Control.add(cbb_Nam);
		
		JPanel pnl_Chart = new JPanel();
		pnl_Chart.setBackground(new Color(255, 255, 255));
		pnl_Chart.setBounds(237, 11, 375, 233);
		pnl_Control.add(pnl_Chart);
		
		JButton btn_XuatPhieuLuong = new JButton("Xuất phiếu lương");
		btn_XuatPhieuLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XuatPhieuLuong.setBounds(24, 99, 182, 33);
		pnl_Control.add(btn_XuatPhieuLuong);
		
		JPanel pnl_Table = new JPanel();
		pnl_Table.setBackground(new Color(255, 255, 255));
		pnl_Table.setBounds(20, 341, 1258, 404);
		panel.add(pnl_Table);
		
		tbl_BangLuong = new JTable();
		tbl_BangLuong.setBackground(new Color(192, 192, 192));
		pnl_Table.add(tbl_BangLuong);
	}
}

	



	
	


