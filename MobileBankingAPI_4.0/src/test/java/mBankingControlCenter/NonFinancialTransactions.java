package mBankingControlCenter;


import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.RandomNumGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonFinancialTransactions extends ExtentManager{
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
    
	
	@Test(priority=0)
	public void AppLogin() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.appLogin();
		String req2=StaticStore.appLogin2();
		response =sendReqAppLogin(request, req2, "App Login", uniNum);
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void balanceEnq() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, "Balance Enquiry");
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void balanceEnqWithInvalidAccNo() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("invalidaccno"));
		response = sendReq (request, "Balance Enquiry");
		assertTrue(response.substring(2,4).contains("01"));	
	}
	
	@Test(priority=2)
	public void MiniStatement() throws IOException, SQLException {
		request = StaticStore.miniStatement();
		response = sendReq (request, "Mini statement");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void TransactionHistory() throws IOException, SQLException {
		request = StaticStore.transactionHistory();
		response = sendReq (request, "Transaction History");
		assertResponse(response);
	}

	@Test(priority=4)
	public void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = sendReq (request, "Generate MMID");
		assertResponse(response);
	}

	@Test(priority=5)
	public void RetrieveMMID() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = sendReq (request, "Retrieve MMID");
		assertResponse(response);
	}

	@Test(priority=6)
	public void CancelMMIDAll() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		response = sendReq (request, "Cancel MMID All");
		assertResponse(response);
	}

	@Test(priority=7)
	public void CancelMMIDSingle() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDSingle();
		response = sendReq (request, "Cancel MMID Single");
		assertResponse(response);
	}

	@Test(priority=8)
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, "Email ID fetch");
		assertResponse(response);
	}

	@Test(priority=9)
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, "Email ID Fetch");
		assertResponse(response);
	}

	@Test(priority=10)
	public void ChequeStatus() throws IOException, SQLException {
		request = StaticStore.chequeStatus("123456");
		response = sendReq (request, "Cheque status");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void StopCheque() throws IOException, SQLException {
		request = StaticStore.stopCheque("123456");
		response = sendReq (request, "Stop Cheque");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void Accountfetch() throws IOException, SQLException {
		request = StaticStore.Accountfetch();
		response = sendReq (request, "Account Fetch");
		assertResponse(response);
	}
	
	
	@Test(priority=12)
	public void changeloginpwd() throws IOException, SQLException {
		request = StaticStore.changeloginpwd("8609547570776098518502128580812621291");
		response = sendReq (request, "Change Login Password");
		assertResponse(response);
	}
	
}














