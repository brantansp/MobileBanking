package mBankingControlCenter;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.SkipException;
import org.testng.annotations.Test;

import mBankingBasePageObject.BaseObject;
import mBankingPageObjectModel.Configuration;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.dbTransactionlog;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.ITestAnnotation;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class NewTest extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
    
	 //@Test
		public void BalanceEnq() throws IOException, SQLException
		{
			//PropertyConfigurator.configure("log4j.properties");
			request = StaticStore.balanceEnq();
			response = sendReq (request, "Balance Enquiry");
			assertResponse(response);
		}
		//@Test
		public void MiniStatement() throws IOException, SQLException {
			request = StaticStore.miniStatement();
			response = sendReq (request, "Mini statement");
			assertResponse(response);
		}
	
		@Test
		public void test() throws IOException, SQLException
		{
			log.info(request = StaticStore.balanceEnq());
			response = sendReq (request, "Mini statement");
			assertResponse(response);
		}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
