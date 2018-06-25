package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Recharge extends ExtentManager {
	private static String response;
	public static String request;
	public static String RRN;
	public static String searchResult;
	public static Log log = LogFactory.getLog(MethodHandles.lookup()
			.lookupClass().getSimpleName());

	/*
	 * @Test(groups = { "financial", "positive" }) public void Rechargelist()
	 * throws IOException, SQLException { request = StaticStore.Rechargelist();
	 * response =sendReq(request, TCID , "Recharge List");
	 * assertResponse(response); }
	 */// DUPLICATE

	@Test(groups = { "financial", "positive" })
	public void Operatorsearch() throws IOException, SQLException {
		request = StaticStore.Operatorsearch("MTP",
				prop.getProperty("operator"));
		response = sendReq(request, TCID, "Operator Search");
		RRN=returnRRN(response);
		searchResult= returnMobileBiller(response, prop.getProperty("operator"));
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void Rechargeconfirm() throws IOException, SQLException {
		request = StaticStore.Rechargeconfirm(prop.getProperty("rechargeType"),
				searchResult, prop.getProperty("RechargeMobNo"),
				prop.getProperty("RechargeAmount"), RRN);

		response = sendReq(request, TCID, "Recharge Confirm");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void RechargeStatusEnq() throws IOException, SQLException {
		request = StaticStore.RechargeStatusEnq("", "");
		response = sendReq(request, TCID, "Recharge Status Enquiry");
		assertResponse(response);
	}
}
