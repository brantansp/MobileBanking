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

public class PaymentTransactions extends ExtentManager{

	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	

	@Test(priority=0)
	public void Billercategorylist() throws IOException, SQLException {
		request = StaticStore.Billercategorylist();
		response =sendReq(request, "Billercategorylist");
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void billerlist() throws IOException, SQLException {
		request = StaticStore.billerlist("000000000057");
		response =sendReq(request, "BillerList");
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void billerregisration() throws IOException, SQLException {
		request = StaticStore.billerregisration("000000000057");
		response =sendReq(request, "Biller Registration");
		assertResponse(response);
	}
	
	
	@Test(priority=3)
	public void biilerregistrationconfirm() throws IOException, SQLException {
		request = StaticStore.biilerregistrationconfirm("000000000057","Birla Sunlife,Mumbai","228875554","5278775554","likha");
		response =sendReq(request, "Biller Registration Confirm");
		assertResponse(response);
	}

	
	@Test(priority=4)
	public void Accountselectionbiilerlist() throws IOException, SQLException {
		request = StaticStore.Accountselectionbiilerlist();
		response =sendReq(request, "Account selection biiler list");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void biilerlistselection() throws IOException, SQLException {
		request = StaticStore.biilerlistselection("gfxv");
		response =sendReq(request, "Biller List Selection");
		assertResponse(response);
	}
	
	
	@Test(priority=6)
	public void RegBillerpay() throws IOException, SQLException {
		request = StaticStore.RegBillerpay("gfxv");
		response =sendReq(request, "Register Biller Pay");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void RegBillerpayconfirm() throws IOException, SQLException {
		request = StaticStore.RegBillerpayconfirm("gfxv","100","");
		response =sendReq(request, "Register Biller Pay Confirm");
		assertResponse(response);
	}
	
	
	@Test(priority=8)
	public void biilerderegselection() throws IOException, SQLException {
		request = StaticStore.biilerderegselection();
		response =sendReq(request, "Biller Registration selection");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void AdHocBillercategorylist() throws IOException, SQLException {
		request = StaticStore.AdHocBillercategorylist();
		response =sendReq(request, "AdHoc Biller Category List");
		assertResponse(response);
	}
	
	@Test(priority=10)
	public void AdHocbillerlist() throws IOException, SQLException {
		request = StaticStore.AdHocbillerlist("000000000057");
		response =sendReq(request, "AdHoc Biller List");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void billerlistselection() throws IOException, SQLException {
		request = StaticStore.billerlistselection("Birla Sunlife,Mumbai");
		response =sendReq(request, "Biller List Selection");
		assertResponse(response);
	}
	
	@Test(priority=12)
	public void Adhocpayconfirm() throws IOException, SQLException {
		request = StaticStore.Adhocpayconfirm("Birla Sunlife,Mumbai","228881554","528885554","100","807415244998");
		response =sendReq(request, "AdHoc Pay Confirm");
		assertResponse(response);
	}
	
	@Test(priority=13)
	public void Rechargelist() throws IOException, SQLException {
		request = StaticStore.Rechargelist();
		response =sendReq(request, "Recharge List");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void Operatorsearch() throws IOException, SQLException {
		request = StaticStore.Operatorsearch("MTP","dgha");
		response =sendReq(request, "Operator Search");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void Rechargeconfirm() throws IOException, SQLException {
		request = StaticStore.Rechargeconfirm("","","","","");
		response =sendReq(request, "Recharge Confirm");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void RechargeStatusEnq() throws IOException, SQLException {
		request = StaticStore.RechargeStatusEnq("","");
		response =sendReq(request, "Recharge Status Enquiry");
		assertResponse(response);
	}
	
	@Test(priority=17)
	public void m2mQuickFT() throws IOException, SQLException {
		request = StaticStore.m2mQuickFT("9894060407","20","rtj");
		response =sendReq(request, "m2m Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=18)
	public void m2mBenAcclist() throws IOException, SQLException {
		request = StaticStore.m2mBenAcclist("","");
		response =sendReq(request, "m2m Benificiary Account list");
		assertResponse(response);
	}
	@Test(priority=19)
	public void m2mBenReg() throws IOException, SQLException {
		request = StaticStore.m2mBenReg("","","");
		response =sendReq(request, "m2m Benificiary Registration");
		assertResponse(response);
	}
	@Test(priority=20)
	public void m2mRegbensearch() throws IOException, SQLException {
		request = StaticStore.m2mRegbensearch();
		response =sendReq(request, "m2m Register benificiary search");
		assertResponse(response);
	}
	@Test(priority=21)
	public void m2mbenpayment() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment("","","");
		response =sendReq(request, "m2m benificiary payment");
		assertResponse(response);
	}
	@Test(priority=22)
	public void m2mbensearch() throws IOException, SQLException {
		request = StaticStore.m2mbensearch("");
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	@Test(priority=23)
	public void m2mbendelsearch() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch("");
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	@Test(priority=24)
	public void P2Pbendelete() throws IOException, SQLException {
		request = StaticStore.P2Pbendelete("");
		response =sendReq(request, "P2P benificiary delete");
		assertResponse(response);
	}
	@Test(priority=25)
	public void P2AQuickFT() throws IOException, SQLException {
		request = StaticStore.P2AQuickFT("","","");
		response =sendReq(request, "P2A Quick FT");
		assertResponse(response);
	}
	@Test(priority=26)
	public void m2abenreg() throws IOException, SQLException {
		request = StaticStore.m2abenreg("","","");
		response =sendReq(request, "m2a benificary registration");
		assertResponse(response);
	}
	@Test(priority=27)
	public void m2abensearchreq() throws IOException, SQLException {
		request = StaticStore.m2abensearchreq("","","");
		response =sendReq(request, "m2a benificiary search req");
		assertResponse(response);
	}
	@Test(priority=28)
	public void m2abendetails() throws IOException, SQLException {
		request = StaticStore.m2abendetails("");
		response =sendReq(request, "m2a benificiary details");
		assertResponse(response);
	}
	@Test(priority=29)
	public void m2abenderegsearch() throws IOException, SQLException {
		request = StaticStore.m2abenderegsearch("");
		response =sendReq(request, "m2a benificiary deregistration search");
		assertResponse(response);
	}
	@Test(priority=30)
	public void NEFTQuickFT() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT("","","","","");
		response =sendReq(request, "NEFT Quick FT");
		assertResponse(response);
	}
	@Test(priority=31)
	public void NEFTbenreg() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg("","","","");
		response =sendReq(request, "NEFT benificiary registration");
		assertResponse(response);
	}
	@Test(priority=32)
	public void NEFTbenregconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm("","","","");
		response =sendReq(request, "NEFT benificiary registration confirm");
		assertResponse(response);
	}
	@Test(priority=33)
	public void NEFTbenlist() throws IOException, SQLException {
		request = StaticStore.NEFTbenlist();
		response =sendReq(request, "NEFT benificiary list");
		assertResponse(response);
	}
	@Test(priority=34)
	public void NEFTbenpayment() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment("","","");
		response =sendReq(request, "NEFT benificiary payment");
		assertResponse(response);
	}
	@Test(priority=35)
	public void NEFTbendetail() throws IOException, SQLException {
		request = StaticStore.NEFTbendetail("");
		response =sendReq(request, "NEFT benificiary detail");
		assertResponse(response);
	}
	@Test(priority=36)
	public void NEFTbendereglist() throws IOException, SQLException {
		request = StaticStore.NEFTbendereglist("");
		response =sendReq(request, "NEFT benificiary de-registration list");
		assertResponse(response);
	}
	@Test(priority=37)
	public void NEFTbenderegconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenderegconfirm("");
		response =sendReq(request, "NEFT benificiary de-registration confirm");
		assertResponse(response);
	}

}
