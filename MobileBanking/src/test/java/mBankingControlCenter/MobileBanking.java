package mBankingControlCenter;

import org.testng.annotations.Test;
import org.apache.commons.logging.*;

import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.RequestBuilder;
import mBankingUtilityCenter.dbTransactionlog;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;

public class MobileBanking {
	private static String response;
	private static int index;
	private static Log log = LogFactory.getLog(MobileBanking.class);
    //public static FileHandler fh;  
	static HttpConnect obj=new HttpConnect();
	
	public static void main(String[] args) {
          /**
           * For checking Single transactions
           */
		index=2; //APBE
		response =RequestBuilder.buildRequest(index);
	}
	
	@Test
	public void BalanceEnquiry() throws IOException, SQLException {
		index=0; //APBE
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("BE00"));
	}
	
	@Test
	public void MiniStatement() throws IOException, SQLException {
		index=1; //APMS
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("MS00"));	
	}
}














