package factory.implMailApi;

import data.User;
import factory.interfaces.AuthHelper;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

public class AuthHelperApi implements AuthHelper {

    private Session mailSession;

    public AuthHelperApi(Session session){
        mailSession = session;
    }
    @Override
    public boolean loginAs(User user) {
        try {
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", user.getMail(), user.getPassword());
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
