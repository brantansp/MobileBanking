package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Accounts extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	public static String testScriptName ()
	{
		return MethodHandles.lookup().lookupClass().getSimpleName();
	}
	
	
	public static void main(String[] args) throws IOException, SQLException {
		request = StaticStore.balanceEnq();
		response = sendReq ("9952033881APSU;Y;85118262095530592846350644903156898169;8609547570776098518502128580812621291;50915897835336758097120764282302435687;9952033881;N;N;N;504433;123457;4.0.3;0;", "" , "SignUp");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void balanceEnq() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, TCID , "Balance Enquiry");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void MiniStatement() throws IOException, SQLException {
		request = StaticStore.miniStatement();
		response = sendReq (request, TCID , "Mini statement");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void TransactionHistory() throws IOException, SQLException {
		request = StaticStore.transactionHistory();
		response = sendReq (request, TCID , "Transaction History");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqWithInvalidAccNo() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("invalidaccno"));
		response = sendReq (request, TCID , "Balance Enquiry");
		assertTrue(response.substring(2,4).contains("AF"));	
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqWithClosedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("closedaccountno"));
		response = sendReq (request, TCID , "Balance Enquiry with closed Account");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqWithInactiveAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, TCID , "Balance Enquiry with Inactive Account");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqWithBlockedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("blockedaccountno"));
		response = sendReq (request, TCID , "Balance Enquiry with Blocked Account");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqForAccountHavingZeroBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Zerobalnacc"));
		response = sendReq (request, TCID , "Balance Enquiry For Account Having Zero Balance");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void balanceEnqForAccountHavingNegativeBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Negbalnacc"));
		response = sendReq (request, TCID , "Balance Enquiry For Account Having Negative Balance");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void MiniStatementForClosedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("closedaccountno"));
		response = sendReq (request, TCID , "Mini statement For Closed Account");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void MiniStatementForinactiveAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, TCID , "Mini statement For Inactive Account");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "negative" })
	public void MiniStatementForBlockedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("blockedaccountno"));
		response = sendReq (request, TCID , "Mini Statement For Blocked Account");
		assertResponse(response);
	}

}
