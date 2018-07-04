package mBankingControlCenter;

import java.io.IOException;
import java.sql.SQLException;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;

import org.testng.annotations.Test;

public class DebitCardControl extends ExtentManager {

	private static String response;
	public static String request;

	// 

	@Test(groups = { "nonfinancial", "positive" })
	public void GenerateMMID() throws IOException, SQLException {
		
	}
	
	public static void main(String[] args) throws IOException, SQLException {

		request = StaticStore.AddDebitCard("9766201050","566802070000211");
		response = sendReq(request, "001", "Generate MMID");
		assertResponse(response);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
