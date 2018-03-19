package mBankingControlCenter;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mBankingBasePageObject.BaseObject;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class FinancialTransactions extends ExtentManager{
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2PInstant("9352478845", "9240123", "7", "dfsjh");
		response =sendReq(request, "IMPSP2PInstantPayment");
		assertResponse(response);
	}
	
	//Billercategorylist
	@Test
	public void Billercategorylist() throws IOException, SQLException {
		request = StaticStore.Billercategorylist();
		response =sendReq(request, "Billercategorylist");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2AInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2AInstant("3727163937362819373", "HDFC0000001", "10", "tehry");
		response =sendReq(request, "IMPSP2AInstantPayment");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2UInstant("", "", "");
		response =sendReq(request, "IMPSP2UInstantPayment");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen( "9240143", "9372616576", "yashuuuu");
		response =sendReq(request, "IMPSP2PAddBeneficiary");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PConfBen( "9240143", "9372616576", "yashuuuu");
		response =sendReq(request, "IMPSP2PAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PBeneficiarySearchListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch( "niiki");
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenConf( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PBeneficiaryPaymentListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch("niiki");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf("20", "trans","yashuuuu");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen( "6473839242827281547", "SA", "HDFC0000002", "nickii");
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2AConfBen( "6473839242827281547", "SA", "HDFC0000002", "nickii");
		response =sendReq(request, "IMPSP2AAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2ABeneficiarySearchListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ABenSearch( "");
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenSearch( "");
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenConf( "");
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch( "nickii");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf( "nickii","10", "gffsa");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	
	//-----------------------------------------P2U Update Index value
	
	@Test
	public void IMPSP2UAddBeneficiary() throws IOException, SQLException {
		index=23;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UAddBeneficiaryconfirmation() throws IOException, SQLException {
		index=24;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UBeneficiarySearchListenquiry() throws IOException, SQLException {
		index=25;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UDeleteBeneficiaryListenquiry() throws IOException, SQLException {
		index=26;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		index=27;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UBeneficiaryPaymentListenquiry() throws IOException, SQLException {
		index=28;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		index=29;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	

}














