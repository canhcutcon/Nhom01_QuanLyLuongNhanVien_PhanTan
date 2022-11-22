package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JDateChooser;

import entity.BangChamCong;
import entity.NhanVien;
import entity.PhongBan;
import service.BangChamCongService;
import service.NhanVienService;
import service.PhongBanServic;

public class FrmChamCong extends JInternalFrame implements ActionListener, MouseListener, ItemListener {
	private static final String HOST = "localhost";
	private static final String PORT = "8988";
	NhanVienService nhanVienService;
	PhongBanServic phongBanServic;
	BangChamCongService bangChamCongService;
	private JTextField txtTenNVCM, txtCVNV, txtPhongban, txtNgayCong;
	private JCheckBox cnkDiLam;
	private JButton btnSuaChamCong, btnChamCong, btnToday;
	private JLabel lblTenNhanVien;
	private JTable tableChamCong;
	private DefaultTableModel tblModelChamCong;
	private JComboBox cboPhongBan;
	DefaultComboBoxModel<String> modelPhongBan;
	JDateChooser chooser;
	String[] col = { "Mã nhân viên", "Tên nhân viên", "Ngày vào làm", "Chức vụ", "Trạng thái đi làm", "Đi trễ" };
	String[] colChamCong = { "Mã chấm công", "Mã nhân viên", "Tên nhân viên", "Ngày vào làm", "Chức vụ",
			"Trạng thái đi làm", "Đi trễ" };

	/**
	 * Ngày 29/08/2022 Võ Thị Trà Giang
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChamCong frame = new FrmChamCong();
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
	public FrmChamCong() {
		initGUI();
		setUI();

	}

	private void initGUI() {
		// TODO Auto-generated method stub
		setResizable(true);
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Chấm công nhân viên");
		getContentPane().setBackground(new Color(252, 222, 223));
		setBackground(new Color(252, 222, 223));
		setBounds(-10, 0, 1530, 800);
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		phongBanServic = new PhongBanServic(HOST, PORT);
		nhanVienService = new NhanVienService(HOST, PORT);
		bangChamCongService = new BangChamCongService(HOST, PORT);
	}

	private void setUI() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		thongTinNhanVienPanelMethod(panel);

		thongTinPhongBanPanelMethod(panel);

		thongTinChamCongPanelMethod(panel);

		timeLinePanelMethod(panel);

		bangChamCongPanelMethod(panel);
		loadComboBox();
		loadDatatoTable();
		chooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				btnChamCong.setEnabled(false);
				btnSuaChamCong.setEnabled(false);
				cnkDiLam.setEnabled(false);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				Date d = chooser.getDate();
				if (chooser.getDate() == null)
					return;
				if (dateFormat.format(date).equals(dateFormat.format(d))) {
					btnSuaChamCong.setEnabled(true);
					btnChamCong.setEnabled(true);
					cnkDiLam.setEnabled(true);
				}
				
				if (d.after(date))
					btnChamCong.setEnabled(false);
				else
					btnChamCong.setEnabled(true);
				txtNgayCong.setText(dateFormat.format(chooser.getDate()));

				PhongBan pb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
				if (d.before(date)) {
					int ngay = d.getDate();
					int thang = d.getMonth() + 1;
					int year = d.getYear() + 1900;
					loadBangChamCongDatatoTable(pb.getMaPB() + "", ngay, thang, year);
				} else {
					loadDatatoTable(pb.getMaPB() + "");
				}
			}
		});
	}

	private void bangChamCongPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel panelBangChamCong = new JPanel();
		panelBangChamCong.setBackground(new Color(252, 222, 223));
		getContentPane().add(panelBangChamCong, BorderLayout.CENTER);
		panelBangChamCong.setLayout(new BorderLayout(0, 0));
//		panelBangChamCong.setLayout(new BoxLayout(panelBangChamCong, BoxLayout.Y_AXIS));
		JPanel panel_1 = new JPanel();
		panelBangChamCong.add(panel_1, BorderLayout.NORTH);
		JLabel lblNewLabel = new JLabel("BẢNG CHẤM CÔNG NHÂN VIÊN");
		lblNewLabel.setPreferredSize(new Dimension(1000, 50));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(135, 206, 250));
		panel_1.add(lblNewLabel);
		tblModelChamCong = new DefaultTableModel(col, 0) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Boolean.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tableChamCong = new JTable(tblModelChamCong);
		tableChamCong.getColumnModel().getColumn(1).setPreferredWidth(109);
		tableChamCong.getColumnModel().getColumn(4).setPreferredWidth(112);
		tableChamCong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollPane_1 = new JScrollPane(tableChamCong);
		panelBangChamCong.add(scrollPane_1, BorderLayout.CENTER);

		// ==================
		btnChamCong.addActionListener(this);
		btnSuaChamCong.addActionListener(this);
		btnToday.addActionListener(this);
		tableChamCong.addMouseListener(this);
		cnkDiLam.addItemListener(this);
		cboPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhongBan maPb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
				int ngay = chooser.getDate().getDate();
				int thang = chooser.getDate().getMonth() + 1;
				int year = chooser.getDate().getYear() + 1900;
				loadBangChamCongDatatoTable(maPb.getMaPB() + "", ngay, thang, year);
			}
		});
	}

	private void timeLinePanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel panelTimeLine = new JPanel();
		panelTimeLine.setSize(new Dimension(600, 0));
		panelTimeLine.setBounds(new Rectangle(0, 0, 1200, 0));
		panelTimeLine.setBackground(new Color(252, 222, 223));
		getContentPane().add(panelTimeLine, BorderLayout.WEST);
		panelTimeLine.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel();

		panel_1.setPreferredSize(new Dimension(300, 680));
		panelTimeLine.add(panel_1);
		panel_1.setBackground(new Color(252, 222, 223));
		panel_1.setLayout(null);

//		
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new java.awt.BorderLayout(0, 0));
		datePanel.setBounds(10, 83, 280, 46);
		panel_1.add(datePanel);
		chooser = new JDateChooser();
		chooser.setDateFormatString("dd/MM/yyyy");
		chooser.setDate(new Date());
		datePanel.add(chooser, BorderLayout.CENTER);

		UtilDateModel dateModel = new UtilDateModel();

		btnToday = new JButton("Today");
		btnToday.setBackground(new Color(135, 206, 250));
		btnToday.setHorizontalTextPosition(SwingConstants.CENTER);
		btnToday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnToday.setBounds(156, 151, 134, 39);
		panel_1.add(btnToday);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(252, 222, 223));
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ph\u00F2ng ban", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel_2.setBounds(10, 235, 280, 127);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("Chọn phòng ban:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_4);

		cboPhongBan = new JComboBox();
		cboPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(cboPhongBan);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 280, 63);
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		Label label = new Label("NGÀY CÔNG");
		panel_3.add(label, BorderLayout.CENTER);
		label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		label.setAlignment(Label.CENTER);
		label.setBackground(new Color(135, 206, 250));
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setForeground(Color.BLACK);
	}

	private void thongTinChamCongPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel pnChamCong = new JPanel();
		pnChamCong.setBorder(new TitledBorder(null, "Ch\u1EA5m c\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(220, 20, 60)));
		pnChamCong.setBackground(new Color(252, 222, 223));
		panel.add(pnChamCong);
		pnChamCong.setLayout(new GridLayout(0, 2, 0, 0));

		cnkDiLam = new JCheckBox("Đi làm");
		cnkDiLam.setBackground(new Color(252, 222, 223));
		cnkDiLam.setPreferredSize(new Dimension(30, 21));
		cnkDiLam.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pnChamCong.add(cnkDiLam);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(252, 222, 223));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.PINK));
		pnChamCong.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 10, 5));

		btnSuaChamCong = new JButton("Sửa chấm công");
		btnSuaChamCong.setBackground(new Color(153, 204, 255));
		btnSuaChamCong.setIcon(new ImageIcon("HinhAnh\\Icon\\repair.png"));
		btnSuaChamCong.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_1.add(btnSuaChamCong);

		btnChamCong = new JButton("Chấm công");
		btnChamCong.setAutoscrolls(true);
		btnChamCong.setActionCommand("");
		btnChamCong.setBackground(new Color(255, 204, 204));
		btnChamCong.setIcon(new ImageIcon("HinhAnh\\Icon\\add32.png"));
		btnChamCong.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_1.add(btnChamCong);

	}

	private void thongTinPhongBanPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel pnPhongban = new JPanel();
		pnPhongban.setPreferredSize(new Dimension(200, 10));
		pnPhongban.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng ban", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		pnPhongban.setBackground(new Color(252, 222, 223));
		panel.add(pnPhongban);
		pnPhongban.setLayout(new GridLayout(2, 2, -200, 10));

		JLabel lblNewLabel_2 = new JLabel("Phòng:");
		lblNewLabel_2.setPreferredSize(new Dimension(10, 13));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pnPhongban.add(lblNewLabel_2);

		txtPhongban = new JTextField();
		txtPhongban.setEditable(false);
		pnPhongban.add(txtPhongban);
		txtPhongban.setColumns(10);
		txtPhongban.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblNewLabel_3 = new JLabel("Ngày công:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pnPhongban.add(lblNewLabel_3);

		txtNgayCong = new JTextField();
		txtNgayCong.setEditable(false);
		pnPhongban.add(txtNgayCong);
		txtNgayCong.setColumns(10);
		txtNgayCong.setFont(new Font("Times New Roman", Font.BOLD, 14));
	}

	private void thongTinNhanVienPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel panelThongTinNV = new JPanel();
		panelThongTinNV.setPreferredSize(new Dimension(180, 10));
		panelThongTinNV.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelThongTinNV.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelThongTinNV.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		panel.add(panelThongTinNV);
		panelThongTinNV.setLayout(new GridLayout(2, 2, 0, 10));
		panelThongTinNV.setBackground(new Color(252, 222, 223));

		lblTenNhanVien = new JLabel("Tên nhân viên:");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTenNhanVien.setPreferredSize(new Dimension(50, 20));
		panelThongTinNV.add(lblTenNhanVien);

		txtTenNVCM = new JTextField();
		txtTenNVCM.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panelThongTinNV.add(txtTenNVCM);
		txtTenNVCM.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Chức vụ:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panelThongTinNV.add(lblNewLabel_1);

		txtCVNV = new JTextField();
		txtCVNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCVNV.setColumns(10);
		panelThongTinNV.add(txtCVNV);
	}

	public void loadComboBox() {

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

	public void loadDatatoTable() {
		List<NhanVien> nhanViens = null;
		try {
			nhanViens = nhanVienService.getAllNhanVien();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nhanViens == null)
			nhanViens = new ArrayList<NhanVien>();

		tblModelChamCong = new DefaultTableModel(col, 0) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Boolean.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tableChamCong.setModel(tblModelChamCong);
		for (NhanVien item : nhanViens) {
			String chucvu = item.getChucVu();
			boolean trangThaiLamViec = false;
			boolean ditre = false;
			Object[] obj = { item.getMaNV(), item.getTenNV(), item.getNgayVaoLam(), chucvu, trangThaiLamViec, ditre };
			tblModelChamCong.addRow(obj);
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
		if (nhanViens == null)
			nhanViens = new ArrayList<NhanVien>();

		tblModelChamCong = new DefaultTableModel(col, 0) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Boolean.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tableChamCong.setModel(tblModelChamCong);
		for (NhanVien item : nhanViens) {
			String chucvu = item.getChucVu();
			boolean trangThaiLamViec = false;
			boolean ditre = false;
			Object[] obj = { item.getMaNV(), item.getTenNV(), item.getNgayVaoLam(), chucvu, trangThaiLamViec, ditre };
			tblModelChamCong.addRow(obj);
		}
	}


	public void loadBangChamCongDatatoTable(String mapb, int ngayCong, int thang, int nam) {
		List<BangChamCong> aBangChamCongs = null;
		try {
			aBangChamCongs = bangChamCongService.getListChamCong(ngayCong, thang, nam, Integer.parseInt(mapb));
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (aBangChamCongs == null)
			return;

		tblModelChamCong = new DefaultTableModel(colChamCong, 0) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Boolean.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		tableChamCong.setModel(tblModelChamCong);
		for (BangChamCong item : aBangChamCongs) {
			String chucvu = item.getNhanVien().getChucVu();
			Object[] obj = { item.getMaChamCong(), item.getNhanVien().getMaNV(), item.getNhanVien().getTenNV(),
					item.getNhanVien().getNgayVaoLam(), chucvu, item.isDiLam(), item.isDiTre() };
			tblModelChamCong.addRow(obj);
		}
	}

	public void loadDataToText(NhanVien nhanVien) {
		txtTenNVCM.setText(nhanVien.getTenNV() + "");
		txtCVNV.setText(nhanVien.getChucVu());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		txtPhongban.setText(cboPhongBan.getSelectedItem().toString());
	}

	public List<BangChamCong> createBangChamCong̣() {
		List<BangChamCong> bangChamCongs = new ArrayList<BangChamCong>();

		int row = tableChamCong.getRowCount();
		for (int i = 0; i < row; i++) {
			BangChamCong bangChamCong;
			int ngayCong = chooser.getDate().getDay();
			int thangCong = chooser.getDate().getMonth() + 1;
			int nam = chooser.getDate().getYear() + 1900;
			boolean diLam = (Boolean) tableChamCong.getValueAt(i, 4);
			boolean diTre = (Boolean) tableChamCong.getValueAt(i, 5);
			NhanVien nv = null;
			try {
				nv = nhanVienService.getNhanVienTheoMa(Integer.parseInt(tableChamCong.getValueAt(i, 0).toString()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bangChamCong = new BangChamCong(ngayCong, thangCong, nam, diLam, diTre, 1, nv);
			bangChamCongs.add(bangChamCong);
		}
		return bangChamCongs;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnChamCong)) {
			List<BangChamCong> bangChamCongs = createBangChamCong̣();
			if (txtNgayCong.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày để chấm công");
				return;
			}
			if (bangChamCongs == null) {
				JOptionPane.showMessageDialog(null, "Chấm công không thành công");
				return;
			}

			for (BangChamCong bangChamCong : bangChamCongs) {
				try {
					bangChamCongService.addBangChamCong(bangChamCong);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Chấm công thành công");
			int ngay = chooser.getDate().getDay();
			int thang = chooser.getDate().getMonth() + 1;
			int year = chooser.getDate().getYear() + 1900;
			PhongBan maPb = phongBanServic.getPhongBanByName(cboPhongBan.getSelectedItem().toString());
			loadBangChamCongDatatoTable(maPb.getMaPB() + "", ngay, thang, year);
		} else if (obj.equals(btnSuaChamCong)) {
			List<BangChamCong> bangChamCongs = createBangChamCong̣();

			if (bangChamCongs == null) {
				JOptionPane.showMessageDialog(null, "Sửa chấm công không thành công");
				return;
			}
			for (BangChamCong bangChamCong : bangChamCongs) {
				try {
					bangChamCongService.updateChamCong(bangChamCong);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Sửa chấm công thành công");
			cnkDiLam.setSelected(false);
		} else if (obj.equals(btnToday)) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
		int select = tableChamCong.getSelectedRow();
		if (select >= 0) {
			try {

				loadDataToText(nhanViens.get(select));

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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int row = tableChamCong.getRowCount();
		for (int i = 0; i < row; i++) {
			if (cnkDiLam.isSelected())
				tableChamCong.setValueAt(true, i, 4);
			else
				tableChamCong.setValueAt(false, i, 4);
		}

	}
}
