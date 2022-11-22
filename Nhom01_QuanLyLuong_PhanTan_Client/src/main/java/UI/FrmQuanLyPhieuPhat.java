package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.LoaiPhatDao;
import dao.NhanVienDao;
import dao.PhieuPhatDao;
import entity.LoaiPhat;
import entity.NhanVien;
import entity.PhieuPhat;

import javax.swing.ImageIcon;


public class FrmQuanLyPhieuPhat extends JInternalFrame {

	private JPanel contentPane;
	private JTable tbl_BangLuong;
//	private FrmQuanLyPhieuPhat frmQuanLyPhieuPhat;
//	private Frm_MucPhat frm_MucPhat;
	DefaultTableModel modelPhieuPhat;
	String[] colHeader = { "Mã phiếu phạt","Ngày phạt", "Nhân viên","Lí do"};
	JComboBox cbb_MaMucPhat;
	JComboBox cbb_MaNhanVien;
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
	 * @throws RemoteException 
	 */
	public FrmQuanLyPhieuPhat() throws RemoteException {
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

	private void setUI() throws RemoteException {
	
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
		
		cbb_MaMucPhat = new JComboBox();
		cbb_MaMucPhat.setBounds(171, 25, 1085, 22);
		pnl_Input.add(cbb_MaMucPhat);
		
	    cbb_MaNhanVien = new JComboBox();
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
	
		JButton btn_Them = new JButton("Thêm phiếu");
		btn_Them.setSelectedIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\add32.png"));
		btn_Them.setIcon(new ImageIcon("D:\\JavaPhanTan\\Nhom01_QuanLyLuongNhanVien_PhanTan\\Nhom01_QuanLyLuong_PhanTan_Client\\HinhAnh\\Icon\\add32.png"));
		btn_Them.setBounds(171, 92, 230, 48);
		pnl_Input.add(btn_Them);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
//				String temp_mp = cbb_MaMucPhat.getSelectedItem().toString();
//
//				int idMp = Character.getNumericValue(temp_mp.charAt(0));
//				String temp_nv = cbb_MaNhanVien.getSelectedItem().toString();
//
//				int idNv = Character.getNumericValue(temp_nv.charAt(0));
//				PhieuPhat phieuPhat = new PhieuPhat(idNv  );
//				 PhieuPhat( NhanVien maNV, LocalDate ngayPhat, int trangThai, LoaiPhat loaiPhat) {
//				LoaiPhatDao loaiPhatDao = getLoaiPhat();
//				try {
//					loaiPhatDao.createMucPhat(loaiPhat);
//					getDataForTable(tbl_MucPhat, modelMucPhat);
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Quản lý phiếu phạt");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(508, 11, 221, 44);
		panel.add(lblNewLabel_4_2_1_1);


		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 241, 980, 251);
	

		modelPhieuPhat = new DefaultTableModel(colHeader, 0);
		panel_3.setLayout(null);
		tbl_BangLuong = new JTable(modelPhieuPhat);
		JScrollPane scrollPane = new JScrollPane(tbl_BangLuong);
		scrollPane.setBounds(0, 11, 980, 229);
		panel_3.add(scrollPane);
			getDataForTable(tbl_BangLuong, modelPhieuPhat);
			tbl_BangLuong.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					{
						int index = tbl_BangLuong.getSelectedRow();
//						
					}
				}
			});
		panel.add(panel_3);
		
		
	}
	public PhieuPhatDao getPhieuPhat() {
		try {
			return (PhieuPhatDao) Naming.lookup("rmi://localhost:8988/phieuPhatDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	public LoaiPhatDao getLoaiPhat() {
		try {
			return (LoaiPhatDao) Naming.lookup("rmi://localhost:8988/loaiPhatDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
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
	public void getDataForTable(JTable table, DefaultTableModel model) throws RemoteException {
		clearModel(model);
		PhieuPhatDao phieuPhatDao = getPhieuPhat();
		
		List<PhieuPhat> phieuPhats = phieuPhatDao.getListPhieuPhat();
		for (PhieuPhat pp : phieuPhats) {
			Vector vector = new Vector();
			vector.add(pp.getMaPhieuPhat() + "");
			vector.add(pp.getNgayPhat());
			vector.add(pp.getMaNV().getTenNV()+"");
			vector.add(pp.getLoaiPhat().getTenLoai()+"");
			model.addRow(vector);
			tbl_BangLuong.setModel(model);
			Frm_MucPhat.setCellsAlignment(tbl_BangLuong, SwingConstants.CENTER);
		}
		LoaiPhatDao loaiPhatDao = getLoaiPhat();
		List<LoaiPhat> loaiPhats = loaiPhatDao.getListMucPhat();
		for (LoaiPhat loai  : loaiPhats) {
			String x = loai.getMaLoaiPhat()+". "+loai.getTenLoai();
			cbb_MaMucPhat.addItem(x);
			}
		NhanVienDao nhanVienDao = getNhanVienDao();
		List<NhanVien> nhanViens = nhanVienDao.getListNhanVien();
		for (NhanVien nv  : nhanViens) {
			String x = nv.getMaNV()+". "+nv.getTenNV();
			cbb_MaNhanVien.addItem(x);
			}
		
	}


	public boolean checkEmpty(String tenNhanvien) {
		if (tenNhanvien.length() == 0)
			return true;
		else
			return false;
	}
	
	public void clearModel(DefaultTableModel model) {
		while(model.getRowCount() > 0)
		{
			model.removeRow(0);
		}
	}

	public static void setCellsAlignment(JTable table, int alignment) {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(alignment);

		TableModel tableModel = table.getModel();

		for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
			table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
		}
	}
}
