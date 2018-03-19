package mBankingUtilityCenter;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.util.Properties;

import mBankingBasePageObject.BaseObject;
import mBankingPageObjectModel.Configuration;
import mBankingPageObjectModel.StaticStore;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	public WebDriver driver;
	//protected static Log log = LogFactory.getLog(ExtentManager.class);
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	public static Properties prop;
	
	@BeforeSuite
	public void setUp(){
			extent = new ExtentReports (System.getProperty("user.dir") +"/logs/STMExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			prop =ExcelReader.setPropertyFromExcel("Data","InputData");
	}

	@BeforeMethod
	public void beforeMethod(Method method)
	{
		extentLogger = extent.startTest(this.getClass().getSimpleName()+ " ::  " +method.getName(), method.getName()); 
		extentLogger.assignAuthor("Brantan sp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log( LogStatus.PASS, "Test started successfully");
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}extent.endTest(extentLogger);
	}
	
	@AfterSuite
	public void endReport(){ 
                extent.flush();
    } 
	
	public void launchReport()
	{
		System.out.println("*******************");
		System.out.println("launching IE browser");
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();	
	}
	
	public static void assertResponse(String response)
	{
		//log.info(response.substring(2, 4));
		assertTrue(response.substring(2,4).contains("00"));		
	}
	
	public static String sendReq (String Request, String txnType)
	{
		log.info("******************************START******************************");
	    log.info("Request : " + txnType);
	    BigInteger uniNum = RandomNumGenerator.generate();
	  	if (Configuration.HMAC.equals("Y"))
		{
		  try {
			Request=Hmac.Hmacing(Request+uniNum, Request, uniNum);
			log.info("Hmaced Request : "+Request);
		        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		   }
		}
		else {
			Request = Request +";"+uniNum;
			log.info("Non-Hmac request : "+Request);
			log.info(" Request");
		}
		try {
			 HttpConnect obj=new HttpConnect();
			response = obj.Post(Request);
			log.info("Response received from Server : "+response);
			if (response.contains("TXNID"))
			{
				transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
				log.info("Transaction ID : "+transactionID);
				if(Configuration.dbReport=="Y")
				{
					dbResult = dbTransactionlog.fetchRecord(transactionID);
					WriteToCSVFile.reportGeneration( dbResult);
				}		
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	log.info("******************************END********************************\r\n");
	return response;
	}
}



