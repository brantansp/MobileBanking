package mBankingUtilityCenter;

import java.lang.invoke.MethodHandles;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.mail.smtp.SMTPTransport;


public class SendEmail
{

	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) {
		
		

        final String smtpAuthUserName = "brantansp@fss.co.in";
        final String smtpAuthPassword = "Mar.2018";
        String emailFrom = "brantansp@fss.co.in";
        String emailTo   = "brantansp@fss.co.in";
        Authenticator authenticator = new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(smtpAuthUserName, smtpAuthPassword);
            }
        };
        Properties properties = new Properties();
        properties.setProperty("UseDefaultCredentials", "false");
        properties.setProperty("mail.smtp.host", "outlook.office365.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
 
        properties.setProperty("mail.smtp.starttls.enable", "true");
  /*      properties.setProperty("EnableSsl", "false");*/
        Session session = Session.getInstance( properties, authenticator );
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            InternetAddress[] to = {new InternetAddress(emailTo)};
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject("PLACE_SUBJECT_HERE");
            message.setText("YOUR_MESSAGE_HERE");
            Transport.send(message);
        }
        catch (MessagingException exception)
        {
            exception.printStackTrace();
        }
    
		
/*	sendEmail( "brantansp@fss.co.in", "brantansp@fss.co.in", "brantansp", "Mar.2018" , "smtp.office365.com", "emailSubject" , "emailBody");
	*/
/*
		// Create object of Property file
		Properties props = new Properties();

		props.put("UseDefaultCredentials", "false");
		props.put("EnableSsl", "false");
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "Outlook.office365.com");

		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "587");

		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");
		


		// set the port of SMTP server
		props.put("mail.smtp.port", "587");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
		{
					protected PasswordAuthentication getPasswordAuthentication() 
					   {
						  log.info("pwd authentication");
					      return new PasswordAuthentication("brantansp@fss.co.in", "Mar.2018");
					   }

		}
);

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("rajeshkhannar@fss.co.in"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("brantansp@fss.co.in"));
            
                        // Add the subject link
			message.setSubject("Testing Subject");

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("This is message body");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send
			//String filename = "G:\\a.xlsx";

			// Create data source and pass the filename
			//DataSource source = new FileDataSource(filename);

			// set the handler
			//messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			//messageBodyPart2.setFileName(filename);

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			SMTPTransport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {

			throw new RuntimeException(e);
		}*/
}

	
	public static boolean sendEmail(String toAddress, String fromAddress, String userName, String userPassword,String smtpHost, String emailSubject,String emailBody) {
	      // Recipient's email ID needs to be mentioned.


	      String to = toAddress;

	      // Sender's email ID needs to be mentioned
	      String from = fromAddress;//change accordingly
	      final String username = userName;//change accordingly
	      final String password = userPassword;//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = smtpHost;

	      Properties props = new Properties();

	      props.put("mail.smtp.auth",true);
	      props.put("mail.smtp.starttls.enable",true);
	      props.put("mail.smtp.host", host);

	      // Get the Session object.
	      SimpleMailAuthenticator authenticator = new SimpleMailAuthenticator(username, password);
	      Session session = Session.getInstance(props, authenticator);


	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(emailSubject);

	         // Now set the actual message
	         message.setText(emailBody);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	    return true;
	   }
}

class SimpleMailAuthenticator extends Authenticator {
	
    String userName;
    String password;
    PasswordAuthentication authentication;

    public SimpleMailAuthenticator(String userName,String password) {
        super();
        this.userName = userName;
        this.password = password;           
        authentication = new PasswordAuthentication(userName, password);
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return authentication;
    }


}  

/*
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

public class SendEMail
{
  private static final Logger log1 = Logger.getLogger("com.src.error");

  public void send(String paramString1, String paramString2, String paramString3, String paramString4) throws AddressException, MessagingException
  {
    log1.info("Inside send mail");
    String str1 = ""; String str2 = ""; String str3 = ""; String str4 = "";
    try {
      String str5 = ""; String localObject1 = ""; String localObject2 = ""; String localObject3 = ""; String localObject4 = "";
      Properties localObject5 = new Properties();

      localObject4 = "config.properties";
      localObject5.load(SendMail.class.getClassLoader().getResourceAsStream(localObject4));
      str1 = localObject5.getProperty("mailHostIP");
      log1.info("host is " + str1);
      str2 = localObject5.getProperty("fromAddress");
      str5 = localObject5.getProperty("midText");
      str4 = localObject5.getProperty("subjectText");
      localObject1 = localObject5.getProperty("greetings");
      localObject3 = localObject5.getProperty("bodyTextMsg");
      if ((paramString4 != null) && (paramString4.equals("FDP")))
      {
        str5 = localObject5.getProperty("midTextFDP");
        str4 = localObject5.getProperty("subjectTextFDP");
      }
      localObject2 = "\t\t\t\t\t\t" + str5 + localObject3;
      str3 = localObject1 + localObject2;
      str3 = localObject1 + localObject2;
    } catch (IOException localIOException) {
      M24Utility.printStackTraceLog(localIOException, log1);
    }
    String str6 = paramString2;

    Object localObject1 = System.getProperties();
    ((Properties)localObject1).put("mail.smtp.host", str1);
    ((Properties)localObject1).put("mail.smtp.port", "25");
    Object localObject2 = Session.getInstance((Properties)localObject1, null);
    Object localObject3 = new MimeMessage((Session)localObject2);
    ((MimeMessage)localObject3).setFrom(new InternetAddress(str2));
    ((MimeMessage)localObject3).setRecipients(Message.RecipientType.TO, str6);
    ((MimeMessage)localObject3).setSubject(str4);
    Object localObject4 = new MimeBodyPart();
    ((BodyPart)localObject4).setContent(str3.toString(), "text/html");
    Object localObject5 = new MimeMultipart();
    ((Multipart)localObject5).addBodyPart((BodyPart)localObject4);
    localObject4 = new MimeBodyPart();
    String str7 = paramString3 + "/OTP/";
    FileDataSource localFileDataSource = new FileDataSource(str7 + paramString1);
    ((BodyPart)localObject4).setDataHandler(new DataHandler(localFileDataSource));
    ((BodyPart)localObject4).setFileName(paramString1);
    ((Multipart)localObject5).addBodyPart((BodyPart)localObject4);
    log1.info("Attachment Content setting");
    ((MimeMessage)localObject3).setContent((Multipart)localObject5);
    log1.info("Mail built");
    try
    {
      Transport localTransport = ((Session)localObject2).getTransport("smtp");
      log1.info("Prepared to send Mail");
      Transport.send((Message)localObject3, ((MimeMessage)localObject3).getAllRecipients());
      log1.info("Mail Sent Successfully");
    } catch (SendFailedException localSendFailedException) {
      log1.info("UNABLE TO SEND THE MAIL");
      log1.info(localSendFailedException);
    }
  }
} */