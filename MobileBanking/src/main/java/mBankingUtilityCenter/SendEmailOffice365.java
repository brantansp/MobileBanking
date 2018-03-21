package mBankingUtilityCenter;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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

public class SendEmailOffice365 {


    private static final Logger log = Logger.getAnonymousLogger();

    private static final String server = "10.44.10.10";
    private static final int port = 25;
    private static final String userName = "brantansp@fss.co.in";
    private static final String password = "Mar.2018";

    private final String from = "brantansp@fss.co.in";
    private final String to = "rajeshkhannar@fss.co.in";

    private final String subject = "Test";
    private final String messageContent = "Hello world";

    public void sendEmail() {
    	Properties config = new Properties();
    	config.put("mail.smtp.host",  "10.44.10.10");
        final Session session = Session.getDefaultInstance(config, null);

        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            Multipart multipart = new MimeMultipart("related");
            message.setSubject(subject);
            BodyPart bodypart = new MimeBodyPart();
            bodypart.setContent("Welcome", "text/html");
            multipart.addBodyPart(bodypart);
            message.setContent(multipart);
            message.setText(messageContent);
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
            log.log(Level.WARNING, "Error : " + ex.getMessage(), ex);
        }
    }


    public static void main(final String[] args) {
        new SendEmailOffice365().sendEmail();
    }

}
