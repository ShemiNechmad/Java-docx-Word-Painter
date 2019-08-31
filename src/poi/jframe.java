package poi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class jframe {
	
	
	
	 
	 static JFrame jhome = new JFrame("WoMLA");
	 static JTextField monitor = new JTextField("(: שלום");
	 static JTextField adder = new JTextField("");
	 static String filetopaint="";
	 static JButton band1 = new JButton ("Band 1");
	 static JButton band2 = new JButton ("Band 2");
	 static JButton band3 = new JButton ("Band 3");
	 static JButton erase = new JButton ("מחקי"); 
	 static JButton opendocx = new JButton ("פתחי קובץ"); 
	 static  JButton add = new JButton ("הוסיפי"); 
	 static String[] lister={""};
	 static String[] lister2={""};
	 static JPanel p = new JPanel();
	 static JList list = new JList(lister);
	 static JList flist = new JList(lister2);
	 static DefaultListModel listmodel = new DefaultListModel();
	 static DefaultListModel listmodel2 = new DefaultListModel();
	 static int index;
	 static String[] tester = {"1","2"};
	 static String item="";
	 static int bandPresented=1;
	 static String bandfile="band1.txt";
	 static String[] afc = new String[0];
	 
	 
	 
	 public static void opendocx(){
		 if (flist.getSelectedValue()==null) return;
		 files.filetoopen = "marked\\"+flist.getSelectedValue().toString();
		 files.opendocx();
	 }
	
	 
	 
	 
	 
	 
	 public static void band1(){
		 monitor.setText("Band1 מציג רשימת");
		 lister=files.b1l;
		 listmodel.clear();
		 for (int i=0; i<lister.length; i++){
				listmodel.add(i,lister[i]);
			}
			 list.setModel(listmodel);
		band1.setBackground(Color.cyan);
		band2.setBackground(null);
		band3.setBackground(null);
		bandPresented=1;
		bandfile="band1.txt"; 
		
		
	 }
	 public static void band2(){
		 monitor.setText("Band2 מציג רשימת");
		lister=files.b2l;
		listmodel.clear();
		for (int i=0; i<lister.length; i++){
			listmodel.add(i,lister[i]);
		}
		 list.setModel(listmodel);
		 band1.setBackground(null);
		 band2.setBackground(Color.cyan);
		 band3.setBackground(null);
		 bandPresented=2;
		 bandfile="band2.txt"; 
		
	 }
	 public static void band3(){
		 monitor.setText("Band3 מציג רשימת");
		 lister=files.b3l;
		 listmodel.clear();
		 for (int i=0; i<lister.length; i++){
				listmodel.add(i,lister[i]);
			}
			 list.setModel(listmodel);
			 band1.setBackground(null);
			 band2.setBackground(null);
			 band3.setBackground(Color.cyan);
			 bandPresented=3;
			 bandfile="band3.txt"; 
		
	 }
	 
//-------------------------------ADD TO LIST BUTTON FUNCTION-----------------------------------------------------------------
	 
	 
	 public static void add() throws IOException{
		 item = adder.getText();
		 if (item.length()==0) return; if (item.equals(" ")) return;
		 int count = item.length() - item.replace(" ", "").length();
		 if (count>2){monitor.setText("עד 3 מלים בלבד"); return;}
		 
		 String spacer = item.substring(item.length() - 1); 
		 if (spacer.equals(" ")) item = item.substring(0, item.length() - 1);
		 String spacer2 = item.substring(item.length() - 1); 
		 if (spacer2.equals(" ")) item = item.substring(0, item.length() - 1);
		 Character spacer3 = item.charAt(0); 
		 if (spacer3 ==(' ')) item = item.substring(1);
		 Character spacer4 = item.charAt(0); 
		 if (spacer4.equals(' ')) item = item.substring(1);
		 
		 
		 if (bandPresented==1){ 
			 afc = new String[files.b1l.length+1];
			 for (int i=0; i<files.b1l.length; i++){
				 afc[i]=files.b1l[i];
			 }
			 afc[afc.length-1]=item;
			 files.b1l = new String[files.b1l.length+1];
			 files.b1l=afc;
			 jframe.band1();
			 monitor.setText("Band1 מלה נוספה ל");
			 bandfile="band1.txt"; 
		 }
		 if (bandPresented==2){ 
			 afc = new String[files.b2l.length+1];
			 for (int i=0; i<files.b2l.length; i++){
				 afc[i]=files.b2l[i];
			 }
			 afc[afc.length-1]=item;
			 files.b2l = new String[files.b2l.length+1];
			 files.b2l=afc;
			 jframe.band2();
			 monitor.setText("Band2 מלה נוספה ל");
			 bandfile="band2.txt"; 
		 }
		 if (bandPresented==3){ 
			 afc = new String[files.b3l.length+1];
			 for (int i=0; i<files.b3l.length; i++){
				 afc[i]=files.b3l[i];
			 }
			 afc[afc.length-1]=item;
			 files.b3l = new String[files.b3l.length+1];
			 files.b3l=afc;
			 jframe.band3();
			 monitor.setText("Band3 מלה נוספה ל");
			 bandfile="band3.txt"; 
		 }
		 File file = new File(bandfile);
		 FileWriter fr = new FileWriter(file, true);
		 fr.write((System.getProperty( "line.separator" )));
		 fr.write(item);
		 fr.close();
		 
		 
		 adder.setText("");
		 
	 }
	 
	 
	 //---------------ERASE BUTTON------------------------------------------------------------------------------------

	 public static void erase() throws IOException{
		 if (list.getSelectedValue()==null) return;
		 String fordel = list.getSelectedValue().toString();
		 
		 if (bandPresented==1){ 
			 String[] del = new String[files.b1l.length-1];
			 int j=0;
			 for (int i =0; i<files.b1l.length; i++){
				 if (!fordel.equals(files.b1l[i])){
					 del[j]=files.b1l[i];
					 j++;
				 }
			 }
			 files.b1l=del;
			 jframe.band1();
			 monitor.setText("Band1 מלה נמחקה מ");
			 
			 File file = new File("band1.txt");
			 FileWriter fr = new FileWriter(file, false);
			 for (int k = 0; k<files.b1l.length; k++){
				 fr.write(files.b1l[k]);
				if(k<files.b1l.length-1) fr.write((System.getProperty( "line.separator" )));
			 }

			 fr.close();
			 
		 }
		 if (bandPresented==2){ 
			 String[] del = new String[files.b2l.length-1];
			 int j=0;
			 for (int i =0; i<files.b2l.length; i++){
				 if (!fordel.equals(files.b2l[i])){
					 del[j]=files.b2l[i];
					 j++;
				 }
			 }
			 files.b2l=del;
			 jframe.band2();
			 monitor.setText("Band2 מלה נמחקה מ");
			 
			 
			 File file = new File("band2.txt");
			 FileWriter fr = new FileWriter(file, false);
			 for (int k = 0; k<files.b2l.length; k++){
				 fr.write(files.b2l[k]);
				if(k<files.b2l.length-1) fr.write((System.getProperty( "line.separator" )));
			 }

			 fr.close();
			 
			 
		 }
		 if (bandPresented==3){ 
			 String[] del = new String[files.b3l.length-1];
			 int j=0;
			 for (int i =0; i<files.b3l.length; i++){
				 if (!fordel.equals(files.b3l[i])){
					 del[j]=files.b3l[i];
					 j++;
				 }
			 }
			 files.b3l=del;
			 jframe.band3();
			 monitor.setText("Band3 מלה נמחקה מ");
			 
			 
			 File file = new File("band3.txt");
			 FileWriter fr = new FileWriter(file, false);
			 for (int k = 0; k<files.b3l.length; k++){
				 fr.write(files.b3l[k]);
				if(k<files.b3l.length-1) fr.write((System.getProperty( "line.separator" )));
			 }

			 fr.close();
			 
		 }
		 
		 
		 
	 }
	 
	
	 
	 
	 //---------------PICK A FILE BUTTON-----------------------------------------------------------------------------
	
	public static void pickfile() throws InvalidFormatException, IOException{
		final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = fc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			String extension = "";
			int i = path.lastIndexOf('.');
			if (i > 0) {
			    extension = path.substring(i+1);
			}
		
			if (!extension.equals("docx")) monitor.setText("docx אנא בחרו קובץ");
			else {
				monitor.setText("הקובץ בבדיקה");
				File file = new File(path);
				String name = file.getName();
				monitor.setText(name);
				File target = new File ("Marked\\Marked-"+name);
				if (target.exists()) target.delete();
				try {
				Files.copy(file.toPath(), target.toPath());
				filetopaint = "Marked\\Marked-"+name;
				main.paintfile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
			
		}

	}
	
	
	
	
	
	
	
	
	
	
	public static void homepage() throws InterruptedException{
		
		
		jhome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; int width = 550; int height=450; int north = ((screenWidth - width)/2); int east = ((screenHeight - height)/2); jhome.setLocation(north, east);
		jhome.setSize(550,450);
			
		p.setLayout(null);
			
		//TITLE
		JLabel title1 = new JLabel("Word Match, Liora & Avishag");
		title1.setBounds(160,10,200,15);
		p.add(title1);
		
		
		//LABEL 1
		JLabel lt = new JLabel("רשימת קבצים מוכנים");
		lt.setBounds(400,100,100,15);
		p.add(lt);
		
		
		//PICK FILE BUTTON
		JButton pickfile = new JButton("בחרי קובץ לצביעה");
		pickfile.setBounds(350, 45, 150, 30);
		pickfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {try {
				jframe.pickfile();
			} catch (InvalidFormatException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	}}); 
	    p.add(pickfile);

		
	    //MONITOR
	    Font f = new Font("Arial",Font.BOLD,15);
	    //JTextField monitor = new JTextField("(: שלום");
	    monitor.setFont(f);
	    monitor.setHorizontalAlignment(SwingConstants.RIGHT);
	    monitor.setEditable(false); //monitor.setSelectedTextColor("44B7E5");
	    monitor.setBounds(350,380,180,25);
	    p.add(monitor);
	    
	    
	    //BAND1 BUTTON
	    
	   
	    band1.setBounds(30, 45, 75, 30);
		band1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {jframe.band1();	}}); 
	    p.add(band1);
	    band1.setBackground(Color.cyan);
		band2.setBackground(null);
		band3.setBackground(null);
	    
	    
	  //BAND2 BUTTON
	    
	   
	    band2.setBounds(105, 45, 75, 30);
		band2.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {jframe.band2();	}}); 
	    p.add(band2);
	    
	    
	  //BAND3 BUTTON
	    
	   
	    band3.setBounds(180, 45, 75, 30);
		band3.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {jframe.band3();	}}); 
	    p.add(band3);
	    
	    
	    
	  //ADD TO LIST BUTTON
	    add.setBounds(140,380,105,25);
		add.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {try {
			jframe.add();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}}); 
	    p.add(add);
	    
	    
	    
	    //ERASE FROM LIST BUTTON
	    erase.setBounds(245,380,105,25);
	    erase.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {try {
			jframe.erase();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}}); 
	    p.add(erase);
	    
	    
	    
	
	    
	    
	    
	  //FILES LIST
	    files.getdirectory();
	    lister2=files.fif;
	    flist = new JList(lister2);
	    JScrollPane s2 = new JScrollPane(flist);
	    s2.setBounds(350,120,150,210);
	    s2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p.add(s2);
		
		
		
		
		
		//OPEN DOCX BUTTON
	    opendocx.setBounds(350,330,150,20);
	    opendocx.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {jframe.opendocx();	}}); 
	    p.add(opendocx);
	    
	    
	    
	    //ADD TO LIST TEXTBOX
	    adder.setFont(f);
	    adder.setBounds(20,380,120,25);
	    p.add(adder);
	    
	    
	    

		//GET ALL LISTS
		files.getbands();
		lister=files.b1l;
		list = new JList(lister);
		JScrollPane s = new JScrollPane(list);
		s.setBounds(30,75,225,280);
	    s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p.add(s);
		
		
		
		  
		  
		  
	    
	    jhome.add(p); 
		jhome.setVisible(true);
		
	}

}
