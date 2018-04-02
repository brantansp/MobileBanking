package mBankingControlCenter;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void AppLogin() throws IOException, SQLException {
		String imei = "864829030310400";
		String randNum = "1522649949907";
		String req2=appLogin2(imei, randNum);
		BigInteger uniNum = RandomNumGenerator.generate();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss"); 
		Date date = new Date(); 
		String selectTableSQL = "INSERT INTO \""+prop.getProperty("DB_USER")+
				"\".\"INCOMING_SMS\" (MOBILE_NO, SMS_MSG, SMS_DATE_TIME, APPLICATION_NAME, SMS_STATUS, SMS_FROM, TXN_ID, RECV_DATETIME, DYNAMIC_PORT, MPIN_FLAG, BANKID, IMEI_NO) VALUES "
				+ "('+91"+prop.getProperty("RemMobileno")+"', '"+req2.substring(11)+uniNum+"', '"+dateFormatter.format(date)+" "+timeFormatter.format(date)+"', 'MPAY', 'Y', 'IMI', '3309605', TO_DATE"
						+ "('2018-01-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '-', 'Y', '"+prop.getProperty("bankCode")+"', '"+imei+randNum+"')";
		
		dbConnection = dbTransactionlog.getDBConnection();
		statement = dbConnection.createStatement();
		//statement.executeQuery(selectTableSQL);
		request = appLogin(imei, randNum);
		response =sendReqAppLogin(request, req2, "App Login", uniNum);
		//assertResponse(response);
	}
	
	//8778602561APMN;BVD:4.3.12#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#864829030310400#1522649949907;504432;123457;4.0.3;0;0921811490902212
	public static String appLogin (String imei, String randNum)   
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append("XXXXXXXXXX");
		sb.append("APMN;");
		sb.append("BVD:");
		sb.append("4.3.12%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus%23"+imei+"%23"+randNum+";");
		sb.append("504432;");
		sb.append("123457;");
		sb.append("4.0.3;");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String appLogin2(String imei, String randNum)   //request with #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append("XXXXXXXXXX");
		sb.append("APMN;");
		sb.append("BVD:");
		sb.append("4.3.12#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#"+imei+"#"+randNum+";");
		sb.append("504432;");
		sb.append("123457;");
		sb.append("4.0.3;");
		sb.append("0;");
		return sb.toString();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
