package poi;

import java.io.*;
import java.util.Arrays;

public class bands {
	
	public static String[] setband1() throws IOException{
		
		
		File band1file = new File ("band1.txt");
//		if (band1file.exists()) System.out.println("band 1 file exists");
		BufferedReader br = new BufferedReader(new FileReader(band1file));
		
		int counter1=0;
		String st1;
		while ((st1 = br.readLine()) !=null) counter1++;
		br.close();
		String[] band1 = new String[counter1];	
		counter1=0;
		BufferedReader br2 = new BufferedReader(new FileReader(band1file));
		while ((st1 = br2.readLine()) !=null) {band1[counter1]=st1; counter1++;}
		br2.close();
		Arrays.sort(band1, (a, b)->Integer.compare(a.length(), b.length()));
		return (band1);
	}
	
	
	
	
	
	public static String[] band1a() throws IOException{
		String[] allband1= bands.setband1();
		int countera=0;
		for (int i=0; i<allband1.length; i++){ if (!allband1[i].contains(" ")) countera++;}
		String[] band1a=new String[countera];
		countera=0;
		for (int i=0; i<allband1.length; i++){
			if (!allband1[i].contains(" ")) {band1a[countera]=allband1[i]; countera++;}
		}
		return band1a;
	}
	
	public static String[] band1b() throws IOException {
		String[] allband1 = bands.setband1();
		int[] spacescount = new int[allband1.length];
		
		for (int i=0; i<allband1.length; i++){
			int count = allband1[i].length() - allband1[i].replace(" ", "").length();
			spacescount[i] = count;
		}
		int counterb=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==1) counterb++;
		}
		String[] band1b = new String[counterb];
		counterb=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==1) {band1b[counterb]=allband1[i]; counterb++;}
		}
		
		return band1b;
	}
	
	public static String[] band1c() throws IOException {
		String[] allband1 = bands.setband1();
		int[] spacescount = new int[allband1.length];
		
		for (int i=0; i<allband1.length; i++){
			int count = allband1[i].length() - allband1[i].replace(" ", "").length();
			spacescount[i] = count;
		}
		int counterc=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==2) counterc++;
		}
		String[] band1c = new String[counterc];
		counterc=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==2) {band1c[counterc]=allband1[i]; counterc++;}
		}
		
		return band1c;
	}
	
//--------------------------------------------------------------------------------------------------------------
public static String[] setband2() throws IOException{
		
		
		File band2file = new File ("band2.txt");

		BufferedReader br = new BufferedReader(new FileReader(band2file));
		
		int counter1=0;
		String st1;
		while ((st1 = br.readLine()) !=null) counter1++;
		br.close();
		String[] band2 = new String[counter1];	
		counter1=0;
		BufferedReader br2 = new BufferedReader(new FileReader(band2file));
		while ((st1 = br2.readLine()) !=null) {band2[counter1]=st1; counter1++;}
		br2.close();
		Arrays.sort(band2, (a, b)->Integer.compare(a.length(), b.length()));
		return (band2);
	}
	
	
	
	
	
	public static String[] band2a() throws IOException{
		String[] allband2= bands.setband2();
		int countera=0;
		for (int i=0; i<allband2.length; i++){ if (!allband2[i].contains(" ")) countera++;}
		String[] band2a=new String[countera];
		countera=0;
		for (int i=0; i<allband2.length; i++){
			if (!allband2[i].contains(" ")) {band2a[countera]=allband2[i]; countera++;}
		}
		return band2a;
	}
	
	public static String[] band2b() throws IOException {
		String[] allband2 = bands.setband2();
		int[] spacescount = new int[allband2.length];
		
		for (int i=0; i<allband2.length; i++){
			int count = allband2[i].length() - allband2[i].replace(" ", "").length();
			spacescount[i] = count;
		}
		int counterb=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==1) counterb++;
		}
		String[] band2b = new String[counterb];
		counterb=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==1) {band2b[counterb]=allband2[i]; counterb++;}
		}
		
		return band2b;
	}
	
	public static String[] band2c() throws IOException {
		String[] allband2 = bands.setband2();
		int[] spacescount = new int[allband2.length];
		
		for (int i=0; i<allband2.length; i++){
			int count = allband2[i].length() - allband2[i].replace(" ", "").length();
			spacescount[i] = count;
		}
		int counterc=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==2) counterc++;
		}
		String[] band2c = new String[counterc];
		counterc=0;
		for (int i=0; i<spacescount.length; i++){
			if (spacescount[i]==2) {band2c[counterc]=allband2[i]; counterc++;}
		}
		
		return band2c;
	}

	
	//--------------------------------------------------------------------------------------------------------------
	public static String[] setband3() throws IOException{
			
			
			File band3file = new File ("band3.txt");

			BufferedReader br = new BufferedReader(new FileReader(band3file));
			
			int counter1=0;
			String st1;
			while ((st1 = br.readLine()) !=null) counter1++;
			br.close();
			String[] band3 = new String[counter1];	
			counter1=0;
			BufferedReader br2 = new BufferedReader(new FileReader(band3file));
			while ((st1 = br2.readLine()) !=null) {band3[counter1]=st1; counter1++;}
			br2.close();
			Arrays.sort(band3, (a, b)->Integer.compare(a.length(), b.length()));
			return (band3);
		}
		
		
		
		
		
		public static String[] band3a() throws IOException{
			String[] allband3= bands.setband3();
			int countera=0;
			for (int i=0; i<allband3.length; i++){ if (!allband3[i].contains(" ")) countera++;}
			String[] band3a=new String[countera];
			countera=0;
			for (int i=0; i<allband3.length; i++){
				if (!allband3[i].contains(" ")) {band3a[countera]=allband3[i]; countera++;}
			}
			return band3a;
		}
		
		public static String[] band3b() throws IOException {
			String[] allband3 = bands.setband3();
			int[] spacescount = new int[allband3.length];
			
			for (int i=0; i<allband3.length; i++){
				int count = allband3[i].length() - allband3[i].replace(" ", "").length();
				spacescount[i] = count;
			}
			int counterb=0;
			for (int i=0; i<spacescount.length; i++){
				if (spacescount[i]==1) counterb++;
			}
			String[] band3b = new String[counterb];
			counterb=0;
			for (int i=0; i<spacescount.length; i++){
				if (spacescount[i]==1) {band3b[counterb]=allband3[i]; counterb++;}
			}
			
			return band3b;
		}
		
		public static String[] band3c() throws IOException {
			String[] allband3 = bands.setband3();
			int[] spacescount = new int[allband3.length];
			
			for (int i=0; i<allband3.length; i++){
				int count = allband3[i].length() - allband3[i].replace(" ", "").length();
				spacescount[i] = count;
			}
			int counterc=0;
			for (int i=0; i<spacescount.length; i++){
				if (spacescount[i]==2) counterc++;
			}
			String[] band3c = new String[counterc];
			counterc=0;
			for (int i=0; i<spacescount.length; i++){
				if (spacescount[i]==2) {band3c[counterc]=allband3[i]; counterc++;}
			}
			
			return band3c;
		}
}
