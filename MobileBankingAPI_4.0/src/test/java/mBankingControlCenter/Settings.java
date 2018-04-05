package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Settings extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test(priority=8)
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, "Email ID fetch");
		assertResponse(response);
	}

	@Test(priority=9)
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, "Email ID Update");
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
