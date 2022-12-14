package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import componentCustom.CurrentState;
import dao.NhanVienDao;
import entity.NhanVien;

public class FrmDangNhap extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField taiKhoanText;
	private JButton cancelButton, okButton;
	private JPasswordField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDangNhap frame = new FrmDangNhap();
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
	public FrmDangNhap() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						loginUser();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		setFocusable(true);
		initFrameDangNhap();
		setUIFrmDangNhap();

	}

	private void initFrameDangNhap() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
	}

	private void setUIFrmDangNhap() {
//		LEFT PANEL 
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.WHITE);
		leftPanel.add(logoPanel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("HinhAnh\\Logo\\41973c0e30db4c36924ab8e4a4a9cd33 (1).png"));
		logoPanel.add(lblNewLabel);

		JPanel companyPanel = new JPanel();
		companyPanel.setBackground(new Color(255, 153, 153));
		leftPanel.add(companyPanel);

		JLabel lblNewLabel_1 = new JLabel("GSB Company");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 24));
		companyPanel.add(lblNewLabel_1);

		Component verticalStrut = Box.createVerticalStrut(10);
		verticalStrut.setBackground(Color.WHITE);
		leftPanel.add(verticalStrut);

		JLabel fogotPasswordLabel = new JLabel("Fotgot password?");
		fogotPasswordLabel.setForeground(Color.RED);
		fogotPasswordLabel.setBackground(Color.WHITE);
		fogotPasswordLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		leftPanel.add(fogotPasswordLabel);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalStrut_1.setBackground(Color.WHITE);
		leftPanel.add(verticalStrut_1);

		// ============== Right ===========
		JPanel RightPanel = new JPanel();
		RightPanel.setBackground(Color.WHITE);
		contentPane.add(RightPanel, BorderLayout.CENTER);
		RightPanel.setLayout(new BorderLayout(0, 0));

		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setOpaque(true);
		loginLabel.setBackground(Color.PINK);
		loginLabel.setPreferredSize(new Dimension(31, 80));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 30));
		RightPanel.add(loginLabel, BorderLayout.NORTH);

		JPanel infoLoginPanel = new JPanel();
		infoLoginPanel.setBackground(Color.WHITE);
		RightPanel.add(infoLoginPanel, BorderLayout.CENTER);
		infoLoginPanel.setLayout(new BoxLayout(infoLoginPanel, BoxLayout.Y_AXIS));

		Component verticalStrut_2 = Box.createVerticalStrut(40);
		infoLoginPanel.add(verticalStrut_2);

		JPanel userPanel = new JPanel();
		userPanel.setBackground(Color.WHITE);
		infoLoginPanel.add(userPanel);

		JLabel taiKhoanLabel = new JLabel("Username");
		taiKhoanLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		userPanel.add(taiKhoanLabel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		userPanel.add(horizontalStrut);

		taiKhoanText = new JTextField("4");
		taiKhoanText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userPanel.add(taiKhoanText);
		taiKhoanText.setColumns(15);

		JPanel passPanel = new JPanel();
		passPanel.setBackground(Color.WHITE);
		infoLoginPanel.add(passPanel);

		JLabel mkLabel = new JLabel("Password");
		mkLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		mkLabel.setPreferredSize(taiKhoanLabel.getPreferredSize());
		passPanel.add(mkLabel);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		passPanel.add(horizontalStrut_1);

		passwordText = new JPasswordField("123456");
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passPanel.add(passwordText);
		passwordText.setColumns(15);

		Component verticalStrut_3 = Box.createVerticalStrut(40);
		infoLoginPanel.add(verticalStrut_3);

		JPanel functionPanel = new JPanel();
		functionPanel.setPreferredSize(new Dimension(10, 50));
		functionPanel.setBackground(Color.WHITE);
		RightPanel.add(functionPanel, BorderLayout.SOUTH);

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.PINK);
		cancelButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		functionPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.setBackground(Color.PINK);
		okButton.setPreferredSize(cancelButton.getPreferredSize());
		okButton.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 20));
		functionPanel.add(okButton);

		cancelButton.addActionListener(this);
		okButton.addActionListener(this);
		taiKhoanText.addKeyListener(this);
		passwordText.addKeyListener(this);
	}

	public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj == cancelButton) {
			int n = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n tho??t?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				close();
			}
		} else if (obj == okButton) {
			try {
				loginUser();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				loginUser();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void loginUser() throws RemoteException {
		try {
			int userName = Integer.parseInt(taiKhoanText.getText());
			@SuppressWarnings("deprecation")
			String password = passwordText.getText();
			NhanVienDao nhanVienDao = getNhanVienDao();
			NhanVien nhanVien = nhanVienDao.getNhanVienTheoMa(userName);
			if (checkLoginUser(userName, password)) {
				this.setVisible(false);
				FrmTrangChinh window = new FrmTrangChinh(nhanVien.getTenNV(),getRole(nhanVien.getChucVu().trim()));
				window.frmCngTyGsb.setVisible(true);
				window.frmCngTyGsb.setLocationRelativeTo(null);
			} else {
				JOptionPane.showMessageDialog(null, "T??i kho???n m???t kh???u kh??ng ch??nh x??c");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "T??i kho???n m???t kh???u kh??ng ch??nh x??c");
		}
	}

	private boolean checkLoginUser(int userName, String password) throws NumberFormatException, RemoteException {
		// TODO Auto-generated method stub
		NhanVienDao nhanVienDao = getNhanVienDao();
		boolean isLogin = nhanVienDao.checkLoginUser(userName, password);
		if (isLogin) {
			return true;
		}
		return false;
	}

	public NhanVienDao getNhanVienDao() {
		try {
			return (NhanVienDao) Naming.lookup("rmi://localhost:8988/nhanVienDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public CurrentState getRole(String role) {
		if (role.equalsIgnoreCase("ADMIN"))
			return CurrentState.ADMIN;
		else if (role.equalsIgnoreCase("EMPLOYEE"))
			return CurrentState.EMPLOYEE;
		else if (role.equalsIgnoreCase("MANAGER"))
			return CurrentState.MANAGER;
		else if (role.equalsIgnoreCase("SALARY_MANAGER"))
			return CurrentState.SALARY_MANAGER;
		else if (role.equalsIgnoreCase("EMPLOYEE_MANAGER"))
			return CurrentState.EMPLOYEE_MANAGER;
		return CurrentState.NONE;

	}

}
