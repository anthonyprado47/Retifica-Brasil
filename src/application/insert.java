package application;

import model.dao.DaoFactory;
import model.dao.OsDao;
import model.entities.OS;

public class insert{
	
	public static void main(String[] args){
		OsDao osDao = DaoFactory.createOs();
		
		@SuppressWarnings("deprecation")
		Integer OsId = new Integer(OSread.id(args));
		String OsName = OSread.name(args);
		String OsDescription = OSread.description(args);
		@SuppressWarnings("deprecation")
		Integer OsSituation = new Integer(OSread.status(args));
		
		System.out.println("===insert===");
		OS os = new OS(OsId,OsName,OsDescription,OsSituation);
		osDao.insert(os);
		System.out.println(os);
	}
}
