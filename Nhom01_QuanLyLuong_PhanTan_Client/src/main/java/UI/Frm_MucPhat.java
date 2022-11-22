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
import java.util.List;
import java.util.Vector;

import javax.persistence.Convert;
import javax.persistence.Converter;
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
import dao.PhongBanDao;
import entity.LoaiPhat;
import entity.PhongBan;

public class Frm_MucPhat extends JInternalFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtThue;
	private JTextField txtSoNgayLam;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txt_TenMucPhat;
	private JTextField txt_TienPhat;
	private JTable tbl_MucPhat;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_MucPhat frame = new Frm_MucPhat();
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
	public Frm_MucPhat() throws RemoteException {
		setBackground(Color.WHITE);
		initGUI();
		setUI();
	}
	private void initGUI() {
		
		setBounds(100, 100, 1013, 533);
		setFocusCycleRoot(true);
		setFocusable(true);
		setFocusCycleRoot(true);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
	}
	DefaultTableModel modelMucPhat;
	String[] colHeader = { "Mã mức phạt", "Tên mức phạt","Tiền phạt"};
	int idSelected=-1;
	private void setUI() throws RemoteException {
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(252, 222, 223));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pnl_Input = new JPanel();
		pnl_Input.setBounds(10, 66, 980, 157);
		pnl_Input.setBackground(new Color(252, 222, 223));
		panel.add(pnl_Input);
		pnl_Input.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("Tên mức phạt");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(10, 23, 151, 23);
		pnl_Input.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tiền phạt");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(10, 57, 151, 23);
		pnl_Input.add(lblNewLabel_4_2_1);
		
		JButton btnXoa = new JButton("Xoá mức phạt");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmDel = JOptionPane.showConfirmDialog(null, "U want delete ???", "!!!",
						JOptionPane.YES_NO_OPTION);
				if (confirmDel == 0) {
					LoaiPhatDao loaiPhatDao = getLoaiPhat();
					boolean isDelete = false;
					try {
						LoaiPhat lp = new LoaiPhat();
						lp.setMaLoaiPhat(idSelected);
						lp.setTrangThai(0);
						isDelete = loaiPhatDao.deleteMucPhat(lp);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (isDelete) {
						JOptionPane.showMessageDialog(null, "Success ^^");
						try {
							getDataForTable(tbl_MucPhat, modelMucPhat);
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
		btnXoa.setBounds(734, 92, 230, 33);
		pnl_Input.add(btnXoa);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Sua = new JButton("Sửa mức phạt");
		btn_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int n = JOptionPane.showConfirmDialog(null, "Thêm", "Thông báo", JOptionPane.YES_NO_OPTION);
				LoaiPhat loaiPhat = new LoaiPhat(idSelected,txt_TenMucPhat.getText(), Double.parseDouble(txt_TienPhat.getText()) , 1);
				LoaiPhatDao loaiPhatDao = getLoaiPhat();
				try {
					loaiPhatDao.updateMucPhat(loaiPhat);
					getDataForTable(tbl_MucPhat, modelMucPhat);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_Sua.setBounds(455, 92, 230, 33);
		pnl_Input.add(btn_Sua);
		btn_Sua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btn_Them = new JButton("Thêm mức phạt");
		btn_Them.setBounds(171, 92, 230, 33);
		pnl_Input.add(btn_Them);
		btn_Them.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_TenMucPhat = new JTextField();
		txt_TenMucPhat.setBounds(170, 23, 794, 23);
		pnl_Input.add(txt_TenMucPhat);
		txt_TenMucPhat.setColumns(10);
		
		txt_TienPhat = new JTextField();
		txt_TienPhat.setColumns(10);
		txt_TienPhat.setBounds(171, 57, 793, 23);
		pnl_Input.add(txt_TienPhat);
		btn_Them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int n = JOptionPane.showConfirmDialog(null, "Thêm", "Thông báo", JOptionPane.YES_NO_OPTION);
				LoaiPhat loaiPhat = new LoaiPhat(txt_TenMucPhat.getText(), Double.parseDouble(txt_TienPhat.getText()) , 1);
				LoaiPhatDao loaiPhatDao = getLoaiPhat();
				try {
					loaiPhatDao.createMucPhat(loaiPhat);
					getDataForTable(tbl_MucPhat, modelMucPhat);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("Quản lý mức phạt");
		lblNewLabel_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4_2_1_1.setBounds(382, 11, 221, 44);
		panel.add(lblNewLabel_4_2_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 223, 980, 269);
	

		modelMucPhat = new DefaultTableModel(colHeader, 0);
		panel_3.setLayout(null);
		tbl_MucPhat = new JTable(modelMucPhat);
		JScrollPane scrollPane = new JScrollPane(tbl_MucPhat);
		scrollPane.setBounds(0, 0, 980, 269);
		panel_3.add(scrollPane);
			getDataForTable(tbl_MucPhat, modelMucPhat);
			tbl_MucPhat.addMouseListener(new MouseListener() {

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
						int index = tbl_MucPhat.getSelectedRow();
						txt_TenMucPhat.setText((String) (modelMucPhat.getValueAt(index, 1)));
						txt_TienPhat.setText((String) (modelMucPhat.getValueAt(index, 2)));
						String cc = tbl_MucPhat.getModel().getValueAt(index, 0).toString();
						idSelected = Integer.parseInt(cc);
					}
				}
			});
		panel.add(panel_3);
		
		
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
	public void getDataForTable(JTable table, DefaultTableModel model) throws RemoteException {
		clearModel(model);
		LoaiPhatDao loaiPhatDao = getLoaiPhat();
		List<LoaiPhat> loaiPhats = loaiPhatDao.getListMucPhat();
		for (LoaiPhat lp : loaiPhats) {
			Vector vector = new Vector();
			vector.add(lp.getMaLoaiPhat() + "");
			vector.add(lp.getTenLoai());
			vector.add(lp.getTienPhat()+"");
			model.addRow(vector);
			tbl_MucPhat.setModel(model);
			Frm_MucPhat.setCellsAlignment(tbl_MucPhat, SwingConstants.CENTER);
		}
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

}
