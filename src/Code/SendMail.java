/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author Zunaid
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    public void emailMe(String txt) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("myfiverr01", "pass");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("myfiverr01@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("amarallmail@gmail.com"));
        message.setSubject("Temporary Pass From Java App");
        message.setText("Please Copy and Pest this Code in Application :,"
                + "\n\n" + txt);

        Transport.send(message);

        System.out.println("Done");

    }

}
