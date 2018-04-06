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

    
	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Email ID fetch");
		assertResponse(response);
	}

	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Email ID Update");
		assertResponse(response);
	}
	
	@Test
	public void Accountfetch() throws IOException, SQLException {
		request = StaticStore.Accountfetch();
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Account Fetch");
		assertResponse(response);
	}
	
	@Test
	public void changeloginpwd() throws IOException, SQLException {
		request = StaticStore.changeloginpwd(RsaEncryption.encrypt("9999"));
		response = sendReq (request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Change Login Password");
		assertResponse(response);
	}
	
}
