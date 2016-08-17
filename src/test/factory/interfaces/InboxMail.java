package factory.interfaces;

import data.Letter;

public interface InboxMail {
    Letter openLetterBySubjectContains(String subject);
}
