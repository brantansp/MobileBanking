package mBankingControlCenter;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class IMPSTransactions extends ExtentManager{
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
	 *  IMPS P2P 
	 */
	
	@Test(priority=0)
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void IMPSP2PAddBeneficiaryPreConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void IMPSP2PBeneficiaryPaymentListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void IMPSP2PBeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch("");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf(prop.getProperty("IMPSBenNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void IMPSP2PBeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiryWKw");
		assertResponse(response);
	}
	
	@Test(priority=6)
	public void IMPSP2PBeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch("");
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void IMPSP2PDeleteBeneficiaryListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void IMPSP2PDeleteBeneficiaryListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=8)
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}


	/*
	 * IMPS P2A 
	 */
	
	@Test(priority=101)
	public void IMPSP2AInstantPayment() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=102)
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=103)
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2AConfBen(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=104)
	public void IMPSP2ABeneficiaryPaymentListenquiryWkW() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=105)
	public void IMPSP2ABeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch("");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=106)
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=107)
	public void IMPSP2ABeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2ABenDetailSearch("");
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=108)
	public void IMPSP2ABeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2ABenDetailSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=109)
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=110)
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	/*
	 * IMPS P2U
	 */
	
	@Test(priority=201)
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=202)
	public void impsP2UAddBenPreConf() throws IOException, SQLException {
		request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "impsP2UAddBenPreConf");
			assertResponse(response);
	}
	
	@Test(priority=203)
	public void IMPSP2UAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UAddBenConf(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			assertResponse(response);
	}
	
	@Test(priority=204)
	public void IMPSP2UBeneficiaryPaymentListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayListEnq(prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "IMPSP2UBeneficiaryPaymentListenquiryWKw");
			assertResponse(response);
	}
	
	@Test(priority=205)
	public void IMPSP2UBeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayListEnq("");
			response =sendReq(request, "IMPSP2UBeneficiaryPaymentListenquiryWoKw");
			assertResponse(response);
	}
	
	@Test(priority=206)
	public void IMPSP2UBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("IMPSBenNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			assertResponse(response);

	}
	
	@Test(priority=207)
	public void IMPSP2UBeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDetailsSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UBeneficiarySearchListenquiry");
		assertResponse(response);
   }
	
	@Test(priority=208)
	public void IMPSP2UBeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDetailsSearch("");
		response =sendReq(request, "IMPSP2UBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
   }
	
	@Test(priority=209)
	public void IMPSP2UDeleteBeneficiaryListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=210)
	public void IMPSP2UDeleteBeneficiaryListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelSearch("");
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=211)
	public void IMPSP2UDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
		
}














