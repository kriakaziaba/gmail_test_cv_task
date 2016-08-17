package test.factory.implMailApi;

import test.factory.interfaces.AuthHelper;
import test.factory.interfaces.InboxMail;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;

public class AuthHelperApi implements AuthHelper {

    private Session mailSession;

    public AuthHelperApi(Session session){
        mailSession = session;
    }
    @Override
    public boolean loginAs(String login, String password) {
        try {
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", "luxofttest1002@gmail.com", "b55rkrgb13");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
