package mBankingUtilityCenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.Date;

public class Dir {

	public static void main(String[] args) throws FileNotFoundException {
		writeFile();
	}
	
	public static void writeFile() throws FileNotFoundException{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy"); 
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HHmmss"); 
		Date date = new Date();  
		System.out.println(dateFormatter.format(date));  
		System.out.println(timeFormatter.format(date));  
    	File dir = new File(System.getProperty("user.dir")+"/test-output/ExtentReport/"+dateFormatter.format(date));
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    	}
    	String savestr = "ExtentReport-"+timeFormatter.format(date)+".html"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;
    	if(file.exists())
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
    	}else
    	{
    		pw = new PrintWriter(file);
    	}
    	
    	/*
	    String fileName =  datestamp + ".txt";

	    File directory = new File(directoryName);
	    if (! directory.exists()){
	        directory.mkdir();
	        // If you require it to make the entire directory path including parents,
	        // use directory.mkdirs(); here instead.
	    }

	    File file = new File(directoryName + "/" + fileName);
	    try{
	        FileWriter fw = new FileWriter(file.getAbsoluteFile());
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(value);
	        bw.close();
	    }
	    catch (IOException e){
	        e.printStackTrace();
	        System.exit(-1);
	    }*/
	}
	
}
