package mBankingConfigurationCenter;

public class StaticTest {
		public static String menuDesc [][] = new String [][]
		{
	        {"Balance Enquiry","APBE;Y","4-4-N-Y-Y","1","false","false","N"},
	        {"Mini Statement","APMS;Y",Configuration.mPIN,"4-4-N-Y-Y","1","false","false","N"},
		};
		
		public static void main(String[] args) 
		{
		     System.out.println(menuDesc [0][0].length());	
		}
}
