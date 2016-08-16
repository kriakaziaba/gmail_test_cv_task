package test.factory.implMailApi;

import test.factory.interfaces.AppManager;
import test.factory.interfaces.AuthHelper;
import test.factory.interfaces.InboxMail;
import test.factory.interfaces.SendMail;

/**
 * Created by tku on 8/15/2016.
 */
public class AppManagerApi implements AppManager {
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
