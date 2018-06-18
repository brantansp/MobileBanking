package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Transfer extends ExtentManager{
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	/*
	 * M2M
	 */

   @Test(groups = { "financial", "positive" })
	public void m2mQuickFT() throws IOException, SQLException {
		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2m Quick FT");
		assertResponse(response);
	}
   
   
   @Test(groups = { "financial", "positive" })
	public void m2mBenRegAcclist() throws IOException, SQLException {
		request = StaticStore.m2mBenRegAcclist(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2m Benificiary Account list");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenReg() throws IOException, SQLException {
		request = StaticStore.m2mBenReg(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"), prop.getProperty("BenAccNo"));
		response =sendReq(request, TCID , "m2m Benificiary Registration");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mPaybensearch() throws IOException, SQLException {
		request = StaticStore.m2mPaybensearch();
		response =sendReq(request, TCID , "m2m Register benificiary search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mbenpayment() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2m benificiary payment");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch("");
		response =sendReq(request, TCID , "m2m benificiary search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2m benificiary search");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenDelSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch("");
		response =sendReq(request, TCID , "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenDelSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2mBenDelete() throws IOException, SQLException {
		request = StaticStore.m2mbenedelete(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "M2M benificiary delete");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
 	public void m2mQuickFTBenificiaryNotRegForMobileBanking() throws IOException, SQLException {
 		request = StaticStore.m2mQuickFT(prop.getProperty("NotregBenMobileNo"), 
 				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
 		response =sendReq(request, TCID , "m2m Quick FT Benificiary Not Registered For Mobile Banking");
		assertTrue(response.substring(2,4).contains("09"));

 	}
   
   @Test(groups = { "financial", "negative" })
  	public void m2mQuickFTInsufficientAmount() throws IOException, SQLException {
  		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
  				prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
  		response =sendReq(request, TCID , "m2m Quick FT Insufficient Amount");
		assertTrue(response.substring(2,4).contains("20"));

  	}
	
   @Test(groups = { "financial", "negative" })
 	public void m2mQuickFTAmountExceedsLimit() throws IOException, SQLException {
 		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
 				prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
 		response =sendReq(request, TCID , "m2m Quick FT Amount Exceeds Limit");
		assertTrue(response.substring(2,4).contains("21"));

 	}

   @Test(groups = { "financial", "negative" })
  	public void m2mBenRegAcclistForRandomMobileNo() throws IOException, SQLException {
  		request = StaticStore.m2mBenRegAcclist(prop.getProperty("NotregBenMobileNo"), 
  				prop.getProperty("FTBenNickName"));
  		response =sendReq(request, TCID , "m2m Ben Reg Acclist For Random Mobile No");
  		assertResponse(response);
  	}
   
   @Test(groups = { "financial", "negative" })
	public void m2mbenpaymentExceedTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2m ben payment Exceed Transaction Amount");
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void m2mbenpaymentInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2m ben payment Insufficient Amount");
	//	assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void m2mBenDelSameBenSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2m Ben Del Same Ben SearchWKw");
		assertResponse(response);
	}
	
	/*
	 * M2A
	 */
	
	@Test(groups = { "financial", "positive" })
	public void m2aQuickFT() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("WtFTAmount"));
		response =sendReq(request, TCID , "M2A Quick FT");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2aBenRegSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenRegSearch(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a benificary registration search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2aBenReg() throws IOException, SQLException {
		request = StaticStore.m2abenreg(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a benificiary req");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2aBenPaymentSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenPaySearch();
		response =sendReq(request, TCID , "m2a benificiary payment search");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2aBenPayment() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2a benificiary payment");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2abendetailsWoKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails("");
		response =sendReq(request, TCID , "m2a benificiary details Without Keyword");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2abendetailsWKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a benificiary details With Keyword");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2abenderegsearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch("");
		response =sendReq(request, TCID , "m2a benificiary deregistration search without keyword");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2abenderegsearchWKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void m2aBenDereg() throws IOException, SQLException {
		request = StaticStore.m2aBenDereg(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aQuickFTRandomBenAccount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("InvalidBenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("WtFTAmount"));
		response =sendReq(request, TCID , "m2a Quick FT Random Ben Account");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aQuickFTExceedsTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("ExceededAmount"));
		response =sendReq(request, TCID , "m2a Quick FT Exceeds Transaction Amount");
		assertTrue(response.substring(2,4).contains("21"));

		//assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aQuickFTInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("InsufficientAmount"));
		response =sendReq(request, TCID , "m2a QuickFT Insufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aBenRegWithRandomBenAccount() throws IOException, SQLException {
		request = StaticStore.m2abenreg(prop.getProperty("RandomBenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a Ben Reg With Random Ben Account");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aBenPaymentExceedTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2a Ben Payment Exceed Transaction Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));
	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aBenPaymentInSufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, TCID , "m2a Ben Payment InSufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void m2aBenDeregSameBen() throws IOException, SQLException {
		request = StaticStore.m2aBenDereg(prop.getProperty("FTBenNickName"));
		response =sendReq(request, TCID , "m2a Ben De-register Same Ben");
		assertResponse(response);
	}
	

	/*
	 * NEFT
	 */
	
	@Test(groups = { "financial", "positive" })
	public void NEFTQuickFT() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT(prop.getProperty("BenAccountno"), prop.getProperty("AccountType"),
				prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"), 
				prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFT Quick FT");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbenreg() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT benificiary registration");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbenregconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT benificiary registration confirm");
		assertResponse(response);
	}

	
	@Test(groups = { "financial", "positive" })
	public void NEFTbenlist() throws IOException, SQLException {
		request = StaticStore.NEFTbenlist();
		response =sendReq(request, TCID , "NEFT benificiary list");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbenpayment() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("NeftAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFT benificiary payment");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbendetail() throws IOException, SQLException {
		request = StaticStore.NEFTbendetail(prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT benificiary detail");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbendereglist() throws IOException, SQLException {
		request = StaticStore.NEFTbendereglist("");
		response =sendReq(request, TCID , "NEFT benificiary de-registration list");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void NEFTbenderegconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenderegconfirm(prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT benificiary de-registration confirm");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void NEFTQuickFTWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT(prop.getProperty("BenAccountno"), prop.getProperty("AccountType"),
				prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"), 
				prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFT Quick FT With Invalid IFSC code");
		assertResponse(response);
		
	}
	
	@Test(groups = { "financial", "negative" })
	public void NEFTbenregWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT ben reg With Invalid IFSC code");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "negative" })
	public void NEFTbenregconfirmWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, TCID , "NEFT ben reg confirm With Invalid IFSC code");
		assertResponse(response);
	}

	@Test(groups = { "financial", "negative" })
	public void NEFTbenpaymentWithExceededAmount() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("ExceededAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFT ben payment With Exceeded Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void NEFTbenpaymentWithInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("InsufficientAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFT ben payment With Insufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(groups = { "financial", "negative" })
	public void NEFTbenpaymentWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("NeftAmount"),
				prop.getProperty("RandomNickname") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, TCID , "NEFTbenpaymentWithRandomNickname");
		assertResponse(response);
	}
	
	public static void main(String[] args) {}
}
