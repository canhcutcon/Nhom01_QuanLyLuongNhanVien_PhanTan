package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import entity.BangLuongNhanVien;
import entity.NhanVien;
import entity.PhongBan;
import service.BangChamCongService;
import service.BangLuongService;
import service.NhanVienService;
import service.PhongBanServic;

public class FrmBangLuongNhanVien extends JInternalFrame implements ActionListener, MouseListener {
	private static final String HOST = "localhost";
	private static final String PORT = "8988";
	NhanVienService nhanVienService;
	PhongBanServic phongBanServic;
	BangChamCongService bangChamCongService;
	BangLuongService bangLuongService;
	private JPanel contentPane;
	private JTextField txtThue;
	private JTextField txtSoNgayLam;
	private JTextField txtLuongCoBan;
	private JTextField txtNgayTinhLuong;
	private JTextField txtChungChi;
	private JTable tbl_BangLuong;
	private JTextField txtMaNV;
	private JTextField txtTienPhat;
	private JTextField txtTongLuongTT;
	private JTextField txtThucNhan;
	JComboBox cboPhongBan;
	JComboBox cboNam;
	JComboBox cboThang;
	JButton btn_TinhLuong;
	JButton btn_XuatPhieuLuong;
	JButton btnSua;
	JButton btnLoad;
	JButton btnHuy;
	JButton btnLuu;
	private DefaultTableModel modelTableLuong;
	DefaultComboBoxModel<String> modelPhongBan;
	Date dateTinhLuong = new Date();
	String[] col = { "Mã nhân viên", "Họ Tên", "Phòng ban", "Lương cơ bản", "Tiền Phạt", "Thuế(%)", "Phụ cấp",
			"Số ngày công", "Chứng chỉ", "Tổng lương", "Thực nhận", "Mã lương" };
	String[] colNhanVien = { "Mã nhân viên", "Họ Tên", "Phòng ban", "Lương cơ bản", "Tiền Phạt", "Thuế(%)", "Phụ cấp",
			"Số ngày công", "Chứng chỉ", "Tổng lương", "Thực nhận" };
	private JTextField txtPhuCap;
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
		bangLuongService = new BangLuongService(HOST, PORT);
		phongBanServic = new PhongBanServic(HOST, PORT);
		nhanVienService = new NhanVienService(HOST, PORT);
		bangChamCongService = new BangChamCongService(HOST, PORT);
		initGUI();
		setUI();
		loadCbo();
		btn_TinhLuong.setEnabled(false);
		btnSua.setEnabled(false);
		int t = Integer.parseInt(cboThang.getSelectedItem().toString());
		int year = Integer.parseInt(cboNam.getSelectedItem().toString());
		int tTL = dateTinhLuong.getMonth() + 1;
		int yearTL = dateTinhLuong.getYear() + 1900;
		PhongBan pb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());

		loadDatatoTable(pb.getMaPB(), t, year);
		// ==== action
		btn_TinhLuong.addActionListener(this);
		btn_XuatPhieuLuong.addActionListener(this);
		btnLoad.addActionListener(this);
		btnSua.addActionListener(this);
		tbl_BangLuong.addMouseListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		cboPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = Integer.parseInt(cboThang.getSelectedItem().toString());
				int year = Integer.parseInt(cboNam.getSelectedItem().toString());
				int tTL = dateTinhLuong.getMonth() + 1;
				int yearTL = dateTinhLuong.getYear() + 1900;
				if (tTL == t && yearTL == year) {
					btn_TinhLuong.setEnabled(true);
					btnSua.setEnabled(true);
				}
					loadDatatoTable(pb.getMaPB(), t, year);
			}
		});
		cboNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = Integer.parseInt(cboThang.getSelectedItem().toString());
				int year = Integer.parseInt(cboNam.getSelectedItem().toString());
				int tTL = dateTinhLuong.getMonth() + 1;
				int yearTL = dateTinhLuong.getYear() + 1900;
				if (tTL == t && yearTL == year) {
					btn_TinhLuong.setEnabled(true);
					btnSua.setEnabled(true);
				} 
					loadDatatoTable(pb.getMaPB(), t, year);
			}
		});
		cboThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = Integer.parseInt(cboThang.getSelectedItem().toString());
				int year = Integer.parseInt(cboNam.getSelectedItem().toString());
				int tTL = dateTinhLuong.getMonth() + 1;
				int yearTL = dateTinhLuong.getYear() + 1900;
				if (tTL == t && yearTL == year) {
					btn_TinhLuong.setEnabled(true);
					btnSua.setEnabled(true);
				} 
				loadDatatoTable(pb.getMaPB(), t, year);
			}
		});

	}

	private void initGUI() {
		setBounds(100, 100, 1483, 785);
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
		pnl_Input.setBounds(10, 75, 915, 211);
		pnl_Input.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thuế");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 50, 151, 23);
		pnl_Input.add(lblNewLabel);

		txtThue = new JTextField();
		txtThue.setText("0.5");
		txtThue.setColumns(10);
		txtThue.setBounds(134, 46, 295, 23);
		pnl_Input.add(txtThue);

		JLabel lblNewLabel_1 = new JLabel("Số ngày làm được");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 84, 151, 23);
		pnl_Input.add(lblNewLabel_1);

		txtSoNgayLam = new JTextField();
		txtSoNgayLam.setEditable(false);
		txtSoNgayLam.setColumns(10);
		txtSoNgayLam.setBounds(134, 80, 295, 23);
		pnl_Input.add(txtSoNgayLam);

		JLabel lblNewLabel_2 = new JLabel("Lương cơ bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 118, 151, 23);
		pnl_Input.add(lblNewLabel_2);

		txtLuongCoBan = new JTextField();
		txtLuongCoBan.setText("50000000");
		txtLuongCoBan.setColumns(10);
		txtLuongCoBan.setBounds(134, 114, 295, 23);
		pnl_Input.add(txtLuongCoBan);

		JLabel lblNewLabel_3 = new JLabel("Ngày tính lương");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 152, 151, 23);
		pnl_Input.add(lblNewLabel_3);

		txtNgayTinhLuong = new JTextField();
		txtNgayTinhLuong.setEditable(false);
		txtNgayTinhLuong.setColumns(10);
		txtNgayTinhLuong.setBounds(134, 148, 295, 23);
		pnl_Input.add(txtNgayTinhLuong);

		JLabel lblNewLabel_4 = new JLabel("Chứng chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 186, 151, 23);
		pnl_Input.add(lblNewLabel_4);

		txtChungChi = new JTextField();
		txtChungChi.setColumns(10);
		txtChungChi.setBounds(134, 182, 295, 23);
		pnl_Input.add(txtChungChi);

		JLabel lblNewLabel_4_2_1 = new JLabel("Mã nhân viên");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 15, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(134, 17, 295, 23);
		pnl_Input.add(txtMaNV);

		JLabel lblNewLabel_4_2_1_2 = new JLabel("Phòng ban");
		lblNewLabel_4_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1_2.setBounds(461, 15, 127, 23);
		pnl_Input.add(lblNewLabel_4_2_1_2);

		JLabel lblTinPht = new JLabel("Tiền phạt");
		lblTinPht.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinPht.setBounds(461, 50, 151, 23);
		pnl_Input.add(lblTinPht);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng lương thực tế");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(461, 118, 151, 23);
		pnl_Input.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Thực nhận");
		lblNewLabel_2_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(461, 152, 151, 23);
		pnl_Input.add(lblNewLabel_2_1);

		txtTienPhat = new JTextField();
		txtTienPhat.setColumns(10);
		txtTienPhat.setBounds(598, 50, 295, 23);
		pnl_Input.add(txtTienPhat);

		txtTongLuongTT = new JTextField();
		txtTongLuongTT.setColumns(10);
		txtTongLuongTT.setBounds(598, 118, 295, 23);
		pnl_Input.add(txtTongLuongTT);

		txtThucNhan = new JTextField();
		txtThucNhan.setColumns(10);
		txtThucNhan.setBounds(598, 152, 295, 23);
		pnl_Input.add(txtThucNhan);

		cboPhongBan = new JComboBox();
		cboPhongBan.setBounds(598, 18, 295, 21);
		pnl_Input.add(cboPhongBan);

		JLabel lblNewLabel_5 = new JLabel("Năm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(702, 181, 87, 28);
		pnl_Input.add(lblNewLabel_5);

		cboNam = new JComboBox();
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cboNam.setBounds(799, 181, 106, 28);
		pnl_Input.add(cboNam);

		JLabel lblNewLabel_5_1 = new JLabel("Tháng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_5_1.setBounds(489, 181, 87, 28);
		pnl_Input.add(lblNewLabel_5_1);

		cboThang = new JComboBox();
		cboThang.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cboThang.setBounds(586, 181, 106, 28);
		pnl_Input.add(cboThang);

		JLabel lblPhCp = new JLabel("Phụ cấp");
		lblPhCp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhCp.setBounds(461, 84, 151, 23);
		pnl_Input.add(lblPhCp);

		txtPhuCap = new JTextField();
		txtPhuCap.setText("500000");
		txtPhuCap.setColumns(10);
		txtPhuCap.setBounds(598, 84, 295, 23);
		pnl_Input.add(txtPhuCap);

		JLabel lblNewLabel_4_2_1_1 = new JLabel("BẢNG LƯƠNG NHÂN VIÊN");
		lblNewLabel_4_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_4_2_1_1.setBounds(508, 11, 347, 44);
		panel.add(lblNewLabel_4_2_1_1);

		JPanel pnl_Control = new JPanel();
		pnl_Control.setBounds(935, 75, 524, 211);
		pnl_Control.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Control);
		pnl_Control.setLayout(null);

		btn_TinhLuong = new JButton("Tính lương");
		btn_TinhLuong.setIcon(new ImageIcon("HinhAnh\\Icon\\add_receipt_48px.png"));
		btn_TinhLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_TinhLuong.setBounds(10, 24, 182, 48);
		pnl_Control.add(btn_TinhLuong);

		btn_XuatPhieuLuong = new JButton("Xuất phiếu lương");
		btn_XuatPhieuLuong.setIcon(new ImageIcon("HinhAnh\\Icon\\folder.png"));
		btn_XuatPhieuLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_XuatPhieuLuong.setBounds(10, 90, 182, 48);
		pnl_Control.add(btn_XuatPhieuLuong);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("HinhAnh\\Icon\\repair.png"));
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(10, 148, 182, 48);
		pnl_Control.add(btnSua);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(202, 24, 182, 48);
		pnl_Control.add(btnLuu);

		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuy.setEnabled(false);
		btnHuy.setBounds(202, 90, 182, 48);
		pnl_Control.add(btnHuy);

		JPanel pnl_Table = new JPanel();
		pnl_Table.setBackground(new Color(252, 222, 223));
		pnl_Table.setBounds(10, 341, 1449, 404);
		panel.add(pnl_Table);
		pnl_Table.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		pnl_Table.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel("BẢNG LƯƠNG NHÂN VIÊN HÀNH CHÁNH");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBackground(new Color(192, 192, 192));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_1.add(lblNewLabel_6);
		modelTableLuong = new DefaultTableModel(colNhanVien, 0);
		tbl_BangLuong = new JTable(modelTableLuong);
		tbl_BangLuong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbl_BangLuong.setBackground(new Color(192, 192, 192));

		JScrollPane scrollPane = new JScrollPane(tbl_BangLuong);
		pnl_Table.add(scrollPane);

		JPanel pnl_Control_1 = new JPanel();
		pnl_Control_1.setLayout(null);
		pnl_Control_1.setBackground(new Color(252, 222, 223));
		pnl_Control_1.setBounds(20, 287, 1439, 44);
		panel.add(pnl_Control_1);

		JLabel lblNewLabel_10 = new JLabel("Lưu ý:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_10.setBounds(421, 10, 87, 24);
		pnl_Control_1.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel(
				"- Chức năng tính lương sẽ được mở vào ngày 28 hàng tháng, và sẽ có 2 ngày để chỉnh sửa, sau hai ngày sẽ khóa.");
		lblNewLabel_11.setBounds(468, 10, 832, 24);
		pnl_Control_1.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.ITALIC, 16));

		btnLoad = new JButton("");
		btnLoad.setBounds(1376, 0, 63, 48);
		pnl_Control_1.add(btnLoad);
		btnLoad.setIcon(new ImageIcon("HinhAnh\\Icon\\synchronize_30px.png"));
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public void loadCbo() {
		Date date = new Date();
		for (int i = 2019; i <= date.getYear() + 1900; i++) {
			cboNam.addItem(i);
		}

		for (int i = 1; i <= date.getMonth() + 1; i++) {
			cboThang.addItem(i);
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

	public void loadDatatoTable(String mapb) {
		List<NhanVien> nhanViens = null;
		try {
			nhanViens = nhanVienService.getAllNhanVien(mapb);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nhanViens == null || nhanViens.size() == 0)
			return;
		tbl_BangLuong.setModel(modelTableLuong = new DefaultTableModel(colNhanVien, 0));
		for (NhanVien nhanVien : nhanViens) {
			Object[] obj = { nhanVien.getMaNV(), nhanVien.getTenNV(), cboPhongBan.getSelectedItem().toString(), 0, 0, 0,
					0, 0, 0, 0, 0 };
			modelTableLuong.addRow(obj);
		}

	}

	public double tongLuong(double luongCoBan, int ngayCong) {
		return luongCoBan * ngayCong;
	}

	public double thucNhan(double tongLuong, BangLuongNhanVien item) {
		return (tongLuong - (item.getTienPhat() + (tongLuong * item.getThue())) + (item.getSoChungChi() * 500000)
				+ item.getPhuCap());
	}

	public long thucNhan(double tongLuong, double thue, double tienPhat, double phuCap, int chungChi) {
		return (long) (tongLuong - (tienPhat + (tongLuong * thue)) + (chungChi * 500000) + phuCap);
	}

	public void loadDatatoTable(int mapb, int thang, int nam) {
		List<BangLuongNhanVien> nhanViens = null;
		try {
			nhanViens = bangLuongService.getListBangLuongNhanVien(mapb, nam, thang, nam);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (nhanViens == null || nhanViens.size() == 0) {
			loadDatatoTable(mapb + "");
			return;
		}
		tbl_BangLuong.setModel(modelTableLuong = new DefaultTableModel(colNhanVien, 0));
		for (BangLuongNhanVien nhanVien : nhanViens) {
			double tongLuong = tongLuong(nhanVien.getLuongCoBan(), nhanVien.getSoNgayLam());
			double thucNhan = thucNhan(tongLuong, nhanVien);
			Object[] obj = { nhanVien.getNhanVien().getMaNV(), nhanVien.getNhanVien().getTenNV(),
					cboPhongBan.getSelectedItem().toString(), nhanVien.getLuongCoBan(), nhanVien.getTienPhat(),
					nhanVien.getThue(), nhanVien.getPhuCap(), nhanVien.getSoNgayLam(), nhanVien.getSoChungChi(),
					txtTongLuongTT.getText(), txtThucNhan.getText(), nhanVien.getMaLuong() };
			modelTableLuong.addRow(obj);
		}

	}

	public int getNgayCong(String maNV) throws NumberFormatException, RemoteException {
		int t = Integer.parseInt(cboThang.getSelectedItem().toString());
		int year = Integer.parseInt(cboNam.getSelectedItem().toString());
		PhongBan pb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
		int snc = bangChamCongService.getSoNgayCong(t, year, pb.getMaPB(), Integer.parseInt(maNV));
		return snc;
	}

	public void validation() {
		if (txtChungChi.getText().isEmpty())
			txtChungChi.setText(0 + "");
		if (txtLuongCoBan.getText().isEmpty())
			txtLuongCoBan.setText("50000000");
		if (txtThue.getText().isEmpty())
			txtThue.setText("0");
		if (txtTienPhat.getText().isEmpty())
			txtTienPhat.setText("0");
	}

	public void tinhLuong(int row, String soNgayLam, String thue, String tienPhat, String phuCap, String chungChi,
			String luongCoBan) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		double t = Double.parseDouble(thue);
		double tP = Double.parseDouble(tienPhat);
		double pC = Double.parseDouble(phuCap);
		int cChi = Integer.parseInt(chungChi);
		double tongLuong = tongLuong(Double.parseDouble(luongCoBan), Integer.parseInt(soNgayLam));
		txtNgayTinhLuong.setText(dateFormat.format(dateTinhLuong));
		txtTongLuongTT.setText(tongLuong + "");
		txtThucNhan.setText(thucNhan(tongLuong, t, tP, pC, cChi) + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btn_TinhLuong)) {
			for (int i = 0; i < tbl_BangLuong.getRowCount(); i++) {
				validation();
				int soNgayCong = 0;
				try {
					soNgayCong = getNgayCong(tbl_BangLuong.getValueAt(i, 0).toString());
					txtSoNgayLam.setText(soNgayCong + "");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double tongLuong = tongLuong(Double.parseDouble(txtLuongCoBan.getText()),
						Integer.parseInt(txtSoNgayLam.getText()));
				double thue = Double.parseDouble(txtThue.getText());
				double tienPhat = Double.parseDouble(txtTienPhat.getText());
				double phuCap = Double.parseDouble(txtPhuCap.getText());
				int chungChi = Integer.parseInt(txtChungChi.getText());
				long thucNhan = (long) thucNhan(tongLuong, thue, tienPhat, phuCap, chungChi);
				txtTongLuongTT.setText(tongLuong + "");
				txtThucNhan.setText(thucNhan + "");
				tbl_BangLuong.setValueAt(txtLuongCoBan.getText(), i, 3);
				tbl_BangLuong.setValueAt(tienPhat, i, 4);
				tbl_BangLuong.setValueAt(thue, i, 5);
				tbl_BangLuong.setValueAt(phuCap, i, 6);
				tbl_BangLuong.setValueAt(soNgayCong, i, 7);
				tbl_BangLuong.setValueAt(chungChi, i, 8);
				tbl_BangLuong.setValueAt(tongLuong, i, 9);
				tbl_BangLuong.setValueAt(thucNhan, i, 10);
				btnLuu.setEnabled(true);
				btnHuy.setEnabled(true);
			}

		} else if (obj.equals(btnLuu)) {
			int n = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				for (int i = 0; i < tbl_BangLuong.getRowCount(); i++) {
					double thue = Double.parseDouble(tbl_BangLuong.getValueAt(i, 5).toString());
					double tienPhat = Double.parseDouble(tbl_BangLuong.getValueAt(i, 4).toString());
					double phuCap = Double.parseDouble(tbl_BangLuong.getValueAt(i, 6).toString());
					int chungChi = Integer.parseInt(tbl_BangLuong.getValueAt(i, 8).toString());
					int ngay = dateTinhLuong.getDay();
					int thang = dateTinhLuong.getMonth() + 1;
					int nam = dateTinhLuong.getYear() + 1900;
					int soNgayCong = 0;
					try {
						soNgayCong = getNgayCong(tbl_BangLuong.getValueAt(i, 0).toString());
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					double luongCoBan = Double.parseDouble(tbl_BangLuong.getValueAt(i, 3).toString());
					NhanVien nhanVien = null;
					try {
						nhanVien = nhanVienService
								.getNhanVienTheoMa(Integer.parseInt(tbl_BangLuong.getValueAt(i, 0).toString()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					double tongLuong = tongLuong(luongCoBan,soNgayCong);
					long thucNhan = (long) thucNhan(tongLuong, thue, tienPhat, phuCap, chungChi);
					BangLuongNhanVien bl = new BangLuongNhanVien(thue, phuCap, ngay, thang, nam, soNgayCong, luongCoBan,
							chungChi, thang, tienPhat, nhanVien);
					try {
						bangLuongService.createBangLuongNhanVien(bl);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnLuu.setEnabled(false);
					btnHuy.setEnabled(false);
				}
			}
		} else if (obj.equals(btnHuy)) {
			
			int n = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy?", "Thông báo", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				PhongBan pb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
				int year = Integer.parseInt(cboNam.getSelectedItem().toString());
				int tTL = dateTinhLuong.getMonth() + 1;
				loadDatatoTable(pb.getMaPB(), tTL, year);
				btnLuu.setEnabled(false);
				btnHuy.setEnabled(false);
			}
		}else if (obj.equals(btn_XuatPhieuLuong)) {
			int select = tbl_BangLuong.getSelectedRow();
			if (select >= 0) {
				BangLuongNhanVien bangLuongNhanVien = null;
				try {
					int t = Integer.parseInt(cboThang.getSelectedItem().toString());
					int year = Integer.parseInt(cboNam.getSelectedItem().toString());
					bangLuongNhanVien = bangLuongService.getBLTheoMaNV(Integer.parseInt(txtMaNV.getText()), t, year);
					if(bangLuongNhanVien == null) 
					{
						JOptionPane.showMessageDialog(null, "Xuất bảng lương không thành công");
						return;
					}
					double tongLuong = tongLuong(Double.parseDouble(txtLuongCoBan.getText()),
							Integer.parseInt(txtSoNgayLam.getText()));
					double thucNhan = thucNhan(tongLuong, bangLuongNhanVien);
					FrmPhieuLuong frm = new FrmPhieuLuong(bangLuongNhanVien, tongLuong, thucNhan);
					frm.pack();
					frm.setBounds(100, 100, 568, 650);
					frm.setBackground(new Color(135, 206, 250));
					frm.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
					frm.setFocusCycleRoot(true);
					frm.setFocusableWindowState(true);
					frm.setVisible(true);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		} else if (obj.equals(btnSua)) {
			BangLuongNhanVien bangLuongNhanVien = null;
			int select = tbl_BangLuong.getSelectedRow();
			if (select >= 0) {				
				try {
					int t = Integer.parseInt(cboThang.getSelectedItem().toString());
					int year = Integer.parseInt(cboNam.getSelectedItem().toString());
					bangLuongNhanVien = bangLuongService.getBLTheoMaNV(Integer.parseInt(txtMaNV.getText()), t, year);
					
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(bangLuongNhanVien == null)
				{
					JOptionPane.showMessageDialog(null, "Sửa thất bại");
					return;
				}
				double thue = Double.parseDouble(txtThue.getText());
				double tienPhat = Double.parseDouble(txtTienPhat.getText());
				double phuCap = Double.parseDouble(txtPhuCap.getText());
				int chungChi = Integer.parseInt(txtChungChi.getText());
				int soNgayCong = 0;
				try {
					soNgayCong = getNgayCong(txtMaNV.getText());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double luongCoBan = Double.parseDouble(txtLuongCoBan.getText());
				bangLuongNhanVien.setLuongCoBan(luongCoBan);
				bangLuongNhanVien.setThue(thue);
				bangLuongNhanVien.setPhuCap(phuCap);
				bangLuongNhanVien.setSoChungChi(chungChi);
				bangLuongNhanVien.setSoNgayLam(soNgayCong);
				bangLuongNhanVien.setTienPhat(tienPhat);
				boolean rs;
				try {
					rs = bangLuongService.updateBangLuongNhanVien(bangLuongNhanVien);
					if(!rs)
					{
						JOptionPane.showMessageDialog(null, "Sửa thất bại");
						return;
					}else
						JOptionPane.showMessageDialog(null, "Sửa thành công");
					PhongBan pb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
					int year = Integer.parseInt(cboNam.getSelectedItem().toString());
					int tTL = dateTinhLuong.getMonth() + 1;
					loadDatatoTable(pb.getMaPB(), tTL, year);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int select = tbl_BangLuong.getSelectedRow();
		if (select >= 0) {
			try {
				int index = phongBanServic.getPhongBanByName(tbl_BangLuong.getValueAt(select, 2).toString()).getMaPB();
				txtMaNV.setText(tbl_BangLuong.getValueAt(select, 0).toString());
				cboPhongBan.setSelectedIndex(index - 1);
				txtLuongCoBan.setText(tbl_BangLuong.getValueAt(select, 3).toString());
				txtTienPhat.setText(tbl_BangLuong.getValueAt(select, 4).toString());
				txtThue.setText(tbl_BangLuong.getValueAt(select, 5).toString());
				txtPhuCap.setText(tbl_BangLuong.getValueAt(select, 6).toString());
				txtSoNgayLam.setText(tbl_BangLuong.getValueAt(select, 7).toString());
				txtChungChi.setText(tbl_BangLuong.getValueAt(select, 8).toString());
				double tongLuong = tongLuong(Double.parseDouble(txtLuongCoBan.getText()),
						Integer.parseInt(txtSoNgayLam.getText()));
				double thue = Double.parseDouble(txtThue.getText());
				double tienPhat = Double.parseDouble(txtTienPhat.getText());
				double phuCap = Double.parseDouble(txtPhuCap.getText());
				int chungChi = Integer.parseInt(txtChungChi.getText());
				long thucNhan = (long) thucNhan(tongLuong, thue, tienPhat, phuCap, chungChi);
				txtTongLuongTT.setText(tongLuong + "");
				txtThucNhan.setText(thucNhan + "");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
