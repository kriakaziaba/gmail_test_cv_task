package factory.interfaces;

public interface AppManager {
    AuthHelper getAuthHelper();
    InboxMail getInboxMailHelper();
    SendMail getSendMailHelper();
    void stop();
    void preconditions();
}
