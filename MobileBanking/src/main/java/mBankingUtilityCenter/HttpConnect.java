package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.reporters.jq.Main;

import mBankingPageObjectModel.Configuration;

public class HttpConnect {

	
	public static void main(String[] args) throws IOException {
		HttpConnect conn=new HttpConnect();
		conn.Post("9894060407APBE;Y;143728359323132456871830477028309680594;403362;123457;4.0.5;1434134124123431;49175274512454");
	}
	public String Post(String request) throws IOException
	{
		URL url = new URL(Configuration.GprsURL+Configuration.servlet+request);
	   
	        StringBuilder postData = new StringBuilder();
	   
	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");

	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
	        conn.setDoOutput(true);
	        conn.getOutputStream().write(postDataBytes);
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	        String response = in.readLine();
	        return response;
	    }

}
















