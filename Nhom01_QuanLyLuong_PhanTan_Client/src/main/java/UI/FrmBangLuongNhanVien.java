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
import javax.swing.JOptionPane;
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
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;

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
		setBackground(new Color(252, 222, 223));
		initGUI();
		setUI();

	}

	private void initGUI() {
		setBounds(100, 100, 1338, 780);
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
	}

	private void setUI() {
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(252, 222, 223));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pnl_Input = new JPanel();
		pnl_Input.setBounds(10, 75, 622, 255);
		pnl_Input.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thuế");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 50, 151, 23);
		pnl_Input.add(lblNewLabel);
		
		txtThue = new JTextField();
		txtThue.setColumns(10);
		txtThue.setBounds(171, 50, 444, 23);
		pnl_Input.add(txtThue);
		
		JLabel lblNewLabel_1 = new JLabel("Số ngày làm được");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 84, 151, 23);
		pnl_Input.add(lblNewLabel_1);
		
		txtSoNgayLam = new JTextField();
		txtSoNgayLam.setColumns(10);
		txtSoNgayLam.setBounds(171, 84, 444, 23);
		pnl_Input.add(txtSoNgayLam);
		
		JLabel lblNewLabel_2 = new JLabel("Lương cơ bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 118, 151, 23);
		pnl_Input.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 118, 444, 23);
		pnl_Input.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày tính lương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 152, 151, 23);
		pnl_Input.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 152, 444, 23);
		pnl_Input.add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Chứng chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 186, 151, 23);
		pnl_Input.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(171, 186, 444, 23);
		pnl_Input.add(textField_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("Mã phiếu phạt");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 220, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 222, 444, 22);
		pnl_Input.add(comboBox);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Mã nhân viên");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 15, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(171, 17, 444, 22);
		pnl_Input.add(comboBox_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Bảng lương nhân viên");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(508, 11, 255, 44);
		panel.add(lblNewLabel_4_2_1_1);
		
		JPanel pnl_Control = new JPanel();
		pnl_Control.setBounds(646, 75, 666, 255);
		pnl_Control.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Control);
		pnl_Control.setLayout(null);
		
		JButton btn_TinhLuong = new JButton("Tính lương");
		btn_TinhLuong.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\MenuXuLy.png"));
		btn_TinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_TinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Lương của nhân viên Bảo là 123000đ  ", "Thông báo", JOptionPane.YES_NO_OPTION);
			}
		});
		btn_TinhLuong.setBounds(10, 24, 182, 48);
		pnl_Control.add(btn_TinhLuong);
		
		JButton btn_ThemLuong = new JButton("Thêm lương");
		btn_ThemLuong.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\add32.png"));
		btn_ThemLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Thêm lương nhân viên Bảo thành công ", "Thông báo", JOptionPane.YES_NO_OPTION);
			}
		});
		btn_ThemLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ThemLuong.setBounds(10, 105, 182, 48);
		pnl_Control.add(btn_ThemLuong);
		
		JPanel pnl_Chart = new JPanel();
		pnl_Chart.setBackground(new Color(252, 222, 223));
		pnl_Chart.setBounds(202, 0, 454, 255);
		pnl_Control.add(pnl_Chart);
		pnl_Chart.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 0, 275, 255);
		pnl_Chart.add(calendar);
		
		
		JButton btn_ThongKeThang = new JButton("Tổng tháng");
		btn_ThongKeThang.setBounds(295, 105, 149, 48);
		pnl_Chart.add(btn_ThongKeThang);
		btn_ThongKeThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_ThongKeNam = new JButton("Tổng năm");
		btn_ThongKeNam.setBounds(295, 182, 149, 48);
		pnl_Chart.add(btn_ThongKeNam);
		btn_ThongKeNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_XuatPhieuLuong = new JButton("Xuất phiếu lương");
		btn_XuatPhieuLuong.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\folder.png"));
		btn_XuatPhieuLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmPhieuLuong frmPhieuLuong = new FrmPhieuLuong();
				frmPhieuLuong.setVisible(true);
			}
		});
		btn_XuatPhieuLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XuatPhieuLuong.setBounds(10, 182, 182, 48);
		pnl_Control.add(btn_XuatPhieuLuong);
		
		JPanel pnl_Table = new JPanel();
		pnl_Table.setBackground(new Color(252, 222, 223));
		pnl_Table.setBounds(10, 341, 1302, 404);
		panel.add(pnl_Table);
		
		tbl_BangLuong = new JTable();
		tbl_BangLuong.setBackground(new Color(192, 192, 192));
		pnl_Table.add(tbl_BangLuong);
	}
}

	



	
	


