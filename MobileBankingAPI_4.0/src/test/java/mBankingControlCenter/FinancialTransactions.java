package mBankingControlCenter;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import java.io.IOException;
import java.sql.SQLException;

public class FinancialTransactions extends ExtentManager{
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test(priority=1)
	public void m2mQuickFT() throws IOException, SQLException {
		request = StaticStore.m2mQuickFT("9894060407","20","rtj");
		response =sendReq(request, "m2m Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void m2mBenAcclist() throws IOException, SQLException {
		request = StaticStore.m2mBenAcclist("","");
		response =sendReq(request, "m2m Benificiary Account list");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void m2mBenReg() throws IOException, SQLException {
		request = StaticStore.m2mBenReg("","","");
		response =sendReq(request, "m2m Benificiary Registration");
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void m2mRegbensearch() throws IOException, SQLException {
		request = StaticStore.m2mRegbensearch();
		response =sendReq(request, "m2m Register benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void m2mbenpayment() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment("","","");
		response =sendReq(request, "m2m benificiary payment");
		assertResponse(response);
	}
	
	@Test(priority=6)
	public void m2mbensearch() throws IOException, SQLException {
		request = StaticStore.m2mbensearch("");
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void m2mbendelsearch() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch("");
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(priority=8)
	public void P2Pbendelete() throws IOException, SQLException {
		request = StaticStore.P2Pbendelete("");
		response =sendReq(request, "P2P benificiary delete");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void P2AQuickFT() throws IOException, SQLException {
		request = StaticStore.P2AQuickFT("","","");
		response =sendReq(request, "P2A Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=10)
	public void m2abenreg() throws IOException, SQLException {
		request = StaticStore.m2abenreg("","","");
		response =sendReq(request, "m2a benificary registration");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void m2abensearchreq() throws IOException, SQLException {
		request = StaticStore.m2abensearchreq("","","");
		response =sendReq(request, "m2a benificiary search req");
		assertResponse(response);
	}
	
	@Test(priority=12)
	public void m2abendetails() throws IOException, SQLException {
		request = StaticStore.m2abendetails("");
		response =sendReq(request, "m2a benificiary details");
		assertResponse(response);
	}
	
	@Test(priority=13)
	public void m2abenderegsearch() throws IOException, SQLException {
		request = StaticStore.m2abenderegsearch("");
		response =sendReq(request, "m2a benificiary deregistration search");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void NEFTQuickFT() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT("","","","","");
		response =sendReq(request, "NEFT Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void NEFTbenreg() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg("","","","");
		response =sendReq(request, "NEFT benificiary registration");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void NEFTbenregconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm("","","","");
		response =sendReq(request, "NEFT benificiary registration confirm");
		assertResponse(response);
	}
	
	@Test(priority=17)
	public void NEFTbenlist() throws IOException, SQLException {
		request = StaticStore.NEFTbenlist();
		response =sendReq(request, "NEFT benificiary list");
		assertResponse(response);
	}
	
	@Test(priority=18)
	public void NEFTbenpayment() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment("","","");
		response =sendReq(request, "NEFT benificiary payment");
		assertResponse(response);
	}
	
	@Test(priority=19)
	public void NEFTbendetail() throws IOException, SQLException {
		request = StaticStore.NEFTbendetail("");
		response =sendReq(request, "NEFT benificiary detail");
		assertResponse(response);
	}
	
	@Test(priority=20)
	public void NEFTbendereglist() throws IOException, SQLException {
		request = StaticStore.NEFTbendereglist("");
		response =sendReq(request, "NEFT benificiary de-registration list");
		assertResponse(response);
	}
	
	@Test(priority=21)
	public void NEFTbenderegconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenderegconfirm("");
		response =sendReq(request, "NEFT benificiary de-registration confirm");
		assertResponse(response);
	}
	
//-------------------------------------------------------------------------------->

	@Test(priority=50)
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		StaticStore.generateMMID();
		request = StaticStore.impsP2PInstant("9352478845", "9240123", "7", "dfsjh");
		response =sendReq(request, "IMPSP2PInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=51)
	public void IMPSP2AInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2AInstant("3727163937362819373", "HDFC0000001", "10", "tehry");
		response =sendReq(request, "IMPSP2AInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=52)
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2UInstant("", "", "");
		response =sendReq(request, "IMPSP2UInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=53)
	public void IMPSP2PAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen( "9240143", "9372616576", "yashuuuu");
		response =sendReq(request, "IMPSP2PAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=54)
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PConfBen( "9240143", "9372616576", "yashuuuu");
		response =sendReq(request, "IMPSP2PAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=55)
	public void IMPSP2PBeneficiarySearchListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch( "niiki");
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=56)
	public void IMPSP2PDeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=57)
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenConf( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=58)
	public void IMPSP2PBeneficiaryPaymentListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch("niiki");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=59)
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf("20", "trans","yashuuuu");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test(priority=60)
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen( "6473839242827281547", "SA", "HDFC0000002", "nickii");
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=61)
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2AConfBen( "6473839242827281547", "SA", "HDFC0000002", "nickii");
		response =sendReq(request, "IMPSP2AAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=62)
	public void IMPSP2ABeneficiarySearchListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ABenSearch( "");
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=63)
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenSearch( "");
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=64)
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenConf( "");
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=65)
	public void IMPSP2ABeneficiaryPaymentListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch( "nickii");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=66)
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf( "nickii","10", "gffsa");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	
	//-----------------------------------------P2U Update Index value
	
	@Test(priority=67)
	public void IMPSP2UAddBeneficiary() throws IOException, SQLException {
/*		index=23;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
	@Test(priority=68)
	public void IMPSP2UAddBeneficiaryconfirmation() throws IOException, SQLException {
/*		index=24;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
	@Test(priority=69)
	public void IMPSP2UBeneficiarySearchListenquiry() throws IOException, SQLException {
/*		index=25;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
	@Test(priority=70)
	public void IMPSP2UDeleteBeneficiaryListenquiry() throws IOException, SQLException {
/*		index=26;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
	@Test(priority=71)
	public void IMPSP2UDeleteBeneficiaryConfirmation() throws IOException, SQLException {

	}
	
	@Test(priority=72)
	public void IMPSP2UBeneficiaryPaymentListenquiry() throws IOException, SQLException {
/*		index=28;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
	@Test(priority=73)
	public void IMPSP2UBeneficiaryPaymentConfirmation() throws IOException, SQLException {
/*		index=29;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);*/
	}
	
}














