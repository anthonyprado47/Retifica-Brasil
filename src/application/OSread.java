package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OSread{
	
	public static String id(String[] OsId){
		String path = "OS/OS.txt";
		try{
		FileReader fr = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			OsId = line.split("_");
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
		return OsId[0];
	}
	public static String name(String[] OsName){
		String path = "OS/OS.txt";
		try{
		FileReader fr = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			OsName = line.split("_");
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
		return OsName[1];
	}
	public static String status(String[] OsStatus){
		String path = "OS/OS.txt";
		try{
		FileReader fr = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			OsStatus = line.split("_");
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
		return OsStatus[3];
	}
	public static String description(String[] OsDescription){
		String path = "OS/OS.txt";
		try{
		FileReader fr = new FileReader(path);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			OsDescription = line.split("_");
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
		return OsDescription[2];
	}
}  
