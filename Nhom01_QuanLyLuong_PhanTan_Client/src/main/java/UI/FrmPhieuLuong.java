package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;

import entity.BangLuongNhanVien;

public class FrmPhieuLuong extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnCanCel;
	JLabel lblThang;
	JLabel lblNam;
	JLabel lblMaNV;
	JLabel lblTen;
	JLabel lblLuongCoBan;
	JLabel lblPhuCap;
	JLabel lblTongLuong;
	JLabel lblNguoiNhan;
	JLabel lblTenNguoiTao;
	JLabel lblThucNhan;
	JLabel lblKhongDiLam;
	JLabel lblPhatDiTre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					FrmPhieuLuong frame = new FrmPhieuLuong();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPhieuLuong(BangLuongNhanVien bangLuongNhanVien, double tongLuong, double thucNhan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		
		JPanel pnlPhieuLuongNhanVien = new JPanel();
		contentPane.add(pnlPhieuLuongNhanVien, BorderLayout.CENTER);
		pnlPhieuLuongNhanVien.setLayout(null);
		
		btnCanCel = new JButton("");
		btnCanCel.setIcon(new ImageIcon("HinhAnh\\Icon\\btnExitLogin.png"));
		btnCanCel.setBounds(485, 10, 63, 54);
		pnlPhieuLuongNhanVien.add(btnCanCel);
		
		JLabel lblNewLabel = new JLabel("Công ty TNHH GBS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setBounds(10, 10, 180, 39);
		pnlPhieuLuongNhanVien.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PHIẾU LƯƠNG");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1.setBounds(180, 59, 186, 74);
		pnlPhieuLuongNhanVien.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tháng:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(44, 131, 93, 24);
		pnlPhieuLuongNhanVien.add(lblNewLabel_2);
		
		lblThang = new JLabel("New label");
		lblThang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThang.setBounds(175, 131, 93, 24);
		lblThang.setText(bangLuongNhanVien.getThangLuong()+"");
		pnlPhieuLuongNhanVien.add(lblThang);
		
		JLabel lblNewLabel_2_1 = new JLabel("Năm:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(219, 131, 93, 24);
		pnlPhieuLuongNhanVien.add(lblNewLabel_2_1);
		
		lblNam = new JLabel("New label");
		lblNam.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNam.setBounds(310, 131, 93, 24);
		lblNam.setText(bangLuongNhanVien.getNam()+"");
		pnlPhieuLuongNhanVien.add(lblNam);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(44, 177, 134, 24);
		pnlPhieuLuongNhanVien.add(lblNewLabel_2_2);
		
		lblMaNV = new JLabel("New label");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaNV.setBounds(175, 177, 93, 24);
		lblMaNV.setText(bangLuongNhanVien.getNhanVien().getMaNV()+"");
		pnlPhieuLuongNhanVien.add(lblMaNV);
		
		JLabel lblNewLabel_2_3 = new JLabel("Họ tên:");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(219, 177, 93, 24);
		pnlPhieuLuongNhanVien.add(lblNewLabel_2_3);
		
		lblTen = new JLabel("New label");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(310, 177, 205, 24);
		lblTen.setText(bangLuongNhanVien.getNhanVien().getTenNV());
		pnlPhieuLuongNhanVien.add(lblTen);
		
		JPanel panel = new JPanel();
		panel.setBounds(44, 222, 471, 139);
		pnlPhieuLuongNhanVien.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("1.Lương -Phụ cấp");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(175, 238, 238));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Nội dung");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBackground(new Color(255, 235, 205));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Đơn giá");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBackground(new Color(255, 235, 205));
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Đơn giá");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBackground(new Color(255, 235, 205));
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Lương cơ bản");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_8);
		
		lblLuongCoBan = new JLabel("New label");
		lblLuongCoBan.setText(bangLuongNhanVien.getLuongCoBan()+"");
		lblLuongCoBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLuongCoBan.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblLuongCoBan);
		
		JLabel lblNewLabel_10 = new JLabel("VNĐ");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9 = new JLabel("Phụ cấp");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_9);
		
		lblPhuCap = new JLabel("New label");
		lblPhuCap.setText(bangLuongNhanVien.getPhuCap()+"");
		lblPhuCap.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhuCap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhuCap.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblPhuCap);
		
		JLabel lblNewLabel_12 = new JLabel("VNĐ");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_12.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1.add(lblNewLabel_12);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Tổng lương:");
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_3.add(lblNewLabel_4);
		
		
		lblTongLuong = new JLabel("New label");
		lblTongLuong.setText(tongLuong+"");
		lblTongLuong.setForeground(new Color(220, 20, 60));
		lblTongLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTongLuong.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_3.add(lblTongLuong);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(44, 371, 471, 139);
		pnlPhieuLuongNhanVien.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3_1 = new JLabel("2. Phạt");
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3_1.setBackground(new Color(175, 238, 238));
		panel_2.add(lblNewLabel_3_1, BorderLayout.NORTH);
		
		JPanel panel_1_1 = new JPanel();
		panel_2.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel_5_1 = new JLabel("Nội dung");
		lblNewLabel_5_1.setOpaque(true);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		lblNewLabel_5_1.setBackground(new Color(255, 235, 205));
		panel_1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Đơn giá");
		lblNewLabel_7_1.setOpaque(true);
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		lblNewLabel_7_1.setBackground(new Color(255, 235, 205));
		panel_1_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Đơn giá");
		lblNewLabel_6_1.setOpaque(true);
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		lblNewLabel_6_1.setBackground(new Color(255, 235, 205));
		panel_1_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Đi làm trễ");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblNewLabel_8_1);
		
		lblPhatDiTre = new JLabel("New label");
		lblPhatDiTre.setText(""+bangLuongNhanVien.getTienPhat());
		lblPhatDiTre.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhatDiTre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhatDiTre.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblPhatDiTre);
		
		JLabel lblNewLabel_10_1 = new JLabel("VNĐ");
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_10_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Nghỉ không phép");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_9_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblNewLabel_9_1);
		
		lblKhongDiLam = new JLabel("New label");
		lblKhongDiLam.setText("0");
		lblKhongDiLam.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhongDiLam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblKhongDiLam.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblKhongDiLam);
		
		JLabel lblNewLabel_12_1 = new JLabel("VNĐ");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_12_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_1_1.add(lblNewLabel_12_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_2.add(panel_3_1, BorderLayout.SOUTH);
		panel_3_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_4_1 = new JLabel("Thực nhận:");
		lblNewLabel_4_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4_1.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_3_1.add(lblNewLabel_4_1);
		
		lblThucNhan = new JLabel("");
		lblThucNhan.setText(thucNhan+"");
		lblThucNhan.setForeground(new Color(220, 20, 60));
		lblThucNhan.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThucNhan.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_3_1.add(lblThucNhan);
		
		JLabel lblNewLabel_11 = new JLabel("Người tạo");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(44, 520, 106, 44);
		pnlPhieuLuongNhanVien.add(lblNewLabel_11);
		
		lblTenNguoiTao = new JLabel("New label");
		lblTenNguoiTao.setText("Giang Võ");
		lblTenNguoiTao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNguoiTao.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenNguoiTao.setBounds(54, 558, 83, 30);
		pnlPhieuLuongNhanVien.add(lblTenNguoiTao);
		
		JLabel lblNewLabel_11_1 = new JLabel("Người nhận");
		lblNewLabel_11_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11_1.setBounds(363, 520, 106, 44);
		pnlPhieuLuongNhanVien.add(lblNewLabel_11_1);
		
		lblNguoiNhan = new JLabel("New label");
		lblNguoiNhan.setText(bangLuongNhanVien.getNhanVien().getTenNV());
		lblNguoiNhan.setHorizontalAlignment(SwingConstants.CENTER);
		lblNguoiNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNguoiNhan.setBounds(363, 558, 125, 30);
		pnlPhieuLuongNhanVien.add(lblNguoiNhan);
		btnCanCel.addActionListener(this);
	}
	public void close() {
		WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnCanCel))
		{
			close();
		}
	}

}
