package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.reporters.jq.Main;

import mBankingPageObjectModel.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Properties;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpConnect extends ExtentManager {

	public static Properties prop=getProperty();
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) throws IOException {
		HttpConnect conn=new HttpConnect();
		conn.Post("9894060407APBE;Y;143728359323132456871830477028309680594;403362;123457;4.0.5;1434134124123431;49175274512454");
	}
	public String Post(String request) throws IOException
	{
		URL url = new URL(prop.getProperty("GprsURL")+prop.getProperty("servlet")+request);
		   //System.out.println("Posting Url : "+Configuration.GprsURL+Configuration.servlet);
	        StringBuilder postData = new StringBuilder();
	   
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        String response = null;
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				response = in.readLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
				//e.printStackTrace();
			}
	        return response;
	    }

}
















