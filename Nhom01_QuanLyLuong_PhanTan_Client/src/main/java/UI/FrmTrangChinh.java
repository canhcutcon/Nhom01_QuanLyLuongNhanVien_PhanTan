package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class FrmTrangChinh {
	/**
	 * Launch the application. Tên: Võ Thị Trà Giang Ngày tạo: 21/08/2022
	 */
	public JFrame frmCngTyGsb;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenu mnHeThong,mntimKiem, mnDanhMuc,mnXuLy, mnCapNhat;
	private JMenuItem mnItem_HT_DangNhap, mnItem_HT_DangXuat,
						mnItem_TK_NhanVien, mnItem_TK_PhongBan,
						mnItem_XL_TinhLuong, mnItem_XL_ChamCong,
						mnItem_CN_LuongNV, mnItem_CN_MucPhat, mnItem_CN_ChucVu, mnItem_CN_BangChamCong,
						mnItem_DM_NhanVien, mnItem_DM_PhongBan, mnItem_DM_PhieuPhat;

	private FrmTrangChu frmTrangChu;
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTrangChinh window = new FrmTrangChinh();
					window.frmCngTyGsb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmTrangChinh() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCngTyGsb = new JFrame();
		frmCngTyGsb.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmCngTyGsb.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmCngTyGsb.setResizable(false);
		frmCngTyGsb.setBounds(0, 0, 1550, 850);
		frmCngTyGsb.setType(Type.POPUP);
		frmCngTyGsb.setTitle("Công ty GSB");
		frmCngTyGsb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCngTyGsb.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		frmCngTyGsb.setBackground(new Color(255, 192, 203));
		frmCngTyGsb.setFocusCycleRoot(true);
		frmCngTyGsb.setFocusableWindowState(false);
		frmCngTyGsb.setUndecorated(false);

		// === set Main Panel =================================
		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1550, 850);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		frmCngTyGsb.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// // =====================
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1550, 850);
		desktopPane.setLayout(null);
		contentPane.add(desktopPane);

		// === interframe
		initInternalFrame();
//		Menu 
		initMenuItem();
		
	}

	private void initInternalFrame() {
//		========================== Frm Trang Chu ======================
		frmTrangChu = new FrmTrangChu();
		frmTrangChu.setBounds(0, 0, 1530, 800);
		frmTrangChu.setBorder(new EmptyBorder(0, 0, 0, 0));
		desktopPane.add(frmTrangChu);
		frmTrangChu.setVisible(true);
		
	}

	private void initMenuItem() {
		// ==============================Menu======================--
		JPanel pMenu = new JPanel();
		contentPane.add(pMenu,BorderLayout.NORTH);
		pMenu.setLayout(new CardLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("window"));
		pMenu.add(menuBar, "name_417659960722100");
		 
//		======== Hệ thống ==============================
		mnHeThong = createJMenu("Hệ Thống", "HinhAnh\\Icon\\MenuHeThong.png");
		menuBar.add(mnHeThong);
		
//		== menu item ==
		mnItem_HT_DangNhap = createJMenuItem("Đăng Nhập","HinhAnh/Icon/private.png");
		mnHeThong.add(mnItem_HT_DangNhap);
		
		mnItem_HT_DangXuat = createJMenuItem("Đăng Xuất","HinhAnh/Icon/log-out.png");
		mnHeThong.add(mnItem_HT_DangXuat);
		
		
		
//		====== Danh mục 
		mnDanhMuc = createJMenu("Danh Mục", "HinhAnh/Icon/private.png");
		menuBar.add(mnDanhMuc);
		
//		== menu item ==
		
		mnItem_DM_NhanVien = createJMenuItem("Nhân Viên", "HinhAnh/Icon/private.png");
		mnDanhMuc.add(mnItem_DM_NhanVien);
		
		mnItem_DM_PhongBan = createJMenuItem("Phòng Ban", "HinhAnh/Icon/private.png");
		mnDanhMuc.add(mnItem_DM_PhongBan);
		
		mnItem_DM_PhieuPhat = createJMenuItem("Phiếu phạt", "HinhAnh/Icon/private.png");
		mnDanhMuc.add(mnItem_DM_PhieuPhat);
		
		//======== Cập nhật
		mnCapNhat = createJMenu("Cập Nhật","HinhAnh/Icon/private.png");
		menuBar.add(mnCapNhat);
		
		//== menu item
		
		mnItem_CN_LuongNV = createJMenuItem("Lương Nhân Viên", "HinhAnh/Icon/private.png");
		mnCapNhat.add(mnItem_CN_LuongNV);
		
		mnItem_CN_MucPhat = createJMenuItem("Mức Phạt", "HinhAnh/Icon/private.png");
		mnCapNhat.add(mnItem_CN_MucPhat);
		
		mnItem_CN_ChucVu = createJMenuItem("Chức Vụ", "HinhAnh/Icon/private.png");
		mnCapNhat.add(mnItem_CN_ChucVu);
		
		mnItem_CN_BangChamCong = createJMenuItem("Bảng Chấm Công", "HinhAnh/Icon/private.png");
		mnCapNhat.add(mnItem_CN_BangChamCong);
		
//		========= Xử lý ====	
		mnXuLy = createJMenu("Xử Lý", "HinhAnh/Icon/private.png");
		menuBar.add(mnXuLy);
		
		mnItem_XL_TinhLuong = createJMenuItem("Tính Lương", "HinhAnh/Icon/private.png");
		mnXuLy.add(mnItem_XL_TinhLuong);
		
		mnItem_XL_ChamCong = createJMenuItem("Chấm Công", "HinhAnh/Icon/private.png");
		mnXuLy.add(mnItem_XL_ChamCong);
		
//		=========== Tìm kiếm ============
		mntimKiem = createJMenu("Tìm Kiếm", "HinhAnh/Icon/private.png");
		menuBar.add(mntimKiem);

		mnItem_TK_NhanVien = createJMenuItem("Nhân Viên", "HinhAnh/Icon/private.png");
		mntimKiem.add(mnItem_TK_NhanVien);
		
		mnItem_TK_PhongBan = createJMenuItem("Phòng Ban", "HinhAnh/Icon/private.png");
		mntimKiem.add(mnItem_TK_PhongBan);
		
	}
	
	private JMenu createJMenu(String name, String image) {
		JMenu mnTemp = new JMenu(name);
		mnTemp.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnTemp.setIcon(new ImageIcon(image));
		return mnTemp;
	}
	
	private JMenuItem createJMenuItem(String name, String image) {
		JMenuItem mnItem = new JMenuItem(name);
		mnItem.setBackground(new Color(135, 206, 250));
		mnItem.setIcon(new ImageIcon(image));
		return mnItem;
	};
	
	private void anTatCa() {
		frmTrangChu.setVisible(false);
	}
}
