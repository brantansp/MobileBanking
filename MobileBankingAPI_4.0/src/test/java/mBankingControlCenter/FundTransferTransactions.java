package mBankingControlCenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.*;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class FundTransferTransactions extends ExtentManager {
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();
	static Properties prop=getProperty();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	public static void main(String[] args) {

		
		request = StaticStore.m2mbensearch(prop.getProperty("FTBenNickName"));
		try {
			response =sendReq(request, "m2m Benificiary Account list");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * M2M
	 */

   @Test(priority=1)
	public void m2mQuickFT() throws IOException, SQLException {
		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void m2mBenRegAcclist() throws IOException, SQLException {
		request = StaticStore.m2mBenRegAcclist(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m Benificiary Account list");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void m2mBenReg() throws IOException, SQLException {
		request = StaticStore.m2mBenReg(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"), prop.getProperty("BenAccNo"));
		response =sendReq(request, "m2m Benificiary Registration");
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void m2mPaybensearch() throws IOException, SQLException {
		request = StaticStore.m2mPaybensearch();
		response =sendReq(request, "m2m Register benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void m2mbenpayment() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m benificiary payment");
		assertResponse(response);
	}
	
	@Test(priority=6)
	public void m2mBenSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch("");
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void m2mBenSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=8)
	public void m2mBenDelSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch("");
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void m2mBenDelSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(priority=10)
	public void m2mBenDelete() throws IOException, SQLException {
		request = StaticStore.m2mbenedelete(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "M2M benificiary delete");
		assertResponse(response);
	}
	
	/*
	 * M2A
	 */
	
	@Test(priority=51)
	public void m2aQuickFT() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("WtFTAmount"));
		response =sendReq(request, "P2A Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=52)
	public void m2aBenRegSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenRegSearch(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificary registration search");
		assertResponse(response);
	}
	
	@Test(priority=53)
	public void m2aBenReg() throws IOException, SQLException {
		request = StaticStore.m2abenreg(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary req");
		assertResponse(response);
	}
	
	@Test(priority=54)
	public void m2aBenPaymentSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenPaySearch();
		response =sendReq(request, "m2a benificiary payment search");
		assertResponse(response);
	}
	
	@Test(priority=55)
	public void m2aBenPayment() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2a benificiary payment");
		assertResponse(response);
	}
	
	@Test(priority=56)
	public void m2abendetailsWoKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails("");
		response =sendReq(request, "m2a benificiary details Without Keyword");
		assertResponse(response);
	}
	
	@Test(priority=57)
	public void m2abendetailsWKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary details With Keyword");
		assertResponse(response);
	}
	
	@Test(priority=58)
	public void m2abenderegsearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch("");
		response =sendReq(request, "m2a benificiary deregistration search without keyword");
		assertResponse(response);
	}
	
	@Test(priority=59)
	public void m2abenderegsearchWKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	@Test(priority=60)
	public void m2aBenDereg() throws IOException, SQLException {
		request = StaticStore.m2aBenDereg(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	/*
	 * NEFT
	 */
	
	//@Test(priority=101)  Not available in TMB
	public void NEFTQuickFT() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT(prop.getProperty("BenAccountno"), prop.getProperty("AccountType"),
				prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"), 
				prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT Quick FT");
		assertResponse(response);
	}

	@Test(priority=102)
	public void NEFTbenreg() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary registration");
		//assertResponse(response);
	}
	
	@Test(priority=103)
	public void NEFTbenregconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary registration confirm");
		//assertResponse(response);
	}
	
	@Test(priority=104)
	public void NEFTbenlist() throws IOException, SQLException {
		request = StaticStore.NEFTbenlist();
		response =sendReq(request, "NEFT benificiary list");
		assertResponse(response);
	}
	
	@Test(priority=105)
	public void NEFTbenpayment() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("NeftAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT benificiary payment");
		//assertResponse(response);
	}
	
	@Test(priority=106)
	public void NEFTbendetail() throws IOException, SQLException {
		request = StaticStore.NEFTbendetail(prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary detail");
		assertResponse(response);
	}
	
	@Test(priority=107)
	public void NEFTbendereglist() throws IOException, SQLException {
		request = StaticStore.NEFTbendereglist("");
		response =sendReq(request, "NEFT benificiary de-registration list");
		assertResponse(response);
	}
	
	@Test(priority=108)
	public void NEFTbenderegconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenderegconfirm(prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary de-registration confirm");
		assertResponse(response);
	}
	
}
