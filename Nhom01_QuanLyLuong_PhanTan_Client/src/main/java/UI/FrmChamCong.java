package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.ScrollPane;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.UtilCalendarModel;
import org.jdatepicker.impl.UtilDateModel;

import com.toedter.calendar.JDateChooser;




public class FrmChamCong extends JInternalFrame {
	private JTextField txtTenNVCM, txtCVNV,txtPhongban,txtNgayCong;
	private JCheckBox cnkDiLam;
	private JButton btnSuaChamCong,btnLuuCC,btnToday;
	private JLabel lblTenNhanVien;
	private JTable tableChamCong;
	private DefaultTableModel tblModelChamCong;

	String[] col = { "Mã nhân viên", "Tên nhân viên", "Trạng thái" };
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
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
	}

	private void bangChamCongPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel panelBangChamCong = new JPanel();
		panelBangChamCong.setBackground(new Color(252, 222, 223));
		getContentPane().add(panelBangChamCong, BorderLayout.CENTER);
		panelBangChamCong.setLayout(new BoxLayout(panelBangChamCong, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("BẢNG CHẤM CÔNG NHÂN VIÊN");
//		lblNewLabel.setBounds(new Rectangle(0, 0, 900, 0));
		lblNewLabel.setPreferredSize(new Dimension(1000, 50));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(135, 206, 250));
		panelBangChamCong.add(lblNewLabel);
		
		ScrollPane scrollPane = new ScrollPane();
		panelBangChamCong.add(scrollPane);
		tblModelChamCong =  new DefaultTableModel(col,0);
		tableChamCong = new JTable(tblModelChamCong);
		scrollPane.add(tableChamCong);
	}

	private void timeLinePanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel panelTimeLine = new JPanel();
		panelTimeLine.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelTimeLine.setBackground(new Color(252, 222, 223));
		getContentPane().add(panelTimeLine, BorderLayout.WEST);
		panelTimeLine.setLayout(new BoxLayout(panelTimeLine, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(180);
		panelTimeLine.add(verticalStrut_1);
		
		Label label = new Label("NGÀY CÔNG");
		label.setBackground(new Color(135, 206, 250));
		label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		label.setForeground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		panelTimeLine.add(label);
		
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new java.awt.BorderLayout(0, 0));
		panelTimeLine.add(datePanel);
		
		UtilDateModel dateModel = new UtilDateModel();
		JDateChooser chooser = new JDateChooser();
		datePanel.add(chooser);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//		txtNgayCong.setText(sdf.format(date));
		
		btnToday = new JButton("Today");
		btnToday.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		btnToday.setBounds(new Rectangle(0, 0, 50, 0));
		btnToday.setBackground(new Color(135, 206, 250));
		btnToday.setHorizontalTextPosition(SwingConstants.CENTER);
		btnToday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panelTimeLine.add(btnToday);
		
		Component verticalStrut = Box.createVerticalStrut(200);
		panelTimeLine.add(verticalStrut);
	}

	private void thongTinChamCongPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel pnChamCong = new JPanel();
		pnChamCong.setBorder(new TitledBorder(null, "Ch\u1EA5m c\u00F4ng", TitledBorder.LEADING, 
				TitledBorder.TOP, null, new Color(220, 20, 60)));
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
		
		btnLuuCC = new JButton("Lưu chấm công");
		btnLuuCC.setBackground(new Color(255, 204, 204));
		btnLuuCC.setIcon(new ImageIcon("HinhAnh\\Icon\\floppy-disk.png"));
		btnLuuCC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_1.add(btnLuuCC);
		
	}

	private void thongTinPhongBanPanelMethod(JPanel panel) {
		// TODO Auto-generated method stub
		JPanel pnPhongban = new JPanel();
		pnPhongban.setPreferredSize(new Dimension(200, 10));
		pnPhongban.setBorder(new TitledBorder(null, "Th\u00F4ng tin ph\u00F2ng ban",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
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
		panelThongTinNV.setBorder(new TitledBorder(null, "Th\u00F4ng tin nh\u00E2n vi\u00EAn", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
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
	
	


}
