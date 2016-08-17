package test.factory.implMailApi;

import test.data.Letter;
import test.factory.interfaces.InboxMail;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Arrays;

public class InboxMailApi implements InboxMail {

    private Session session;

    public InboxMailApi(Session mailSession){
        session = mailSession;
    }

    @Override
    public Letter openLetterBySubjectContains(String subject) {
        Store store;
        Letter lt = new Letter();
        try {
            store = session.getStore();
            store.connect("imap.gmail.com", "luxofttest1001@gmail.com", "b55rkrgb13");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(1);
            Address[] in = msg.getFrom();
            lt.to.setMail(msg.getFrom()[0].toString());
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
                lt.to.setMail(address.toString());
            }
            System.out.println(msg.getSubject());
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("lol" + bp.getContent());
            lt.message = new String(bp.getContent().toString().getBytes("UTF-8")).trim();
            lt.subject = msg.getSubject();
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return lt;
    }
}
