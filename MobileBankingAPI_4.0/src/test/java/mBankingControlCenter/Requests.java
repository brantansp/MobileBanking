package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Requests extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test
	public void ChequeStatus() throws IOException, SQLException {
		request = StaticStore.chequeStatus("123456");
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Cheque status");
		assertResponse(response);
	}
	
	@Test
	public void StopCheque() throws IOException, SQLException {
		request = StaticStore.stopCheque("123456");
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Stop Cheque");
		assertResponse(response);
	}
	
	@Test
	public void ChequeStatusCheckNotIssuedToCustomer() throws IOException, SQLException {
		request = StaticStore.chequeStatus(prop.getProperty("InvalidCheckNo"));
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Cheque Status Check Not Issued To Customer");
		assertResponse(response);
	}
	
	@Test
	public void StopChequeCheckAlreadyStopped() throws IOException, SQLException {
		request = StaticStore.stopCheque(prop.getProperty("CheckNo"));
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Stop Cheque Check Already Stopped");
		assertResponse(response);
	}
	
}
