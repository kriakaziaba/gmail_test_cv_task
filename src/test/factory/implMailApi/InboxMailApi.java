package factory.implMailApi;

import data.Letter;
import data.User;
import factory.interfaces.InboxMail;
import utils.WorkWithFiles;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import java.io.IOException;
import java.util.Properties;

public class InboxMailApi implements InboxMail {

    private Session session;

    public InboxMailApi(Session mailSession){
        session = mailSession;
    }

    @Override
    public Letter openLetterBySubject(User user, String subject) {
        Store store;
        Letter lt = new Letter();
        try {
            store = session.getStore();
            store.connect("imap.gmail.com", user.getMail(), user.getPassword());
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            for (Message msg : inbox.getMessages()){
                if (msg.getSubject().equalsIgnoreCase(subject)){
                    InternetAddress addressFrom = (InternetAddress)msg.getFrom()[0];
                    lt.getFrom().setMail(addressFrom.getAddress());
                    InternetAddress addressTo = (InternetAddress)msg.getAllRecipients()[0];
                    lt.getTo().setMail(addressTo.getAddress());
                    Multipart mp = (Multipart) msg.getContent();
                    BodyPart bp = mp.getBodyPart(0);
                    lt.setSubject(msg.getSubject());
                    lt.setMessage(new String(bp.getContent().toString().getBytes("UTF-8")).trim());
                    Multipart multiPart = (Multipart) msg.getContent();

                    for (int i = 0; i < multiPart.getCount(); i++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            Properties props = new Properties();
                            try {
                                props.load(WorkWithFiles.class.getResourceAsStream("/project.properties"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            String path = props.getProperty("project.build.testOutputDirectory");
                            String destFilePath = path + System.getProperty("file.separator") + "receivedFile";
                            part.saveFile(destFilePath);
                            lt.setPathToAttachment("receivedFile");
//                            FileOutputStream output = new FileOutputStream(destFilePath);
//                            InputStream input = part.getInputStream();
//                            byte[] buffer = new byte[4096];
//                            int byteRead;
//                            while ((byteRead = input.read(buffer)) != -1) {
//                                output.write(buffer, 0, byteRead);
//                            }
//                            output.close();
                        }
                    }
                }
            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return lt;
    }

    @Override
    public String saveAttachedFile(Letter letter) {
        //ignore
        return "";
    }
}