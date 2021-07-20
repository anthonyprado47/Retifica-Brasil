package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OSwrite {
	public static void main(String[] args){
		String OsId = makeOS.OsT.getText();
		String OsName = makeOS.nameT.getText();
		String OsDescription = makeOS.descT.getText();
		String OsSituation = makeOS.OsStatus;
		
		BufferedWriter bw = null;
		
		String Os = new String(OsId+"_"+OsName+"_"+OsDescription+"_"+OsSituation+"-");
		
		String[] lines = Os.split("-");
		
		String path = "OS/OS.txt";
		
		File file = new File("OS/OS.txt");
		file.delete();
		
		try {
			bw = new BufferedWriter(new FileWriter(path, true));
			
			for(String string : lines){
			      bw.write(string);
			      bw.newLine();
			      bw.flush();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			if(bw != null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
