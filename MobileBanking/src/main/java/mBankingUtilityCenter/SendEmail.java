package mBankingUtilityCenter;
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