package factory.implMailApi;

import factory.interfaces.AppManager;
import factory.interfaces.AuthHelper;
import factory.interfaces.InboxMail;
import factory.interfaces.SendMail;

import javax.mail.Session;
import java.util.Properties;

public class AppManagerApi implements AppManager {

    private AuthHelperApi authHelper;
    private InboxMailApi inboxMail;
    private SendMailApi sendMail;
    Session session;

    public AppManagerApi(){
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.imap.port", "465");
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.store.protocol", "imaps");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        session = Session.getDefaultInstance(mailServerProperties, null);
        authHelper = new AuthHelperApi(session);
        inboxMail = new InboxMailApi(session);
        sendMail = new SendMailApi(session);
    }

    @Override
    public AuthHelper getAuthHelper() {
        return authHelper;
    }

    @Override
    public InboxMail getInboxMailHelper() {
        return inboxMail;
    }

    @Override
    public SendMail getSendMailHelper() {
        return sendMail;
    }

    @Override
    public void stop() {
        //ignore
    }

    @Override
    public void preconditions() {
        //ignore
    }
}
