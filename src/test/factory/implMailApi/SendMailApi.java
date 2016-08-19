package factory.implMailApi;

import data.Letter;
import factory.interfaces.SendMail;
import utils.WorkWithFiles;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Enumeration;
import java.util.Properties;

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
    public void sendMail(Letter letter, String fileName) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(letter.getTo().getMail()));
            message.setSubject(letter.getSubject());
            if ((fileName != null) && !fileName.isEmpty()) {
                String path = WorkWithFiles.directoryOfTest() + fileName;
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(letter.getMessage());
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(path);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(path);
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
            }
            else {
                message.setText(letter.getMessage());
            }
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", letter.getFrom().getMail(), letter.getFrom().getPassword());
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
