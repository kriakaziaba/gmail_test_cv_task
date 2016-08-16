package test.factory.implMailApi;

import test.factory.interfaces.AppManager;
import test.factory.interfaces.AuthHelper;
import test.factory.interfaces.InboxMail;
import test.factory.interfaces.SendMail;

import java.util.Properties;

public class AppManagerApi implements AppManager {

    private final Properties mailServerProperties;

    public AppManagerApi(){
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.imap.port", "465");
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
    }
    @Override
    public AuthHelper getAuthHelper() {
        return null;
    }

    @Override
    public InboxMail getInboxMailHelper() {
        return null;
    }

    @Override
    public SendMail getSendMailHelper() {
        return null;
    }
}
