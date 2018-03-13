package mBankingControlCenter;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mBankingBasePageObject.BaseObject;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class NonFinancialTransactions extends ExtentManager{
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void AccountSync() throws IOException, SQLException {/*
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	*/}
	
	@Test
	public void AppLogin() throws IOException, SQLException {
		request = StaticStore.appLogin();
		response =buildReq(request, "App Login");
		assertResponse(response);
	}
	
	@Test
	public void balanceEnq()
	{
		request = StaticStore.balanceEnq();
		response = buildReq (request, "Balance Enquiry");
		assertResponse(response);
	}
	@Test
	public void MiniStatement() throws IOException, SQLException {
		request = StaticStore.miniStatement();
		response = buildReq (request, "Mini statement");
		assertResponse(response);
	}
	
	//@Test
	public void TransactionHistory() throws IOException, SQLException {
		request = StaticStore.transactionHistory();
		response = buildReq (request, "Transaction History");
		assertResponse(response);
	}

	@Test
	public void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = buildReq (request, "Generate MMID");
		assertResponse(response);
	}

	@Test
	public void RetrieveMMID() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = buildReq (request, "Retrieve MMID");
		assertResponse(response);
	}

	@Test
	public void CancelMMIDAll() throws IOException, SQLException {
		buildReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		response = buildReq (request, "Cancel MMID All");
		assertResponse(response);
	}

	@Test
	public void CancelMMIDSingle() throws IOException, SQLException {
		buildReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDSingle();
		response = buildReq (request, "Cancel MMID Single");
		assertResponse(response);
	}

	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = buildReq (request, "Email ID fetch");
		assertResponse(response);
	}

	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = buildReq (request, "Email ID Fetch");
		assertResponse(response);
	}

	@Test
	public void ChequeStatus() throws IOException, SQLException {
		request = StaticStore.chequeStatus("123456");
		response = buildReq (request, "Cheque status");
		assertResponse(response);
	}
	
	@Test
	public void StopCheque() throws IOException, SQLException {
		request = StaticStore.stopCheque("123456");
		response = buildReq (request, "Stop Cheque");
		assertResponse(response);
	}
	
	public static void main(String[] args) throws IOException, SQLException {
        /**
         * For checking Single transactions
         */
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
		}
}














