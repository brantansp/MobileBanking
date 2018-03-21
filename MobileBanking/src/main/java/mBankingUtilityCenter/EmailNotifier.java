package mBankingUtilityCenter;

import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;


public class EmailNotifier {

	  private static final Logger log1 = Logger.getLogger(EmailNotifier.class);
	  public static final String DESTINATION_API = "destinationApi";
	  public static final String TOKEN = "token";
	  public static final Logger log = Logger.getLogger("com.src.output");

	  public static final Logger logError = Logger.getLogger("com.src.error");
	  private Message message;
	  private StringBuffer sqlBuffer = null;

	  public static void main(String[] args) {
		  EmailNotifier obj = new EmailNotifier();
		  obj.sendMail("brantansp@fss.co.in","brantansp@fss.co.in","brantansp@fss.co.in","hi","hello","01");
	}
	  
	  public boolean sendMail(String toMailId, String ccMailId, String bccMailId, String emailSubject, String emailMessage, String id)
	  {
	    boolean isMailSend = false;
	    StringBuffer senderBuffer = new StringBuffer();
	    try
	    {
	      Multipart multipart = new MimeMultipart("related");
	      this.message.setSubject(emailSubject);

	      if (toMailId.length() > 0) {
	        this.message.setRecipients(Message.RecipientType.TO, 
	          InternetAddress.parse(toMailId, false));
	      }

	      if (ccMailId.length() > 0) {
	        this.message.setRecipients(Message.RecipientType.CC, 
	          InternetAddress.parse(ccMailId, false));
	      }

	      if (bccMailId.length() > 0) {
	        this.message.setRecipients(Message.RecipientType.BCC, 
	          InternetAddress.parse(bccMailId, false));
	      }

	      BodyPart bodypart = new MimeBodyPart();
	      bodypart.setContent(emailMessage, "text/html");
	      multipart.addBodyPart(bodypart);

	      this.message.setContent(multipart);

	      Transport.send(this.message);

	      isMailSend = true;
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }

	    return isMailSend;
	  }
}
