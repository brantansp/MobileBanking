package mBankingControlCenter;

import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException
    {
    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/C", "netstat -n -o | findstr :9017");
    Process process = builder.start();
    process.waitFor();
    String PID=printProcessStream(process.getInputStream());
    builder = new ProcessBuilder("cmd.exe", "/C", "netstat -n -o | findstr :9017");
    process = builder.start();
    process.waitFor();
    }

    private static String printProcessStream(InputStream inputStream) throws IOException
    {
    int bytesRead = -1;
    byte[] bytes = new byte[1024];
    String output = "";
    while((bytesRead = inputStream.read(bytes)) > -1){
        output = output + new String(bytes, 0, bytesRead);
    }
    System.out.println(" The netstat command response is :"+output);
    //  TCP    10.44.71.115:9017      10.44.120.60:57802     ESTABLISHED     3432
    return output.substring(output.lastIndexOf("ESTABLISHED")+11, output.length()).replaceAll("\\s", "");
    }
    
}
