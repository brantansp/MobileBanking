package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Recharge extends ExtentManager{
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test
	public void Rechargelist() throws IOException, SQLException {
		request = StaticStore.Rechargelist();
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Recharge List");
		assertResponse(response);
	}
	
	@Test
	public void Operatorsearch() throws IOException, SQLException {
		request = StaticStore.Operatorsearch("MTP","dgha");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Operator Search");
		assertResponse(response);
	}
	
	@Test
	public void Rechargeconfirm() throws IOException, SQLException {
		request = StaticStore.Rechargeconfirm("","","","","");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Recharge Confirm");
		assertResponse(response);
	}
	
	@Test
	public void RechargeStatusEnq() throws IOException, SQLException {
		request = StaticStore.RechargeStatusEnq("","");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Recharge Status Enquiry");
		assertResponse(response);
	}
}
