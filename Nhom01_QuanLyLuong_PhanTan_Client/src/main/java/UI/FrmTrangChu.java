package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import componentCustom.CurrentState;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class FrmTrangChu extends JInternalFrame {
	private JPanel centerPanel;
	private String name;
	private String role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTrangChu frame = new FrmTrangChu();
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
	public FrmTrangChu() {
		setBackground(Color.WHITE);
		initGUI();
		setUI();
	}

	public FrmTrangChu(String name, CurrentState role) {
		setBackground(Color.WHITE);
		setAuthentication(role);
		this.name = name;
		initGUI();
		setUI();
	}

	private void setAuthentication(CurrentState role2) {
		// TODO Auto-generated method stub
		switch (role2) {
		case ADMIN:
			role = "Quản lý";
			break;
		case EMPLOYEE:
			role = "Nhân viên";
			break;
		case EMPLOYEE_MANAGER:
			role = "Quản lý nhân sự";
			break;
		case SALARY_MANAGER:
			role = "Quản lý lương";
			break;
		case MANAGER:
			role = "Trưởng Phòng";
		case NONE:
			role = "Không";
		default:
			break;

		}
	}

	public void initGUI() {
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));

	}

	public void setUI() {
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel logoPanel = new JPanel();
		leftPanel.add(logoPanel);
		logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("HinhAnh\\Logo\\41973c0e30db4c36924ab8e4a4a9cd33 (1).png"));
		logoPanel.add(lblLogo);

		JPanel rolePanel = new JPanel();
		rolePanel.setBackground(Color.WHITE);
		leftPanel.add(rolePanel);
		rolePanel.setLayout(new BoxLayout(rolePanel, BoxLayout.Y_AXIS));
		Component verticalStrut = Box.createVerticalStrut(120);
		rolePanel.add(verticalStrut);

		JLabel lblRole = new JLabel("");
		lblRole.setIcon(new ImageIcon("HinhAnh\\Logo\\c5d854c65639429c9a675217663b76df.png"));
		lblRole.setBackground(Color.WHITE);
		rolePanel.add(lblRole);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		rolePanel.add(infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		JLabel tblInfo = new JLabel("Tên nhân viên: ");
		tblInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		infoPanel.add(tblInfo);

		JLabel txtTenNhanVien = new JLabel(name);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		infoPanel.add(txtTenNhanVien);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		rolePanel.add(verticalStrut_1);

		JPanel infoRole = new JPanel();
		infoRole.setBackground(Color.WHITE);
		rolePanel.add(infoRole);
		infoRole.setLayout(new BoxLayout(infoRole, BoxLayout.Y_AXIS));

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		infoRole.add(lblChucVu);

		JLabel txtChucVu = new JLabel(role);
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		infoRole.add(txtChucVu);

		centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon("HinhAnh\\Logo\\befunky_layer.jpg"));
		centerPanel.add(backgroundLabel);
		setResizable(true);
		setBounds(-10, 0, 977, 800);
	}
}
