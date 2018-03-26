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

/**
 * 
 * @author brantansp
 *Mail
 */

public class SendEmail
{

	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) {
		
        final String smtpAuthUserName = "rajeshkhannar@fss.co.in";
        final String smtpAuthPassword = "Test@000";
        String emailFrom = "rajeshkhannar@fss.co.in";
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
        properties.setProperty("mail.smtp.host", "10.44.10.10");
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.auth", "true");
 
        properties.setProperty("mail.smtp.starttls.enable", "true");
  /*      properties.setProperty("EnableSsl", "false");*/
        Session session = Session.getInstance( properties, authenticator );
        try
        {
    /*        Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            InternetAddress[] to = {new InternetAddress(emailTo)};
            message.setRecipients(Message.RecipientType.TO, to);
            message.setSubject("LoB 7 DB : QCT mPAY 4.0 - Automation test result");
            message.setText("Please find the status for the automation test run");
            Transport.send(message);*/
            


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailFrom));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo));
            message.setSubject("LoB 7 DB : QCT mPAY 4.0 - Automation test result");
            message.setText("Please find the status for the automation test run");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            String file = System.getProperty("user.dir")+"\\output\\ExtentReport\\24032018\\ExtentReport_220713.html";
            //String fileName = "Extent_Report";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            //messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            System.out.println("Sending");
            Transport.send(message);
            System.out.println("Done");
        }
        catch (MessagingException exception)
        {
            exception.printStackTrace();
        }
   }
}

