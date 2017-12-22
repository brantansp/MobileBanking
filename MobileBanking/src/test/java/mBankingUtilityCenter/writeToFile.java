package mBankingUtilityCenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//
public class writeToFile {
	public static String Transaction ;
	public static String dbResult ;
	public static String Txnauthid ;
	public static String Txntype ;
	public static String Txnstatus ;
	public static String Error_Type ;
	public static String Errorcode ;
	public static String Error_Msg ;
	public static String Responsecode ;
	public static String Response_Description ;
	public static String [] result ;
	
    public static void main(String[]args) throws IOException{}
    
    public static void reportGeneration(String transaction, String dbResult[]) throws FileNotFoundException
    {
    	Transaction = transaction;
    	result = dbResult;
    	File dir = new File(".\\reports");
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    		System.out.println("here");
    	}
    	String savestr = "Result.csv"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;//new PrintWriter(file);
    	StringBuilder sb = new StringBuilder();
    	if(file.exists() )
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
    	} else {
    		pw = new PrintWriter(file);
            sb.append("Transaction");
            sb.append(',');
            sb.append("Txnauthid");
            sb.append(',');
            sb.append("Txntype");
            sb.append(',');
            sb.append("Txnstatus");
            sb.append(',');
            sb.append("Error_Type");
            sb.append(',');
            sb.append("Errorcode");
            sb.append(',');
            sb.append("Error_Msg");
            sb.append(',');
            sb.append("Responsecode");
            sb.append(',');
            sb.append("Response_Description");
            sb.append('\n');
    	}
        sb.append(Transaction);
        sb.append(',');
        sb.append(result[0]);
        sb.append(',');
        sb.append(result[1]);
        sb.append(',');
        sb.append(result[2]);
        sb.append(',');
        sb.append(result[3]);
        sb.append(',');
        sb.append(result[4]);
        sb.append(',');
        sb.append(result[5]);
        sb.append(',');
        sb.append(result[6]);
        sb.append(',');
        sb.append(result[7]);
        sb.append(',');
        sb.append(result[8]);
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    
    }

}
