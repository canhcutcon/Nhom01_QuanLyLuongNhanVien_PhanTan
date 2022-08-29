package app;

import UI.FrmDangNhap;
import UI.FrmLoading;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		try {
			FrmLoading formLoading = new FrmLoading();
			formLoading.setVisible(true);
			formLoading.setLocationRelativeTo(null);
			for (int i = 0; i < 50; i++) {
				Thread.sleep(20);
				formLoading.progressBar.setValue(i*2);
			}
			formLoading.setVisible(false);
			FrmDangNhap frmLogin = new FrmDangNhap();
			frmLogin.setVisible(true);
			frmLogin.setLocationRelativeTo(null);			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
