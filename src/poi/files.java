package poi;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class files {
	
	static String[] b1l = new String[0];
	static String[] b2l = new String[0];
	static String[] b3l = new String[0];
	static String[] fif = new String[0];
	static String filetoopen = "";
	
	
	public static void getdirectory(){
		int counter = 0;
		
		File folder = new File("Marked");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  counter++;
		  } 
		}
		fif = new String[counter];
		counter=0;
		for (int i = 0; i <listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
			fif[counter] = listOfFiles[i].getName();
			counter++;
			  }
		}
	}
	
	
	public static void getbands(){
		
		String line=null; int counter1=0; int counter2=0; int counter3=0;
		
		try {
			FileReader fr1 = new FileReader("band1.txt");
			BufferedReader bf1 = new BufferedReader(fr1);
			while((line = bf1.readLine()) != null) {counter1++;} 
			bf1.close();
			
			FileReader fr1b = new FileReader("band1.txt");
			BufferedReader bf1b = new BufferedReader(fr1b);
			b1l = new String[counter1];
			int i=0;
			while((line = bf1b.readLine()) != null) {b1l[i]=line; i++;}
			bf1b.close();
			
			
			
			FileReader fr2 = new FileReader("band2.txt");
			BufferedReader bf2 = new BufferedReader(fr2);
			while((line = bf2.readLine()) != null) {counter2++;}
			bf2.close();
			
			FileReader fr2b = new FileReader("band2.txt");
			BufferedReader bf2b = new BufferedReader(fr2b);
			b2l = new String[counter2];
			i=0;
			while((line = bf2b.readLine()) != null) {b2l[i]=line; i++;}
			bf2b.close();
			
			
			FileReader fr3 = new FileReader("band3.txt");
			BufferedReader bf3 = new BufferedReader(fr3);
			while((line = bf3.readLine()) != null) {counter3++;}
			bf3.close();
			
			
			FileReader fr3b = new FileReader("band3.txt");
			BufferedReader bf3b = new BufferedReader(fr3b);
			b3l = new String[counter3];
			i=0;
			while((line = bf3b.readLine()) != null) {b3l[i]=line; i++;}
			bf3b.close();
			
			
		}catch (IOException e1) {e1.printStackTrace();}
	}
	
	
	public static void opendocx(){
		 Desktop desktop = Desktop.getDesktop();  
	     try {
	       File f = new File(filetoopen);
	        desktop.open(f);
	     }
	     catch(Exception ex) {}
		
	}

}
