package mBankingControlCenter;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.RandomNumGenerator;
import mBankingUtilityCenter.dbTransactionlog;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class PreLoginTransactions extends ExtentManager {

	private static String response;
	public static String request;
	static HttpConnect obj=new HttpConnect();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	private static Connection dbConnection = null;
	private static Statement statement = null;
	
	@Test(priority=0)
	public void ApplicationMobileNumber() throws IOException, SQLException {
		String imei = "864829030310400";
		BigInteger uniNum = RandomNumGenerator.generate();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss"); 
		SimpleDateFormat dateFormatter2 = new SimpleDateFormat("ddMMyy"); 
		SimpleDateFormat timeFormatter2 = new SimpleDateFormat("HHmmss"); 
		Date date = new Date(); 
		String randNum = "1"+dateFormatter2.format(date)+timeFormatter2.format(date);
		String req2=StaticStore.SilentSms2(imei, randNum);
		
		if("Y".equals(prop.getProperty("SilentSMS")))
		{
			String dbUser = "ADMIN_P2TEST";
		String selectTableSQL = "INSERT INTO \""+dbUser+
				"\".\"INCOMING_SMS\" (MOBILE_NO, SMS_MSG, SMS_DATE_TIME, APPLICATION_NAME, SMS_STATUS, SMS_FROM, TXN_ID, RECV_DATETIME, DYNAMIC_PORT, MPIN_FLAG, BANKID, IMEI_NO) VALUES "
				+ "('+91"+prop.getProperty("RemMobileno")+"', '"+req2.substring(10)+uniNum+"', '"+dateFormatter.format(date)+" "+timeFormatter.format(date)+"', 'MPAY', 'Y', 'IMI', '"+2+timeFormatter2.format(date)+"', TO_DATE"
						+ "('2018-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '-', 'Y', '"+prop.getProperty("bankCode")+"', '"+imei+randNum+"')";
		System.out.println("Query : "+selectTableSQL);
		dbConnection = dbTransactionlog.getDBConnection(dbUser , "admin_p2test321#");
		statement = dbConnection.createStatement();
		statement.executeQuery(selectTableSQL);
		}
		
		request = StaticStore.SilentSms(imei, randNum);
		response =sendReqAppLogin(request, req2, "ApplicationMobileNumber", uniNum);
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void GPRSCheck() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.GPRSCheck();
		String req2=StaticStore.GPRSCheck2();
		response =sendReqAppLogin(request, req2, "GPRS Check", uniNum);
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void buildActivation() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.buildActivation();
		String req2=StaticStore.buildActivation2();
		response =sendReqAppLogin(request, req2, "buildActivation", uniNum);
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void GPRSCheckNew() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.GPRSCheckNew();
		String req2=StaticStore.GPRSCheckNew2();
		response =sendReqAppLogin(request, req2, "buildActivation", uniNum);
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void productOffer() throws IOException, SQLException {

		request = StaticStore.GPRSCheckNew();
		String req2=StaticStore.GPRSCheckNew2();
		//response =sendReqAppLogin(request, req2, "buildActivation");
		assertResponse(response);
	}

	//Loan
	//9894060407APLR;N;100;10;12;2;463795;123457;4.0;0;28396647691290863989616373173741955642
	
	
	//version update
	//9894060407APBV;N;4.1.16;ARD;504511;123457;4.0;0;1522735794546
	
	//ATM loc uusing PIN
		//	APAL;N;P;635851; ;001;504511;123457;4.0;0;9894060407
	//9894060407APAL;N;L;ch; ;001;504511;123457;4.0;0;1522736449475
	
	//branch loc
	//9894060407AP1L;N;P;635851; ;001;504511;123457;4.0;0;1522736556357
	//9894060407AP1L;N;L;ch; ;001;504511;123457;4.0;0;1522736596103	Y	-	null
	//9894060407AP1L;N;L;ch; ;21;504511;123457;4.0;0;1522736677425
	
	//refer friend
	//9894060407APZ5;N;brantan;brantansp3EM*#L9fss.co.in;9047637908;463795;123457;4.0;0;156427595325614052516425771169862832947
	
	//Feedback
	//9894060407AP1F;N;001;463795;123457;4.0;0;193642678486689309906116376043656160964
	//9894060407AP2F;N;90*1#91*1#110*1#150*1;test;463795;123457;4.0;0;179037572733429785283578924912205114102
	
	//Forgot password
	//9894060407APOG;463795;123457;4.0;0;114708343457668991672203685532975502159
   //9894060407APOV;69349112813202152646087269368538447620;463795;123457;4.0;0;26000064459182838061035821015230919775
	//9894060407APP3;Y;193236764614536154242346493710901391873;463795;123457;4.0;0;41425399265261176686215331752420743641
	//9894060407APFN;BVD:4.0.1#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#864829030310400#1522737602321;463795;123457;4.0;0;171762895022425228530675880511995212845
	
	
	
	
	
	
	
	
	
	
	
}
