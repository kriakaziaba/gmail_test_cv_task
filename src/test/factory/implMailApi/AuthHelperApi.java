package factory.implMailApi;

import data.User;
import factory.interfaces.AuthHelper;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

public class AuthHelperApi implements AuthHelper {

    private Session mailSession;
    private Transport transport;

    public AuthHelperApi(Session session){
        mailSession = session;
    }

    @Override
    public boolean loginAs(User user) {
        if ((transport != null) && transport.isConnected()){
            logOut();
        }
        try {
            transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", user.getMail(), user.getPassword());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return (transport != null) && transport.isConnected();
    }

    @Override
    public void logOut() {
        if (transport != null){
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
