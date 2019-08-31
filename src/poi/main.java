package poi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class main {


public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {
	
	jframe.homepage();
	
	
	

}


public static void paintfile() throws InvalidFormatException{
	
	String filetopaint = jframe.filetopaint;
	jframe.monitor.setText("גרסה מסומנת בדרך");
	
	
	
try {
		
		
		
		String[] band1a =(bands.band1a());
		String[] band1b =(bands.band1b());
		String[] band1c =(bands.band1c());
		String[] band2a =(bands.band2a());
		String[] band2b =(bands.band2b());
		String[] band2c =(bands.band2c());
		String[] band3a =(bands.band3a());
		String[] band3b =(bands.band3b());
		String[] band3c =(bands.band3c());
		String easy="44B7E5"; String medium = "9CD549"; String hard="C10D0D";


XWPFDocument doc = new XWPFDocument(OPCPackage.open(filetopaint));
		   
	for (XWPFParagraph p : doc.getParagraphs()) {	//PARAGRAPH
	  int irun =p.getRuns().size();				//irun:NUMBER OF RUNS IN PARAGRAPH
	  if (irun!=0){
		  
		  //CHECKING LENGTH OF 2D i AND DEFINING 2D ARRAY WITH IT.
		  int xicounter=0;
		  for (int i=0; i<irun; i++){
			 XWPFRun r = p.getRuns().get(i); String t = r.getText(0); 
			 if (t!=null) {
				 String[] a={" "};  if (t.contains(" ")) {a=t.split("\\s+");} else {a[0]=t;}
				 xicounter = xicounter + a.length;
			 }
			 }
		  String[][] a2 = new String[xicounter][4];
		
		  	
		int icounter=0;
		for (int i=0; i<irun; i++){				//FOR EVERY RUN
			
			XWPFRun r = p.getRuns().get(i); 
			
			String t = r.getText(0);				//t:TEXT OF RUN
			
			if (t!=null) {						//t:TEXT , a:ARRAY OF STRINGS
				String[] a={" "};  if (t.contains(" ")) {a=t.split("\\s+");} else {a[0]=t;}
				if (a.length>0){						//a READY FOR CHECK

					for (int k=0; k<a.length; k++){	//CHECKING THE ARRAY TEXT
						a2[k+icounter][0]=(a[k]+" ");
						//DEFINE BOLD OF WORD
						if (r.isBold()==true) a2[k+icounter][2]="true"; else a2[k+icounter][2]="false";		
		
						
						//DEFINE COLOR OF WORD----------------------------------------------
						
//EASY 1 --------------------------------------------------------------------------------------------------------
						
						for (int j =0; j<band1a.length; j++){
							if (a[k].equalsIgnoreCase(band1a[j])) {
								a2[k+icounter][1]=easy;
								break;
							} else {
									if(a2[k+icounter][1]==null) {a2[k+icounter][1]=("000000");}
							}
						}
						
//EASY 2 --------------------------------------------------------------------------------------------------------
						for (int j =0; j<band1b.length; j++){
							
						if (k<(a.length-1)) {
							String duals = a[k]+" "+a[k+1];
							if (duals.equalsIgnoreCase(band1b[j])) {
								a2[k+icounter][1]=easy; a2[k+icounter+1][1]=easy;
								break;
							} 
						}
						}
						
//EASY 3 --------------------------------------------------------------------------------------------------------
						for (int j =0; j<band1c.length; j++){
							if (k<(a.length-2)) {
							String triples = a[k]+" "+a[k+1]+" "+a[k+2];
							if (triples.equalsIgnoreCase(band1c[j])) {
								a2[k+icounter][1]=easy; a2[k+icounter+1][1]=easy;  a2[k+icounter+2][1]=easy;
								break;
							} 
						}
						}
						
//MEDIUM 1 ------------------------------------------------------------------------------------------------------
						for (int j =0; j<band2a.length; j++){
							if (a[k].equalsIgnoreCase(band2a[j])) {
								a2[k+icounter][1]=medium;
								break;
							} 
						}
//MEDIUM 2 ------------------------------------------------------------------------------------------------------
						for (int j =0; j<band2b.length; j++){
							
							if (k<(a.length-1)) {
								String duals = a[k]+" "+a[k+1];
								if (duals.equalsIgnoreCase(band2b[j])) {
									a2[k+icounter][1]=medium; a2[k+icounter+1][1]=medium;
									break;
								} 
						}
						}
//MEDIUM 3 ------------------------------------------------------------------------------------------------------
						for (int j =0; j<band2c.length; j++){
							if (k<(a.length-2)) {
							String triples = a[k]+" "+a[k+1]+" "+a[k+2];
							if (triples.equalsIgnoreCase(band2c[j])) {
								a2[k+icounter][1]=medium; a2[k+icounter+1][1]=medium;  a2[k+icounter+2][1]=medium;
								break;
							} 
						}
						}
//HARD 1 --------------------------------------------------------------------------------------------------------
						for (int j =0; j<band3a.length; j++){
							if (a[k].equalsIgnoreCase(band3a[j])) {
								a2[k+icounter][1]=hard;
								break;
							} 
						}
//HARD 2 --------------------------------------------------------------------------------------------------------
						for (int j =0; j<band3b.length; j++){
							
							if (k<(a.length-1)) {
								String duals = a[k]+" "+a[k+1];
								if (duals.equalsIgnoreCase(band3b[j])) {
									a2[k+icounter][1]=hard; a2[k+icounter+1][1]=hard;
									break;
								} 
						}
						}
//HARD 3 --------------------------------------------------------------------------------------------------------
						for (int j =0; j<band3c.length; j++){
							if (k<(a.length-2)) {
							String triples = a[k]+" "+a[k+1]+" "+a[k+2];
							if (triples.equalsIgnoreCase(band3c[j])) {
								a2[k+icounter][1]=hard; a2[k+icounter+1][1]=hard;  a2[k+icounter+2][1]=hard;
								break;
							} 
						}
						}
//------------------------------------------------------------------------------------------------------------

						//DEFINE ITALIC
						if (r.isItalic()==true) a2[k+icounter][3]="true"; else a2[k+icounter][3]="false";		
						
						
						
					}
					icounter=icounter+a.length;
				}
			}
		}
		//PARAGRAPH ENDED
		//System.out.println(Arrays.deepToString(a2));
		
		//REMOVE ALL EXISTING RUNS
		int runnums = p.getRuns().size();
			while (runnums>0) {
			p.removeRun(0);
			runnums = p.getRuns().size();	
		}
			
		
		//ADD RUNS OF COLORED TEXT
		for (int i=0; i<a2.length; i++){
			if (a2[i][0].equals(" ")) System.out.println("null"+i); else {
			XWPFRun r =p.createRun();
			r.setFontSize(12);
			r.setColor(a2[i][1]);
			if (a2[i][2].equals("true")) r.setBold(true); else r.setBold(false);
			if (a2[i][3].equals("true")) r.setItalic(true); else r.setItalic(false);
			r.setText(a2[i][0]);
			//System.out.println (a2[i][0]);
			}
		}
		
		
	  }
	 
	} 
	
    doc.write(new FileOutputStream("toerase.docx"));
    doc.close();
    jframe.monitor.setText("הקובץ החדש מוכן");

    
    //--------------UPDATING THE LIST OF FILES----------------------    
    files.getdirectory();
	 jframe.lister2=files.fif;
		jframe.listmodel2.clear();
		for (int i=0; i<jframe.lister2.length; i++){
			jframe.listmodel2.add(i,jframe.lister2[i]);
		}
		jframe.flist.setModel(jframe.listmodel2);
   //---------------------------------------------------------------
    
} catch (IOException e) {
e.printStackTrace();		    
	}            
		
}



}  
		    

	
