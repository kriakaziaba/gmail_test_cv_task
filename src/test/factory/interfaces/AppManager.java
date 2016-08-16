package test.factory.interfaces;

/**
 * Created by tku on 8/15/2016.
 */
public interface AppManager {
    AuthHelper getAuthHelper();
    InboxMail getInboxMailHelper();
    SendMail getSendMailHelper();
}
