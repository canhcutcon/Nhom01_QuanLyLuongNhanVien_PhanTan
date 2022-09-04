package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


public class FrmQuanLyPhieuPhat extends JInternalFrame {

	private JPanel contentPane;
	private JTable tbl_BangLuong;
//	private FrmQuanLyPhieuPhat frmQuanLyPhieuPhat;
//	private Frm_MucPhat frm_MucPhat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmQuanLyPhieuPhat frame = new FrmQuanLyPhieuPhat();
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
	public FrmQuanLyPhieuPhat() {
		getContentPane().setBackground(new Color(252, 222, 223));
		
		setName("FrmQLPhieuPhat");
		setTitle("Công ty GBS");
		setVisible(true);
		setBackground(Color.WHITE);
		initGUI();
		setUI();
	}
	private void initGUI() {
		setBounds(100, 100, 1302, 793);
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
//		frmQuanLyPhieuPhat = new FrmQuanLyPhieuPhat();
//		frm_MucPhat = new Frm_MucPhat();
	}

	private void setUI() {
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(252, 222, 223));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pnl_Input = new JPanel();
		pnl_Input.setBounds(10, 75, 1266, 163);
		pnl_Input.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("Mã mức phạt");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 23, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Mã nhân viên");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 57, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		JComboBox cbb_MaMucPhat = new JComboBox();
		cbb_MaMucPhat.setBounds(171, 25, 1085, 22);
		pnl_Input.add(cbb_MaMucPhat);
		
		JComboBox cbb_MaNhanVien = new JComboBox();
		cbb_MaNhanVien.setBounds(171, 59, 1085, 22);
		pnl_Input.add(cbb_MaNhanVien);
		
		JButton btnXoa = new JButton("Xoá phiếu");
		btnXoa.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\remove32.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Xoá", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnXoa.setBounds(1026, 92, 230, 48);
		pnl_Input.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Sua = new JButton("Sửa phiếu");
		btn_Sua.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\repair.png"));
		btn_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Sửa", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		});
		btn_Sua.setBounds(598, 92, 230, 48);
		pnl_Input.add(btn_Sua);
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Them = new JButton("Thêm phiếu");
		btn_Them.setSelectedIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\add32.png"));
		btn_Them.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\add32.png"));
		btn_Them.setBounds(171, 92, 230, 48);
		pnl_Input.add(btn_Them);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Thêm", "Thông báo", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Quản lý phiếu phạt");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(508, 11, 221, 44);
		panel.add(lblNewLabel_4_2_1_1);
		
		JPanel pnl_Table = new JPanel();
		pnl_Table.setBackground(new Color(252, 222, 223));
		pnl_Table.setBounds(10, 249, 1268, 496);
		panel.add(pnl_Table);
		
		tbl_BangLuong = new JTable();
		tbl_BangLuong.setBackground(new Color(192, 192, 192));
		pnl_Table.add(tbl_BangLuong);
	}
}
