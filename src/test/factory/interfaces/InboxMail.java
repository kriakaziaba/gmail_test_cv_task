package test.factory.interfaces;

import test.data.Letter;

public interface InboxMail {
    Letter openLetterBySubjectContains(String subject);
}
