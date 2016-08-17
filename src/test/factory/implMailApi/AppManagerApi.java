package test.factory.implMailApi;

import test.factory.interfaces.AppManager;
import test.factory.interfaces.AuthHelper;
import test.factory.interfaces.InboxMail;
import test.factory.interfaces.SendMail;

import javax.mail.Session;
import java.util.Properties;

public class AppManagerApi implements AppManager {

    private AuthHelperApi authHelper;
    private InboxMailApi inboxMail;
    private SendMailApi sendMail;

    public AppManagerApi(){
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.imap.port", "465");
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getDefaultInstance(mailServerProperties, null);
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
}
