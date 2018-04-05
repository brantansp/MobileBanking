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

	@Test(priority=1)
	public void balanceEnqWithValidData() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, "Balance Enquiry");
		assertResponse(response);
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
	
	@Test(priority=1)
	public void balanceEnqWithInvalidAccNo() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("invalidaccno"));
		response = sendReq (request, "Balance Enquiry");
		assertTrue(response.substring(2,4).contains("AF"));	
	}
	
	@Test(priority=13)
	public void balanceEnqWithClosedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("closedaccountno"));
		response = sendReq (request, "Balance Enquiry with closed Account");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void balanceEnqWithInactiveAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, "Balance Enquiry with Inactive Account");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void balanceEnqWithBlockedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("blockedaccountno"));
		response = sendReq (request, "Balance Enquiry with Blocked Account");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void balanceEnqForAccountHavingZeroBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Zerobalnacc"));
		response = sendReq (request, "Balance Enquiry For Account Having Zero Balance");
		assertResponse(response);
	}
	
	@Test(priority=17)
	public void balanceEnqForAccountHavingNegativeBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Negbalnacc"));
		response = sendReq (request, "Balance Enquiry For Account Having Negative Balance");
		assertResponse(response);
	}
	
	@Test(priority=18)
	public void MiniStatementForClosedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("closedaccountno"));
		response = sendReq (request, "Mini statement For Closed Account");
		assertResponse(response);
	}
	
	@Test(priority=19)
	public void MiniStatementForinactiveAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, "Mini statement For Inactive Account");
		assertResponse(response);
	}
	
	@Test(priority=20)
	public void MiniStatementForBlockedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("blockedaccountno"));
		response = sendReq (request, "Mini Statement For Blocked Account");
		assertResponse(response);
	}

}
