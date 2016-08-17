package test.factory.implMailApi;

import test.data.Letter;
import test.factory.interfaces.InboxMail;

import javax.mail.Session;

public class InboxMailApi implements InboxMail {

    private Session session;

    public InboxMailApi(Session mailSession){
        session = mailSession;
    }

    @Override
    public Letter openLetterBySubjectContains(String subject) {
        return null;
    }
}
