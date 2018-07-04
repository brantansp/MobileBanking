package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;
import java.io.File;
import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class IMPS extends ExtentManager {
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup()
			.lookupClass().getSimpleName());

	public static void main(String[] args) {
		
	}
	
	@Test(groups = { "nonfinancial", "positive" })
	public void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = sendReq(request, TCID, "Generate MMID");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void RetrieveMMID() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = sendReq(request, TCID, "Retrieve MMID");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void CancelMMIDAll() throws IOException, SQLException {
		sendReq(StaticStore.generateMMID());
		request = StaticStore.cancelMMIDAll();
		response = sendReq(request, TCID, "Cancel MMID All");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void CancelMMIDSingle() throws IOException, SQLException {
		sendReq(StaticStore.generateMMID()); // calling generate MMID
		request = StaticStore.cancelMMIDSingle();
		response = sendReq(request, TCID, "Cancel MMID Single");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void AgainCancelAllMMIDs() throws IOException, SQLException {
		sendReq(StaticStore.generateMMID()); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		response = sendReq(request, TCID, "Again Cancel All MMIDs");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void RetrieveMMIDs() throws IOException, SQLException {
		sendReq(StaticStore.generateMMID()); // calling generate MMID
		request = StaticStore.retrieveMMID();
		response = sendReq(request, TCID, "Retrieve MMID");
		assertResponse(response);
	}

	@Test(groups = { "nonfinancial", "positive" })
	public void GenerateMMIDs() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = sendReq(request, TCID, "Generate MMID");
		assertResponse(response);
	}

	/*
	 * IMPS P2P
	 */

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		sendReq(StaticStore.generateMMID());
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2PInstantPayment");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PAddBeneficiaryPreConfirmation() throws IOException,
			SQLException {
		sendReq(StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname")));
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2PAddBeneficiaryconfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PBeneficiaryPaymentListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PPaySearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PBeneficiaryPaymentListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PPaySearch("");
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2PPayConf(prop.getProperty("IMPSBenNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PBeneficiarySearchListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PBenSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiarySearchListenquiryWKw");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PBeneficiarySearchListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PBenSearch("");
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PDeleteBeneficiaryListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PDelBenSearch("");
		response = sendReq(request, TCID, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PDeleteBeneficiaryListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2PDelBenSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

	/*
	 * IMPS P2P Negative
	 */

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentWithInvalidMMID() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PInstant(prop.getProperty("MobileNoforM1forP2P"),
						prop.getProperty("InvalidBenMMID"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment With Invalid MMID");
		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentWithExceededAmount() throws IOException,
			SQLException {
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(
				request,
				TCID,
				"IMPS P2P Instant Payment With Amount greater than Maximum amount to be transfered");
		assertTrue(response.substring(2, 4).contains("21"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentWithMinimumAmount() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(
				request,
				TCID,
				"IMPS P2P Instant Payment With Amount lesser than Minimum amount to be transfered");
		assertTrue(response.substring(2, 4).contains("20"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PBeneficiaryPaymentWithExceededAmount()
			throws IOException, SQLException {

		sendReq(StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"))); // Registering
														// Beneficiary for
														// payment

		request = StaticStore.impsP2PPayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(
				request,
				TCID,
				"IMPS P2P Instant Payment With Amount greater than Maximum amount to be transfered");
		assertTrue(response.substring(2, 4).contains("21"));

		sendReq(StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname"))); // Deleting benefiicary After
													// Payment
	}

	@Test(groups = { "financial", "negative" })
	public void iMPSP2PBeneficiaryPaymentConfirmationwithMinimumAmount()
			throws IOException, SQLException {

		sendReq(StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"))); // Registering
														// Beneficiary for
														// payment

		request = StaticStore.impsP2PPayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(
				request,
				TCID,
				"IMPS P2P Instant Payment With Amount lesser than Minimum amount to be transfered");
		assertTrue(response.substring(2, 4).contains("20"));

		sendReq(StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname"))); // Deleting benefiicary After
													// Payment

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM0Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM0forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M0");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM1Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM1forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M1");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM2Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM2forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M2");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM3Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM3forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M3");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM4Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM4forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M4");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM5Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM5forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M5");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentForM6Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNoforM6forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPS P2P Instant Payment Declines with response code  M6");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentfor92Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNofor92forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2PInstantPaymentfor92Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentfor13Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNofor13forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2PInstantPaymentfor13Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PInstantPaymentfor51Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2PInstant(
				prop.getProperty("MobileNofor51forP2P"),
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2PInstantPaymentfor51Decline");
		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PAddBeneficiaryWithExistingNickname() throws IOException,
			SQLException {

/*		sendReq(StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"))); // Registering
														// Beneficiary for
														// payment
*/
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);

		sendReq(StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname"))); // Deleting benefiicary After
													// Payment
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PAddBeneficiaryRegMobileWithOtherNickname()
			throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname1"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PBeneficiaryPaymentListenquiryWithRandomNickname()
			throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PBeneficiaryPaymentConfirmationWithRandomNickname()
			throws IOException, SQLException {
		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PDeleteAlreadydeletedBen() throws IOException,
			SQLException {
		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM0Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM0forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");

		assertTrue(response.substring(2, 4).contains("M0"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM1Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM1forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM1Decline");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");

		assertTrue(response.substring(2, 4).contains("M1"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM2Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM2forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM2Decline");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");

		assertTrue(response.substring(2, 4).contains("M2"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM3Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM3forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM3Decline");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PDeleteBeneficiaryConfirmation");

		assertTrue(response.substring(2, 4).contains("M3"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM4Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM4forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM4Decline");

		assertTrue(response.substring(2, 4).contains("M4"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM5Decline() throws IOException,
			SQLException {

		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM5forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM5Decline");
		assertTrue(response.substring(2, 4).contains("M5"));

	}

	@Test(groups = { "financial", "negative" })
	public void IMPSP2PRegBeneficiaryPaymentForM6Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2PAddBen(prop.getProperty("MobileNoforM6forP2P"),
						prop.getProperty("BenMMID"),
						prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PAddBeneficiaryPreConfirmation");

		request = StaticStore
				.impsP2PPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);

		request = StaticStore.impsP2PDelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2PRegBeneficiaryPaymentForM6Decline");
		assertTrue(response.substring(2, 4).contains("M6"));

	}

	// IMPS P2A

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2AInstantPayment() throws IOException, SQLException {

		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPayment");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2AConfBen(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiaryconfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ABeneficiaryPaymentListenquiryWkW() throws IOException,
			SQLException {
		request = StaticStore.impsP2APaySearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ABeneficiaryPaymentListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2APaySearch("");
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2APayConf(prop.getProperty("IMPSBenNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ABeneficiarySearchListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2ABenDetailSearch("");
		response = sendReq(request, TCID, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ABeneficiarySearchListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2ABenDetailSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException,
			SQLException {
		request = StaticStore.impsP2ADelBenSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2ADeleteBeneficiaryListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive", "p2a" })
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ADeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

	@Test
	public void IMPSP2AInstantPaymentWithRandomAccandIFSCcode()
			throws IOException, SQLException {
		request = StaticStore
				.impsP2AInstant(prop.getProperty("InvalidIMPSBenAcNo"),
						prop.getProperty("InvalidIMPSIFSC"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2AInstantPaymentWithRandomAccandIFSCcode");
		assertTrue(response.substring(2, 4).contains("09"));
	}

	@Test
	public void IMPSP2AInstantPaymentWithExceededAmount() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSIFSC"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2AInstantPaymentWithExceededAmount");
		assertTrue(response.substring(2, 4).contains("21"));
	}

	@Test
	public void IMPSP2AInstantPaymentWithInsufficientAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSIFSC"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2AInstantPaymentWithInsufficientAmount");
		assertTrue(response.substring(2, 4).contains("20"));
	}

	@Test
	public void IMPSP2AAddBeneficiaryWithRandomAccandIFSCcode()
			throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("InvalidIMPSBenAcNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("InvalidIMPSIFSC"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2AAddBeneficiaryWithRandomAccandIFSCcode");
		assertTrue(response.substring(2, 4).contains("09"));
	}

	@Test
	public void IMPSP2ABeneficiaryPaymentConfirmationWithExceedeAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmationWithExceedeAmount");
		assertTrue(response.substring(2, 4).contains("21"));
	}

	@Test
	public void IMPSP2ABeneficiaryPaymentConfirmationWithInsufficientAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"),
				prop.getProperty("BenMMID"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request);
		
		request = StaticStore.impsP2APayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmationWithInsufficientAmount");
		assertTrue(response.substring(2, 4).contains("20"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM0Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM0forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM0Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM1Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM1forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM1Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM2Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM2forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM2Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM3Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM3forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM3Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM4Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM4forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM4Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM5Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM5forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM5Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentForM6Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNoforM6forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentForM6Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentfor92Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNofor92forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentfor92Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentfor13Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNofor13forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentfor13Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AInstantPaymentfor51Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AInstant(
				prop.getProperty("AccNofor51forP2A"),
				prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2AInstantPaymentfor51Decline");

		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2AAddBeneficiaryWithExistingNickname() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo1"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}

	@Test
	public void IMPSP2AAddBeneficiaryRegMobileWithOtherNickname()
			throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("IMPSBenNickname1"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}

	@Test
	public void IMPSP2ABeneficiaryPaymentListenquiryWithRandomNickname()
			throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}

	@Test
	public void IMPSP2ABeneficiaryPaymentWithRandomNickname()
			throws IOException, SQLException {
		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM0Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM0forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM0Decline");

		assertTrue(response.substring(2, 4).contains("M0"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM1Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM1forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM1Decline");
		assertTrue(response.substring(2, 4).contains("M1"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM2Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM2forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM2Decline");
		assertTrue(response.substring(2, 4).contains("M2"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM3Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM3forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM3Decline");

		assertTrue(response.substring(2, 4).contains("M3"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM4Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM4forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM4Decline");
		assertTrue(response.substring(2, 4).contains("M4"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM5Decline() throws IOException,
			SQLException {
		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM5forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM5Decline");

		assertTrue(response.substring(2, 4).contains("M5"));

	}

	@Test
	public void IMPSP2ARegBeneficiaryPaymentForM6Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2AAddBen(
				prop.getProperty("AccNoforM6forP2A"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2AAddBeneficiary");

		request = StaticStore
				.impsP2APayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2ABeneficiaryPaymentConfirmation");

		request = StaticStore.impsP2ADelBenConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2ARegBeneficiaryPaymentForM6Decline");

		assertTrue(response.substring(2, 4).contains("M6"));

	}

	// IMPS P2U

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPayment");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UAddBenPreConf() throws IOException, SQLException {
		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UAddBeneficiaryconfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2UAddBenConf(
				prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UBeneficiaryPaymentListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenPayListEnq(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2UBeneficiaryPaymentListenquiryWKw");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UBeneficiaryPaymentListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenPayListEnq("");
		response = sendReq(request, TCID,
				"IMPSP2UBeneficiaryPaymentListenquiryWoKw");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UBeneficiaryPaymentConfirmation() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("IMPSBenNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");
		assertResponse(response);

	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UBeneficiarySearchListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenDetailsSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2UBeneficiarySearchListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UBeneficiarySearchListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenDetailsSearch("");
		response = sendReq(request, TCID,
				"IMPSP2UBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UDeleteBeneficiaryListenquiryWKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenDelSearch(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UDeleteBeneficiaryListenquiryWoKw() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenDelSearch("");
		response = sendReq(request, TCID, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}

	@Test(groups = { "financial", "positive" })
	public void IMPSP2UDeleteBeneficiaryConfirmation() throws IOException,
			SQLException {
		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID,
				"IMPSP2UDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

	@Test
	public void IMPSP2UInstantPaymentWithInvalidAadhar() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("InvalidIMPSAadharNo"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2UInstantPaymentWithInvalidAadhar");
		assertResponse(response);
	}

	@Test
	public void IMPSP2UInstantPaymentWithExceededAmount() throws IOException,
			SQLException {
		request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2UInstantPaymentWithExceededAmount");
		assertTrue(response.substring(2, 4).contains("21"));
	}

	@Test
	public void IMPSP2UInstantPaymentWithInsufficientAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2UInstantPaymentWithInsufficientAmount");
		assertTrue(response.substring(2, 4).contains("20"));
	}

	@Test
	public void IMPSP2UBeneficiaryPaymentConfirmationWithExceededAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("ExceededAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2UBeneficiaryPaymentConfirmationWithExceededAmount");
		assertTrue(response.substring(2, 4).contains("21"));

	}

	@Test
	public void IMPSP2UBeneficiaryPaymentConfirmationWithInsufficientAmount()
			throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayConf(
				prop.getProperty("IMPSBenNickname"),
				prop.getProperty("InsufficientAmount"),
				prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID,
				"IMPSP2UBeneficiaryPaymentConfirmationWithInsufficientAmount");
		assertTrue(response.substring(2, 4).contains("20"));

	}

	@Test
	public void IMPSP2UAddBenPreConfwithInvalidAadharNo() throws IOException,
			SQLException {
		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("InvalidIMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");
		assertResponse(response);
	}

	@Test
	public void IMPSP2UInstantPaymentForM0Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM0P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM0Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentForM1Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM1P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM1Decline");
		assertTrue(response.substring(2, 4).contains("57"));
	}

	@Test
	public void IMPSP2UInstantPaymentForM2Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM2P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM2Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentForM3Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM3P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM3Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentForM4Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM4P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM4Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentForM5Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM5P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM5Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentForM6Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNoforM6P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentForM6Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentfor92Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNofor92P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentFor92Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentfor13Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNofor13P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentFor13Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UInstantPaymentfor51Decline() throws IOException,
			SQLException {
		request = StaticStore
				.impsP2UInstant(prop.getProperty("AadharNofor51P2U"),
						prop.getProperty("IMPSAccType"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UInstantPaymentFor51Decline");
		assertTrue(response.substring(2, 4).contains("57"));

	}

	@Test
	public void IMPSP2UAddBeneficiaryWithExistingNickname() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("IMPSAadharNo1"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("IMPSBenNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");
		assertResponse(response);

	}

	@Test
	public void IMPSP2UAddBeneficiaryRegMobileWithOtherNickname()
			throws IOException, SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("IMPSBenNickname1"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");
		assertResponse(response);

	}

	@Test
	public void IMPSP2UBeneficiaryPaymentListenquiryWithRandomNickname()
			throws IOException, SQLException {
		request = StaticStore.impsP2UBenDetailsSearch(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "IMPSP2UBeneficiarySearchListenquiry");
		assertResponse(response);

	}

	@Test
	public void IMPSP2UBeneficiaryPaymentWithRandomNickname()
			throws IOException, SQLException {

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");
		assertResponse(response);
	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM0Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM0P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM0Decline");

		assertTrue(response.substring(2, 4).contains("M0"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM1Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM1P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM1Decline");

		assertTrue(response.substring(2, 4).contains("M1"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM2Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM2P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM2Decline");

		assertTrue(response.substring(2, 4).contains("M2"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM3Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM3P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM3Decline");

		assertTrue(response.substring(2, 4).contains("M3"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM4Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM4P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM4Decline");

		assertTrue(response.substring(2, 4).contains("M4"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM5Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM5P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM5Decline");

		assertTrue(response.substring(2, 4).contains("M5"));

	}

	@Test
	public void IMPSP2URegBeneficiaryPaymentForM6Decline() throws IOException,
			SQLException {

		request = StaticStore.impsP2UAddBenPreConf(
				prop.getProperty("AadharNoforM6P2U"),
				prop.getProperty("IMPSAccType"),
				prop.getProperty("RandomNickname"));
		response = sendReq(request, TCID, "impsP2UAddBenPreConf");

		request = StaticStore
				.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
						prop.getProperty("IMPSAmount"),
						prop.getProperty("IMPSRemarks"));
		response = sendReq(request, TCID, "IMPSP2UAddBeneficiaryconfirmation");

		request = StaticStore.impsP2UBenDelConf(prop
				.getProperty("RandomNickname"));
		response = sendReq(request, TCID,
				"IMPSP2URegBeneficiaryPaymentForM6Decline");

		assertTrue(response.substring(2, 4).contains("M6"));

	}
	
}

