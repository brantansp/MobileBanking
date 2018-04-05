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

	@Test(priority=13)
	public void Rechargelist() throws IOException, SQLException {
		request = StaticStore.Rechargelist();
		response =sendReq(request, "Recharge List");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void Operatorsearch() throws IOException, SQLException {
		request = StaticStore.Operatorsearch("MTP","dgha");
		response =sendReq(request, "Operator Search");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void Rechargeconfirm() throws IOException, SQLException {
		request = StaticStore.Rechargeconfirm("","","","","");
		response =sendReq(request, "Recharge Confirm");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void RechargeStatusEnq() throws IOException, SQLException {
		request = StaticStore.RechargeStatusEnq("","");
		response =sendReq(request, "Recharge Status Enquiry");
		assertResponse(response);
	}
}
