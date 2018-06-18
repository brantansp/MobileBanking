package mBankingControlCenter;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

public class Payment extends ExtentManager{
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test(groups = { "financial", "positive" })
	public void Billercategorylist() throws IOException, SQLException {
		request = StaticStore.Billercategorylist();
		response =sendReq(request, TCID , "Billercategorylist");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void billerlist() throws IOException, SQLException {
		request = StaticStore.billerlist("000000000057");
		response =sendReq(request, TCID , "BillerList");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void billerregisration() throws IOException, SQLException {
		request = StaticStore.billerregisration("000000000057");
		response =sendReq(request, TCID , "Biller Registration");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void biilerregistrationconfirm() throws IOException, SQLException {
		request = StaticStore.biilerregistrationconfirm("000000000057","Birla Sunlife,Mumbai","228875554","5278775554","likha");
		response =sendReq(request, TCID , "Biller Registration Confirm");
		assertResponse(response);
	}

	
	@Test(groups = { "financial", "positive" })
	public void Accountselectionbiilerlist() throws IOException, SQLException {
		request = StaticStore.Accountselectionbiilerlist();
		response =sendReq(request, TCID , "Account selection biiler list");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void biilerlistselection() throws IOException, SQLException {
		request = StaticStore.biilerlistselection("gfxv");
		response =sendReq(request, TCID , "Biller List Selection");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void RegBillerpay() throws IOException, SQLException {
		request = StaticStore.RegBillerpay("gfxv");
		response =sendReq(request, TCID , "Register Biller Pay");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void RegBillerpayconfirm() throws IOException, SQLException {
		request = StaticStore.RegBillerpayconfirm("gfxv","100","");
		response =sendReq(request, TCID , "Register Biller Pay Confirm");
		assertResponse(response);
	}
	
	
	@Test(groups = { "financial", "positive" })
	public void biilerderegselection() throws IOException, SQLException {
		request = StaticStore.biilerderegselection();
		response =sendReq(request, TCID , "Biller Registration selection");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void AdHocBillercategorylist() throws IOException, SQLException {
		request = StaticStore.AdHocBillercategorylist();
		response =sendReq(request, TCID , "AdHoc Biller Category List");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void AdHocbillerlist() throws IOException, SQLException {
		request = StaticStore.AdHocbillerlist("000000000057");
		response =sendReq(request, TCID , "AdHoc Biller List");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void billerlistselection() throws IOException, SQLException {
		request = StaticStore.billerlistselection("Birla Sunlife,Mumbai");
		response =sendReq(request, TCID , "Biller List Selection");
		assertResponse(response);
	}
	
	@Test(groups = { "financial", "positive" })
	public void Adhocpayconfirm() throws IOException, SQLException {
		request = StaticStore.Adhocpayconfirm("Birla Sunlife,Mumbai","228881554","528885554","100","807415244998");
		response =sendReq(request, TCID , "AdHoc Pay Confirm");
		assertResponse(response);
	}
}
