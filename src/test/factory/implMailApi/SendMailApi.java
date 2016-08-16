package test.factory.implMailApi;

import test.factory.interfaces.SendMail;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class SendMailApi implements SendMail {
    private MimeMessage generateMailMessage;

    @Override
    public void sendMail(String to, String subject, String messageBody) {
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("luxofttest1001@gmail.com"));
//        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
        generateMailMessage.setSubject("Greetings from Crunchify..");
        String emailBody;
        emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "luxofttest1002@gmail.com", "b55rkrgb13");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    @Override
    public void sendMailWithFile(String to, String subject, String messageBody, File file) {

    }
}
