package mBankingUtilityCenter;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
/**
 * 
 * @author brantansp
 *
 */
public class ExtentManager{
	
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	public static String response="";
	public static String transactionID = "";
	static HttpConnect obj=new HttpConnect();
	private static String dbResult[];
	public static WebDriver driver;
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	public static Properties prop=getProperty();
	static String reportPath;
	private static Connection dbConnection = null;
	private static Statement statement = null;
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd"); 
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HHmmss"); 
	Date date = new Date();  
	static int TestCaseNum =1;
	public String TCID;
	
	@BeforeSuite
	public void setUp()throws FileNotFoundException, SQLException{
      	    log.info("Running Mobile banking API Automation testing on mPAY 4.0"+"\r\n"); 
        	File dir = new File(System.getProperty("user.dir")+"\\output\\ExtentReport\\"+dateFormatter.format(date));
        	if (!dir.exists())
        	{
        		dir.mkdirs();
        	}
        	reportPath= dir+"\\ExtentReport_"+timeFormatter.format(date)+".html";
			extent = new ExtentReports (reportPath, true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			prop =getProperty();
			
			String selectTableSQL = "select modulus from registration where regmobileno = '+91"+ prop.getProperty("RemMobileno")+"'";
			dbConnection = dbTransactionlog.getDBConnection(prop.getProperty("DB_USER") , prop.getProperty("DB_PASSWORD"));
			statement = dbConnection.createStatement();
			ResultSet resultSet= statement.executeQuery(selectTableSQL);
			resultSet.next();
			String modulus = resultSet.getString("MODULUS");
			prop.setProperty("mPIN", RsaEncryption.encrypt(prop.getProperty("mPINPlain"), modulus));
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		extentLogger = extent.startTest(this.getClass().getSimpleName()+ " ::  " +method.getName(), method.getName()); 
		extentLogger.assignAuthor("Brantan sp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log( LogStatus.PASS, "Test started successfully");
    	TCID = "TC_"+this.getClass().getSimpleName()+"_"+TestCaseNum;
/*		try {
			ExcelWriter.writeTestCaseID(TestCaseNum , TCID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result){

		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
	try {
			ExcelWriter.writeTestResult(TestCaseNum , result.getStatus());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.endTest(extentLogger);
		
	}
	
	@AfterSuite
	public void endReport(){
		 extent.flush();
		/* 
                extent.flush();
                Scanner sc = new Scanner (System.in);
                boolean loop = true;
                while (loop)
                {
                     System.out.println("Please enter y to Launch report and n to cancel");
                     String flag = sc.nextLine();
                     switch (flag)
                        {
                            case "y":
                            log.info("Launching report");
                            loop = false;
            	            launchReport();
                            break;
                            case "n":
                            log.info("Launching report canceled");
                            loop = false;
                            break;
                            default : 
                            log.info("Please select only y or n");
                            loop = true;
                        }
                } 
                loop = true;
                while (loop)
                {
                     System.out.println("Please enter y to send mail to Stakeholders or n to cancel");
                     String flag = sc.nextLine();
                     switch (flag)
                        {
                            case "y":
                            log.info("Sending mail");
                            loop = false;
                            SendEmail.sendEmail(dateFormatter.format(date));
                            break;
                            case "n":
                            log.info("Sending mail was canceled");
                            loop = false;
                            break;
                            default : 
                            log.info("Please select only y or n");
                            loop = true;
                        }
                } 
                sc.close();
  */}
	
	
    public static String testCaseNum(String ModuleName)
    {
    	String TCID = "TC_"+ModuleName+"_"+TestCaseNum;
    
    	return TCID;
    }
    
	public static Properties getProperty()
	{
		prop=ExcelReader.getPropertyFromExcel("Data","InputData");
		return prop;
	}
	
	public static String encPin()
	{
		prop =getProperty();
		String selectTableSQL = "select modulus from registration where regmobileno = '+91"+ prop.getProperty("RemMobileno")+"'";
		dbConnection = dbTransactionlog.getDBConnection(prop.getProperty("DB_USER") , prop.getProperty("DB_PASSWORD"));
		String modulus = null;
		try {
			statement = dbConnection.createStatement();
			ResultSet resultSet= statement.executeQuery(selectTableSQL);
			resultSet.next();
			modulus = resultSet.getString("MODULUS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(RsaEncryption.encrypt(prop.getProperty("mPINPlain"), modulus));
		String encryptedPin = RsaEncryption.encrypt(prop.getProperty("mPINPlain"), modulus);
        return encryptedPin;
	}
		
	public static void launchReport()
	{
		System.out.println("*******************");
		System.out.println("launching Report in browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver2.33.exe");
		driver = new ChromeDriver();
		System.setProperty("java.net.preferIPv4Stack", "true");
/*		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		driver.manage().window().maximize();
		driver.get(reportPath);
		System.out.println("*******************");
	}
	
	public static void assertResponse(String response)
	{
		//log.info(response.substring(2, 4));
		assertTrue(response.substring(2,4).contains("00"));		
	}
	
	public static String sendReq (String Request) throws IOException, SQLException
	{
	    BigInteger uniNum = RandomNumGenerator.generate();
	  	if (prop.getProperty("HMAC").equals("Y"))
		{
		  try {
			Request=Hmac.Hmacing(Request+uniNum, Request, uniNum);
		        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error(e);
		   }
		}
		else {
			Request = Request +";"+uniNum;
		}
			 HttpConnect obj=new HttpConnect();
			response = obj.Post(Request);
     	if(response.substring(2,4).contains("IM"))
     	{
     		log.info("mPIN is invalid : Please enter a valid mPIN and start the test");
     		log.info("Program is terminating");
     		System.exit(1);
     	}
	return response;
	}
	
	public static String sendReq (String Request, String TCID, String Description) throws IOException, SQLException
	{
		log.info("******************************START******************************");
	    log.info("Test Case ID : " + TCID);
	    log.info("Test Description : " + Description);
		try {
			ExcelWriter.writeTestCaseID(TestCaseNum , TCID);
			ExcelWriter.writeTestCaseDesc(TestCaseNum , Description);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BigInteger uniNum = RandomNumGenerator.generate();
	  	if (prop.getProperty("HMAC").equals("Y"))
		{
		  try {
			Request=Hmac.Hmacing(Request+uniNum, Request, uniNum);
			log.info("Hmaced Request : "+Request);
		        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error(e);
		   }
		}
		else {
			Request = Request +";"+uniNum;
			log.info("Non-Hmac request : "+Request);
			log.info(" Request");
		}

			 HttpConnect obj=new HttpConnect();
			response = obj.Post(Request);
			log.info("Response received from Server : "+response);
     	if (response.contains("TXNID"))
			{
				transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
				log.info("Transaction ID : "+transactionID);
				if("Y".equals(prop.getProperty("dbReport")))
				{
					dbResult = dbTransactionlog.fetchRecord(transactionID);
					WriteToCSVFile.reportGeneration( Description, dbResult);
				}		
			}
     	if(response.substring(2,4).contains("IM"))
     	{
     		log.info("mPIN is invalid : Please enter a valid mPIN and start the test");
     		log.info("Program is terminating");
     		System.exit(1);
     	}
     	TestCaseNum++;
	log.info("******************************END********************************\r\n");
	return response;
	}
	
	public static String sendReq2 (String Request, String TCID, String req2,String Description, BigInteger uniNum) throws IOException, SQLException
	{
		log.info("******************************START******************************");
	    log.info("Test Case ID : " + TCID);
	    log.info("Test Description : " + Description);
		try {
			ExcelWriter.writeTestCaseID(TestCaseNum , TCID);
			ExcelWriter.writeTestCaseDesc(TestCaseNum , Description);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	if (prop.getProperty("HMAC").equals("Y"))
		{
		  try {
			Request=Hmac.Hmacing(req2+uniNum, Request, uniNum);
			log.info("Hmaced Request : "+Request);
		        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			e.printStackTrace();
			log.error(e);
		   }
		}
		else {
			Request = Request +";"+uniNum;
			log.info("Non-Hmac request : "+Request);
			log.info(" Request");
		}

			 HttpConnect obj=new HttpConnect();
			response = obj.Post(Request);
			log.info("Response received from Server : "+response);
     	if (response.contains("TXNID"))
			{
				transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
				log.info("Transaction ID : "+transactionID);
				if("Y".equals(prop.getProperty("dbReport")))
				{
					dbResult = dbTransactionlog.fetchRecord(transactionID);
					WriteToCSVFile.reportGeneration( dbResult);
				}		
			}
	log.info("******************************END********************************\r\n");
	return response;
	}
}



