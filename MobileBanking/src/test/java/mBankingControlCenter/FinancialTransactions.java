package mBankingControlCenter;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mBankingBasePageObject.BaseObject;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class FinancialTransactions extends ExtentManager{
	private static String response;
	private static int index;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	@Test
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		index=13; 
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2AInstantPayment() throws IOException, SQLException {
		index=14;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		index=15;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PAddBeneficiary() throws IOException, SQLException {
		index=16;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		index=17;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PBeneficiarySearchListenquiry() throws IOException, SQLException {
		index=18;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryListenquiry() throws IOException, SQLException {
		index=19;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		index=20;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PBeneficiaryPaymentListenquiry() throws IOException, SQLException {
		index=21;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		index=22;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		index=23;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		index=24;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2ABeneficiarySearchListenquiry() throws IOException, SQLException {
		index=25;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		index=26;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		index=27;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentListenquiry() throws IOException, SQLException {
		index=28;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
	}
	
	@Test
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		index=29;
		response =BaseObject.buildRequest(index);
		BaseObject.assertResponse(response, index);
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
	
	public static void main(String[] args) throws IOException, SQLException {
        /**
         * For checking Single transactions
         */
		}
}














