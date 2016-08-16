package test.factory.interfaces;

import test.data.Letter;

public interface InboxMail {
    Letter openLetterByIndex(Integer index);

    Letter openLetterBySubject(String subject);
}
