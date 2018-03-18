package mBankingUtilityCenter;

import java.io.File;
import java.io.FileInputStream;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {

	static String path = System.getProperty("user.dir")+"\\testdata\\Data.xlsx";
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	HashMap< String, String > properties = new HashMap< String, String >();
	public static List<String> testRunFlag = new ArrayList<>();
	public static List<String> testsEnabled = new ArrayList<>();
 //public static Map<String,String> testDataInput = new HashMap<String,String>();
	//static Properties prop = new Properties();
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties props=setPropertyFromExcel("Data","InputData");
        log.info(props.getProperty("Test11"));
		/*for(Map.Entry m : setPropertyFromExcel("Data","InputData").entrySet())
		{  
			  System.out.println(m.getKey()+" "+m.getValue());  
			//  props.put(m.getKey(), m.getValue());
	    }  		*/
	}
	
	public static void  getRunFlagFromExcel(String workBook, String workSheet) {
		try {
			String path = System.getProperty("user.dir")+"\\testdata\\"+workBook+".xlsx";
			FileInputStream fis = new FileInputStream(new File(path));
			
/*			if (path.endsWith("xlsx"))
			{
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(workSheet);
			}else if (path.endsWith("xls")) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.getSheet(workSheet);
		    } else {
		        throw new IllegalArgumentException("The specified file is not Excel file");
		    }
*/			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(workSheet);
			
			int rowCount = sheet.getLastRowNum();
			//log.info(rowCount);
			int columnCount = sheet.getRow(0).getLastCellNum();
			//log.info(columnCount);
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=1; j <columnCount; j=j+2 ){
						try {
							String cellValue = "";
							String cellKey = "";
							try{
									cellKey = row.getCell(j).getStringCellValue();
									cellValue = row.getCell(j+1).getStringCellValue();
									testRunFlag.add(cellKey +" : "+cellValue);
									log.info(cellKey +" : "+cellValue);	
							}catch(NullPointerException e){
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}			
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Properties setPropertyFromExcel (String workBook, String workSheet) {
		Properties prop = new Properties();
		try {
			String path = System.getProperty("user.dir")+"\\testdata\\"+workBook+".xlsx";
			FileInputStream fis = new FileInputStream(new File(path));
					
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(workSheet);
			
			int rowCount = sheet.getLastRowNum();
			//log.info(rowCount);
			int columnCount = sheet.getRow(0).getLastCellNum();
			//log.info(columnCount);
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					DataFormatter dataFormatter = new DataFormatter();
					for(int j=1; j <columnCount; j=j+2){
						try {
							XSSFCell cellValue;
							XSSFCell cellKey;
							try{
									cellKey = row.getCell(j);
									cellValue = row.getCell(j+1);
									prop.put(dataFormatter.formatCellValue(cellKey), dataFormatter.formatCellValue(cellValue));
									//log.info(dataFormatter.formatCellValue(cellKey) +" : "+dataFormatter.formatCellValue(cellValue));	
							}catch(NullPointerException e){
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	  
	public static List<String> getEnabledTests(String workBook, String sheetName)
   	{
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\testdata\\"+workBook+".xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=1; j <columnCount; j=j+2){ // loop through the columns
						try {
							String cellValue = "";
							try{
								if(row.getCell(j+1).getStringCellValue().equals("N") || row.getCell(j+1).getStringCellValue().equals("n") || row.getCell(j+1).getStringCellValue().equals("no") || row.getCell(j+1).getStringCellValue().equals("No") || row.getCell(j+1).getStringCellValue().equals("NO"))
								{
									cellValue = row.getCell(j).getStringCellValue();
									testsEnabled.add(cellValue);
									//log.info(cellValue);	
								}
							}catch(NullPointerException e){
								e.printStackTrace();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testsEnabled;
	
   	}
  

	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}

