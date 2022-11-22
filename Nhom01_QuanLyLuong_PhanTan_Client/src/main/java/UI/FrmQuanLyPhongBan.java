package UI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.PhongBanDao;
import entity.PhongBan;
import java.awt.Color;
import javax.swing.UIManager;

public class FrmQuanLyPhongBan extends JInternalFrame {

	public static void main(String[] args) throws RemoteException {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "policy\\policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		FrmQuanLyPhongBan frm = new FrmQuanLyPhongBan();
		frm.setVisible(true);
	}

	JTable tblPhongBan;
	DefaultTableModel modelPhongBan;
	String[] colHeader = { "Mã phòng ban", "Tên phòng ban" };

	public FrmQuanLyPhongBan() throws RemoteException {
		setBackground(new Color(255, 192, 203));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(10, 0, 776, 41);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHÒNG BAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 192, 203));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 51, 483, 272);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng ban:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 68, 135, 33);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên phòng ban:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 169, 135, 33);
		panel_1.add(lblNewLabel_1_1);

		txtMaPhongBan = new JTextField();
		txtMaPhongBan.setEnabled(false);
		txtMaPhongBan.setBounds(168, 74, 254, 25);
		panel_1.add(txtMaPhongBan);
		txtMaPhongBan.setColumns(10);

		txtTenPB = new JTextField();
		txtTenPB.setEnabled(false);
		txtTenPB.setColumns(10);
		txtTenPB.setBounds(168, 173, 254, 25);
		panel_1.add(txtTenPB);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(505, 51, 281, 272);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnThem.getText().trim().equals("Thêm")) {
					txtTenPB.setText("");
					txtTenPB.setEnabled(true);
					btnThem.setText("Lưu");
				} else {
					PhongBanDao phongBanDao = getPhongBanDao();
					if (checkEmpty(txtTenPB.getText().trim())) {
						JOptionPane.showMessageDialog(null, "Không để trống dữ liệu");
					} else {
						PhongBan pb = new PhongBan();
						pb.setTenPB(txtTenPB.getText());
						pb.setTrangThai(1);
						boolean isCreated = false;
						try {
							isCreated = phongBanDao.createPhongBan(pb);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (isCreated) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại");
						}
						txtTenPB.setText(null);
						txtTenPB.setEnabled(false);
						btnThem.setText("Thêm");
					}

				}

			}
		});
		btnThem.setBounds(94, 40, 100, 35);
		panel_2.add(btnThem);

		JButton btnDel = new JButton("Xóa");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmDel = JOptionPane.showConfirmDialog(null, "U want update ???", "!!!",
						JOptionPane.YES_NO_OPTION);
				if (confirmDel == 0) {
					PhongBanDao phongBanDao = getPhongBanDao();
					boolean isDelete = false;
					try {
						PhongBan pb = new PhongBan();
						pb.setMaPB(Integer.parseInt(txtMaPhongBan.getText().trim()));
						pb.setTenPB(txtTenPB.getText());
						isDelete = phongBanDao.deletePhongBan(pb);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (isDelete) {
						JOptionPane.showMessageDialog(null, "Success ^^");
						try {
							getDataForTable(tblPhongBan, modelPhongBan);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Delete fail");
					}
				}

			}
		});
		btnDel.setBounds(94, 192, 100, 35);
		panel_2.add(btnDel);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnUpdate.getText().equals("Sửa")) {
					btnUpdate.setText("Lưu");
					txtTenPB.setEnabled(true);
				} else {
					if (checkEmpty(txtTenPB.getText())) {
						JOptionPane.showMessageDialog(null, "Không để trống dữ liệu");
					} else {
						PhongBanDao phongBanDao = getPhongBanDao();
						PhongBan pb = new PhongBan();
						pb.setMaPB(Integer.parseInt(txtMaPhongBan.getText().trim()));
						pb.setTenPB(txtTenPB.getText());
						pb.setTrangThai(1);
						int quesUpdate = JOptionPane.showConfirmDialog(null, "Bạn muốn thay đổi thông tin phòng ban",
								"???", JOptionPane.YES_NO_OPTION);
						if (quesUpdate == 0) {
							boolean isUpdate = false;
							try {
								isUpdate = phongBanDao.updatePhongBan(pb);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if (isUpdate) {
								JOptionPane.showMessageDialog(null, "update oke <3<3");
								try {
									getDataForTable(tblPhongBan, modelPhongBan);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else {
								JOptionPane.showMessageDialog(null, "có gì đ sai sai", "Update Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						btnUpdate.setText("Lưu");
						txtTenPB.setEnabled(false);
					}

				}

			}
		});
		btnUpdate.setBounds(94, 116, 100, 35);
		panel_2.add(btnUpdate);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 333, 776, 220);
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		modelPhongBan = new DefaultTableModel(colHeader, 0);
		tblPhongBan = new JTable(modelPhongBan);
		panel_3.add(new JScrollPane(tblPhongBan));
		getDataForTable(tblPhongBan, modelPhongBan);
		tblPhongBan.addMouseListener(new MouseListener() {

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
					int index = tblPhongBan.getSelectedRow();
					txtMaPhongBan.setText((String) (modelPhongBan.getValueAt(index, 0)));
					txtTenPB.setText((String) (modelPhongBan.getValueAt(index, 1)));
					
				}
			}
		});

	}

	public void getDataForTable(JTable table, DefaultTableModel model) throws RemoteException {
		clearModel(model);
		PhongBanDao phongBanDao = getPhongBanDao();
		List<PhongBan> phongBans = phongBanDao.getListPhongBan();
		for (PhongBan pb : phongBans) {
			Vector vector = new Vector();
			vector.add(pb.getMaPB() + "");
			vector.add(pb.getTenPB());
			model.addRow(vector);
			tblPhongBan.setModel(model);
			FrmQuanLyPhongBan.setCellsAlignment(tblPhongBan, SwingConstants.CENTER);
		}
	}

	public PhongBanDao getPhongBanDao() {
		try {
			return (PhongBanDao) Naming.lookup("rmi://localhost:8988/phongBanDao");
		} catch (MalformedURLException | RemoteException | NotBoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public boolean checkEmpty(String tenPhongBan) {
		if (tenPhongBan.length() == 0)
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhongBan;
	private JTextField txtTenPB;
}
