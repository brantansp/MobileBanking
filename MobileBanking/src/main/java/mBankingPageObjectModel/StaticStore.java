package mBankingPageObjectModel;

import mBankingUtilityCenter.RandomNumGenerator;

public class StaticStore {
	
	public static void main(String[] args) 
	{
		System.out.println(menuDesc.length);
		
	}
	//9865928748
	public static String menuDesc[][] = new String[][] {
		//Non Financial Transactions
		{"App Login",Configuration.RemMobileno+"APCG;BVD",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion},   //0
		{"Account Sync",Configuration.RemMobileno+"APSY","2",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,"0"}, //1
		{"Balance Enquiry",Configuration.RemMobileno+"APBE",Configuration.mPINRequired,Configuration.mPIN,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},    //2
		{"Mini Statement",Configuration.RemMobileno+"APMS",Configuration.mPINRequired,Configuration.mPIN,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},      //3
		{"Transaction history",Configuration.RemMobileno+"APTH",Configuration.mPINRequired,Configuration.mPIN,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //4
		{"Generate MMID",Configuration.RemMobileno+"APIM",Configuration.mPINRequired,Configuration.mPIN,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //5		
		{"Retrieve MMID",Configuration.RemMobileno+"APS6",Configuration.mPINRequired,Configuration.mPIN,Configuration.RemAccountno,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //6
		{"Cancel MMID All",Configuration.RemMobileno+"APRC",Configuration.mPINRequired,Configuration.mPIN,"ALL",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //7
		{"Cancel MMID Single",Configuration.RemMobileno+"APRC",Configuration.mPINRequired,Configuration.mPIN,Configuration.RemAccountno,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //8
		{"Email ID Fetch",Configuration.RemMobileno+"APZ6",Configuration.mPINRequired,Configuration.mPIN,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //9		
		{"Update Email ID",Configuration.RemMobileno+"APZ3",Configuration.mPINRequired,Configuration.mPIN,"aboutsatham@gmail.com",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //10
		{"Cheque Status",Configuration.RemMobileno+"APLW",Configuration.mPINRequired,Configuration.mPIN, Configuration.chequenum, Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //11
		{"Stop Cheque", Configuration.RemMobileno+"APL4",Configuration.mPINRequired,Configuration.mPIN, Configuration.chequenum, Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno}, //12
		
		
		//Financial Transactions		
		//IMPS Instant Payment
		{"IMPS P2P Instant",Configuration.RemMobileno+"APQI",Configuration.mPINRequired, Configuration.mPIN,Configuration.BenMobileNo,Configuration.BenMMID, Configuration.FTAmount,Configuration.FTRemarks,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //13
		{"IMPS P2A Instant",Configuration.RemMobileno+"APK1",Configuration.mPINRequired, Configuration.mPIN,Configuration.BenAccountNo,Configuration.RemAccountType,Configuration.BenIFSCCode, Configuration.FTAmount,Configuration.FTRemarks,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //14
		{"IMPS P2U Instant",Configuration.RemMobileno+"AP1U",Configuration.mPINRequired, Configuration.mPIN,Configuration.BenAadharNo,Configuration.RemAccountType, Configuration.FTAmount,Configuration.FTRemarks,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //15
		
		//IMPS Registration Payments
		{"IMPS P2P Add Beneficiary",Configuration.RemMobileno+"APW1",Configuration.mPINRequired, Configuration.mPIN,Configuration.BenMMID,Configuration.BenMobileNo, Configuration.NicknameP2P,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //16
		{"IMPS P2P Add Beneficiary confirmation",Configuration.RemMobileno+"APW2", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenMMID,Configuration.BenMobileNo, Configuration.NicknameP2P,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //17
		{"IMPS P2P Beneficiary Search List enquiry",Configuration.RemMobileno+"APD9", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenSearchText,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //18
		{"IMPS P2P Delete Beneficiary List enquiry",Configuration.RemMobileno+"AP5L", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenSearchText,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //19
		{"IMPS P2P Delete Beneficiary Confirmation",Configuration.RemMobileno+"AP5L", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenName,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //20
		{"IMPS P2P Beneficiary Payment List enquiry",Configuration.RemMobileno+"APW3", Configuration.mPINRequired, Configuration.mPIN,"P",Configuration.BenSearchText,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //21
		{"IMPS P2P Beneficiary Payment Confirmation",Configuration.RemMobileno+"APW4", Configuration.mPINRequired, Configuration.mPIN,Configuration.FTAmount, Configuration.FTRemarks, Configuration.BenName  , Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //22

		{"IMPS P2A Add Beneficiary",Configuration.RemMobileno+"APK2",Configuration.mPINRequired, Configuration.mPIN,Configuration.BenAccountNo,Configuration.BenAccType, Configuration.BenIFSCCode,Configuration.FTRemarks, Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //23
		{"IMPS P2A Add Beneficiary confirmation",Configuration.RemMobileno+"APK3", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenMMID,Configuration.BenMobileNo, Configuration.NicknameP2P,Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //24
		{"IMPS P2A Beneficiary Search List enquiry",Configuration.RemMobileno+"APD9", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenSearchText,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //25
		{"IMPS P2A Delete Beneficiary List enquiry",Configuration.RemMobileno+"AP5L", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenSearchText,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //26
		{"IMPS P2A Delete Beneficiary Confirmation",Configuration.RemMobileno+"AP5L", Configuration.mPINRequired, Configuration.mPIN,Configuration.BenName,"001",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //27
		{"IMPS P2A Beneficiary Payment List enquiry",Configuration.RemMobileno+"APK4", Configuration.mPINRequired, Configuration.mPIN, Configuration.BenSearchText,"1",Configuration.bankCode,Configuration.DUKPT,Configuration.buildVersion,Configuration.RemAccountno},  //28
		{"IMPS P2A Beneficiary Payment Confirmation",Configuration.RemMobileno+"APK5", Configuration.mPINRequired, Configuration.mPIN, Configuration.BenName , Configuration.FTAmount, Configuration.FTRemarks , Configuration.bankCode,Configuration.DUKPT, Configuration.buildVersion,Configuration.RemAccountno},  //29

	
		{"Add Beneficiary","APRM;Y",Configuration.mPIN,Configuration.bankCode,"Mobile No.",
         "Nickname","0001","4-4-N-Y-Y","","10-10-N-N-N","1-20-ANW-N-N","","5","true","true","Y"},//0
        {"Add Beneficiary","APRA;Y",Configuration.mPIN,Configuration.bankCode,"A/C No.","001",
         "Nickname","4-4-N-Y-Y","","15-15-N-N-N","","1-20-ANW-N-N","5","true","true","Y"},//1
        {"Beneficiary List","APRL;Y",Configuration.mPIN,"","1","false","false"},//2
        {"Mobile Fund Transfer","APFT;Y",Configuration.mPIN,"Amount (Rs.)","Remarks","","1-7-ND-N-N","0-25-AN-N-N","3","false","true","N"},//3
        {"A/C Fund Transfer","APFA;Y",Configuration.mPIN,"Amount (Rs.)","","1-7-ND-N-N","2","true","true","N"},//4
        {"Change mPIN", "APPC;Y", Configuration.mPIN, "New mPIN", "Confirm New mPIN",
        "4-4-N-Y-Y", "4-4-N-Y-Y", "4-4-N-Y-Y", "3" ,"true","true","N"},//5
        {"Payment Only","APAI;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","true","Y"},//6
        {"Payment Only","APAB;Y",Configuration.mPIN,"001","BRN No.","","","1-6-N-N-N","3","true","true","Y"},//7
        {"Payment Only","APPA;Y",Configuration.mPIN,"Y","001","","","","3","false","true","N"},//8  // Airline Confirmation
        {"Booking & Payment","APAS;Y",Configuration.mPIN,"From","To","Departure Date (DDMMYYYY)","Departure Time","Economy","No. of Passengers",
         "No. of Adults","No. of Children","No. of Infants","001","4-4-N-Y-Y","3-20-ANW-N-N","3-20-ANW-N-N","8-8-D-N-N","","","1-2-N-N-N",
        "1-2-N-N-N","1-2-N-N-N","1-2-N-N-N","","11","true","true","Y"},//9
        {"Customer Details","APCD;Y",Configuration.mPIN,"First Name","Last Name","","1-20-ANW-N-N","1-20-ANW-N-N","3","true","true"},//10
        {"Add Biller","APB1;Y",Configuration.mPIN,"E-mail ID","4-4-N-Y-Y","4-25-AN-N-N","2","true","true"},//11
        {"Add Biller","APB2;Y",Configuration.mPIN,"Flag","001","4-4-N-Y-Y","","","3","false","false","Y"},//12
        {"Add Biller","APB3;Y",Configuration.mPIN,"Biller ID","Flag","","","","3","false","false","Y"},//13
        {"Add Biller","APB3;Y",Configuration.mPIN,"001","001","001","001","001","","","","","","","6","true","true","Y"},//14
        {"Balance Enquiry","APBE;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//15
        {"Mini Statement","APMS;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//16
        {},//17 Used for dynamic biller linking. Dont modify this array//when u Change mPIN length change it into unregbillers array in.
        {"Registered Bill Payment","AP1B;Y",Configuration.mPIN,"A","CustMneNme","001","","","","","4","false","false","Y"},//18 APB5;Y Changed to AP1B
        {"Pay Biller","APB6;Y",Configuration.mPIN,"CustMneName","Payment Flag","Bill No.","Amount (Rs.)","TXNID","","","","","","","6","false","false","N"},//19
        {"Pay Biller","APB6;Y",Configuration.mPIN,"CustMneName","Payment Flag","Bill No.","Amount (Rs.)","TXNID","","","","","1-10-ND-N-N","","6","false","false","N"},//20
        {"Registered Bill Payment","APBN;Y",Configuration.mPIN,"001","","","2","true","true"},//21
        {"Pay Biller","APB6;Y",Configuration.mPIN,"CustMneName","Payment Flag","Bill No.","Amount (Rs.)","001","","","","0-35-AN-N-N","1-10-ND-N-N","","6","true","true","N"},//22
        {"Delete Biller","APBY;Y",Configuration.mPIN,"Nickname","","","2","false","false","N"},//23
        {},//24 Used for dynamic adhoc payment. Dont modify this array
        {"Donation","APTL;Y",Configuration.mPIN,"001","","","2","true","true"},//25
        {"Donation","APTD;Y",Configuration.mPIN,"001","001","001","Amount (Rs.)","","","","","1-7-N-N-N","5","true","true"},//26
        {"Movie Ticketing","APM1;Y",Configuration.mPIN,"City/Town","Language"," "," ","No. of Tickets","Date(DDMMYYYY)-Optional","001",
        "4-4-N-Y-Y","1-16-ANW-N-N","1-16-ANW-N-N","","","1-2-N-N-N","0-8-D-N-N","","8","true","true","Y"},//27
        {"Movie Ticketing","APM1;Y",Configuration.mPIN,"001","001","001","001","001","001","001",
        "","","","","","","","","8","false","true","Y"},//28
        {"Movie Ticketing","APM2;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001",
        "","","","","","","","","","","10","false","false","Y"},//29
        {"Movie Ticketing","APM3;Y",Configuration.mPIN,"Region Name","Language","Venue Name","Cinema Name","No Of Tickets","Show-Date","Show-Time","Price ID","Price",
        "","","","","","","","","","","10","false","false","Y"},//30
        {"Movie Ticketing","APM4;Y",Configuration.mPIN,"TXN-ID","Order-ID","Ticket-Price","No. of Tickets","","","","","","5","false","false","N"},//31
        {"Mobile Recharge","APR5;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","Y"},//32   
    	{"Mobile Recharge","APR6;Y",Configuration.mPIN,"","Mobile No.","Amount (Rs.)","","","","10-10-N-N-N","1-7-N-N-N","","5","false","false","Y"},//33
        {"Institution Registration","APIS;Y",Configuration.mPIN,"Search Institution","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//34
        {"Institution Registration","APIS;Y",Configuration.mPIN,"001","001","","","","3","true","true","Y"},//35
        {"Institution Registration","APIR;Y",Configuration.mPIN,"001","","","2","false","false","N"},//36
        {"Fees Payment","APIL;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","Y"},//37
        {"Fees Payment","API1;Y",Configuration.mPIN,"001","Roll No.","","","2-12-N-N-N","3","true","true","Y"},//38
        {"Fees Payment","API2;Y",Configuration.mPIN,"001","001","001","001","001","","","","","","","6","false","false","Y"},//39
        {"Cheque Book","APL1;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//40
        {"Demand Draft","APLY;Y",Configuration.mPIN,"Favour Of","Payable At","Amount (Rs.)","4-4-N-Y-Y","3-30-AN-N-N","3-30-AN-N-N","1-10-ND-N-N","4","true","true","N"},//41
        {"Request for A/C Statement","APL3;Y",Configuration.mPIN,"From Date (DDMMYYYY)","To Date (DDMMYYYY)","4-4-N-Y-Y","8-8-D-N-N","8-8-D-N-N","3","true","true","N"},//42
        {"Stop Cheque","APL4;Y",Configuration.mPIN,"Cheque No.","4-4-N-Y-Y",Configuration.chequeMin+"-"+Configuration.chequeMax+"-N-N-N","2","true","true","N"},//43
        {"Fixed Deposit","APL5;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//44
        {"Mobile Number Registration","APL6;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false"},//45
        {"Loan","APL7;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//46
        {"Credit Card","APL8;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//47
        {"Debit Card","APL9;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//48
        {"Request for New A/C","APL6;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//49
        {"Internet Banking PIN","APLZ;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//50
        {"ATM","APAL;N","L","Search City","Search Location","001","","0-20-ANW-N-N","0-20-ANW-N-N","","4","true","true","N"},//51
        {"Location","AP1L;N","L","Search City","Search Location","001","","0-20-ANW-N-N","0-20-ANW-N-N","","4","true","true","N"},//52
        {"Enable/Disable Transaction","APE5;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","Y"},//53
        {"Disable Transation","APDE;Y",Configuration.mPIN,"N","001","","","","3","true","true","N"},//54
        {"Shopping","APCP;Y",Configuration.mPIN,"Amount (Rs.)",Configuration.bankCode,"Merchant Nickname","4-4-N-Y-Y","1-10-ND-N-N","","1-25-ANW-N-N","4","true","true","Y"},//55
        {"Corporate Search", "APCS;Y", Configuration.mPIN, "Y",
         "Search Corporate",  "001","4-4-N-Y-Y", "", "0-20-ANW-N-N", "", "4","true","true"},//56-4
        {"Sub-Corporate Search", "APSS;Y", Configuration.mPIN, "001","Y","Search Sub-corporate", "001",
         "", "", "", "0-20-ANW-N-N", "", "5","true","true"},//57 - 5
        {},//58 - 14
        {"Sub-Corporate List","APSS;Y",Configuration.mPIN,"001","N","001","001","","","","","","5","true","true"},//59 -15
        {"Corporate Registration","APSR;Y",Configuration.mPIN,"001","N","Distributor ID:","","","","0-12-AN-N-N","4","true","true"},//60 - 7
        {"Sub-Corporate Registration","APSR;Y",Configuration.mPIN,"001","Y","001","Distributor ID","","","","","0-12-AN-N-N","5","true","true"},//61
        {"Payment", "APPS;Y", Configuration.mPIN,"Transaction ID","Corporate ID","Sub Corporate ID","Amount (Rs.)","Distributor ID","Invoice No.",
          "","","","","1-10-ND-N-N","","0-20-N-N-N", "7","true","true"},//62 - 9  // "With Invoice No.",
        {"Payment", "APPS;Y", Configuration.mPIN,"Transaction ID","Corporate ID","Sub Corporate ID","Amount (Rs.)","distributor ID"," ",
          "","","","","1-10-ND-N-N","","", "7","true","true"},//63 - 9  // "Without Invoice No.",
        {"SI-Registration", "APSI;Y", Configuration.mPIN,"Corporate ID","Sub corporate ID","Per Day Transaction Limit", "Per Transaction Limit", "Distributor ID",
                 "", "", "","1-10-ND-N-N", "1-10-ND-N-N", "", "6","true","true"},//64 - 11
        {"Deregistration", "APDR;Y", Configuration.mPIN,"Corporate ID","sub corporate ID","Distributor ID","", "", "","",  "4","true","true"},//65 - 12
        {"Forgot Password", "APCF;Y", Configuration.mPIN,"Corporate ID","sub corporate ID","Distributro ID","", "", "","", "4","true","true"},//66 - 13
        {"Payment Only","APAR;Y",Configuration.mPIN,"001","Title","First Name","Last Name","Passenger Count","",
         "","","1-20-ANW-N-N","1-20-ANW-N-N","1-1-N-Y-N","6","true","true","Y"},//67
        {"Booking & Payment","APAS;Y",Configuration.mPIN,"001","001","001","001","001","001",
         "001","001","001","001","","","","","","","",
        "","","","","11","true","true","Y"},//68
        {"Booking & Payment","APAC;Y",Configuration.mPIN,"001","001","001","","","","","4","false","false","N"},//69
        {"Delete Biller","APBZ;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","Y"},//70
        {"Cheque Status","APLW;Y",Configuration.mPIN,"Cheque No.","4-4-N-Y-Y",Configuration.chequeMin+"-"+Configuration.chequeMax+"-N-N-N","2","true","true","N"},//71
        {"Hotlist Debit Card","APL0;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//72
        {"Un-Block Card","APL2;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//73
        {"ATM","APAL;N","P","Pincode"," ","001","","6-6-N-N-N","","","4","true","true","N"},//74 mid:12897
        {"Branch","AP1L;N","P","Pincode"," ","001","","6-6-N-N-N","","","4","true","true","N"},//75
        {"CFT Registered Lists", "APSP;Y", Configuration.mPIN,"Mode Flag", "Search Beneficiary","001","4-4-N-Y-Y","","0-20-ANW-N-N","", "4","true","true"},//76 - 8
        {"Shopping","APCN;Y",Configuration.mPIN,"001","001","4-4-N-Y-Y","","","3","false","false","N"},//77
        {"Payment Only","APR1;Y",Configuration.mPIN,"001","BRN No.","","","1-6-N-N-N","3","true","true","N"},//78
        {"Booking & Payment","APR2;Y",Configuration.mPIN,"Order ID","4-4-N-Y-Y","5-20-AN-N-N","2","true","true","N"},//79
        {"Enable/Disable Transaction","APE6;Y",Configuration.mPIN,"001","","","2","false","false","N"},//80
        {"Bank Download","APQ1;Y",Configuration.mPIN,"001","","","2","true","true"},//81
        {"Add Beneficiary","APQ2;Y",Configuration.mPIN,"A/C No.","001","IFS Code","Beneficiary Name",
         "","6-19-ANW-N-N","","11-11-ANW-N-N","1-20-AN-N-N","5","true","true","Y"},//82//4-4-N-Y-Y
        {"Add Beneficiary","APQ3;Y",Configuration.mPIN,"A/C No.","001","IFS Code","Nickname","","","","","","5","false","false","N"},//83
        {"Partner Bank","APQ4;Y",Configuration.mPIN,"A/C No.","001","001","Nickname",
        "4-4-N-Y-Y","6-19-ANW-N-N","","","1-20-ANW-N-N","5","true","true"},//84
        {"VMT Registration","APQ5;Y;",Configuration.mPIN,"Card No.","Expiry Date","Nickname",
        "4-4-N-Y-Y","16-19-N-N-N","4-4-N-N-N","1-20-ANW-N-N","4","true","true"},//85
        {"MMT Registration","APQ6;Y",Configuration.mPIN,"Card No.","Expiry Date","Nickname",
        "4-4-N-Y-Y","16-19-N-N-N","4-4-N-N-N","1-20-ANW-N-N","4","true","true"},//86
        {"Pay Beneficiary","APQ7;Y",Configuration.mPIN,"001","001","4-4-N-Y-Y","","","3","false","false","Y"},//87
        {"Pay Beneficiary","APQ8;Y",Configuration.mPIN,"Amount (Rs.)","Remarks","001","","1-7-N-N-N","0-25-AN-N-N","","4","false","false","N"},//88
        {"Partner Bank Registered List","APQ9;Y",Configuration.mPIN,"001","001","4-4-N-Y-Y","","","3","true","true"},//89
        {"Partner Bank Fund Transfer","APQA;Y",Configuration.mPIN,"Amount (Rs.)","001","4-4-N-Y-Y","1-10-ND-N-N","","3","true","true"},//90
        {"Delete Beneficiary","AP4D;Y",Configuration.mPIN,"001","","","2","false","false","N"},//91
        {"Donation","APT1;Y",Configuration.mPIN,"Search Entity","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//92
        {"Donation","APT1;Y",Configuration.mPIN,"001","001","","","","3","false","false","Y"},//93
        {"Donation","APT2;Y",Configuration.mPIN,"001","001","","","","3","false","false","Y"},//94 //  Select Scheme
        {"Donation","APT3;Y",Configuration.mPIN,"001","001","001","","","","","4","false","false","Y"},//95   //  Select Sub-schemes
        {"Donation","APT4;Y",Configuration.mPIN,"001","001","001","001","001","", //  Confirm Temple Payment Details
        "","","","","","6","false","false","Y"},//96
        {"Donation","APT5;Y",Configuration.mPIN,"001","001","001","001","001","Amount (Rs.)","001",
        "","","","","","","1-9-N-N-N","","8","false","false","N"},//97 mid: 12985 -ND- to -N-
        {"Within Bank Deregistration","APF4;Y",Configuration.mPIN,"D","001","4-4-N-Y-Y","","","3","true","true"},//98
        {"Within Bank Deregistration","APF3;Y",Configuration.mPIN,"001","","","2","true","true"},//99
        {"Pay Beneficiary","APF1;Y",Configuration.mPIN,"P","001","4-4-N-Y-Y","","","3","false","false","Y"},//100
        {"Pay Beneficiary","APFT;Y",Configuration.mPIN,"Amount (Rs.)","Remarks","001","","1-10-ND-N-N","0-25-AN-N-N","","4","false","false","N"},//101
        {"Pay Beneficiary","APF2;Y",Configuration.mPIN,"P","001","4-4-N-Y-Y","","","3","false","false","Y"},//102
        {"Pay Beneficiary","APFA;Y",Configuration.mPIN,"Amount (Rs.)","Remarks","001","","1-10-ND-N-N","0-25-AN-N-N","","4","false","false","N"},//103
        {"Fees Payment","API4;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001",
        "","","","","","","","","","9","false","false","Y"},//104
        {"Fees Payment","API2;Y",Configuration.mPIN,"001","001","001","001","","","","","","5","true","true","Y"},//105
        {"Fees Payment","API3;Y",Configuration.mPIN,"001","001","001","001","","","","","","5","false","false","Y"},//106
        {"Fees Payment","APIP;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","001",
        "001","Amount (Rs.)","001","","","","","","","","","","","","","1-10-ND-N-N","","14","true","true","N"},//107
        {"Fees Payment","APIP;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","Room No.",
        "001","Amount (Rs.)","001","","","","","","","","","","","0-12-AN-N-N","","1-10-ND-N-N","","14","false","false","N"},//108
        {"Fees Payment","APIP;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","Room No.",
        "001","001","001","","","","","","","","","","","","","","","14","true","true","N"},//109
        {"Fees Payment","APIP;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","Room No.",
        "001","001","001","","","","","","","","","","","0-12-AN-N-N","","","","14","true","true","N"},//110
        {"Institution Deregistration","API5;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","Y"},//111
        {"Institution Deregistration","APID;Y",Configuration.mPIN,"001","","","2","false","false","N"},//112
        {"TMB mConnect Login","APMU","BVD:"+Configuration.buildVersion + "#" + Configuration.mobileType + "#" +  Configuration.mobileScreenSize + "#" +Configuration.mobileDetails,"","1","false","false","N"},//113
        {(Configuration.isForgotPassword?"Create Password":"TMB mConnect Login"),"APNA","BVD:"+Configuration.buildVersion + "#" + Configuration.mobileType + "#" +  Configuration.mobileScreenSize + "#" +Configuration.mobileDetails,"Login Password","Confirm Login Password","","4-4-N-Y-Y","4-4-N-Y-Y","3","true","true","N"},//114
        {"Forgot Password","APP3;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//115
        {"Forgot Password","APFP","001","Your Answer","","0-12-AN-N-N","2","true","true"},//116
        {"Change Login Password","APCW","Select New Password","Confirm New Password","4-4-N-Y-Y","4-4-N-Y-Y","2","true","true","N"},//117
        {"TMB mConnect Service No.","1111;Y","Service No.","4-10-N-N-N","1","false","false","N"},//118
        {"TMB mConnect Service Url","2222;Y","Service URL","0-150-AN-N-N","1","false","false","N"},//119
        {"Pay Biller","AP1N;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","001","001","001",
        "4-4-N-Y-Y","","","","","","","","","","","","","13","false","false"},//120
        {"Defer Bill","APDN;Y",Configuration.mPIN,"001","001","001","001","Defer Date(DDMMYYYY)","4-4-N-Y-Y","","","","","8-8-D-N-N","6","true","true"},//121
        {"Pay Biller","AP1N;Y",Configuration.mPIN,"001","001","001","001","001","001","001","001","001","001","Amount (Rs.)","001",
        "4-4-N-Y-Y","","","","","","","","","","","1-10-ND-N-N","","13","true","true"},//122
        {"TMB mConnect Login","APUM","Login Password","4-4-N-Y-Y","1","false","false","N"},//123
        {"Add Beneficiary","APC1;Y",Configuration.mPIN,Configuration.bankCode,"001",
         "001","Beneficiary Acc No.","","","","","","5","false","false","N"},//124
        {"Add Beneficiary","APC2;Y",Configuration.mPIN,Configuration.bankCode,"001","001",
         "001","","","","","","5","false","false","N"},//125
        {"WAP","APZP;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//126
        {"Configure/Update E-mail ID","APZ6;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","Y"},//127
        {"Configure/Update E-mail ID","APZ3;Y",Configuration.mPIN,"E-mail ID","","1-35-AN-N-N","2","false","false","N"},//128
        {"Refer a Friend","APZ5;N","Friend Name","Friend's E-mail ID","Friend's Mobile No.","1-35-ANW-N-N","1-35-AN-N-N","10-10-N-N-N","3","true","true","N"},//129
        {"Promotional Campaign","AP1Y;Y",Configuration.mPIN,"001","001","4-4-N-Y-Y","","","3","true","true"},//130
        {"Promotional Campaign","AP3Y;Y",Configuration.mPIN,"001","Defer Date(DDMMYYYY)","001","4-4-N-Y-Y","","8-8-D-N-N","","4","true","true"},//131
        {"CFT Registered Lists", "APSP;Y", Configuration.mPIN,"Mode Flag", "Search Beneficiary","001","4-4-N-Y-Y","","","", "4","true","true"},//132- More 76 - 8
        {"Payment","APPL;Y",Configuration.mPIN,"Mode Flag","Corp","Sub Corp","001","4-4-N-Y-Y","","","","","5","true","true"},//133
        {"Add Biller","APB9;Y",Configuration.mPIN,"Cat ID","Search State (optional)","Search City (optional)","Flag","001",
          "","","0-20-ANW-N-N","0-20-ANW-N-N","","","6","true","true","Y"},//134
        {"Add Biller","APB9;Y",Configuration.mPIN,"Cat ID","Search State (optional)","Search City (optional)","Flag","001",
          "","","","","","","6","true","true","Y"},//135
        {"Booking & Payment","APA1;Y",Configuration.mPIN,"Flight ID","From","To","Journey Date","Ticktes","Adults","Child","Infants","Flight Class","001",
          "","","","","","","","","","","","","11","false","false","Y"},//136
        {"Reactivate TMB mConnect","APCA","Login Password","4-4-N-N-Y","1","false","false","N"},//137
        {"Change Login Password","APP5","Login Password","New Password","Confirm New Password","4-4-N-Y-Y","4-4-N-Y-Y","4-4-N-Y-Y","3","true","true","N"},//138
        {"IFSC Search","APS1;Y",Configuration.mPIN,"Search Bank","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//139
        {"IFSC Search","APS2;Y",Configuration.mPIN,"Bankname","Search Location","001","","","0-20-ANW-N-N","","4","true","true","Y"},//140
        {"IFSC Search","AP3S;Y",Configuration.mPIN,"Bankname","Location","001","","","","","4","false","false","N"},//141
        {"IFSC Search","APS1;Y",Configuration.mPIN,"Search Bank","001","","","","3","true","true","Y"},//142
        {"IFSC Search","APS2;Y",Configuration.mPIN,"Bankname","Search Location","001","","","","","4","true","true","Y"},//143(IFSC)
        {"ATM","APSA;Y",Configuration.mPIN,"P","Pincode"," ","001","","","","","","5","false","false","N"},//144
        {"Branch","AP1L;Y",Configuration.mPIN,"P","Pincode"," ","001","","","","","","5","false","false","N"},//145
        {"Registered Bill Payment","APBX;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","Y"},//146
        {"Registered Bill Payment","APBW;Y",Configuration.mPIN,"Customer Mne Name","","","2","false","false","Y"},//147
        {"Register Feedback","APFC;Y",Configuration.mPIN,"Feedback","4-4-N-Y-Y","1-80-AN-N-N","2","true","true","N"},//148
        {"Status Enquiry","APFS;Y",Configuration.mPIN,"Ticket ID","4-4-N-Y-Y","12-12-N-N-N","2","true","true","N"},//149
        {"Bank Search","AP4S;Y",Configuration.mPIN,"IFS Code","4-4-N-Y-Y","11-11-ANW-N-N","2","true","true","N"},//150
        {"TMB mConnect Service No.","3333;Y","Service No.","6-6-N-N-N","1","false","false","N"},//151
        {},//152
        {},//153
        {"Checking Internet Connectivity","APGT","","","1","false","false","N"},//154
       // {"Authenticating Mobile No.","APCM",Configuration.myMobileNo,"","1","false","false","N"},//155 
        {"Deregistration","APDG;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},//156
        {"Beneficiary Details","APE3;Y",Configuration.mPIN,"0001","4-4-N-Y-Y","","2","true","true"},//157
        {"Beneficiary Details","APE4;Y",Configuration.mPIN,"0001","4-4-N-Y-Y","","2","true","true"},//158
        {"Link an A/C","APAA;Y",Configuration.mPIN,"A/C No.","A/C Type","4-4-N-Y-Y","6-19-ANW-N-N","","3","true","true","N"},//159
        {"De-Link an A/C","APDA;Y",Configuration.mPIN,"A/C No.","4-4-N-Y-Y","","2","false","false","N"},//160
        {"Remittance","APSC;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","Confirm Remitter PIN","Amount (Rs.)",
        "4-4-N-Y-Y","10-10-N-N-N","4-4-N-Y-Y","4-4-N-Y-Y","1-9-N-N-N","5","true","true","Y"},//161
         {"Remittance","APEC;Y",Configuration.mPIN,"Mobile No.","Surcharge","Amount (Rs.)","TXNID","","","","","","5","false","false","N"},//156-162
         {"Status","APSE;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "4-4-N-Y-Y","10-10-N-N-N","4-4-N-Y-Y","","4","true","true","N"},//157-163
         {"Status","APSE;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "","","","","4","true","true","N"},//158-164
         {"Forgot PIN","APPF;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "4-4-N-Y-Y","10-10-N-N-N","4-4-N-Y-Y","","4","true","true","Y"},//159-165
         {"Forgot PIN","APPF;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "","","","","4","false","false","Y"},//160-166
         {"Forgot PIN","APFF;Y",Configuration.mPIN,"Beneficiary Mobile No.","Reciept No.",
         "","","","3","false","false","N"},//161-167
         {"Cancel eCash ","APCE;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "4-4-N-Y-Y","10-10-N-N-N","4-4-N-Y-Y","","4","true","true","Y"},//162-168
         {"Cancel eCash ","APCE;Y",Configuration.mPIN,"Beneficiary Mobile No.","Remitter PIN","0001",
         "","","","","4","true","true","Y"},//163-169
         {"Cancel eCash ","APCC;Y",Configuration.mPIN,"Beneficiary Mobile No.","Reciept No.",
         "","","","3","false","false","N"},//164-170
         {"Add Beneficiary","APW1;Y",Configuration.mPIN,"Mobile No.","MMID No.","Nickname",
         "4-4-N-Y-Y","10-10-N-N-N","7-7-N-N-N","1-20-ANW-N-N","4","true","true","Y"},//165-171
         {"Add Beneficiary","APW2;Y",Configuration.mPIN,"MMID","Mobile No.","Nickname",
         "","","","","4","false","false","N"},//166-172
         {"Pay Beneficiary","APW3;Y",Configuration.mPIN,"P","Search Beneficiary","001","4-4-N-Y-Y","","0-20-ANW-N-N","","4","true","true","Y"},//167-173
         {"Pay Beneficiary","APW4;Y",Configuration.mPIN,"Amount (Rs.)","Remarks","001","","1-10-ND-N-N","0-25-AN-N-N","","4","false","false","N"},//168-174
         {"MBIN Search","APS4;Y",Configuration.mPIN,"Search Bank","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true"},//169-175
         {"Bank Search By MBIN","APS5;Y",Configuration.mPIN,"MBIN","4-4-N-Y-Y","0-4-N-N-N","2","true","true"},//170-176
         {"Retrieve MMID","APS6;Y",Configuration.mPIN,"Acc No.","4-4-N-Y-Y","","2","false","false","N"},//171-177
         {"Generate MMID","APIM;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","N"},//173-178
         {"Instant Pay","APQI;Y",Configuration.mPIN,"Enter Beneficiary Mobile No.","Enter Beneficiary MMID No.","Enter Amount","Remarks","4-4-N-Y-Y","10-10-N-N-N","7-7-N-N-N","1-10-ND-N-N","0-25-AN-N-N","5","true","true","N"},//174-179
         {"Transaction Timeout Count","APTC","Timeout Count","1-1-N-N-N","1","false","false","N"},//180
         {"Transaction Timeout Count","APTO","Last Tran and Time","","1","false","false","N"},//181
         {"Delete Beneficiary","AP2L;Y",Configuration.mPIN," Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//182
         {"Delete Beneficiary","AP2D;Y",Configuration.mPIN,"Nickname","","","2","false","false","N"},//183
         {"Delete Beneficiary","AP3L;Y",Configuration.mPIN," Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//182
         {"Delete Beneficiary","AP3D;Y",Configuration.mPIN,"Nickname","","","2","false","false","N"},//185
         {"Beneficiary Details","APD5;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","N"},//186
         {"Beneficiary Details","APD6;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","N"},//187
         {"Account Sync/update","APSY","001","","1","false","false","N"},//188
         {"Visa Card Beneficiary Registration","APV1;Y",Configuration.mPIN,"Nickname","Card No.","4-4-N-Y-Y","1-20-ANW-N-N","16-19-N-Y-N","3","true","true","N"},//189
         {"Visa Card Bill Payment ","APV2;Y",Configuration.mPIN,"Search String","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","Y"},//190
         {"Visa Card Bill Payment ","APV3;Y",Configuration.mPIN,"Amount (Rs.)","001","","1-10-ND-N-N","","3","false","false","N"},//191
         {"Delete Beneficiary","APV5;Y",Configuration.mPIN,"001","","","2","false","false"},//192 
         {"Delete Beneficiary","APV4;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true"},//193
         {"Beneficiary Payment Status","APNS;Y",Configuration.mPIN,"Reference No.","4-4-N-Y-Y","4-16-AN-N-N","2","false","false","N"},//194
         {"Recharge Status Enquiry","AP7T;Y",Configuration.mPIN," ","Enter Transaction ID (Optional)","1","","","0-12-N-N-N","","4","false","false","N"},//195 //4-4-N-Y-Y
         {"Delete Beneficiary","AP4L;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","false","false","Y"},//196                                                                     
         {"Request for Cash Pickup","APG1;Y",Configuration.mPIN,"Amount (Rs.)","Date Of Pickup(DDMMYYYY)","Preferred Hour(00-23)","Preferred Minute(00,15,30,45)","4-4-N-Y-Y","1-10-ND-N-N","8-8-N-N-N","2-2-N-N-N","2-2-N-N-N","5","true","true","N"},//197
         {"Request for Cash Delivery","APG2;Y",Configuration.mPIN,"Cheque No.","Amount (Rs.)","Cheque Date(DDMMYYYY)","Date Of Delivery(DDMMYYYY)","Preferred Hour(00-23)","Preferred Minute(00,15,30,45)","4-4-N-Y-Y",Configuration.chequeMin+"-"+Configuration.chequeMax+"-N-N-N","1-10-ND-N-N","8-8-N-N-N","8-8-N-N-N","2-2-N-N-N","2-2-N-N-N","7","true","true","N"},//198
         {"Cheque Pickup", "APG3;Y", Configuration.mPIN, "", "Cheque No.",
				"Date Of Pickup(DDMMYYYY)", "Preferred Hour(00-23)",
				"Preferred Minute(00,15,30,45)", "", "",Configuration.chequeMin+"-"+Configuration.chequeMax+"-N-N-N",
				"8-8-N-N-N", "2-2-N-N-N", "2-2-N-N-N", "6", "false",
				"false" ,"N"},// 199
         {"Request for Draft Delivery","APG4;Y",Configuration.mPIN,"Amount (Rs.)","Date Of  Delivery(DDMMYYYY)","Preferred Hour(00-23)","Preferred Minute(00,15,30,45)","Beneficiary Name","Payee Location","4-4-N-Y-Y","1-10-ND-N-N","8-8-N-N-N","2-2-N-N-N","2-2-N-N-N","1-30-AN-N-N","1-30-N-N","0-10-N-N-N","0-10-N-N-N","7","true","true","N"},//200
         {"Cheque Book Request","APG7;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","N"},//201
         {"Request for A/C Statement","APL3;Y",Configuration.mPIN,"From Date(DDMMYYYY)","To Date(DDMMYYYY)","4-4-N-Y-Y","8-8-N-N-N","8-8-N-N-N","3","true","true","N"},//202
         {"Request for Statement - Email","APG5;Y",Configuration.mPIN,"From Date(DDMMYYYY)","To Date(DDMMYYYY)","4-4-N-Y-Y","8-8-N-N-N","8-8-N-N-N","3","true","true","N"},//203
         {"Request for a New Product","APG6;Y",Configuration.mPIN,"","Preferred Branch","Contact Date(DDMMYYYY)","Contact Time-HH(01-24)","","","6-20-AN-N-N","8-8-N-N-N","2-2-N-N-N","5","true","true","N"},//204
         {"Change mPIN", "APNC;Y", Configuration.mPIN, "New mPIN", "Confirm New mPIN",
         "4-4-N-Y-Y", "4-4-N-Y-Y", "4-4-N-Y-Y", "3" ,"true","true","N"},//205
         {"Old User Activation","APOC","","","1","false","false","N"},//206
         {"View Paid Bills","APPB;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","N"},//207
         {"Request for Demand Draft","APG8;Y",Configuration.mPIN,"First Name","Middle Name","Last Name","","","","","","","","Amount (Rs.)","Payable At","Remarks","4-4-N-Y-Y","1-15-ANW-N-N","1-15-ANW-N-N","0-50-AN-N-N","","","","","","","","1-10-ND-N-N","1-20-AN-N-N","0-25-AN-N-N","14","true","true","N"},//208
         {"Fixed Deposit", "APG9;Y", "", "", "", "","Amount (Rs.)", "", "", "", "", "", "",	"5-5-N-N-N", "", "", "7", "false", "false","N" },// 209
			 {"Cancel MMID","APRC;Y",Configuration.mPIN,"","4-4-N-Y-Y","","2","false","false","N"},//210			
         {"Request for a New Product","APGP;Y",Configuration.mPIN,"001","4-4-N-Y-Y","","2","false","false","N"},//211
         {"Beneficiary Details","APD9;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","N"},//212
         {"Beneficiary Details","APNL;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true","N"},//213
         {"Beneficiary Details","APD8;Y",Configuration.mPIN,"","","","2","false","false","N"},//214
         {"VISA Card Beneficiary Details","APV6;Y",Configuration.mPIN,"Search Beneficiary","001","4-4-N-Y-Y","0-20-ANW-N-N","","3","true","true"},//215
         {"Reset Password","APPE","Login Password","New Password","Confirm New Password","4-4-N-N-Y","4-4-N-Y-Y","4-4-N-Y-Y","3","true","true","N"},//216
         { "Cheque Pickup", "APG3;Y", Configuration.mPIN, "Number of Instruments","4-4-N-Y-Y", "1-1-N-N-N", "2", "false", "false","N" },// 217//put	specially for android cheque	pickup
		{ "Fixed Deposit", "APG9;Y", Configuration.mPIN, "4-4-N-Y-Y", "1","false", "false","N" },// 218//put specially for fixed deposit
		{ "Fixed Deposit", "APG9;Y", "Number Of Days", "1-3-N-N-N", "1","false", "false","N" },// 219//put specially for fixed deposit
				{},//220 dead index
				{},// 221for seperate mPIN screen..
				{}, //222
				};


}
