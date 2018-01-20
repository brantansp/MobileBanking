package mBankingControlCenter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.logging.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mBankingBasePageObject.RequestBuilder;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.dbTransactionlog;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MobileBanking {
	private static String response;
	private static int index;
	private static Log log = LogFactory.getLog(MobileBanking.class);
	static ExtentReports extent;
	ExtentTest logger;
    //public static FileHandler fh;  
	static HttpConnect obj=new HttpConnect();
	
	
	public static void main(String[] args) {
          /**
           * For checking Single transactions
           */
		index=1; 

		response =RequestBuilder.buildRequest(index);
		System.out.println(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00");

	}
	
	@BeforeTest
	public void startReport(){
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/STMExtentReport.html", true);
		    extent
                .addSystemInfo("Host Name", "LOB - DB QCT mPAY")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Brantan sp");
                extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@Test
	public void AccountSync() throws IOException, SQLException {
		index=1; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	@Test
	public void BalanceEnquiry() throws IOException, SQLException {
		index=2; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	@Test
	public void MiniStatement() throws IOException, SQLException {
		index=3; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void TransactionHistory() throws IOException, SQLException {
		index=4;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test(priority = 0)
	public void GenerateMMID() throws IOException, SQLException {
		index=5; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void RetrieveMMID() throws IOException, SQLException {
		index=6; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void CancelMMIDAll() throws IOException, SQLException {
		index=7; 
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		RequestBuilder.buildRequest(5); // calling generate MMID
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void CancelMMIDSingle() throws IOException, SQLException {
		index=8;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		RequestBuilder.buildRequest(5); // calling generate MMID
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		index=9;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		index=10;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void ChequeStatus() throws IOException, SQLException {
		index=11;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void StopCheque() throws IOException, SQLException {
		index=12;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PInstant() throws IOException, SQLException {
		index=13;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void IMPSP2AInstant() throws IOException, SQLException {
		index=14;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2UInstant() throws IOException, SQLException {
		index=15;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PAddBeneficiary() throws IOException, SQLException {
		index=16;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		index=17;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PBeneficiarySearchListenquiry() throws IOException, SQLException {
		index=18;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryListenquiry() throws IOException, SQLException {
		index=19;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		index=20;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2PBeneficiaryPaymentListenquiry() throws IOException, SQLException {
		index=21;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@Test
	public void IMPSP2PBeneficiaryPaymentConfirmation () throws IOException, SQLException {
		index=22;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		index=23;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		index=24;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2ABeneficiarySearchListenquiry() throws IOException, SQLException {
		index=25;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		index=26;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		index=27;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentListenquiry() throws IOException, SQLException {
		index=28;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		index=29;
		logger = extent.startTest(StaticStore.menuDesc[index][0]);
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains(StaticStore.menuDesc[index][1].substring(StaticStore.menuDesc[index][1].length()-2 , StaticStore.menuDesc[index][1].length())+"00"));
		logger.log(LogStatus.PASS, StaticStore.menuDesc[index][0]+"is Passed");
	}
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
			extent.endTest(logger);
	}
	@AfterTest
	public void endReport(){
		          extent.flush();
             extent.close();
    }
}














