package factory.implMailApi;

import data.Letter;
import data.User;
import factory.interfaces.InboxMail;
import tests.BaseTest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
                    lt.setSubject(msg.getSubject());
                    String cType = msg.getContentType();
                    if (cType.startsWith("TEXT/PLAIN")){
                        lt.setMessage(msg.getContent().toString().trim());
                    }
                    else if (cType.startsWith("multipart/MIXED") || cType.startsWith("multipart/ALTERNATIVE")) {
                        Multipart mp = (Multipart) msg.getContent();
                        BodyPart bp = mp.getBodyPart(0);
                        lt.setSubject(msg.getSubject());
                        lt.setMessage(new String(bp.getContent().toString().getBytes("UTF-8")).trim());
                    }
                }
            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return lt;
    }

    @Override
    public String saveAttachedFile(Letter letter, User user) {
        Store store;
        String filePath = null;
        try {
            store = session.getStore();
            store.connect("imap.gmail.com", user.getMail(), user.getPassword());
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            for (Message msg : inbox.getMessages()){
                if (msg.getSubject().equalsIgnoreCase(letter.getSubject())){
                    Multipart multiPart = (Multipart) msg.getContent();
                    for (int i = 0; i < multiPart.getCount(); i++) {
                        BodyPart bodyPart = multiPart.getBodyPart(i);
                        if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                            InputStream is = bodyPart.getInputStream();
                            String[] list = (System.getProperty("file.separator").equals("\\"))
                                    ? bodyPart.getFileName().split("\\\\")
                                    : bodyPart.getFileName().split("/");
                            String fileName = list[list.length-1];
                            filePath = BaseTest.downloadedDirectory + fileName;
                            File f = new File(filePath);
                            FileOutputStream fos = new FileOutputStream(f);
                            byte[] buf = new byte[4096];
                            int bytesRead;
                            while((bytesRead = is.read(buf))!=-1) {
                                fos.write(buf, 0, bytesRead);
                            }
                            fos.close();
                        }
                    }
                }
            }
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
}