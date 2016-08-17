package test.factory.implMailApi;

import test.data.Letter;
import test.factory.interfaces.SendMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

public class SendMailApi implements SendMail {

    private Session session;

    public SendMailApi(Session mailSession){
        session = mailSession;
    }

    @Override
    public void sendMail(Letter letter) {
        sendMail(letter, null);
    }

    @Override
    public void sendMail(Letter letter, File file) {
        try {
            MimeMessage generateMailMessage = new MimeMessage(session);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(letter.to));
            generateMailMessage.setSubject(letter.subject);
            generateMailMessage.setContent(letter.message, "text/html");
            if (file != null)
                generateMailMessage.setFileName(file.getAbsolutePath());

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", letter.from, "b55rkrgb13");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
