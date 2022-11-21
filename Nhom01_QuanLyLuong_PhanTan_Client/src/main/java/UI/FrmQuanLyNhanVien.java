package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import componentCustom.CurrentState;
import componentCustom.ImageFilter;
import entity.NhanVien;
import entity.PhongBan;
import service.NhanVienService;
import service.PhongBanServic;

public class FrmQuanLyNhanVien extends JInternalFrame implements MouseListener, ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private static final String HOST = "localhost";
	private static final String PORT = "8988";
	private JTextField txtNgayVaoLam;
	private JTextField txtNgaySinh;
	private JLabel lblImage;
	private JTable tableNhanVien;
	private DefaultTableModel modelNhanVien;
	JComboBox cboChucVu;
	JComboBox cboPhongBan;
	DefaultComboBoxModel<String> modelChucVu;
	DefaultComboBoxModel<String> modelPhongBan;
	JButton btnThem;
	JButton btnSua;
	JButton btnChonAnh;
	JButton btnTimKienNhanVien;
	JButton btnLoad;
	NhanVienService nhanVienService;
	PhongBanServic phongBanServic;
	String[] colHeader = { "Mã nhân viên", "Tên nhân viên", "SĐT", "CMND", "Ngày vào làm", "Ngày sinh", "Chức vự",
			"Hình ảnh" };
	private JButton btnXoa;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtSDTNV;
	private JTextField txtCMNDNV;
	private TextField txtPath;
	JRadioButton radMaNV;
	JRadioButton radTenNV;
	JRadioButton radSDT;
	ImageIcon scaleIcon;
	HashMap<String, CurrentState> roles = new HashMap<String, CurrentState>();
	private JTextField txtTK;

	public FrmQuanLyNhanVien() {
		nhanVienService = new NhanVienService(HOST, PORT);
		phongBanServic = new PhongBanServic(HOST, PORT);
		addRole();
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 1474, 40);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 46, 688, 374);
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

		txtNgayVaoLam = new JFormattedTextField();
		txtNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNgayVaoLam.setColumns(10);
		txtNgayVaoLam.setBounds(152, 195, 477, 34);
		panel_1.add(txtNgayVaoLam);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 233, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(152, 239, 477, 34);
		panel_1.add(txtNgaySinh);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(10, 277, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1_1_1);

		cboChucVu = new JComboBox();
		cboChucVu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboChucVu.setBounds(152, 283, 477, 31);
		panel_1.add(cboChucVu);

		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("Phòng ban:");
		lblNewLabel_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1_1_1_1_1_1_1.setBounds(10, 318, 115, 31);
		panel_1.add(lblNewLabel_2_1_1_1_1_1_1_1);

		cboPhongBan = new JComboBox();
		cboPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPhongBan.setBounds(152, 324, 477, 31);
		panel_1.add(cboPhongBan);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(152, 13, 477, 31);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		txtMaNV.requestFocus();

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(152, 57, 477, 31);
		panel_1.add(txtTenNV);

		txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(152, 101, 477, 31);
		panel_1.add(txtSDTNV);

		txtCMNDNV = new JTextField();
		txtCMNDNV.setColumns(10);
		txtCMNDNV.setBounds(152, 151, 477, 31);
		panel_1.add(txtCMNDNV);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(719, 46, 363, 374);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblImage = new JLabel("");
		lblImage.setBounds(76, 30, 230, 230);
		panel_2.add(lblImage);

		btnChonAnh = new JButton("Select Image");
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChonAnh.setIcon(new ImageIcon("HinhAnh\\Icon\\folder.png"));
		btnChonAnh.setBounds(113, 323, 166, 41);
		panel_2.add(btnChonAnh);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1092, 50, 392, 370);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("HinhAnh\\Icon\\add32.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(127, 67, 146, 41);
		panel_3.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("HinhAnh\\Icon\\repair.png"));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(127, 175, 146, 41);
		panel_3.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("HinhAnh\\Icon\\remove32.png"));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(127, 272, 146, 41);
		panel_3.add(btnXoa);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 481, 1474, 236);
		getContentPane().add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		tableNhanVien = new JTable(modelNhanVien);
		JScrollPane scrollPane = new JScrollPane(tableNhanVien);
		panel_4.add(scrollPane, BorderLayout.CENTER);

		// ==========
		tableNhanVien.addMouseListener(this);

		modelNhanVien = new DefaultTableModel(colHeader, 0);

		btnTimKienNhanVien = new JButton("Tìm kiếm nhân viên");
		btnTimKienNhanVien.setIcon(new ImageIcon("HinhAnh\\Icon\\search32.png"));
		btnTimKienNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTimKienNhanVien.setBounds(10, 430, 219, 41);
		getContentPane().add(btnTimKienNhanVien);

		btnLoad = new JButton("");
		btnLoad.setIcon(new ImageIcon("HinhAnh\\Icon\\synchronize_30px.png"));
		btnLoad.setBounds(1432, 431, 40, 40);
		getContentPane().add(btnLoad);

		ImageIcon scaleIcon = scaleImage(new ImageIcon("HinhAnh\\Logo\\boy512.png"));
		lblImage.setIcon(scaleIcon);

		txtPath = new TextField();
		txtPath.setBounds(76, 282, 230, 21);
		panel_2.add(txtPath);

		txtTK = new JTextField();
		txtTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTK.setBounds(239, 430, 295, 41);
		getContentPane().add(txtTK);
		txtTK.setColumns(10);
		
		
		radMaNV = new JRadioButton("Mã nhân viên");
		radMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radMaNV.setBounds(577, 430, 103, 41);
		getContentPane().add(radMaNV);

		radTenNV = new JRadioButton("Tên nhân viên");
		radTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radTenNV.setBounds(696, 430, 133, 41);
		getContentPane().add(radTenNV);

		radSDT = new JRadioButton("Số điện thoại nhân viên");
		radSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		radSDT.setBounds(847, 430, 177, 41);
		getContentPane().add(radSDT);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radMaNV);
		bg.add(radSDT);
		bg.add(radTenNV);
		loadNhanVienToTable();
		loadComboBox();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnTimKienNhanVien.addActionListener(this);
		btnLoad.addActionListener(this);
		btnSua.setEnabled(true);
		btnChonAnh.setEnabled(true);
		radMaNV.addItemListener(this);
		radSDT.addItemListener(this);
		radTenNV.addItemListener(this);
		enableAll();
	}

	private ImageIcon scaleImage(ImageIcon icon) {
		// scaling image fit in jtable
		java.awt.Image img = icon.getImage();
		java.awt.Image imgScale = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaleIcon = new ImageIcon(imgScale);
		return scaleIcon;
	}

	public int getChucVu(CurrentState role) {
		switch (role) {
		case ADMIN:
			return 5;
		case EMPLOYEE:
			return 0;
		case EMPLOYEE_MANAGER:
			return 3;
		case MANAGER:
			return 1;
		case NONE:
			return 2;
		case SALARY_MANAGER:
			return 4;
		default:
			break;
		}
		return -1;
	}

	public void addRole() {
		roles.put("admin", CurrentState.ADMIN);
		roles.put("Nhân viên", CurrentState.EMPLOYEE);
		roles.put("Quản lý nhân sự", CurrentState.EMPLOYEE_MANAGER);
		roles.put("Quản lý", CurrentState.MANAGER);
		roles.put("none", CurrentState.NONE);
		roles.put("Quản lý lương", CurrentState.SALARY_MANAGER);
	}

	public CurrentState getRolẹ(String chucVu) {

		for (String role : roles.keySet()) {
			if (chucVu.equals(role)) {
				return roles.get(role);
			}
		}
		return CurrentState.NONE;
	}

	public void loadComboBox() {
		try {
			modelChucVu = new DefaultComboBoxModel();
			modelChucVu.addElement("Nhân Viên");
			modelChucVu.addElement("Quản lý");
			modelChucVu.addElement("none");
			modelChucVu.addElement("Quản lý nhân sự");
			modelChucVu.addElement("Quản lý lương");
			cboChucVu.setModel(modelChucVu);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try {
			modelPhongBan = new DefaultComboBoxModel();
			List<PhongBan> lst = phongBanServic.getAllPhongBan();
			for (PhongBan i : lst)
				modelPhongBan.addElement(i.getTenPB());
			cboPhongBan.setModel(modelPhongBan);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void loadNhanVienToTable() {
		List<NhanVien> nhanViens = null;
		try {
			nhanViens = nhanVienService.getAllNhanVien();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nhanViens == null)
			nhanViens = new ArrayList<NhanVien>();

		tableNhanVien.setModel(modelNhanVien = new DefaultTableModel(colHeader, 0));
		for (NhanVien item : nhanViens) {
			String chucvu = item.getChucVu();
			Object[] obj = { item.getMaNV(), item.getTenNV(), item.getSdt(), item.getCmnd(), item.getNgayVaoLam(),
					item.getNgaySinh(), chucvu, item.getHinhAnh() };
			modelNhanVien.addRow(obj);
		}

	}

	public void loadNhanVienToTable(List<NhanVien> nhanViens) {
		tableNhanVien.setModel(modelNhanVien = new DefaultTableModel(colHeader, 0));
		for (NhanVien item : nhanViens) {
			String chucvu = item.getChucVu();
			Object[] obj = { item.getMaNV(), item.getTenNV(), item.getSdt(), item.getCmnd(), item.getNgayVaoLam(),
					item.getNgaySinh(), chucvu, item.getHinhAnh() };
			modelNhanVien.addRow(obj);
		}
	}

	public void loadDataToText(NhanVien nhanVien) {
		txtMaNV.setText(nhanVien.getMaNV() + "");
		txtTenNV.setText(nhanVien.getTenNV());
		txtCMNDNV.setText(nhanVien.getCmnd());
		txtNgaySinh.setText(nhanVien.getNgaySinh() + "");
		txtSDTNV.setText(nhanVien.getSdt());
		txtNgayVaoLam.setText(nhanVien.getNgayVaoLam().toString());
		txtNgaySinh.setText(nhanVien.getNgaySinh().toString());
		ImageIcon scaleIcon = scaleImage(new ImageIcon(nhanVien.getHinhAnh()));
		lblImage.setIcon(scaleIcon);
		int index = 0;
		for (CurrentState role : roles.values()) {
			if (nhanVien.getChucVu().equals(role.name())) {
				index = getChucVu(role);
			}
		}
		cboChucVu.setSelectedIndex(index);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		List<NhanVien> nhanViens = null;
		try {
			nhanViens = nhanVienService.getAllNhanVien();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (nhanViens == null)
			nhanViens = new ArrayList<NhanVien>();
		int select = tableNhanVien.getSelectedRow();
		if (select >= 0) {
			try {
				loadDataToText(nhanViens.get(select));
				btnThem.setEnabled(true);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

	public boolean checkEmpty() {
		String maLoai = txtMaNV.getText().trim();
		String tenNV = txtMaNV.getText().trim();
		String txtSDTNV = txtMaNV.getText().trim();
		String txtCMNDNV = txtMaNV.getText().trim();
		String txtNgayVaoLam = txtMaNV.getText().trim();
		String txtNgaySinh = txtMaNV.getText().trim();
		String chucVu = cboChucVu.getSelectedItem().toString();
		if (tenNV.isEmpty() || txtSDTNV.isEmpty() || txtCMNDNV.isEmpty() || txtNgayVaoLam.isEmpty()
				|| txtNgaySinh.isEmpty() || chucVu.isEmpty())
			return false;
		return true;
	}

	public NhanVien creatNhanVien() {
		int cv = cboChucVu.getSelectedIndex();
		String chucvu;
		Boolean isAdmin = false;
		if (cv == 0) {
			chucvu = "nhanvien";
		} else {
			chucvu = "quanly";
			isAdmin = true;
		}
		String cmnd = txtCMNDNV.getText().trim();
		String hinhAnh = txtPath.getText().trim();
		System.out.println(hinhAnh);
		String matKhau = "123456";
		LocalDate ngayVaoLam = LocalDate.now();
		LocalDate ngaySinh = LocalDate.parse(txtNgaySinh.getText().trim());
		String sdt = txtSDTNV.getText().trim();
		String ten = txtTenNV.getText().trim();
		PhongBan ban = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
		return new NhanVien(Integer.parseInt(txtMaNV.getText()), ten, sdt, cmnd, "", ngayVaoLam, ngaySinh, chucvu,
				matKhau, isAdmin, hinhAnh, 1, ban);
	}

	public void clearAll() {
		txtMaNV.setText("");
		txtCMNDNV.setText("");
		txtNgaySinh.setText("");
		txtNgayVaoLam.setText("");
		txtSDTNV.setText("");
		txtTenNV.setText("");
		cboChucVu.setSelectedIndex(0);
		cboPhongBan.setSelectedIndex(0);
		lblImage.setText("");
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void enableAll() {

		txtNgaySinh.setEnabled(true);
		txtNgaySinh.setEditable(true);

		txtNgayVaoLam.setEnabled(true);
		txtNgayVaoLam.setEditable(true);

	}

	public boolean accept(File f) {
		if (f.getName().toLowerCase().endsWith(".jpeg"))
			return true;
		if (f.getName().toLowerCase().endsWith(".jpg"))
			return true;
		if (f.isDirectory())
			return true;
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		txtMaNV.setEnabled(false);
		if (obj.equals(btnThem)) {
			if (!checkEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
				return;
			}
			enableAll();
			NhanVien nhanVien = creatNhanVien();
			boolean rs;
			try {
				rs = nhanVienService.addNewNhanVien(nhanVien);
				if (!rs)
					JOptionPane.showMessageDialog(null, "Thêm thất bại");
				else {
					loadNhanVienToTable();
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj.equals(btnSua)) {
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			enableAll();
			int select = tableNhanVien.getSelectedRow();
			if (!checkEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
				return;
			}

			if (select < 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn sửa thông tin");
				return;
			}

			NhanVien nhanVien = creatNhanVien();
			if (nhanVien == null) {
				JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!!!");
				return;
			}
			System.out.println(nhanVien);
			boolean rs;
			try {
				rs = nhanVienService.updateNhanVien(nhanVien);
				if (!rs)
					JOptionPane.showMessageDialog(null, "Sửa thất bại");
				else {
					loadNhanVienToTable();
					JOptionPane.showMessageDialog(null, "Sủa thành công");
				}
				btnThem.setEnabled(true);
				btnXoa.setEnabled(true);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj.equals(btnXoa)) {
			int select = tableNhanVien.getSelectedRow();
			if (select < 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên muốn xóa thông tin");
				return;
			}

			NhanVien nhanVien = null;
			try {
				nhanVien = nhanVienService.getNhanVienTheoMa(Integer.parseInt(txtMaNV.getText()));
			} catch (NumberFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (nhanVien == null) {
				JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!!!");
				return;
			}

			int n = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn XÓA nhân viên  này?",
					"Thông báo xác nhận XÓA nhân viên", JOptionPane.YES_NO_OPTION);
			boolean rs;
			try {
				rs = nhanVienService.deleteNhanVien(nhanVien);
				if (!rs)
					JOptionPane.showMessageDialog(null, "Xóa thất bại");
				else {
					loadNhanVienToTable();
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (obj.equals(btnLoad)) {
			loadNhanVienToTable();
		} else if (obj.equals(btnChonAnh)) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.addChoosableFileFilter(new ImageFilter());
			fileChooser.setAcceptAllFileFilterUsed(false);

			int option = fileChooser.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				txtPath.setText(file.getPath());

				ImageIcon scaleIcon = scaleImage(new ImageIcon(file.getAbsolutePath()));
				lblImage.setIcon(scaleIcon);
			} else {
				lblImage.setText("Open command canceled");
			}
		} else if (obj.equals(btnTimKienNhanVien)) {
			List<NhanVien> nhanviens = new ArrayList<NhanVien>();
			if (radMaNV.isSelected())
			{
				NhanVien nhanVien = null;
				int ma =Integer.parseInt(txtTK.getText().trim());
				try {
					nhanVien = nhanVienService.getNhanVienTheoMa(ma);
				} catch (NumberFormatException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!!!");
					return;
				}
				if (nhanVien == null) {
					JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!!!");
					return;
				}
				nhanviens.add(nhanVien);
				loadNhanVienToTable(nhanviens);
				return;

			} else {
				String tenNV = "";
				String sdt = "";
				if (radSDT.isSelected())
					sdt = txtTK.getText().trim();
				if (radTenNV.isSelected())
					tenNV = txtTK.getText().trim();
				try {
					nhanviens = nhanVienService.getNhanVienTheoDanhMuc(tenNV, sdt, "", "");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loadNhanVienToTable(nhanviens);
				return;
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
}
