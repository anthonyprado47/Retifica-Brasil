package model.dao;

import db.DB;
import model.dao.impl.OsDaoJDBC;

public class DaoFactory {
	public static OsDao createOs(){
		return new OsDaoJDBC(DB.getConnection());
	}
}
