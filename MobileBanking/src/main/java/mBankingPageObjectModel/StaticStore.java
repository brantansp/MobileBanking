package mBankingPageObjectModel;

import java.util.Properties;

import mBankingUtilityCenter.ExcelReader;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.RandomNumGenerator;

public class StaticStore extends ExtentManager{
	
	static StringBuilder sb = new StringBuilder() ;
	static Properties prop=getProperty();
	
	public static void main(String[] args) 
	{
		System.out.println(prop.getProperty("RemAccountno")+";");
		
	}
	
	public static String appLogin ()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APSY;");
		sb.append("2;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String balanceEnq (String remAccountno)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APBE;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(remAccountno+";");
		return sb.toString();
	}
	
	public static String balanceEnq ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APBE;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String miniStatement ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APMS;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String transactionHistory ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APTH;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String generateMMID ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APIM;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String retrieveMMID ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APS6;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("RemAccountno")+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String cancelMMIDAll ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APRC;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("ALL;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String cancelMMIDSingle ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APRC;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("RemAccountno")+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String emailIDFetch ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APZ6;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String updateEmailID (String emailID)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APZ3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(emailID+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String chequeStatus (String chqNo)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APLW;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(chqNo+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String stopCheque (String chqNo)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APL4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(chqNo+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	// NA
	
	public static String Accountfetch ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APSY;");
	    sb.append("0001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		return sb.toString();
	}
	
	// NA
	public static String changeloginpwd (String newpassword)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APP5;");
		sb.append(newpassword+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		return sb.toString();
	}
	
	//Financial Transactions		
	//IMPS Instant Payment
	public static String impsP2PInstant (String benMobNo, String benMMID, String amount, String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APQI;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMobNo+";");
		sb.append(benMMID+";");
		sb.append(amount+";");
		sb.append(remark+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2AInstant (String benAcNo, String benIFSC, String amount, String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK1;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benAcNo+";");
		sb.append(prop.getProperty("RemAccountType")+";");
		sb.append(benIFSC+";");
		sb.append(amount+";");
		sb.append(remark+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2UInstant (String aadharNo,  String amount, String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APQI;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(aadharNo+";");
		sb.append(prop.getProperty("RemAccountType")+";");
		sb.append(amount+";");
		sb.append(remark+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	//IMPS Registration Payments
	public static String impsP2PAddBen ( String benMMID,String benMobNo, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW1;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMMID+";");
		sb.append(benMobNo+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno;")+";");
		return sb.toString();
	}
	
	public static String impsP2PConfBen ( String benMMID,String benMobNo, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW2;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMMID+";");
		sb.append(benMobNo+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APD9;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PDelBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PDelBenConf (String benName)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2PPaySearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("P;");
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2PPayConf (String amount,String remark,String benName)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(amount+";");
		sb.append(remark+ ";");
		sb.append(benName+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2AAddBen (String accNo,  String accType, String ifsccode, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK2;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(accNo+";");
		sb.append(accType+";");
		sb.append(ifsccode+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2AConfBen (String accNo,  String accType, String ifsccode, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(accNo+";");
		sb.append(accType+";");
		sb.append(ifsccode+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2ABenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APD9;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2ADelBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2ADelBenConf (String benName)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2APaySearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("1;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2APayConf (String benName,String amount,String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK5;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append(amount+";");
		sb.append(remark+ ";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	
	//
	// *** UNBI payments-Bill Pay ***//
	
	// *** Biller Registration ***//
	public static String Billercategorylist()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB2;");
        sb.append("P;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerlist(String Typeofbiller)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB9;");
		sb.append(Typeofbiller+";");
        sb.append("P;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerregisration(String Typeofbillerlist)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(Typeofbillerlist+";");
        sb.append("P;");
	    sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	public static String biilerregistrationconfirm (String Typeofbiller, String Typeofbillerlist, String Field1, String Field2, String Nickname	)
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APB4;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(Typeofbiller+";");
	    sb.append(Typeofbillerlist+";");
	    sb.append("2;");
	    sb.append(Field1+":");
	    sb.append(Field2+";");
	    sb.append(Nickname+";");
	    sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	 
	
	// *** Registered Bill Payment ***//
	
	public static String Accountselectionbiilerlist()
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBX;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String biilerlistselection(String Registerdbiller1)
	{ 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBW;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String RegBillerpay(String Registerdbiller1)
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("AP1B;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("A;");
	    sb.append(Registerdbiller1+";");
	    sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String RegBillerpayconfirm(String Registerdbiller1, String Amount, String transactionId)
	{
		sb.delete(0, sb.length());
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APB6;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
	    sb.append("P;");
	    sb.append("5044821053000059;");
	    sb.append(Amount+";");
	    sb.append(transactionId+";");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	// *** Biller Deregistration ***//
	
	public static String biilerderegselection()
	{
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBZ;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("001;");
        sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String biilerderegister(String Registerdbiller1)
	{
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBY;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
        sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	// *** Adhoc Bill Payment***//
	
	public static String AdHocBillercategorylist()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB2;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
        sb.append("A;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String AdHocbillerlist(String Typeofbiller)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDW;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbiller+";");
        sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerlistselection(String Typeofbillerlist)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDT;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbillerlist+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Adhocpayconfirm(String Typeofbillerlist, String Field1, String Field2, String Amount, String Transactionid	)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDM;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbillerlist+";");
		sb.append(Field1+";");
		sb.append(Field2+";");
		sb.append(Amount+";");
		sb.append(Transactionid+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Rechargelist ()
	{
	   // sb.delete(0, sb.length());
		StringBuilder sb = new StringBuilder() ;
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("AP2T;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
	    {
	    sb.append(prop.getProperty("mPINRequired")+";");
	    sb.append(prop.getProperty("mPIN")+";");
	    }
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("0001;");
	    sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno"));
	    return sb.toString();
	}
	
	public static String Operatorsearch(String TypeofRecharge, String searchfield1)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP2T;");
		  if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(searchfield1+";");
	    sb.append("MTP:DTH:DTC;");
		sb.append("0001;");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Rechargeconfirm(String TypeofRecharge, String searchresult, String RechargeMobNo,String RechargeAmount,String TransactionId )
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP3T;");
		  if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(searchresult+";");
		sb.append("O;");
		sb.append("MTP:DTH:DTC;");
		sb.append(RechargeMobNo+";");
		sb.append(RechargeAmount+";");
		sb.append(prop.getProperty("RechargeNickname")+";");
		sb.append(TransactionId+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String RechargeStatusEnq(String TypeofRecharge, String TransactionId )
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP7T;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(TransactionId+";");
		sb.append("1;");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	//** Fund Transfer within bank **//
		// 
		public static String m2mQuickFT(String BenMobileNo,String Amount,String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQM;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(BenMobileNo+";");
			sb.append(Amount+";");
			sb.append(Remarks+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mBenAcclist(String BenMobileNo,String Nickname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APRM;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(BenMobileNo+";");
			sb.append(Nickname+";");
			sb.append("0001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
			
		public static String m2mBenReg(String BenAccountno,String Nickname,String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APC1;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(prop.getProperty("BenMobileNo")+";");
			sb.append(Nickname+";");
			sb.append(BenAccountno+";");
			sb.append("0001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mRegbensearch()
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APF1;");
			sb.append("P;");
			sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbenpayment(String Benregname, String Amount,String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APFT;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(Amount+";");
			sb.append(Remarks+";");
			sb.append(Benregname+";");
			sb.append("P;");
			sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbensearch(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APD5;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbendelsearch(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP2L;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String P2Pbendelete(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP2D;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String P2AQuickFT(String BenAccountno,String AccountType,String Amount)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQT;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(BenAccountno+";");
	        sb.append(AccountType+";");
	        sb.append(Amount+";");
	        sb.append(prop.getProperty("FTRemarks")+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2abenreg(String BenAccountno,String AccountType,String Amount)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQT;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(BenAccountno+";");
	        sb.append(AccountType+";");
	        sb.append(Amount+";");
	        sb.append(prop.getProperty("FTRemarks")+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}

		public static String m2abensearchreq(String BenAccountno,String AccountType,String Amount)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APF2;");
		    sb.append(BenAccountno+";");
	        sb.append("P;");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		//** need to add P2Abenpayment **//
		public static String m2abendetails(String searchfield1)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APD6;");
		    sb.append(searchfield1+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}

		public static String m2abenderegsearch(String searchfield1)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP3L;");
		    sb.append(searchfield1+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		//** need to add P2Abendereg **//
		
		//** Fund Transfer-otherbank NEFT**//
		public static String NEFTQuickFT(String benaccountno,String accounttype,String benIFSCcode,String benname, String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQN;");
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
		    sb.append(Remarks+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}

		public static String NEFTbenreg(String benaccountno,String accounttype,String benIFSCcode,String benname )
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ2;");
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenregconfirm(String benaccountno,String accounttype,String benIFSCcode,String benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ3;");
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenlist()
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ7;");
		    sb.append("P;");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenpayment(String Amount,String Benname, String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ8;");
		    sb.append(Amount+";");
		    sb.append(Remarks+";");
		    sb.append(Benname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
	
		public static String NEFTbendetail(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APNL;");
		    sb.append("N;");
		    sb.append(Benname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
	
		public static String NEFTbendereglist(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP4L;");
		    sb.append("N;");
		    sb.append(Benname+";");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenderegconfirm(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP4D;");
		    sb.append("N;");
		    sb.append(Benname+";");
		    sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno"));
			return sb.toString();
		}


}
