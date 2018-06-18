package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.RsaEncryption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Settings extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

    
	@Test(groups = { "nonfinancial", "positive" })
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, TCID , "Email ID fetch");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, TCID , "Email ID Update");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void Accountfetch() throws IOException, SQLException {
		request = StaticStore.Accountfetch();
		response = sendReq (request, TCID , "Account Fetch");
		assertResponse(response);
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void changeloginpwd() throws IOException, SQLException {
		request = StaticStore.changeloginpwd(RsaEncryption.encrypt("8541"));
		response = sendReq (request, TCID , "Change Login Password");
		assertResponse(response);
	}
	
}
