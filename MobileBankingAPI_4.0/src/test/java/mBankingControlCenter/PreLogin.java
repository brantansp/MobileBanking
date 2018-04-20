package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
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
import mBankingUtilityCenter.RsaEncryption;
import mBankingUtilityCenter.dbTransactionlog;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class PreLogin extends ExtentManager {

	private static String response;
	public static String request;
	static HttpConnect obj=new HttpConnect();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	private static Connection dbConnection = null;
	private static Statement statement = null;
	static int i =0;

    @Test
	public void ApplicationMobileNumber() throws IOException, SQLException {
		String imei = prop.getProperty("imei");
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
		String selectTableSQL = "INSERT INTO \""+prop.getProperty("DB_USER_ADMIN")+
				"\".\"INCOMING_SMS\" (MOBILE_NO, SMS_MSG, SMS_DATE_TIME, APPLICATION_NAME, SMS_STATUS, SMS_FROM, TXN_ID, RECV_DATETIME, DYNAMIC_PORT, MPIN_FLAG, BANKID, IMEI_NO) VALUES "
				+ "('+91"+prop.getProperty("RemMobileno")+"', '"+req2.substring(10)+uniNum+"', '"+dateFormatter.format(date)+" "+timeFormatter.format(date)+"', 'MPAY', 'Y', 'IMI', '"+2+timeFormatter2.format(date)+"', TO_DATE"
						+ "('2018-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '-', 'Y', '"+prop.getProperty("bankCode")+"', '"+imei+randNum+"')";
		log.info("Query : "+selectTableSQL);
		dbConnection = dbTransactionlog.getDBConnection(prop.getProperty("DB_USER_ADMIN") , prop.getProperty("DB_PASSWORD_ADMIN"));
		statement = dbConnection.createStatement();
		statement.executeQuery(selectTableSQL);
		}
		
		request = StaticStore.SilentSms(imei, randNum);
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , req2, "ApplicationMobileNumber", uniNum);
		assertResponse(response);
	}
	
	@Test
	public void GPRSCheck() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.GPRSCheck();
		String req2=StaticStore.GPRSCheck2();
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , req2, "GPRS Check", uniNum);
		assertResponse(response);
	}
	
	@Test
	public void buildActivation() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.buildActivation();
		String req2=StaticStore.buildActivation2();
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , req2, "buildActivation", uniNum);
		assertResponse(response);
	}
	
	@Test
	public void GPRSCheckNew() throws IOException, SQLException {
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.GPRSCheckNew();
		String req2=StaticStore.GPRSCheckNew2();
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , req2, "GPRSCheckNew", uniNum);
		assertResponse(response);
	}
	
	@Test
	public void productOffer() throws IOException, SQLException {

		request = StaticStore.productOfferLeg2();
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "productOfferLeg2");
		String [] split =  response.split(";");
		String x=split[1];
		split = x.split("\\*");
		 x = split[0];
		assertResponse(response);
		
		request = StaticStore.productOfferLeg3(x);
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "productOfferLeg3");
		String [] split2 =  response.split(";");
	    String y=split2[2];
		split = y.split("\\*");
		 y = split[0];
		assertResponse(response);
		
		request = StaticStore.productOfferLeg4(x , y);
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "productOfferLeg4");
		String [] split3 =  response.split(";");
	    String z=split3[3];
		split = z.split("\\*");
		z = split[0];
		assertResponse(response);
		
		request = StaticStore.productOfferLeg5(x , y, z);
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "productOfferLeg5");
        split =  response.split(";");
		assertResponse(response);
	}

	@Test
	public void Loan() throws IOException, SQLException {
		request = StaticStore.Loan("100","10","12","2");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "Loan");
		assertResponse(response);	
	}

	@Test
	public void versionUpgrade() throws IOException, SQLException {
		request = StaticStore.versionUpgrade("4.1.16");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "versionUpgrade");
		assertResponse(response);	
	}

	@Test
	public void ATMPinSearch() throws IOException, SQLException {
		request = StaticStore.ATMPinSearch("600001", RsaEncryption.encrypt("2580"));
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "ATMPinSearch");
		assertResponse(response);	
	}
	
	@Test
	public void ATMLocationSearch() throws IOException, SQLException {
		request = StaticStore.ATMLocationSearch("che");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "ATMLocationSearch");
		assertResponse(response);	
	}

	@Test
	public void BranchPinSearch() throws IOException, SQLException {
		request = StaticStore.BranchPinSearch("600001");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "BranchPinSearch");
		assertResponse(response);	
	}
	
	@Test
	public void BranchLocationSearch() throws IOException, SQLException {
		request = StaticStore.BranchLocationSearch("che");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "BranchLocationSearch");
		assertResponse(response);	
	}

	//3EM*#L9
	@Test
	public void ReferFriend() throws IOException, SQLException {
		request = StaticStore.referFriend("brantan","brantansp@fss.co.in","9047637908");
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "ReferFriend");
		assertResponse(response);	
	}
	
	@Test
	public void FeedBack() throws IOException, SQLException {
		request = StaticStore.feedbackleg1();
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "FeedBack Leg1");
		assertResponse(response);	
		
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.feedbackleg2();
		String request2 = StaticStore.feedbackleg2_();
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , request2, "FeedBack Leg2", uniNum);
		assertResponse(response);	
	}
	
	@Test(priority=13)
	public void ForgotLoginPin() throws IOException, SQLException {
        request = StaticStore.OTPGeneration();
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "OTP Generation");
		transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
		assertResponse(response);	
		

		String selectTableSQL = "SELECT SMS_MSG FROM OUTGOING_SMS WHERE TXN_ID ='"+transactionID+"'";
		dbConnection = dbTransactionlog.getDBConnection(prop.getProperty("DB_USER_ADMIN") , prop.getProperty("DB_PASSWORD_ADMIN"));
		statement = dbConnection.createStatement();
		ResultSet resultSet= statement.executeQuery(selectTableSQL);
		resultSet.next();
		String sms_msg = resultSet.getString("sms_msg");
		sms_msg=sms_msg.substring(sms_msg.lastIndexOf("Your OTP is ")+12 , sms_msg.lastIndexOf("Your OTP is ")+18);
		log.info("OTP : "+sms_msg);
		request = StaticStore.OTPVerification(RsaEncryption.encrypt(sms_msg));
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "OTP Verification");
		assertResponse(response);	
		
		request = StaticStore.loginmPinCheck(RsaEncryption.encrypt(prop.getProperty("mPINPlain")));
		response =sendReq(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , "mPIN verification in Forgot login pin");
		assertResponse(response);	
		
		SimpleDateFormat dateFormatter2 = new SimpleDateFormat("ddMMyy"); 
		SimpleDateFormat timeFormatter2 = new SimpleDateFormat("HHmmss"); 
		Date date = new Date(); 
		String randNum = "1"+dateFormatter2.format(date)+timeFormatter2.format(date);
		
		BigInteger uniNum = RandomNumGenerator.generate();
		request = StaticStore.loginNewPinSet(prop.getProperty("imei") , randNum);
		String request2 = StaticStore.loginNewPinSet_(prop.getProperty("imei") , randNum);
		response =sendReq2(request, testCaseNum(MethodHandles.lookup().lookupClass().getSimpleName()) , request2, "Forgot login pin : New PIN Set", uniNum);
		assertResponse(response);	
	}


	
	
	
	

	
}
