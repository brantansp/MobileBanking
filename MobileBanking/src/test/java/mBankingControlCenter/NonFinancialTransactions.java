package mBankingControlCenter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonFinancialTransactions extends ExtentManager{
	private static int n = 0;
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
    
	//@Test
	public void AccountSync() throws IOException, SQLException {/*
		index=1; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	*/}
	
	@Test
	public void AppLogin() throws IOException, SQLException {
		request = StaticStore.appLogin();
		response =sendReq(request, "App Login");
		assertResponse(response);
	}
	
	@Test
	public void balanceEnq() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, "Balance Enquiry");
		assertResponse(response);
	}
	@Test
	public void MiniStatement() throws IOException, SQLException {
		request = StaticStore.miniStatement();
		response = sendReq (request, "Mini statement");
		assertResponse(response);
	}
	
	//@Test
	public void TransactionHistory() throws IOException, SQLException {
		request = StaticStore.transactionHistory();
		response = sendReq (request, "Transaction History");
		assertResponse(response);
	}

	@Test
	public void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = sendReq (request, "Generate MMID");
		assertResponse(response);
	}

	@Test
	public void RetrieveMMID() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = sendReq (request, "Retrieve MMID");
		assertResponse(response);
	}

	@Test
	public void CancelMMIDAll() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		response = sendReq (request, "Cancel MMID All");
		assertResponse(response);
	}

	@Test
	public void CancelMMIDSingle() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDSingle();
		response = sendReq (request, "Cancel MMID Single");
		assertResponse(response);
	}

	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, "Email ID fetch");
		assertResponse(response);
	}

	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, "Email ID Fetch");
		assertResponse(response);
	}

	@Test
	public void ChequeStatus() throws IOException, SQLException {
		request = StaticStore.chequeStatus("123456");
		response = sendReq (request, "Cheque status");
		assertResponse(response);
	}
	
	@Test
	public void StopCheque() throws IOException, SQLException {
		request = StaticStore.stopCheque("123456");
		response = sendReq (request, "Stop Cheque");
		assertResponse(response);
	}
	
	@Test
	public void Accountfetch() throws IOException, SQLException {
		request = StaticStore.Accountfetch();
		response = sendReq (request, "Account Fetch");
		assertResponse(response);
	}
	
	
	@Test
	public void changeloginpwd() throws IOException, SQLException {
		request = StaticStore.changeloginpwd("");
		response = sendReq (request, "Change Login Password");
		assertResponse(response);
	}
	
}














