package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.OsDao;
import model.entities.OS;

public class findCortesia {
	
	public static List<OS> list;
	
	public static void main(String[] args) {
		OsDao osDao = DaoFactory.createOs();
		
		OS Os = new OS(null,null,null,4);
		list = osDao.findBySituation(Os);
		System.out.println("===findBySituation===");
		for(OS os : list){
			System.out.println(os);
		}
		
		String str = "";
		String os = new String(str+list);
		
		String[] lines = os.split("],");
		
		String path = "OS/findCortesia.txt";
		
		File file = new File("OS/findCortesia.txt");
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
