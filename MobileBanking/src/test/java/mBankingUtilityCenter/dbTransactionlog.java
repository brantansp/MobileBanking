package mBankingUtilityCenter;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//
public class dbTransactionlog {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//10.144.24.45:1527/ormpypre";
	private static final String DB_USER = "TMB_P2TEST";
	private static final String DB_PASSWORD = "tmb_p2test321#";
	private static Connection dbConnection = null;
	private static Statement statement = null;
	private static String transactionID="734910241217";
	private static String result= "";
	private static ResultSet resultSet;
	//check2
	public static void main(String[] argv) {
		try {
			fetchRecord(transactionID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String fetchRecord( String transactionID) throws SQLException {

		String selectTableSQL = "select txnauthid, txntype , txnstatus , Error_Type, Errorcode, Error_Msg, Responsecode, Response_Description from Transactionlog WHERE TXNAUTHID ='"+transactionID+"'";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			resultSet = statement.executeQuery(selectTableSQL);
			//ResultSetMetaData rsmd = resultSet.getMetaData();
			resultSet.next();
			 result = resultSet.getString("txnauthid") +"|"+
					 resultSet.getString("txntype") +"|"+
	                       resultSet.getString("txnstatus") +"|"+
	                       resultSet.getString("Error_Type")+"|"+
			  resultSet.getString("Errorcode")+"|"+
			  resultSet.getString("Responsecode")+"|"+
			  resultSet.getString("Response_Description")+"|"+
			  resultSet.getString("Errorcode");
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return result;
	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	 public void clear() {
	 		if (resultSet != null) {
	 			try {
	 				resultSet.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			resultSet = null;
	 		}
	 		if (statement != null) {
	 			try {
	 				statement.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			statement = null;
	 		}
	 	} 	

}










