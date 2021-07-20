package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.OsDao;
import model.entities.OS;

public class OsDaoJDBC implements OsDao{
	
	private Connection conn = null;
	
	public OsDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	public void insert(OS os) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement("INSERT INTO os "
					+ "(OsId,OsName,OsDescription,OsSituation) "
					+ "VALUES "
					+ "(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setInt(1, os.getOsId());
			st.setString(2, os.getOsName());
			st.setString(3, os.getOsDescription());
			st.setInt(4, os.getOsSituation());
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0){
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()){
					int id = rs.getInt(1);
					os.setOsId(id);
				}
				DB.closeResultSet(rs);
			}else{
				throw new DbException("Unexpected error! No rows affected!");
			}
			
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
		}
	}

	public void update(OS os) {
	
	}

	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM retificabrasil1.os "
					+ "WHERE OsId = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	public OS findById(Integer id){
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = conn.prepareStatement("SELECT * FROM os "
					+ "WHERE OsSituation = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()){
				OS os = new OS();
				os.setOsId(rs.getInt("OsId"));
				os.setOsName(rs.getString("OsName"));
				os.setOsDescription(rs.getString("OsDescription"));
				os.setOsSituation(rs.getInt("OsSituation"));
				return os;
			}
			return null;
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public List<OS> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = conn.prepareStatement("SELECT * FROM retificabrasil1.os;");
			
			rs = st.executeQuery();
			
			List<OS> list = new ArrayList<>();
			
			while(rs.next()){
				OS obj = instantiateOs(rs);
				list.add(obj);
			}
			return list;
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public List<OS> findBySituation(OS os) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = conn.prepareStatement("SELECT * FROM retificabrasil1.os "
					+ "WHERE OsSituation = ?");
			st.setInt(1, os.getOsSituation());
			rs = st.executeQuery();
			
			List<OS> list = new ArrayList<>();
			
			while(rs.next()){
				OS obj = instantiateOs(rs);
				list.add(obj);
			}
			return list;
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private OS instantiateOs(ResultSet rs) throws SQLException {
		OS Os = new OS();
		Os.setOsId(rs.getInt("OsId"));
		Os.setOsName(rs.getString("OsName"));
		Os.setOsDescription(rs.getString("OsDescription"));
		Os.setOsSituation(rs.getInt("OsSituation"));
		return Os;
	}
}