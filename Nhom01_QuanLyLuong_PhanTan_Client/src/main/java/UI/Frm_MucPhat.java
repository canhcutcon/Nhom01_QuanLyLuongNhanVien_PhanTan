package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Frm_MucPhat extends JFrame {


	private JPanel contentPane;
	private JTextField txtThue;
	private JTextField txtSoNgayLam;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txt_TenMucPhat;
	private JTextField txt_TienPhat;
	private JTable tbl_MucPhat;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_MucPhat frame = new Frm_MucPhat();
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
	public Frm_MucPhat() {
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
		
		JLabel lblNewLabel_4_2 = new JLabel("Tên mức phạt");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 23, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tiền phạt");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 57, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		JButton btnXoa = new JButton("Xoá mức phạt");
		btnXoa.setBounds(734, 92, 230, 33);
		pnl_Input.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Sua = new JButton("Sửa mức phạt");
		btn_Sua.setBounds(455, 92, 230, 33);
		pnl_Input.add(btn_Sua);
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Them = new JButton("Thêm mức phạt");
		btn_Them.setBounds(171, 92, 230, 33);
		pnl_Input.add(btn_Them);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_TenMucPhat = new JTextField();
		txt_TenMucPhat.setBounds(170, 23, 794, 23);
		pnl_Input.add(txt_TenMucPhat);
		txt_TenMucPhat.setColumns(10);
		
		txt_TienPhat = new JTextField();
		txt_TienPhat.setColumns(10);
		txt_TienPhat.setBounds(171, 57, 793, 23);
		pnl_Input.add(txt_TienPhat);
		
		tbl_MucPhat = new JTable();
		tbl_MucPhat.setBounds(10, 136, 954, 269);
		pnl_Input.add(tbl_MucPhat);
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Quản lý mức phạt");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(382, 11, 221, 44);
		panel.add(lblNewLabel_4_2_1_1);
	}
}
