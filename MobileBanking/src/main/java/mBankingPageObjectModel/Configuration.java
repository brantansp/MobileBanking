package mBankingPageObjectModel;

public class Configuration {
	
	public static String HMAC = "Y";
	public static String dbReport = "Y";
	public static String chequeMin=null;
	public static String chequeMax=null;
	public static String mobileType= null;
	public static String buildVersion= "4.0";
	public static String mobileScreenSize=null;
	public static String mobileDetails=null;
	public static boolean isForgotPassword= false;
   //public static String GprsURL="http://10.44.120.60:7020";
    public static String GprsURL="http://mobileprd.fssnet.co.in";
    public static String servlet = "/txnmpayportal/servlet/MQSender?request=";
    public static String mPINRequired = "Y";
    public static String mPIN = "41781320402139635621401969632506560255";
    public static String bankCode = "463795";
    public static String DUKPT = "123457";
    public static boolean mpinAtStart = false; 
	public static String RemMobileno = "9865928748";
	public static String RemAccountno= "161100350300067";
    public static String AppPwd = "1111";
    public static String BenMobileNo = "9790954696";
	public static String NotRegMobileNo = "9842798393";
	public static String BenMobileNo2 = "8754599510";
	public static String BenMMID = "9240123";
	public static String InitiatorMobNo = "8754533510";
	public static String NotActivatedMobNo = "9677155591";
	public static String MNickname = "Mobile";
	public static String BenAccountNo = "24140566612121";
	public static String InvalidAccountNo = "24140100022696";
	public static String InitiatorAccNo = "34545656756786";
	public static String BenAccountNo2 = "24140156456465";
	public static String RemAccountType = "SA";
	public static String BenIFSCCode = "HDFC0000001";
	public static String BenAadharNo = "789456123654";
	public static String NicknameP2P = "Appu";
	public static String NicknameP2A = "Babu";
	public static String BenAccType = "SA";
	public static String FTAmount = "200";
	public static String FTAmount1 = "2";
	public static String FTAmount2 = "9999999";
	public static String FTRemarks = "test";    	
	public static String FTBenSearch = "Mobile";
	public static String FTBenSearch1 = "Account";
	public static String BenSearchText = "";
	public static String BenName = "test";
	//************Test Input for Other Bank - NEFT*********//
	public static String BenNAccountNo = "24140100009637";
	public static String BenNAccountNo1 = "24140100009636";
	public static String NNickname = "NEFT";
	public static String NNickname1 = "NEFT1";
	public static String NEFT_IFSC = "ABHY0065003";
	public static String Inv_IFSC = "12345678901";
	public static String Initiator_IFSC = "ANDB0000054";	
	public static String NAmount = "200";
	public static String NAmount1 = "2";
	public static String NAmount2 = "9999999";
	public static String NRemarks = "";  	
	public static String NEFT_AccType = "SAVINGS"; 	
	public static String NBenSearch = "NEFT";
	public static String NBankname = "ANDHRA BANK";
	public static String NLocationname = "B";
	//*********Test Input for Request to Bank ********//
	public static String FromDate = "20062013";
	public static String ToDate = "20062014";
	public static String FutureDate = "20062019";
	//*********Test Input for Bill Pay Transaction Set ********//
	public static String BillerCategory = "INSURANCE";
	public static String BillerSubCategory = "INSURANCE";
	public static String BillerName1 = "Life Insurance";
	public static String Billeradhoc = "Life Insurance";
	public static String BillConsumerNo = "7000";
	public static String NicknameBP = "Robotium";
	public static String Billpayamount = "100";
	//*********Test Input for Recharge Transaction Set ********//
	public static String RechargeCategory = "Mobile Recharge";
	public static String OperatorName = "AIRTEL";
	public static String RechargeMobNo = "4950000003";
	public static String RechargeAmt = "100";
	public static String RechargeNickname = "Robotium 11";
	public static String RechargeNicknameAlready = "Robotium 10";
	public static String RechargeTXNID = "";
	//*********Test Input for Institution Fees Payment Transaction Set ********//
	public static String InstitutionName = "VIT";
	public static String RollNo = "4703";
	public static String Category = "";
	public static String SubCategory = "";
	public static String Course = "";
	public static String data ="";
	//************Test Input for IMPS - Fund Transfer*********//
    public static String IMPS_Mobile="9840364946";
    public static String IMPS_Mobile1="8754599508";
	public static String MMID = "9011151";
	public static String MMID1 = "9011118";
	public static String Inv_MMID = "1234544";
	public static String InitiatorMMID = "9011737";
	public static String IMPS_Account="24140100009737";
	public static String IMPS_Account1="24140100009660";
	public static String IMPS_IFSC=  "ANDB0000054";
	public static String IMPS_aadharno ="641552393534";
	public static String Merchant_Mobile="9850525545";
	public static String Merchant_MMID="9011888";
	public static String IMPS_P2P_Nickname="imps p2p";
	public static String IMPS_P2A_Nickname="imps p2a";
	public static String IMPS_P2U_Nickname="imps p2u";
	public static String IMPS_P2M_Nickname="imps p2m";
	public static String IMPS_Nickname1="IMPS";
	public static String IMPS_BenSearch = "IMPS";
	public static String RPTPNickname="Papanasam";
	public static String RPTMNickname="Fewthings";
	public static String P2MPayref="AWK993434";
	public static String IAmount = "200";
	public static String IAmount1 = "2";
	public static String IAmount2 = "9999999";
	public static String TXNID = "";
	//P2A
    public static String IMPS_Acc ="24140100009737";
    public static String IFS = "alla0210299";
    public static String P2A_Nickname = "IMPS P2A";
    public static String P2A_Already = "IMPS P2A1";
    public static String IMPS_Acc1 ="24140100002006";	
	//P2M
    public static String IMPSM_Mobile ="9677107309"; 
    public static String MMID_M ="9027934"; 
    //public static String IMPS_P2M_Nickname ="Merchant";
    public static String PayRef ="Paid Ref1";
	//************Test Input for Refer a Friend*****************//
    public static String FriendName = "Robotium";
    public static String Friendmob = "9840464070";
    //************Test Input for Feedback*****************//
    public static String Feedback ="Good";
    //************Test Input for Stop Cheque & Cheque Status***********//
  	public static String chequenum ="1234567";
  	public static String chequenum1 ="2";
  	//************Test Input for Change Login Password*********//
  	/***********Password Change - Success********/
    public static String NewPwd = "1111";
  	public static String EmailID = "test@fss.co.in";
}












