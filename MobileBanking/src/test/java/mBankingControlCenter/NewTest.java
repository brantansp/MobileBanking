package mBankingControlCenter;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import mBankingBasePageObject.BaseObject;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class NewTest extends ExtentManager {
	static HttpConnect obj=new HttpConnect();
	public static String response="";
	public static String request;
	private static String dbResult[];
	public static String transactionID = "";
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	@Test
	public void AppLogin() throws IOException, SQLException {
		request = StaticStore.appLogin();
		response =sendReq(request, "App Login");
		assertResponse(response);
	}
	
	@Test
	public void balanceEnq()
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, "Balance Enquiry");
		assertResponse(response);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
