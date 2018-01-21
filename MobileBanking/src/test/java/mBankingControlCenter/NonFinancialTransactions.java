package mBankingControlCenter;


import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mBankingBasePageObject.BaseObject;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class NonFinancialTransactions extends ExtentManager{
	private static String response;
	private static int index;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void AccountSync() throws IOException, SQLException {
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	@Test
	public void BalanceEnquiry() throws IOException, SQLException {
		index=2; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void MiniStatement() throws IOException, SQLException {
		index=3; 
	
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test(enabled = false)
	public void TransactionHistory() throws IOException, SQLException {
		index=4;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test(priority = 0)
	public void GenerateMMID() throws IOException, SQLException {
		index=5; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void RetrieveMMID() throws IOException, SQLException {
		index=6; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void CancelMMIDAll() throws IOException, SQLException {
		index=7; 
		BaseObject.buildRequest(5); // calling generate MMID
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void CancelMMIDSingle() throws IOException, SQLException {
		index=8;
		BaseObject.buildRequest(5); // calling generate MMID
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		index=9;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		index=10;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}

	@Test
	public void ChequeStatus() throws IOException, SQLException {
		index=11;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void StopCheque() throws IOException, SQLException {
		index=12;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	public static void main(String[] args) throws IOException, SQLException {
        /**
         * For checking Single transactions
         */
		}
}














