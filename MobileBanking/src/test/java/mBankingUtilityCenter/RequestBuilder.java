package mBankingUtilityCenter;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.reporters.jq.Main;

import mBankingConfigurationCenter.Configuration;
import mBankingConfigurationCenter.StaticStore;
import mBankingControlCenter.MobileBanking;

public class RequestBuilder {
static HttpConnect obj=new HttpConnect();
public static String response="";
private static String dbResult[];
public static String transactionID = "";
private static Log log = LogFactory.getLog(RequestBuilder.class);

public static String buildRequest(int index)
{
	log.info("******************************START******************************");
    log.info("Request : "+StaticStore.menuDesc[index][0]);
    String Request = ""; 
    if(Configuration.mPINRequired.equals("Y"))
    {
    	for(int x=1; x< StaticStore.menuDesc[index].length; x++ )
    	{	
    		Request =Request + StaticStore.menuDesc[index][x]+";";
    	}
    	} else {
    		for(int x=1; x< 3; x++ )
        	{	
        		Request =Request + StaticStore.menuDesc[index][x]+";"; 
        	}
    		for(int y=4; y< StaticStore.menuDesc[index].length; y++ )
    		{
    			Request =Request + StaticStore.menuDesc[index][y]+";";   
    		}
    	}
    BigInteger uniNum = RandomNumGenerator.generate();
	if (Configuration.HMAC.equals("Y"))
	{
	  try {
		Request=Hmac.Hmacing(Request+uniNum, Request, uniNum);
		log.info("Hmaced Request : "+Request);
	        } catch (InvalidKeyException | SignatureException | NoSuchAlgorithmException e) {
		e.printStackTrace();
	   }
	}
	else {
		Request = Request +uniNum;
		log.info("Non-Hmac request : "+Request);
		log.info(StaticStore.menuDesc[index][0]+" Request");
	}
	try {
		response = obj.Post(Request);
		log.info("Response received from Server : "+response);
		transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
		log.info("Transaction ID : "+transactionID);
		if(Configuration.dbReport=="Y")
		{
			dbResult = dbTransactionlog.fetchRecord(transactionID);
			System.out.println(StaticStore.menuDesc[index][0]);
			log.info("DB Result : "+dbResult);
			writeToFile.reportGeneration(StaticStore.menuDesc[index][0], dbResult);
		}		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("******************************END********************************\r\n");
		return  response;
  }

public static void main(String[] args) {
buildRequest(2);
}
}










