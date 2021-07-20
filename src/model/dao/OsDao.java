package model.dao;

import java.util.List;

import model.entities.OS;

public interface OsDao {
	void insert(OS os);
	void update(OS os);
	void deleteById(Integer id);
	OS findById(Integer id);
	List<OS> findAll();
	List<OS> findBySituation(OS os);
}
