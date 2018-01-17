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
	public void AccountSync() throws IOException, SQLException {
		index=1; 
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("SY00"));
	}
	@Test
	public void BalanceEnquiry() throws IOException, SQLException {
		index=2; 
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("BE00"));
	}
	@Test
	public void MiniStatement() throws IOException, SQLException {
		index=3; 
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("MS00"));	
	}
	
	@Test
	public void TransactionHistory() throws IOException, SQLException {
		index=4;
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("TH00"));
	}
	@Test(priority = 0)
	public void GenerateMMID() throws IOException, SQLException {
		index=5; 
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("IM00"));
	}
	@Test
	public void RetrieveMMID() throws IOException, SQLException {
		index=6; 
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("S600"));
	}
	@Test
	public void CancelMMIDAll() throws IOException, SQLException {
		index=7; 
		RequestBuilder.buildRequest(5); // calling generate MMID
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("RC00"));
	}
	@Test
	public void CancelMMIDSingle() throws IOException, SQLException {
		index=8;
		RequestBuilder.buildRequest(5); // calling generate MMID
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("RC00"));
	}
	@Test
	public void EmailIDFetch() throws IOException, SQLException {
		index=9;
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("Z600"));
	}
	@Test
	public void EmailIDUpdate() throws IOException, SQLException {
		index=10;
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("Z300"));
	}
	@Test
	public void ChequeStatus() throws IOException, SQLException {
		index=11;
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("LW00"));
	}
	@Test
	public void StopCheque() throws IOException, SQLException {
		index=12;
		response =RequestBuilder.buildRequest(index);
		assertTrue(response.contains("L400"));
	}
}














