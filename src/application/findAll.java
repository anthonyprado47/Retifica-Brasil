package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.OsDao;
import model.entities.OS;

public class findAll{
	
	public static List<OS> list;
	
	public static void main(String[] args) {
		OsDao osDao = DaoFactory.createOs();
		
		list = osDao.findAll();
		System.out.println("===findAll===");
		for(OS os : list){
			System.out.println(os);
		}

		String str = "";
		String Os = new String(str+list);
		
		String[] lines = Os.split("],");
		
		String path = "OS/findOS.txt";
		
		File file = new File("OS/findOS.txt");
		file.delete();
		
		try(FileWriter writer = new FileWriter(path, true);
				BufferedWriter bw = new BufferedWriter(writer)){
			for(String string : lines){
					bw.write(string);
			    	bw.newLine();
			    	bw.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}