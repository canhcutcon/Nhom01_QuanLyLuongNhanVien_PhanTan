package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class FrmThongKeNhanSu extends JFrame {

	private JPanel contentPane;
	private JTextField txtThue;
	private JTextField txtSoNgayLam;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tbl_NhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThongKeNhanSu frame = new FrmThongKeNhanSu();
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
	public FrmThongKeNhanSu() {
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
		pnl_Input.setBounds(10, 75, 980, 416);
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("Quý");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 23, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Trạng thái nhân viên");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 57, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		tbl_NhanVien = new JTable();
		tbl_NhanVien.setBounds(10, 136, 954, 269);
		pnl_Input.add(tbl_NhanVien);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 23, 793, 23);
		pnl_Input.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(171, 59, 793, 23);
		pnl_Input.add(comboBox_1);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Thống kê nhân sự");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(382, 11, 221, 44);
		panel.add(lblNewLabel_4_2_1_1);
	}
}