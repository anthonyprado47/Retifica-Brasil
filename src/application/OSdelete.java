package application;

import model.dao.DaoFactory;
import model.dao.OsDao;

public class OSdelete {
	public static void main(String[] args) {
		OsDao osDao = DaoFactory.createOs();
		
		String OsDel = deleteOS.OsDelT.getText();
		Integer os = Integer.parseInt(OsDel);
		osDao.deleteById(os);
		System.out.println("===deleteById===\n"+os);
	}
}
