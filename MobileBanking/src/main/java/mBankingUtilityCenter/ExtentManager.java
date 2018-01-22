package mBankingUtilityCenter;

import java.io.File;
import java.lang.reflect.Method;

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
	
	@BeforeSuite
	public void setUp(){
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
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
}



